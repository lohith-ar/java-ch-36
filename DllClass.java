import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

class Node {
    MusicItem mi;
    Node prev;
    Node next;

    Node(MusicItem mi) {
        this.mi = mi;
    }

}

public class DllClass {
    // String filename;
    Node head;
    Node tail;

    public void addNewNode(MusicItem mi) {

        Node newNode = new Node(mi);
        if (head == null) {
            head = newNode;
            tail = newNode;
            return;
        } else {
            Node temp = head;
            while (temp != null) {
                if (!temp.mi.isInAscendingOrder(mi)) {
                    if (temp == head) {
                        newNode.next = head;
                        head.prev = newNode;
                        head = newNode;
                    } else {
                        temp.prev.next = newNode;
                        newNode.prev = temp.prev;
                        newNode.next = temp;
                        temp.prev = newNode;
                    }
                    return;
                }

                temp = temp.next;
            }

            tail.next = newNode;
            newNode.prev = tail;
            tail = newNode;
        }
    }

    boolean readMusicCatalog(String filename) {
        File file = new File(filename);

        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String line = "";
            String[] words = null;
            while ((line = br.readLine()) != null) {
                MusicItem mi = new MusicItem();
                // line = line.toLowerCase().replaceAll("[,':;.?]", " ");
                words = line.split(", ");
                mi.type = words[0];
                mi.artist = words[1];
                mi.song = words[2];
                mi.genre = words[3];
                mi.yorelease = Integer.parseInt(words[4]);
                mi.noofsongs = Integer.parseInt(words[5]);
                mi.duration = words[6];
                addNewNode(mi);
            }
        } catch (IOException io) {
            System.out.println(io.getMessage());
            return false;
        } catch (Exception e) {
            e.printStackTrace();return false;
        }
        return true;

    }

   
    public void showDetails() {
        Node current = head;
        if (head == null) {
            System.out.println("No Nodes found");
            return;
        }
        while (current != null) {
            System.out.println(current.mi);
            current = current.next;
        }
    }

    void showMusicCatalog(Direction direction){
        if(direction.equals(Direction.FORWARD)){
            Node temp = head;
            while(temp!=null){
                System.out.println(temp.mi);
                temp = temp.next;
            }
        }
        if(direction.equals(Direction.REVERSE)){
            Node temp = tail;
            while(temp!=null){
                System.out.println(temp.mi);
                temp = temp.prev;
            }
        }
    }

    void preferences(String name){
        Node current = head;
        if (head == null) {
            System.out.println("No Nodes found");
            return;
        }
        while (current != null) {
            if(current.mi.getArtist().equals(name) || current.mi.getGenre().equals(name) ||  current.mi.getGenre().substring(0,3).equals(name)|| current.mi.getSong().equals(name))
            System.out.println(current.mi);
            current = current.next;
        }
    }



}
