package silverhillapps.com.flickrsample.loader;

import com.loopj.android.http.*;

import silverhillapps.com.flickrsample.conf.Constants;

/**
 * Base class for performing http calls.
 */
public class FlickrRestClient {

    private static AsyncHttpClient client = new AsyncHttpClient();

    public static void get(String url, RequestParams params, AsyncHttpResponseHandler responseHandler) {
        client.get(Constants.RestApiConstants.FLICKR_API_BASE_URL, params, responseHandler);
    }

    public static void post(String url, RequestParams params, AsyncHttpResponseHandler responseHandler) {
        client.post(getAbsoluteUrl(url), params, responseHandler);
    }

    private static String getAbsoluteUrl(String relativeUrl) {
        return Constants.RestApiConstants.FLICKR_API_BASE_URL + relativeUrl;
    }
}
