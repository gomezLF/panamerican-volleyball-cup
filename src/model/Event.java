package model;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class Event {

    private static final String PARTICIPANT_DATA_PATH = "";

    private Participant root;
    private Participant first;


    public Event() {
        root = null;
        first = null;
    }


    public void readData() throws IOException {
        File file = new File(PARTICIPANT_DATA_PATH);
        FileReader fr = new FileReader(file);
        BufferedReader br = new BufferedReader(fr);

        String line = br.readLine();
        while(line != null){
            String words[] = line.split(",");

            String id = words[0];
            String name = words[1];
            String lastName = words[2];
            String email = words[3];
            String gender = words[4];
            String country = words[5];
            String photo = words[6];
            String birthday = words[7];

            addParticipant(name, lastName, id, email, gender, country, photo, birthday);

            line = br.readLine();
        }
    }

    private void addParticipant(String name, String lastName, String id, String email, String gender, String country, String avatar, String birthday){
        Participant participant = new Participant(name, lastName, id, email, gender, country, avatar, birthday);

        if (root == null){
            root = participant;
        }else {
            root.addParticipant(participant);
        }
    }

    public Participant searchParticipant(String id){
        Participant searched = null;

        if (root != null){
            root.search(id);
        }

        return searched;
    }


}
