package silverhillapps.com.flickrsample.loader;

import android.widget.TextView;
import java.util.HashMap;
import java.util.Map;
import silverhillapps.com.flickrsample.conf.Conf;
import silverhillapps.com.flickrsample.model.Person;

/**
 * This class stores a cache for user info and provide the same storage point for all the application. This user info is relatively stable so it is necessary to be cached to reduce the number of calls.
 */
public class PersonLoader {

    private static PersonLoader personLoader;

    private Map<String, Person> peopleCache; // The user's info cache

    //These both variables should be loaded through injection for example with Dagger.
    private FlickrRepository mRepository;	//This is the loader responsible for loading the photo data
    private RepositoryFactory mFactory; 	//This should be loaded through injection


    public static PersonLoader getInstance(){
        if(personLoader == null){
            personLoader = new PersonLoader();
        }

        return personLoader;
    }

    public  PersonLoader(){

        peopleCache = new HashMap<String, Person>();

        // Creates of the factory, and loads the data from the source generating the model.
        mFactory = RepositoryFactory.getInstance();
        mRepository = mFactory.getLoader(Conf.FactoryRepositoryConf.ACTIVE_REPOSITORY);

    }


    /**
     * This method loads asyncronously a new username from a user. In case it is available in cache, it is taken directly from it.
     * @param userId
     * @param textView
     */
    public void loadUsername(final String userId, final TextView textView){

        if(peopleCache.containsKey(userId)){
            textView.setText(peopleCache.get(userId).getUsername().get_content());
        }else{
            mRepository.getUserInfoByUserId(userId, new RepositoryReceiver() {
                @Override
                public void getResults(Object result, int code) {
                    Person p = (Person)result;
                    if(!peopleCache.containsKey(p.getNsid())){
                        peopleCache.put(p.getNsid(), p);
                    }
                    textView.setText(p.getUsername().get_content());
                }

                @Override
                public void getError(int code) {
                    textView.setText("");
                }
            });

        }
    }

    /**
     * This method loads a new user from the user's cache
     * @param userId
     * @return
     */
    public Person loadCachedPerson(String userId){

        if(peopleCache.containsKey(userId)){
            return peopleCache.get(userId);
        }else{
            return null;
        }
    }


}
