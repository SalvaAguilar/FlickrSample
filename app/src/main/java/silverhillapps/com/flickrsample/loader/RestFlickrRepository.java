package silverhillapps.com.flickrsample.loader;

import silverhillapps.com.flickrsample.conf.Constants;
import silverhillapps.com.flickrsample.model.Person;
import silverhillapps.com.flickrsample.model.PhotoResponseWrapper;
import silverhillapps.com.flickrsample.model.PhotoSet;
import silverhillapps.com.flickrsample.model.UserInfoResponseWrapper;
import silverhillapps.com.flickrsample.utils.FlickrUtils;

import org.apache.http.Header;
import org.json.*;

import com.google.gson.Gson;
import com.loopj.android.http.*;

/**
 * This is the flickr rest loader. This generate the http calls to rest api for any of the methods needed in the app.
 * It uses http-request library.
 * @author salva
 *
 */
public class RestFlickrRepository  extends  FlickrRepository{


    /**
     * Method for performing a search by text
     * @param text
     * @param receiver
     */
    @Override
    public void searchPhotoSetByText(String text, final RepositoryReceiver receiver) {

        RequestParams params = FlickrUtils.getParamsGetSearchByText(text);

        FlickrRestClient.get("", params, new JsonHttpResponseHandler() {
            @Override
            public void onSuccess(int statusCode, Header[] headers, JSONObject response) {
                // If the response is JSONObject instead of expected JSONArray
                Gson g = new Gson();
                PhotoResponseWrapper rw = g.fromJson(response.toString(), PhotoResponseWrapper.class);
                PhotoSet ps = rw.getPhotos();

                receiver.getResults(ps, Constants.PassingParamConstants.REST_RETURN_SEARCH_BY_TEXT);

            }

            @Override
            public void onFailure(int statusCode, Header[] headers, String responseString, Throwable throwable) {
                super.onFailure(statusCode, headers, responseString, throwable);
            }
        });


    }

    /**
     * Method for performing a photo search by user.
     * @param userId
     * @param receiver
     */
    @Override
    public void searchPhotoSetByUserId(String userId, final RepositoryReceiver receiver) {

        RequestParams params = FlickrUtils.getParamsGetSearchByUserId(userId);

        FlickrRestClient.get("", params, new JsonHttpResponseHandler() {
            @Override
            public void onSuccess(int statusCode, Header[] headers, JSONObject response) {
                // If the response is JSONObject instead of expected JSONArray
                Gson g = new Gson();
                PhotoResponseWrapper rw = g.fromJson(response.toString(), PhotoResponseWrapper.class);
                PhotoSet ps = rw.getPhotos();

                receiver.getResults(ps, Constants.PassingParamConstants.REST_RETURN_SEARCH_BY_USERID);

            }

            @Override
            public void onFailure(int statusCode, Header[] headers, String responseString, Throwable throwable) {
                super.onFailure(statusCode, headers, responseString, throwable);
            }

        });
    }

    /**
     * Method for performing a user info request.
     * @param userId
     * @param receiver
     */
    @Override
    public void getUserInfoByUserId(String userId, final RepositoryReceiver receiver) {

        RequestParams params = FlickrUtils.getParamsGetInfoUserByUserId(userId);

        FlickrRestClient.get("", params, new JsonHttpResponseHandler() {
            @Override
            public void onSuccess(int statusCode, Header[] headers, JSONObject response) {
                // If the response is JSONObject instead of expected JSONArray
                Gson g = new Gson();
                UserInfoResponseWrapper rw = g.fromJson(response.toString(), UserInfoResponseWrapper.class);
                Person p = rw.getPerson();

                receiver.getResults(p, Constants.PassingParamConstants.REST_RETURN_GET_USER_INFO_BY_USERID);

            }

            @Override
            public void onFailure(int statusCode, Header[] headers, String responseString, Throwable throwable) {
                super.onFailure(statusCode, headers, responseString, throwable);
            }

        });
    }
}
