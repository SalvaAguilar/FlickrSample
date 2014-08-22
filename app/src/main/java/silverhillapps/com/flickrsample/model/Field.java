package silverhillapps.com.flickrsample.model;

import java.util.ArrayList;
import java.util.List;

/**
 * This class model one single generic field in the get info request
 */
public class Field {

    private String _content;

    public Field(String _content) {
        this._content = _content;
    }

    public String get_content() {
        return _content;
    }

    public void set_content(String _content) {
        this._content = _content;
    }
}
