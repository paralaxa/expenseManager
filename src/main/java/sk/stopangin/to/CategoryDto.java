package sk.stopangin.to;

import java.io.Serializable;

/**
 * Created by myPC on 24. 5. 2015.
 */
public class CategoryDto implements Serializable{
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
