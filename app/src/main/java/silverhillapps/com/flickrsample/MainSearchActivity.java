package silverhillapps.com.flickrsample;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import silverhillapps.com.flickrsample.conf.Conf;
import silverhillapps.com.flickrsample.conf.Constants;
import silverhillapps.com.flickrsample.fragment.FlickrListFragment;
import silverhillapps.com.flickrsample.fragment.ItemSelectedListener;
import silverhillapps.com.flickrsample.loader.FlickrRepository;
import silverhillapps.com.flickrsample.loader.PersonLoader;
import silverhillapps.com.flickrsample.loader.RepositoryFactory;
import silverhillapps.com.flickrsample.loader.RepositoryReceiver;
import silverhillapps.com.flickrsample.model.Person;
import silverhillapps.com.flickrsample.model.Photo;
import silverhillapps.com.flickrsample.model.PhotoSet;

/**
 * This is the main activity that shows the list of photos, and load it from the repository
 */
public class MainSearchActivity extends Activity implements ItemSelectedListener, RepositoryReceiver{

    //These both variables should be loaded through injection for example with Dagger.
    private FlickrRepository mRepository;	//This is the loader responsible for loading the photo data
    private RepositoryFactory mFactory; 	//This should be loaded through injection

    private PhotoSet mPhotoSet; 	//This is the photoset information in our model.

    private FlickrListFragment mFragment; // This is the fragment to be shown

    private PersonLoader mPersonLoader; //The loader with cache for the Persons

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if (savedInstanceState == null) {

            // Creates of the factory, and loads the data from the source generating the model.
            mFactory = RepositoryFactory.getInstance();
            mRepository = mFactory.getLoader(Conf.FactoryRepositoryConf.ACTIVE_REPOSITORY);

            // We perform the search
            mRepository.searchPhotoSetByText("squirrel", this);


            mPersonLoader = PersonLoader.getInstance();


            mFragment = new FlickrListFragment();

            getFragmentManager().beginTransaction()
                    .add(R.id.container, mFragment)
                    .commit();
        }
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.

        // It could be really simple to include a search box in the action bar for changing the search string.
        getMenuInflater().inflate(R.menu.main, menu);
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

    // Methods from ItemSelectedListener interface
    @Override
    public void onItemSelected(Photo photo) {

		/*Here we have two options depending on the final device. We can use the fragment manager to show
		the two fragments in the same activity like master-detail or like this case, fire a new activity
		that contains the detail fragment for smartphones. */


        Intent detailActivityIntent = new Intent(MainSearchActivity.this, UserPhotosActivity.class);
        detailActivityIntent.putExtra(Constants.PassingParamConstants.ACTIVITY_PASS_PHOTO_OWNER, photo.getOwner());
        Person p = mPersonLoader.loadCachedPerson(photo.getOwner());
        if(p!=null) {
            detailActivityIntent.putExtra(Constants.PassingParamConstants.ACTIVITY_PASS_PHOTO_USERNAME, p.getUsername().get_content());
        }
        startActivity(detailActivityIntent);

    }

    // Methods from RepositoryReceiver interface
    @Override
    public void getResults(Object result, int code) {
        if(mFragment!=null){

                switch(code){
                    case Constants.PassingParamConstants.REST_RETURN_SEARCH_BY_TEXT:
                        PhotoSet ps = (PhotoSet)result;
                        mFragment.updateTextResults(ps);
                        break;
                }
            }

    }

    @Override
    public void getError(int code) {

    }


}
