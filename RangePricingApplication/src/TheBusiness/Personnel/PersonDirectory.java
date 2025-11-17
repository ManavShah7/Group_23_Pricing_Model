/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TheBusiness.Personnel;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author kal bugrara
 */
public class PersonDirectory {

    private List<Person> personList;

    public PersonDirectory() {
        this.personList = new ArrayList<>();
    }

    public Person addPerson(String name, String phone, String email) {
        Person p = new Person(name, phone, email);
        personList.add(p);
        return p;
    }

    public List<Person> getPersonList() {
        return personList;
    }

    public Person findPersonById(String id) {
        for (Person p : personList) {
            if (p.getPersonId().equals(id)) {
                return p;
            }
        }
        return null;
    }

    public void removePerson(Person p) {
        personList.remove(p);
    }

    public int size() {
        return personList.size();
    }

}
