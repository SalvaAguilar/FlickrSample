package silverhillapps.com.flickrsample;

import android.app.Application;
import android.content.Context;

/**
 * Application class for wrapping global runtime variables
 * @author salva
 *
 */
public class SHAFSApplication extends Application {

    private static Context mContext; // Application context for assets loading

    public void onCreate() {
        super.onCreate();
        SHAFSApplication.mContext = getApplicationContext();


    }

    /**
     * Method which returns the application context
     *
     * @return the application context
     */
    public static Context getAppContext() {
        return SHAFSApplication.mContext;
    }

}