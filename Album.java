import java.util.ArrayList;
import java.util.LinkedList;

public class Album {
    String name;
    String artist;
    ArrayList<song> songs;

    public Album(String name, String artist) {
        this.name = name;
        this.artist = artist;
        this.songs = new ArrayList<song>();
    }

    public song find_song(String title) {
        for (song checkSong : songs)
            if (checkSong.get_title() == title)
                return checkSong;
        return null;
    }

    public boolean addSong(String title, double duration) {
        if (find_song(title) == null) {
            songs.add(new song(title, duration));
            System.out.println("song:" + title + " is succesfully added in the list");
            return true;
        }
        System.out.println("song:" + title + " is already present in the list");
        return false;
    }

    public boolean addToPlaylist(int trackNumber, LinkedList<song> PlayList) {
        int index = trackNumber - 1;
        if (trackNumber > 0 && trackNumber <= songs.size()) {
            PlayList.add(this.songs.get(index));
            return true;
        } else
            System.out.println("there is no song in the list at the given track number");
        return false;
    }

    public boolean addToPlaylist(String title, LinkedList<song> PlayList) {
        for (song checksong : songs) {
            if (checksong.get_title().equals(title)) {
                PlayList.add(checksong);
                return true;
            }
        }
        System.out.println("there is no such song in the list");
        return false;
    }
}
