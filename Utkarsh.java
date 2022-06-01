import java.util.ArrayList;
import java.util.LinkedList;
import java.util.ListIterator;
import java.util.Scanner;

public class Utkarsh {
    static ArrayList<Album> albums=new ArrayList<>();
    static ArrayList<playlist> playlists =new ArrayList<>();

    public static void main(String[] args)
    {
        printmenu();

        Album album=new Album("Album1","AC/DC");

        album.addSong("TNT",4.5);
        album.addSong("Highway to hell",3.5);
        album.addSong("ThunderStruck",5.0);
        albums.add(album);

        album=new Album("Album2","Eminem");

        album.addSong("Rap god",4.5);
        album.addSong("Not Afraid",3.5);
        album.addSong("Lose yourself",4.5);
        albums.add(album);

        LinkedList<song> PlayList_1=new LinkedList<>();

        albums.get(0).addToPlaylist("TNT",PlayList_1);
        albums.get(0).addToPlaylist("Highway to hell",PlayList_1);
        albums.get(1).addToPlaylist("Rap god",PlayList_1);
        albums.get(1).addToPlaylist("Lose yourself",PlayList_1);

        playlist ply1 = new playlist("Playlist 1",PlayList_1);
        playlists.add(ply1);

        LinkedList<song> AllSongList=new LinkedList<>();
        for(int i=0;i< albums.size();i++)
        {
            for(int j = 0; j< albums.get(i).songs.size(); j++)
            {
                albums.get(i).addToPlaylist(albums.get(i).songs.get(j).get_title(),AllSongList);
            }
        }
        boolean exit=false;
        while(!exit) {
            Scanner sc = new Scanner(System.in);
            int action = sc.nextInt();
//            sc.nextLine();
            switch (action) {
                case 0:
                    exit = true;
                    break;
                case 1:
                    System.out.println("press\n"+
                            "1: to start a playlist\n"+
                            "2: to choose song from the list");
                    Scanner pm= new Scanner(System.in);
                    int opt=pm.nextInt();
                    if(opt==1) {
                        System.out.println("Choose the playlist");
                        for (int i = 0; i < playlists.size(); i++)
                            System.out.println((i + 1) + " " + playlists.get(i).title);
                        Scanner chup = new Scanner(System.in);
                        int chap = chup.nextInt();
                        chup.nextLine();
                        play(playlists.get(chap - 1).playList);
                    }
                    else {
                        System.out.println("Choose song");
                        int num = 0;
                        for (int i = 0; i < albums.size(); i++) {
                            for (int j = 0; j < albums.get(i).songs.size(); j++) {
                                num++;
                                System.out.println(Integer.toString(num) + " " + albums.get(i).songs.get(j).get_title());
                            }
                        }
                        Scanner yup = new Scanner(System.in);
                        int hey = yup.nextInt();
                        yup.nextLine();
                        System.out.println("Now playing:" + AllSongList.get(hey - 1).get_title());
                    }
                    printmenu();
                    break;
                case 2:
                    for (int i = 0; i < albums.size(); i++) {
                        for (int j = 0; j < albums.get(i).songs.size(); j++) {
                            System.out.println(albums.get(i).songs.get(j).get_title() + " duration: " + albums.get(i).songs.get(j).get_duration());
                        }
                    }
                    System.out.println("press 3 for the main menu");
                    break;
                case 3:
                    printmenu();
                    break;
                case 4:
                    System.out.println("Choose playlist");
                    for (int i = 0; i < playlists.size(); i++)
                        System.out.println((i + 1) + " " + playlists.get(i).title.toString());
                    Scanner tip = new Scanner(System.in);
                    int cup = tip.nextInt();
                    tip.nextLine();

                    System.out.println("Choose which song to be added");
                    int numb = 1;
                    for (int i = 0; i < albums.size(); i++) {
                        for (int j = 0; j < albums.get(i).songs.size(); j++) {
                            System.out.println(Integer.toString(numb++) + " " + albums.get(i).songs.get(j).get_title() + " duration: " + albums.get(i).songs.get(j).get_duration());
                        }
                    }
                    Scanner go = new Scanner(System.in);
                    int top = go.nextInt();
                    go.nextLine();

                    int count = 0;
                    int albumNum = 0;
                    while (count < top) {
                        count += albums.get(albumNum).songs.size();
                        albumNum++;
                    }
                    count -= albums.get(albumNum - 1).songs.size();

                    playlists.get(cup - 1).addSong(albums.get(albumNum - 1).songs.get(top - count-1), playlists.get(cup - 1));
//                    System.out.println("the song: " + albums.get(albumNum - 1).songs.get(top - count-1).get_title() + " is added to the playlist:" + playlists.get(cup - 1).title.toString());
                    printmenu();
                    break;
                case 5:
                    System.out.println("Choose the playlist");
                    for (int i = 0; i < playlists.size(); i++)
                        System.out.println((i + 1) + " " + playlists.get(i).title);
                    Scanner chup = new Scanner(System.in);
                    int chap = chup.nextInt();
                    chup.nextLine();
                    ListIterator<song> listIterator2 = playlists.get(chap - 1).playList.listIterator();
                    while (listIterator2.hasNext()) {
                        System.out.println(listIterator2.next().to_String());
                    }
                    System.out.println("press 3 for the main menu");
                    break;
                case 6:
                    System.out.println("Enter the name of the new playlist");
                    sc=new Scanner(System.in);
                    String nm = sc.nextLine();
                    playlist plst= new playlist(nm);
                    playlists.add(plst);
                    System.out.println("Your playlist named:"+nm+ " is created");
                    System.out.println("press 3 for the main menu");
                    break;
            }
        }
//        play(PlayList_1);
    }

//    static void showList(LinkedList<song> playList)
//    {
//
//    }

    static void play(LinkedList<song> playlist)
    {
        ListIterator<song> listIterator= playlist.listIterator();

        if(playlist.size()==0)
            System.out.println("This playlist has no song");
        else
        {
            System.out.println("Now playing:"+ listIterator.next().to_String());
            printmenu2();
        }

        Scanner st= new Scanner(System.in);
        boolean quit=false;
        boolean forward=true;

        while(!quit)
        {
            int ptr=st.nextInt();
            st.nextLine();

            switch(ptr)
            {
                case 0:
                quit=true;
                break;

                case 1:
                if(forward==false)
                {
                    if(listIterator.hasNext()) {
                        listIterator.next();
                        forward = true;
                    }
                }
                if(listIterator.hasNext())
                    System.out.println("Now playing:"+listIterator.next().get_title());
                else
                {
                    System.out.println("We are at the end of playlist");
                    listIterator.previous();
                    System.out.println(listIterator.next().get_title());
                }
                break;

                case 2:
                if(forward)
                {
                    if(listIterator.hasPrevious())
                    {
                        listIterator.previous();
                        forward=false;
                    }
                }
                if(listIterator.hasPrevious())
                    System.out.println("Now playing:"+listIterator.previous().get_title());
                else
                {
                    System.out.println("We are at the start of the playlist");
                    listIterator.next();
                    System.out.println("Now playing:"+listIterator.previous().get_title());
                }
                break;

                case 3:
                    if(forward)
                    {
                        listIterator.previous();
                        if(listIterator.hasNext())
                        {
                            System.out.println("Now playing:"+ listIterator.next().get_title());
                        }
                    }
                    else
                    {
                        listIterator.next();
                        if(listIterator.hasPrevious())
                        {
                            System.out.println("Now playing:"+ listIterator.previous().get_title());
                        }
                    }
                    break;

//                case 4:
//                    for(int i=0;i< albums.size();i++)
//                    {
//                        for(int j = 0; j< albums.get(i).songs.size(); j++)
//                        {
//                            System.out.println(albums.get(i).songs.get(j).get_title());
//                        }
//                    }
//                    break;

                case 5:
                    quit=true;
                    break;

                case 4:
                    if(playlist.size()==0)
                    {
                        System.out.println("The playlist is already empty");
                        break;
                    }

                    listIterator.remove();
                    if(listIterator.hasNext()){
//                        listIterator.next();
                        System.out.println("Now playing:"+listIterator.next().get_title());
                    }
                    else if(listIterator.hasPrevious())
                    {
//                        listIterator.previous();
                        System.out.println("Now playing:"+listIterator.previous().get_title());
                    }
                    else
                        System.out.println("The playlist is empty now");
                    break;

//                case 7:
//                    System.out.println("Choose the album");
//                    for(int i=0;i< albums.size();i++)
//                    {
//                        System.out.println((i+1)+" "+albums.get(i).name);
//                    }
//                    Scanner num = new Scanner(System.in);
//                    int x=num.nextInt();
//                    num.nextLine();
//                    if(x>0&&x<=albums.size()) {
//                        System.out.println("Choose the song");
//                        for (int i = 0; i < albums.get(x - 1).songs.size(); i++) {
//                            System.out.println((i + 1) + " " + albums.get(x - 1).songs.get(i).get_title());
//                        }
//                        Scanner ind = new Scanner(System.in);
//                        int y = ind.nextInt();
//                        ind.nextLine();
//                        albums.get(x - 1).addToPlaylist(y, playlist);
//                        System.out.println("The song is added to the playlist");
//                    }
//                    break;
                case 8:
                    ListIterator<song> listIterator1=playlist.listIterator();
                    while(listIterator1.hasNext())
                    {
                        System.out.println(listIterator1.next().get_title());
                    }


            }
        }

    }

    static void printmenu()
    {
        System.out.println("Available options\n press");
        System.out.println(
                "0 - to quit\n"+
//                "1 - to play next song\n"+
//                "2 - to play previous song\n"+
                "1 - play music\n"+
//                "3 - to replay the current song\n"+
                "2 - list of all songs \n"+
                "3 - Menu\n"+
//                "6 - delete current song\n"+
                "4 - add song in the playlist\n"+
                "5 - show playlist\n"+
                "6 - Create new playlist");
    }
    static void printmenu2() {
        System.out.println("Available options\n press");
        System.out.println("1 - to play next song\n" +
                "2 - to play previous song\n" +
                "3 - to replay the current song\n" +
                "4 - delete current song\n" +
                "5 - to exit");
    }
}
