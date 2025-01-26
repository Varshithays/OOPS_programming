package PRA;

import java.util.ArrayList;
import java.util.Scanner;

class MusicApp{
    int appId;
    String appName;
    int appSubscription;
    ArrayList<Song> songs;
    public MusicApp(int appId,String appName,int appSubscription,ArrayList<Song> songs){
        this.appId=appId;
        this.appName=appName;
        this.appSubscription=appSubscription;
        this.songs=songs;
    }
}
class Song{
    int songid;
    String songName;
    String singerName;
    int songViews;
    public Song(int songid,String songName,String singerName,int songViews){
        this.songid=songid;
        this.songName=songName;
        this.singerName=singerName;
        this.songViews=songViews;
    }
}
class Servicem {
    public int CalculateAverageViewBySingerName(ArrayList<MusicApp> ll, String name) {
        int sum = 0;
        int count = 0;
        for (MusicApp m : ll) {
            for (Song s : m.songs) {
                if (s.singerName.equalsIgnoreCase(name)) {
                    if (s.songViews < 0) {
                        System.out.println("Invalid Songsview: SongViews cannot negative");
                    } else {
                        sum += s.songViews;
                        count++;
                    }
                }
            }
        }
            if (count == 0) {
                System.out.println("No song found with mentioned singerName");
                return 0;
            } else {
                int avg = sum / count;
                return avg;
            }
    }
    public ArrayList<MusicApp> findmusicAppOfSongsBySongName(ArrayList<MusicApp> ll,String sname){
        ArrayList<MusicApp> match= new ArrayList<>();
        for(MusicApp m:ll) {
            for (Song s : m.songs) {
                if (s.songName.equalsIgnoreCase(sname)) {
                    match.add(m);
                }
            }
        }
        if(match.isEmpty()){
            System.out.println("No match");
        }
        return match;
    }

}
public class MusicAppService {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n=in.nextInt();in.nextLine();
        ArrayList<MusicApp> ll = new ArrayList<>();
        for(int i=0;i<n;i++){
            int appid=in.nextInt();
            in.nextLine();
            String appName= in.nextLine();
            int appSubscription= in.nextInt();
in.nextLine();
            int ns=in.nextInt();in.nextLine();
            ArrayList<Song> sl= new ArrayList<>();
            for(int j=0;j<ns;j++){
                int songid=in.nextInt();
                in.nextLine();
                String songName=in.nextLine();
                String singerName=in.nextLine();
                int songViews =in.nextInt();in.nextLine();

                sl.add(new Song(songid,songName,singerName,songViews));
            }
            ll.add(new MusicApp(appid,appName,appSubscription,sl));
        }
        String name=in.nextLine();
        String sname=in.nextLine();
        Servicem sm= new Servicem();
        int ans1=sm.CalculateAverageViewBySingerName(ll,name);
        if(ans1!=0){
            System.out.println(ans1);
        }
        ArrayList<MusicApp> ans =sm.findmusicAppOfSongsBySongName(ll,sname);
        for(MusicApp i:ans){
            System.out.println(i.appName);
        }
    }


}
