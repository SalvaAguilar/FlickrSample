package silverhillapps.com.flickrsample.loader;

import silverhillapps.com.flickrsample.conf.Constants;

/**
 * This is the factory of loaders that is called from the primary controller.
 * @author salva
 *
 */
public class RepositoryFactory {

    private static RepositoryFactory factory;

    public static RepositoryFactory getInstance(){
        if(factory == null){
            factory = new RepositoryFactory();
        }
        return factory;
    }

    private RepositoryFactory(){

    }

    public FlickrRepository getLoader(int loaderCode){

        FlickrRepository loader = null;

        switch(loaderCode){

            case Constants.FactoryRepositoryConstants.REST_FLICKR_REPOSITORY_CODE:
                loader = new RestFlickrRepository();
                break;
        }

        return loader;
    }

}
