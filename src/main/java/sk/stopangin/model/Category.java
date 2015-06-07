package sk.stopangin.model;

import javax.persistence.*;

/**
 * Created by myPC on 23. 5. 2015.
 */
@Entity
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "CAT_SEQ")
    @SequenceGenerator(name = "CAT_SEQ", sequenceName = "CAT_SEQ", allocationSize = 1)
    private Long id;
    @Column(name="\"name\"")
    private String name;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
