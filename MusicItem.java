public class MusicItem {
    String type;
    String artist;
    String genre;
    String song;
    int yorelease;
    int noofsongs;
    String duration;

    MusicItem(){

    }

    MusicItem(String type, String artist, String genre, String song, int yorelease, int noofsongs, String duration) {
        this.type = type;
        this.artist = artist;
        this.genre = genre;
        this.song = song;
        this.yorelease = yorelease;
        this.noofsongs = noofsongs;
        this.duration = duration;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getArtist() {
        return artist;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getSong() {
        return song;
    }

    public void setSong(String song) {
        this.song = song;
    }

    public int getYorelease() {
        return yorelease;
    }

    public void setYorelease(int yorelease) {
        this.yorelease = yorelease;
    }

    public int getNoofsongs() {
        return noofsongs;
    }

    public void setNoofsongs(int noofsongs) {
        this.noofsongs = noofsongs;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    @Override
    public String toString() {
        return "ARTIST:" + artist + ",\t DURATION:" + duration + ",\t GENRE:" + genre + ",\t NOOFSONGS:"
                + noofsongs + ",\t SONG:" + song + ",\t TYPE:" + type + ",\t YEAROFRELEASE:" + yorelease;
    }

    boolean isInAscendingOrder(MusicItem newItem) {
        if (this.getArtist().compareTo(newItem.getArtist()) < 0) {
            return true;
        } else if (this.getArtist().compareTo(newItem.getArtist()) > 0) {
            return false;
        } else if (this.getArtist().compareTo(newItem.getArtist()) == 0) {
            if (this.getYorelease() <= newItem.getYorelease()) {
                return true;
            }
        }
        return false;
    }

}
