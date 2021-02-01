import java.util.Scanner;

enum Direction {
    FORWARD, REVERSE
}

public class Task36 {
    

    public static void main(String[] args) throws Exception {
        DllClass dl = new DllClass();

        if(dl.readMusicCatalog("music-catalog.csv")){
            System.out.println("Reading music file operation is successful");
        }else System.out.println("Reading music file operation is not successful");
        // dl.showDetails();
        // System.out.println("\n");

        dl.showMusicCatalog(Direction.FORWARD);
        System.out.println("\n");
        dl.showMusicCatalog(Direction.REVERSE);
        System.out.println("\n");

        Scanner s = new Scanner(System.in);
        System.out.println("Enter Artist/ Genre/ Song name for albums details:");
        String name = s.nextLine();
        dl.preferences(name);


        


    }
}
