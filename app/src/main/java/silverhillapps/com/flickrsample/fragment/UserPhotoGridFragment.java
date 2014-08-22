package silverhillapps.com.flickrsample.fragment;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;
import silverhillapps.com.flickrsample.R;
import silverhillapps.com.flickrsample.adapter.UserPhotoGridAdapter;
import silverhillapps.com.flickrsample.model.PhotoSet;

/**
 * This fragment shows the grid of photos of a determined user.
 * @author salva
 *
 */
public class UserPhotoGridFragment extends Fragment{

    public static final String TAG = "DETAIL_FRAGMENT";

    private PhotoSet mPhotoSet;			// The photo set model
    private String mUserId;             // The user id

    //UI elements
    private GridView mGridView;         // The grid view where the photos will be displayed.

    private UserPhotoGridAdapter mAdapter;		// The list adapter


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {


        View v = inflater.inflate(R.layout.fragment_user_photo_grid, container, false);
        mGridView = (GridView)v.findViewById(R.id.userPhotos_gridView_userPhotoGridFragment);

        mPhotoSet = new PhotoSet();
        mAdapter = new UserPhotoGridAdapter(getActivity(), mPhotoSet.getPhoto());
        mGridView.setAdapter(mAdapter);

        return v;
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