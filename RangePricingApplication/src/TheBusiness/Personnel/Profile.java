/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TheBusiness.Personnel;

import TheBusiness.UserAccountManagement.UserAccount;

/**
 *
 * @author kal bugrara
 */
public abstract class Profile {

    protected Person person;
    protected UserAccount userAccount;

    public Profile(Person person) {
        this.person = person;
    }

    public Person getPerson() {
        return person;
    }

    public void setUserAccount(UserAccount ua) {
        this.userAccount = ua;
    }

    public UserAccount getUserAccount() {
        return userAccount;
    }

    @Override
    public String toString() {
        return person != null ? person.getName() : "Unknown Profile";
    }
    
    public boolean isMatch(String id) {
    if (person == null || id == null) return false;
    return person.getPersonId().equalsIgnoreCase(id);
}

}
