package sk.stopangin.spring.security.model;

import javax.persistence.*;

/**
 * Created by myPC on 23. 5. 2015.
 */
@Entity
@Table(name = "user_roles", schema = "data")
public class UserRole {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String role;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
}
