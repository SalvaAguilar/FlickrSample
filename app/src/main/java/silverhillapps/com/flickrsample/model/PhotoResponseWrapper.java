package silverhillapps.com.flickrsample.model;

/**
 * This class model the parent response from server when photo search method is requested
 */
public class PhotoResponseWrapper {

    private PhotoSet photos;
    private String stat;

    public PhotoResponseWrapper(PhotoSet photos, String stat) {
        this.photos = photos;
        this.stat = stat;
    }

    public PhotoSet getPhotos() {
        return photos;
    }

    public void setPhotos(PhotoSet photos) {
        this.photos = photos;
    }

    public String getStat() {
        return stat;
    }

    public void setStat(String stat) {
        this.stat = stat;
    }
}
