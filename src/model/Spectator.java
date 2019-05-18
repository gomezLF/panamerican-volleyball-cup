package model;

import java.util.List;

public class Spectator {

    private Spectator left;
    private Spectator right;

    private String name;
    private String lastName;
    private String id;
    private String email;
    private String gender;
    private String country;
    private String avatar;
    private String birthday;


    public Spectator(String name, String lastName, String id, String email, String gender, String country, String avatar, String birthday) {
        this.name = name;
        this.lastName = lastName;
        this.id = id;
        this.email = email;
        this.gender = gender;
        this.country = country;
        this.avatar = avatar;
        this.birthday = birthday;

        left = null;
        right = null;
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


    public void addSpectator(Spectator spectator){
        if (spectator.id.compareToIgnoreCase(id) == 0 || spectator.id.compareToIgnoreCase(id) < 0){
            if (left == null){
                left = spectator;
            }else {
                left.addSpectator(spectator);
            }

        }else {
            if (right == null){
                right = spectator;
            }else {
                right.addSpectator(spectator);
            }
        }
    }

    public Spectator search(String id){
        Spectator searched;

        if (id.compareToIgnoreCase(this.id) == 0){
            searched = this;

        }else if (id.compareToIgnoreCase(this.id) < 0){
            if (left == null){
                throw new NullPointerException();
            }else {
                searched = left.search(id);
            }

        }else {
            if (right == null){
                throw new NullPointerException();
            }else {
                searched = right.search(id);
            }
        }
        return searched;
    }

    public void inOrder(List<Spectator> list){
        if (left != null){
            left.inOrder(list);
        }

        list.add(this);

        if (right != null){
            right.inOrder(list);
        }
    }

    public void inOrder(List<Spectator> list, String country){
        if (left != null){
            left.inOrder(list, country);
        }

        if (this.country.compareToIgnoreCase(country) == 0){
            list.add(this);
        }

        if (right != null){
            right.inOrder(list, country);
        }
    }

    @Override
    public String toString() {
        String message;

        message = "Nombre: " + name + " " + lastName + "\n" + "ID: " + id + "\n" + "E-mail: " + email + "\n" + "Género: " + gender + "\n" + "País: " + country + "\n" + "Cumpleaños: " + birthday;

        return message;
    }
}
