import java.util.ArrayList;

public class Album implements Comparable<Album> {

    int albumID;
    ArrayList<String> artistNames;
    String albumTitle;
    int numberOfSongs;

    public Album(int albumID,ArrayList<String>  artistNames, String title, int numSongs) {
        this.albumID = albumID;
        this.albumTitle = title;
        this.artistNames =  artistNames;
        this.numberOfSongs = numSongs;
    }
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("ID: ").append(albumID).append(" NUMBER OF SONGS ").append(numberOfSongs).append("--[");
        for (int i = 0; i < artistNames.size(); i++) {
            sb.append(artistNames.get(i)).append(",");


        }
        sb.append("] -- NULL");
        return sb.toString();
    }

    @Override
    public int compareTo(Album album1){
        if(this.numberOfSongs == album1.numberOfSongs)
            return 0;
        else return -1;
    }
}

