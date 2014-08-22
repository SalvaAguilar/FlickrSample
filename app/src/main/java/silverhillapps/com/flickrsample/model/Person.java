package silverhillapps.com.flickrsample.model;

/**
 * This class model the user info response from server when user info is requested
 */
public class Person {

    private String id;
    private String nsid;
    private int ispro;
    private String iconserver;
    private int iconfarm;
    private String path_alias;
    private Field username;
    private Field description;
    private Field photosurl;
    private Field profileurl;
    private Field mobileurl;
    private PhotosInfo photos;

    public Person(String id, String nsid, int ispro, String iconserver, int iconfarm, String path_alias, Field username, Field description, Field photosurl, Field profileurl, Field mobileurl, PhotosInfo photos) {
        this.id = id;
        this.nsid = nsid;
        this.ispro = ispro;
        this.iconserver = iconserver;
        this.iconfarm = iconfarm;
        this.path_alias = path_alias;
        this.username = username;
        this.description = description;
        this.photosurl = photosurl;
        this.profileurl = profileurl;
        this.mobileurl = mobileurl;
        this.photos = photos;
    }

    public Person(){

    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNsid() {
        return nsid;
    }

    public void setNsid(String nsid) {
        this.nsid = nsid;
    }

    public int getIspro() {
        return ispro;
    }

    public void setIspro(int ispro) {
        this.ispro = ispro;
    }

    public String getIconserver() {
        return iconserver;
    }

    public void setIconserver(String iconserver) {
        this.iconserver = iconserver;
    }

    public int getIconfarm() {
        return iconfarm;
    }

    public void setIconfarm(int iconfarm) {
        this.iconfarm = iconfarm;
    }

    public String getPath_alias() {
        return path_alias;
    }

    public void setPath_alias(String path_alias) {
        this.path_alias = path_alias;
    }

    public Field getUsername() {
        return username;
    }

    public void setUsername(Field username) {
        this.username = username;
    }

    public Field getDescription() {
        return description;
    }

    public void setDescription(Field description) {
        this.description = description;
    }

    public Field getPhotosurl() {
        return photosurl;
    }

    public void setPhotosurl(Field photosurl) {
        this.photosurl = photosurl;
    }

    public Field getProfileurl() {
        return profileurl;
    }

    public void setProfileurl(Field profileurl) {
        this.profileurl = profileurl;
    }

    public Field getMobileurl() {
        return mobileurl;
    }

    public void setMobileurl(Field mobileurl) {
        this.mobileurl = mobileurl;
    }
}
