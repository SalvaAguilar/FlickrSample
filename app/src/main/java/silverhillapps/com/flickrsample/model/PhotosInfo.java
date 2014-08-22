package silverhillapps.com.flickrsample.model;

/**
 * This class model one field of response from server when user info is requested
 */
public class PhotosInfo {

    private Field firstdatetaken;
    private Field firstdate;
    private Field count;

    public PhotosInfo(Field firstdatetaken, Field firstdate, Field count) {
        this.firstdatetaken = firstdatetaken;
        this.firstdate = firstdate;
        this.count = count;
    }

    public Field getFirstdatetaken() {
        return firstdatetaken;
    }

    public void setFirstdatetaken(Field firstdatetaken) {
        this.firstdatetaken = firstdatetaken;
    }

    public Field getFirstdate() {
        return firstdate;
    }

    public void setFirstdate(Field firstdate) {
        this.firstdate = firstdate;
    }

    public Field getCount() {
        return count;
    }

    public void setCount(Field count) {
        this.count = count;
    }
}
