import java.util.LinkedList;
import java.util.ListIterator;

public class playlist {
    String title;
    LinkedList<song>playList;

    public playlist(String title)
    {
        this.title=title;
        this.playList=new LinkedList<song>();
    }

    public playlist(String title, LinkedList<song> ply)
    {
        this.title = title;
        this.playList = ply;
    }

    void addSong(song gaana,playlist pname)
    {
        String name = gaana.get_title();
        pname.playList.add(gaana);
        System.out.println("song: "+gaana.get_title()+ " is added to the playlist: "+ pname.title.toString());
    }
//    String get_title(playlist pname)
//    {
//        return pname.title;
//    }

}
