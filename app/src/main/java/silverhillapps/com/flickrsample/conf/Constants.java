package silverhillapps.com.flickrsample.conf;

/**
 * Constants class
 */
public class Constants {

    /**
     * Class for storing the rest api constants
     */
    public static final class RestApiConstants{
        public static final String FLICKR_API_BASE_URL = "https://api.flickr.com/services/rest/";
        public static final String FLICKR_SEARCH_METHOD = "flickr.photos.search";
        public static final String FLICKR_GET_USER_PHOTOS_METHOD = "flickr.people.getPhotos";
        public static final String FLICKR_GET_INFO_USER_METHOD = "flickr.people.getInfo";

        public static final String FLICKR_METHOD_ID = "method";
        public static final String FLICKR_API_KEY_ID = "api_key";
        public static final String FLICKR_TEXT_ID = "text";
        public static final String FLICKR_API_SIG_ID = "api_sig";
        public static final String FLICKR_FORMAT_ID = "format";
        public static final String FLICKR_NO_JSON_CALLBACK_ID = "nojsoncallback";
        public static final String FLICKR_USER_ID_ID = "user_id";
    }

    /**
     * Class for storing the factory constants
     */
    public static final class FactoryRepositoryConstants{

        public static final int REST_FLICKR_REPOSITORY_CODE = 1;
    }

    /**
     * Class for storing the passing parameters ids contacts
     */
    public static final class PassingParamConstants{

        public static final int REST_RETURN_SEARCH_BY_TEXT = 1;
        public static final int REST_RETURN_SEARCH_BY_USERID = 2;
        public static final int REST_RETURN_GET_USER_INFO_BY_USERID = 3 ;

        public static final String ACTIVITY_PASS_PHOTO_OWNER = "activity_pass_photo_owner";
        public static final String ACTIVITY_PASS_PHOTO_USERNAME = "activity_pass_photo_username";
    }
}
