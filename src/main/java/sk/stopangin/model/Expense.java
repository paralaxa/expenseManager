package sk.stopangin.model;

import javax.persistence.*;

/**
 * Created by myPC on 23. 5. 2015.
 */
@Entity
public class Expense {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "EXP_SEQ")
    @SequenceGenerator(name = "EXP_SEQ", sequenceName = "EXP_SEQ", allocationSize = 1)
    private Long id;
    private String title;
    @Column(name = "\"desc\"")
    private String desc;
    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "category")
    private Category category;
    @Column(name="username")
    private String userName;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

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

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }
}
