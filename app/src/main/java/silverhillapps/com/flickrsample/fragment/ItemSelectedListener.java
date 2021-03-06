package silverhillapps.com.flickrsample.fragment;


import silverhillapps.com.flickrsample.model.Photo;

/**
 * This interface models the communication between the main activity and the  fragment
 * @author salva
 *
 */
public interface ItemSelectedListener {

    /**
     * This method is used to notify the parent which element was clicked.
     * @param photo
     */
    public void onItemSelected(Photo photo);

}