package model;

import java.util.List;

public class Spectator {

    private Spectator left;
    private Spectator right;
    private Spectator parent;

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
        parent = null;
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

    public Spectator getLeft() {
        return left;
    }

    public Spectator getRight() {
        return right;
    }

    public Spectator getParent() {
        return parent;
    }

    public void setLeft(Spectator left) {
        this.left = left;
    }

    public void setRight(Spectator right) {
        this.right = right;
    }

    public void setParent(Spectator parent) {
        this.parent = parent;
    }

    public void addSpectator(Spectator spectator){

        if (spectator.id.compareToIgnoreCase(id) == 0 || spectator.id.compareToIgnoreCase(id) < 0){
            if (left == null){
                left = spectator;
                left.parent = this;
            }else {
                left.addSpectator(spectator);
            }

        }else if (spectator.id.compareToIgnoreCase(id) > 0){
            if (right == null){
                right = spectator;
                right.parent = this;
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

    public void preOrder(List<Spectator> list, String country){
        if (this.country.compareToIgnoreCase(country) == 0){
            list.add(this);
        }

        if (left != null){
            left.preOrder(list, country);
        }

        if (right != null){
            right.preOrder(list, country);
        }
    }

    public void preOrder(List<Spectator> list){
        list.add(this);

        if (left != null){
            left.preOrder(list);
        }
        if (right != null){
            right.preOrder(list);
        }
    }

    public void postOrder(List<Spectator> list){
        if (left != null){
            left.postOrder(list);
        }

        if (right != null){
            right.postOrder(list);
        }

        list.add(this);
    }

    @Override
    public String toString() {
        String message;

        message = "Nombre: " + name + " " + lastName + "\n" + "ID: " + id + "\n" + "E-mail: " + email + "\n" + "Género: " + gender + "\n" + "País: " + country + "\n" + "Cumpleaños: " + birthday;

        return message;
    }
}
