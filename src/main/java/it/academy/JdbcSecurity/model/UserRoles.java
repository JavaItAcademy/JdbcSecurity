package it.academy.JdbcSecurity.model;

import javax.persistence.*;

@Entity
@Table(name = "user_roles")
public class UserRoles {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column(name = "role", nullable = false, length = 100)
    private String roleName;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    public UserRoles() {
    }

    public UserRoles(String roleName, User user) {
        this.roleName = roleName;
        this.user = user;
    }

    public UserRoles(int id, String roleName, User user) {
        this.id = id;
        this.roleName = roleName;
        this.user = user;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
