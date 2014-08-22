package silverhillapps.com.flickrsample;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import silverhillapps.com.flickrsample.conf.Constants;
import silverhillapps.com.flickrsample.fragment.UserPhotoGridFragment;
import silverhillapps.com.flickrsample.loader.FlickrRepository;
import silverhillapps.com.flickrsample.loader.RepositoryFactory;
import silverhillapps.com.flickrsample.loader.RepositoryReceiver;
import silverhillapps.com.flickrsample.model.PhotoSet;


public class UserPhotosActivity extends Activity implements RepositoryReceiver{

    //These both variables should be loaded through injection for example with Dagger.
    private FlickrRepository mRepository;	//This is the loader responsible for loading the photo data
    private RepositoryFactory mFactory; 	//This should be loaded through injection

    private PhotoSet mPhotoSet; 	//This is the photoset information in our model.

    private String mOwner; // Variable for receiving the owner of the photo
    private String mUsername;  // Variable for receiving the username of the photo

    private UserPhotoGridFragment mFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_photos);

        // We retrieve the parameters from parent activity
        mOwner = getIntent().getExtras().getString(Constants.PassingParamConstants.ACTIVITY_PASS_PHOTO_OWNER);

        mUsername = mOwner;
        if(getIntent().getExtras().containsKey(Constants.PassingParamConstants.ACTIVITY_PASS_PHOTO_USERNAME)) {
            mUsername = getIntent().getExtras().getString(Constants.PassingParamConstants.ACTIVITY_PASS_PHOTO_USERNAME);
        }

        getActionBar().setTitle(mUsername);

        if (savedInstanceState == null) {

            // Creates of the factory, and loads the data from the source generating the model.
            mFactory = RepositoryFactory.getInstance();
            mRepository = mFactory.getLoader(Constants.FactoryRepositoryConstants.REST_FLICKR_REPOSITORY_CODE);
            mRepository.searchPhotoSetByUserId(mOwner, this);

            mFragment = new UserPhotoGridFragment();

            getFragmentManager().beginTransaction()
                    .add(R.id.container, mFragment)
                    .commit();
        }
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.detail, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }


    // Methods from RepositoryReceiver interface
    @Override
    public void getResults(Object result, int code) {
        if(mFragment!=null){

            switch(code){
                case Constants.PassingParamConstants.REST_RETURN_SEARCH_BY_USERID:
                    mFragment.updateTextResults((PhotoSet)result);
                    break;
            }
        }

    }

    @Override
    public void getError(int code) {

    }

}
