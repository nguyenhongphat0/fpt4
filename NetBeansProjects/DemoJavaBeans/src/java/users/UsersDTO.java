/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package users;

import java.io.Serializable;

/**
 *
 * @author nguyenhongphat0
 */
public class UsersDTO implements Serializable {
    private String username;
    private String password;
    private String lastname;
    private boolean roles;

    public UsersDTO() {
    }

    public UsersDTO(String username, String password, String lastname, boolean roles) {
        this.username = username;
        this.password = password;
        this.lastname = lastname;
        this.roles = roles;
    }

    /**
     * @return the username
     */
    public String getUsername() {
        return username;
    }

    /**
     * @param username the username to set
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * @return the password
     */
    public String getPassword() {
        return password;
    }

    /**
     * @param password the password to set
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * @return the lastname
     */
    public String getLastname() {
        return lastname;
    }

    /**
     * @param lastname the lastname to set
     */
    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    /**
     * @return the roles
     */
    public boolean isRoles() {
        return roles;
    }

    /**
     * @param roles the roles to set
     */
    public void setRoles(boolean roles) {
        this.roles = roles;
    }

    @Override
    public String toString() {
        return "UsersDTO{" + "username=" + username + ", password=" + password + ", lastname=" + lastname + ", roles=" + roles + '}';
    }
}
