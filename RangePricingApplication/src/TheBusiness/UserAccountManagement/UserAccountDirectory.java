/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TheBusiness.UserAccountManagement;

import TheBusiness.Personnel.*;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author kal bugrara
 */
public class UserAccountDirectory {

    private List<UserAccount> userAccountList;

    public UserAccountDirectory() {
        this.userAccountList = new ArrayList<>();
    }

    public UserAccount createUserAccount(String username, String password, Profile profile) {
        UserAccount ua = new UserAccount(username, password, profile);
        userAccountList.add(ua);
        profile.setUserAccount(ua);
        return ua;
    }

    public UserAccount authenticateUser(String username, String password) {
        for (UserAccount ua : userAccountList) {
            if (ua.authenticate(username, password)) {
                return ua;
            }
        }
        return null;
    }

    public void removeUserAccount(UserAccount ua) {
        userAccountList.remove(ua);
    }

    public List<UserAccount> getUserAccountList() {
        return userAccountList;
    }
}
