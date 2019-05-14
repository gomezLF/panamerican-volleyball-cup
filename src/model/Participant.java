package model;

public class Participant {

    private Participant left;
    private Participant right;

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


    public void addParticipant(Participant participant){
        if (participant.id.compareToIgnoreCase(id) == 0 || participant.id.compareToIgnoreCase(id) < 0){
            if (left == null){
                left = participant;
            }else {
                left.addParticipant(participant);
            }

        }else {
            if (right == null){
                right = participant;
            }else {
                right.addParticipant(participant);
            }
        }
    }

    public Participant search(String id){
        Participant searched = null;

        if (id.compareToIgnoreCase(this.id) == 0){
            searched = this;
        }else if (id.compareToIgnoreCase(this.id) < 0){
            searched = left.search(id);
        }else {
            searched = right.search(id);
        }

        return searched;
    }
}
