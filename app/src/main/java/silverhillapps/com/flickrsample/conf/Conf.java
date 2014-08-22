package silverhillapps.com.flickrsample.conf;

/**
 * Conf constants class
 */
public class Conf {

    /**
     * Class for storing the configuration for Rest Api communication
     */
    public static final class RestApiConf{

        public static final String FLICKR_API_KEY =  "YOUR API KEY";
        public static final String FLICKR_FORMAT = "json";
        public static final String FLICKR_NO_JSON_CALLBACK = "1";
    }

    /**
     * Class for storing the configuration related with the factories.
     */
    public static final class FactoryRepositoryConf{

        // This field wont be necessary in case of dependency injection.
        public static final int ACTIVE_REPOSITORY = Constants.FactoryRepositoryConstants.REST_FLICKR_REPOSITORY_CODE;
    }


}
