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
import silverhillapps.com.flickrsample.model.Photo;
import silverhillapps.com.flickrsample.model.PhotoSet;
import silverhillapps.com.flickrsample.utils.FlickrUtils;
import silverhillapps.com.flickrsample.utils.ImageUtils;

/**
 * Adapter class for representing the general grid view. We use ArrayAdapter as the list is not enough complex to extend from BaseAdapter
 * @author salva
 *
 */
public class UserPhotoGridAdapter extends ArrayAdapter<Photo> {

    private Context mContext;
    private List<Photo> mPhotos;        // The model to be displayed in the grid
    private LayoutInflater mInflater = null;

    private ImageUtils imageUtils;  // The image asynchronous loader

    public UserPhotoGridAdapter(Context context, List<Photo> objects) {
        super(context, R.layout.list_row_grid, objects);

        this.mContext = context;
        this.mPhotos = objects;
        mInflater = LayoutInflater.from(mContext);

        imageUtils = new ImageUtils(context);
    }




    static class ViewHolder {
        public ImageView photoImageView;

    }


    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        ViewHolder holder;
        View rowPhotosView = convertView;

        // We reuse the views
        if (rowPhotosView == null) {

            rowPhotosView = mInflater.inflate(R.layout.list_row_grid, null);

            holder = new ViewHolder();
            holder.photoImageView = (ImageView) rowPhotosView.findViewById(R.id.photo_imageView_userPhotoGrid);

            rowPhotosView.setTag(holder);
        }
        else{
            holder = (ViewHolder) rowPhotosView.getTag();
        }

        Photo j = (Photo) getItem(position);

        // UI update
        imageUtils.displayImage(FlickrUtils.getURLFromPhotoElement(j), holder.photoImageView);

        return rowPhotosView;
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