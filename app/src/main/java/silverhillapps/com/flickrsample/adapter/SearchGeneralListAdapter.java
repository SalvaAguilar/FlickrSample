package silverhillapps.com.flickrsample.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import silverhillapps.com.flickrsample.R;
import silverhillapps.com.flickrsample.loader.PersonLoader;
import silverhillapps.com.flickrsample.model.PhotoSet;
import silverhillapps.com.flickrsample.utils.ImageUtils;
import silverhillapps.com.flickrsample.model.Photo;
import silverhillapps.com.flickrsample.utils.FlickrUtils;

/**
 * Adapter class for representing the general list view. We use ArrayAdapter as the list is not enough complex to extend from BaseAdapter
 * @author salva
 *
 */
public class SearchGeneralListAdapter extends ArrayAdapter<Photo> {

    private Context mContext;
    private List<Photo> mPhotos;   // The photo model.
    private LayoutInflater mInflater = null;

    private ImageUtils imageUtils;   // The image asynchronous loader
    private PersonLoader personLoader;   // The person asynchronous loader


    public SearchGeneralListAdapter(Context context, List<Photo> objects) {
        super(context, R.layout.list_row_general, objects);

        this.mContext = context;
        this.mPhotos = objects;
        mInflater = LayoutInflater.from(mContext);

        imageUtils = new ImageUtils(context);
        personLoader = PersonLoader.getInstance();


    }


    static class ViewHolder {
        public TextView titleTextView;
        public TextView userTextView;
        public ImageView photoImageView;

    }


    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        ViewHolder holder;
        View rowPhotoView = convertView;

        // We reuse the views
        if (rowPhotoView == null) {

            rowPhotoView = mInflater.inflate(R.layout.list_row_general, null);

            holder = new ViewHolder();
            holder.titleTextView = (TextView) rowPhotoView.findViewById(R.id.title_textView_generalSearch);
            holder.userTextView = (TextView) rowPhotoView.findViewById(R.id.user_textView_generalSearch);
            holder.photoImageView = (ImageView) rowPhotoView.findViewById(R.id.photo_imageView_generalSearch);

            rowPhotoView.setTag(holder);
        }
        else{
            holder = (ViewHolder) rowPhotoView.getTag();
        }

        Photo j = (Photo) getItem(position);

        // UI update
        holder.titleTextView.setText(j.getTitle());

        personLoader.loadUsername(j.getOwner(), holder.userTextView);

        imageUtils.displayImage(FlickrUtils.getURLFromPhotoElement(j),holder.photoImageView);

        return rowPhotoView;
    }


    /**
     * Method for communicating with the fragment to notify the new data model.
     * @param result
     */
    public void setResults(PhotoSet result) {
        this.clear();
        this.addAll(result.getPhoto());

        notifyDataSetChanged();

    }

}