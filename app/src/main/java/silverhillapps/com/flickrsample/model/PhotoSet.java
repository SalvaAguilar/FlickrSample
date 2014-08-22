package silverhillapps.com.flickrsample.model;

import java.util.ArrayList;
import java.util.List;

/**
 * This class model the photoset response when search method is called
 */
public class PhotoSet {

    private int page;
    private int pages;
    private int perpage;
    private String total;
    private List<Photo> photo;

    public PhotoSet(){
        this.photo = new ArrayList<Photo>();
    }

    public PhotoSet(int page, int pages, int perpage, String total, List<Photo> photo) {
        this.page = page;
        this.pages = pages;
        this.perpage = perpage;
        this.total = total;
        this.photo = photo;
    }

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public int getPages() {
        return pages;
    }

    public void setPages(int pages) {
        this.pages = pages;
    }

    public int getPerpage() {
        return perpage;
    }

    public void setPerpage(int perpage) {
        this.perpage = perpage;
    }

    public String getTotal() {
        return total;
    }

    public void setTotal(String total) {
        this.total = total;
    }

    public List<Photo> getPhoto() {
        return photo;
    }

    public void setPhoto(List<Photo> photo) {
        this.photo = photo;
    }
}
