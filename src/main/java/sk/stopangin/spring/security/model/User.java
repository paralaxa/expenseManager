package sk.stopangin.spring.security.model;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by myPC on 23. 5. 2015.
 */
@Entity(name = "user")
@Table(name = "users", schema = "data")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String username;
    private String password;
    private boolean enabled;
    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name="user_user_roles", joinColumns={@JoinColumn(name="user_id")}, inverseJoinColumns={@JoinColumn(name="user_role_id")})
    private Set<UserRole> userRole= new HashSet<UserRole>();

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    public Set<UserRole> getUserRole() {
        return userRole;
    }

    public void setUserRole(Set<UserRole> userRole) {
        this.userRole = userRole;
    }
}
