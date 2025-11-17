/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TheBusiness.UserAccountManagement;

import TheBusiness.Personnel.Profile;

/**
 *
 * @author kal bugrara
 */
public class UserAccount {

    private String username;
    private String password;
    private Profile profile;

    public UserAccount(String username, String password, Profile profile) {
        this.username = username;
        this.password = password;
        this.profile = profile;
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

    public Profile getProfile() {
        return profile;
    }

    public boolean authenticate(String username, String password) {
        return this.username.equals(username) && this.password.equals(password);
    }

    @Override
    public String toString() {
        return username + " (" + (profile != null ? profile.toString() : "No profile") + ")";
    }

}
