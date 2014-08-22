package silverhillapps.com.flickrsample.utils;

import com.loopj.android.http.RequestParams;
import silverhillapps.com.flickrsample.conf.Conf;
import silverhillapps.com.flickrsample.conf.Constants;
import silverhillapps.com.flickrsample.model.Photo;

/**
 * This class agglutinates some util methods for flickr rest communication
 */
public class FlickrUtils {

    /**
     * This method traduces the Photo model to url
     * @param p
     * @return
     */
    public static String getURLFromPhotoElement(Photo p){

        //The fina url is conformed with this format
        //https://farm{farm-id}.staticflickr.com/{server-id}/{id}_{secret}_[mstzb].jpg

        StringBuffer buff = new StringBuffer();
        buff.append("https://farm" + p.getFarm() + ".staticflickr.com/");
        buff.append(p.getServer() + "/");
        buff.append(p.getId() + "_" + p.getSecret());
        buff.append("_" + "n" + ".jpg");

        return buff.toString();
    }

    /**
     * This method create the parameters for the get call in the search by text
     * @param text
     * @return
     */
    public static RequestParams getParamsGetSearchByText(String text){

        RequestParams params = new RequestParams();
        params.put(Constants.RestApiConstants.FLICKR_METHOD_ID,Constants.RestApiConstants.FLICKR_SEARCH_METHOD);
        params.put(Constants.RestApiConstants.FLICKR_API_KEY_ID,Conf.RestApiConf.FLICKR_API_KEY);
        params.put(Constants.RestApiConstants.FLICKR_TEXT_ID,text);
        params.put(Constants.RestApiConstants.FLICKR_FORMAT_ID,Conf.RestApiConf.FLICKR_FORMAT);
        params.put(Constants.RestApiConstants.FLICKR_NO_JSON_CALLBACK_ID,Conf.RestApiConf.FLICKR_NO_JSON_CALLBACK);
        return params;

    }

    /**
     * This method create the parameters for the get call in the search by user
     * @param userId
     * @return
     */
    public static RequestParams getParamsGetSearchByUserId(String userId){

        RequestParams params = new RequestParams();
        params.put(Constants.RestApiConstants.FLICKR_METHOD_ID,Constants.RestApiConstants.FLICKR_GET_USER_PHOTOS_METHOD);
        params.put(Constants.RestApiConstants.FLICKR_API_KEY_ID,Conf.RestApiConf.FLICKR_API_KEY);
        params.put(Constants.RestApiConstants.FLICKR_USER_ID_ID,userId);
        params.put(Constants.RestApiConstants.FLICKR_FORMAT_ID,Conf.RestApiConf.FLICKR_FORMAT);
        params.put(Constants.RestApiConstants.FLICKR_NO_JSON_CALLBACK_ID,Conf.RestApiConf.FLICKR_NO_JSON_CALLBACK);
        return params;

    }

    /**
     * This method create the parameters for the get call for getting user info
     * @param userId
     * @return
     */
    public static RequestParams getParamsGetInfoUserByUserId(String userId){

        RequestParams params = new RequestParams();
        params.put(Constants.RestApiConstants.FLICKR_METHOD_ID,Constants.RestApiConstants.FLICKR_GET_INFO_USER_METHOD);
        params.put(Constants.RestApiConstants.FLICKR_API_KEY_ID,Conf.RestApiConf.FLICKR_API_KEY);
        params.put(Constants.RestApiConstants.FLICKR_USER_ID_ID,userId);
        params.put(Constants.RestApiConstants.FLICKR_FORMAT_ID,Conf.RestApiConf.FLICKR_FORMAT);
        params.put(Constants.RestApiConstants.FLICKR_NO_JSON_CALLBACK_ID,Conf.RestApiConf.FLICKR_NO_JSON_CALLBACK);
        return params;

    }

}
