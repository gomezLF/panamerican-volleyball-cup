package model;

import java.util.Comparator;

public class Participant implements Comparable<String> {

    private Participant next;
    private Participant previous;

    private String name;
    private String lastName;
    private String id;
    private String email;
    private String gender;
    private String country;
    private String avatar;
    private String birthday;


    public Participant(String name, String lastName, String id, String email, String gender, String country, String avatar, String birthday) {
        this.name = name;
        this.lastName = lastName;
        this.id = id;
        this.email = email;
        this.gender = gender;
        this.country = country;
        this.avatar = avatar;
        this.birthday = birthday;

        next = null;
        previous = null;
    }


    public String getName() {
        return name;
    }

    public String getLastName() {
        return lastName;
    }

    public String getId() {
        return id;
    }

    public String getEmail() {
        return email;
    }

    public String getGender() {
        return gender;
    }

    public String getCountry() {
        return country;
    }

    public String getAvatar() {
        return avatar;
    }

    public String getBirthday() {
        return birthday;
    }

    public Participant getNext() {
        return next;
    }

    public Participant getPrevious() {
        return previous;
    }

    public void setNext(Participant next) {
        this.next = next;
    }

    public void setPrevious(Participant previous) {
        this.previous = previous;
    }


    @Override
    public int compareTo(String id) {
        int value;

        if (id.compareToIgnoreCase(this.id) == 0){
            value = 0;

        }else if (id.compareToIgnoreCase(this.id) < 0){
            value = -1;

        }else {
            value = 1;
        }

        return value;
    }

    @Override
    public String toString() {
        String message = "";

        message = "Nombre: " + name + " " + lastName + "\n" + "ID: " + id + "\n" + "E-mail: " + email + "\n" + "Género: " + gender + "\n" + "País: " + country + "\n" + "Cumpleaños: " + birthday;

        return message;
    }
}
