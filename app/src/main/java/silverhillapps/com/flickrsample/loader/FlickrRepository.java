package silverhillapps.com.flickrsample.loader;



/**
 * This abstract class determines the structure of a loader
 * @author salva
 *
 */
public abstract class FlickrRepository {

    public abstract void searchPhotoSetByText(String text, RepositoryReceiver receiver);
    public abstract void searchPhotoSetByUserId(String userId, RepositoryReceiver receiver);
    public abstract void getUserInfoByUserId(String userId, final RepositoryReceiver receiver);
}
