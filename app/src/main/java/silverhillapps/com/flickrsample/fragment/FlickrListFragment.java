package silverhillapps.com.flickrsample.fragment;

import android.app.Activity;
import android.app.ListFragment;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ListView;

import silverhillapps.com.flickrsample.adapter.SearchGeneralListAdapter;
import silverhillapps.com.flickrsample.model.PhotoSet;

/**
 * This Fragment shows the list of the searched-by-text photos
 * @author salva
 *
 */
public class FlickrListFragment extends ListFragment {

    public static final String TAG = "GENERAL_LIST_FRAGMENT";

    private ItemSelectedListener mCallback;	// callback object for communicating with the parent activity
    private PhotoSet mPhotoSet;			// The photo set model
    private SearchGeneralListAdapter mAdapter;		// The list adapter

    public FlickrListFragment(){

    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        mPhotoSet = new PhotoSet();
        mAdapter = new SearchGeneralListAdapter(getActivity(), mPhotoSet.getPhoto());
        setListAdapter(mAdapter);
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        try {
            mCallback = (ItemSelectedListener) activity; // We set the callback as soon as the fragment is attached
        } catch (ClassCastException e) {
            Log.d("ClassCastException",
                    "The parent activity must implement the interface to get communication with the fragment");
        }
    }


    @Override
    public void onListItemClick(ListView l, View v, int position, long id) {
        super.onListItemClick(l, v, position, id);
        // Doing click on one item, we call the parent to perform the associated action.
        mCallback.onItemSelected(mPhotoSet.getPhoto().get(position));
    }

    /**
     * Method for communicating with the activity controller, with the data model updated.
     * @param result
     */
    public void updateTextResults(PhotoSet result) {
        this.mPhotoSet = result;
        mAdapter.setResults(result);
    }
}
