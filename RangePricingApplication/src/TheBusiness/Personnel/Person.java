/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TheBusiness.Personnel;

import java.util.UUID;

/**
 *
 * @author kal bugrara
 */
public class Person {

    private final String personId;
    private String name;
    private String phone;
    private String email;

    public Person(String name, String phone, String email) {
        this.personId = UUID.randomUUID().toString();
        this.name = name;
        this.phone = phone;
        this.email = email;
    }

    public String getPersonId() {
        return personId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return name + " (" + personId.substring(0, 6) + ")";
    }
}
