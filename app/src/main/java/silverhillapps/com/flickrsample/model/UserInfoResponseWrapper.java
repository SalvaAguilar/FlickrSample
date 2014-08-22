package silverhillapps.com.flickrsample.model;

/**
 * This class model the parent response from server when user info is requested
 */
public class UserInfoResponseWrapper {

    private Person person;
    private String stat;

    public UserInfoResponseWrapper(Person person, String stat) {
        this.person = person;
        this.stat = stat;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    public String getStat() {
        return stat;
    }

    public void setStat(String stat) {
        this.stat = stat;
    }
}
