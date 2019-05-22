package model;

import customExceptions.EmptyDataException;
import customExceptions.NotRegisteredPersonException;
import userInterface.BannerWindowController;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Event {

    private Spectator root;

    private Spectator countrySpectatorRoot;

    private Participant first;


    public Event() {
        root = null;
        first = null;
        countrySpectatorRoot = null;
    }


    public Spectator getRoot(){
        return  root;
    }

    public Spectator getCountrySpectatorRoot() {
        return countrySpectatorRoot;
    }



    public void readData(String path) throws IOException {

        this.root = null;
        this.first = null;

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
        List<Spectator> list = treeToList();
        int[] randomParticipants = new int[list.size()/2];

        for (int i = 0; i < randomParticipants.length; i++) {
            int rp = (int)Math.floor(Math.random()*(1-(list.size())) + (list.size() - 1));
            randomParticipants[i] = rp;
        }

        for (int i = 0; i < randomParticipants.length; i++) {
            for (int j = 0; j < randomParticipants.length; j++) {
                if (randomParticipants[i] == randomParticipants[j] && i != j){
                    int rp = (int)Math.floor(Math.random()*(1-(list.size())) + (list.size() - 1));
                    randomParticipants[i] = rp;
                    i = 0;
                }
            }
        }

        createParticipants(list, randomParticipants);
    }

    private void createParticipants(List<Spectator> list, int[] randomParticipants){
        for (int i = 0; i < randomParticipants.length; i++) {
            Spectator s = list.get(randomParticipants[i]);

            Participant participant = new Participant(s.getName(), s.getLastName(), s.getId(), s.getEmail(), s.getGender(), s.getCountry(), s.getAvatar(), s.getBirthday());

            addParticipant(participant);
        }
    }

    private void addParticipant(Participant participant){
        if (first == null){
            first = participant;

        }else {
            Participant current = first;

            while(current.getNext() != null){
                current = current.getNext();
            }

            current.setNext(participant);
            participant.setPrevious(current);
        }
    }



    private List<Spectator> treeToList(){
        List<Spectator> list = new ArrayList<>();

        if (root != null){
            root.postOrder(list);
        }
        return list;
    }

    public List<Spectator> treeToList(String country, Spectator root)throws EmptyDataException, NotRegisteredPersonException {
        List<Spectator> list = new ArrayList<>();

        if (country.equals("")){
            throw new EmptyDataException();

        }else {
            if (root == null){
                throw new NotRegisteredPersonException();

            }else {
                root.preOrder(list, country);
            }
        }

        return list;
    }

    public List<Participant> linkedListToList(String country) throws EmptyDataException, NotRegisteredPersonException{
        List<Participant> list = new ArrayList<>();

        if (country.equals("")){
            throw new EmptyDataException();

        }else {
            if (first == null){
                throw new NotRegisteredPersonException();
            }else {
                Participant current = first;

                while (current != null){
                    if (current.getCountry().equals(country)){
                        list.add(current);
                    }
                    current = current.getNext();
                }
            }
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



    public long calculateTime(long n1, long n2){
        long time = n2 - n1;

        return time;
    }



    public String[] organizeToDraw(List<Spectator> list){
        this.countrySpectatorRoot = null;

        String[] positions = new String[list.size()];

        for (int i = 0; i < list.size(); i++) {
            Spectator toAdd = new Spectator(list.get(i).getName(), list.get(i).getLastName(), list.get(i).getId(), list.get(i).getEmail(), list.get(i).getGender(), list.get(i).getCountry(), list.get(i).getAvatar(), list.get(i).getBirthday());

            if (countrySpectatorRoot == null){
                countrySpectatorRoot = toAdd;
                String position = list.get(i).getId() + "," + "500" + "," + "100";
                positions[i] = position;

            }else {
                boolean ok = true;
                Spectator temp = countrySpectatorRoot;

                while(ok){
                    if (temp.getId().compareToIgnoreCase(toAdd.getId()) > 0){
                        if (temp.getLeft() == null){
                            int[] p = searchPositions(temp.getId(), positions);

                            temp.setLeft(toAdd);
                            int posX = p[0] - BannerWindowController.SIZE*2;
                            int posY = p[1] + BannerWindowController.SIZE*2;

                            positions[i] = toAdd.getId() + "," + posX + "," + posY;
                            ok = false;

                        }else {
                            temp = temp.getLeft();
                        }

                    }else if (temp.getId().compareToIgnoreCase(toAdd.getId()) < 0){
                        if (temp.getRight() == null){
                            int[] p = searchPositions(temp.getId(), positions);

                            temp.setRight(toAdd);
                            int posX = p[0] + BannerWindowController.SIZE*2;
                            int posY = p[1] + BannerWindowController.SIZE*2;

                            positions[i] = toAdd.getId() + "," + posX + "," + posY;
                            ok = false;

                        }else {
                            temp = temp.getRight();
                        }
                    }
                }
            }
        }
        return positions;
    }



    public int[] searchPositions(String id, String[] positions){
        int[] p = new int[2];
        boolean founded = false;

        for (int i = 0; i < positions.length && !founded; i++) {
            String[] words = positions[i].split(",");

            if (words[0].equals(id)){
                int x = Integer.parseInt(words[1]);
                int y = Integer.parseInt(words[2]);

                p[0] = x;
                p[1] = y;

                founded = true;
            }
        }
        return p;
    }
}
