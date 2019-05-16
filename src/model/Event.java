package model;

import customExceptions.EmptyDataException;
import customExceptions.NotRegisteredPersonException;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Event {

    private Spectator root;
    private Participant first;



    public Event() {
        root = null;
        first = null;
    }



    public void readData(String path) throws IOException {
        File file = new File(path);
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

            addSpectator(name, lastName, id, email, gender, country, photo, birthday);

            line = br.readLine();
        }

        chooseParticipants();
    }

    private void addSpectator(String name, String lastName, String id, String email, String gender, String country, String avatar, String birthday){
        Spectator spectator = new Spectator(name, lastName, id, email, gender, country, avatar, birthday);

        if (root == null){
            root = spectator;
        }else {
            root.addSpectator(spectator);
        }
    }

    private void chooseParticipants(){
        List<Spectator> list = toList();

        for (int i = 0; i < (list.size() / 2); i++) {
            
        }
    }

    public List<Spectator> toList(){
        List<Spectator> list = new ArrayList<>();

        if (root != null){
            root.inOrder(list);
        }

        return list;
    }


    public Spectator searchSpectator(String id) throws EmptyDataException, NotRegisteredPersonException {
        Spectator searched = null;

        if (id.equals("")){
            throw new EmptyDataException();

        }else {
            if (root == null){
                throw new NotRegisteredPersonException();

            }else{
                searched =  root.search(id);
            }
        }

        if (searched == null){
            throw new NullPointerException();
        }
        return searched;
    }

    public Participant searchParticipant(String id) throws EmptyDataException, NotRegisteredPersonException {
        Participant searched = null;

        if (id.equals("")){
            throw new EmptyDataException();

        }else {
            if (first == null){
                throw new NotRegisteredPersonException();

            }else {
                Participant current = first;
                boolean found =  false;

                while(current != null && !found){

                    if (current.compareTo(id) == 0){
                        found = true;
                        searched = current;
                    }
                    current = current.getNext();
                }
            }
        }

        if (searched == null){
            throw new NullPointerException();
        }
        return searched;
    }
}
