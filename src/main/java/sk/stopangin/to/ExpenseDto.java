package sk.stopangin.to;

import java.io.Serializable;

/**
 * Created by myPC on 23. 5. 2015.
 */
public class ExpenseDto implements Serializable {
    private String title;
    private String desc;
    private CategoryDto category;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public CategoryDto getCategory() {
        return category;
    }

    public void setCategory(CategoryDto category) {
        this.category = category;
    }
}
