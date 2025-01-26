import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MusicPlay {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        Music[] m= new Music[4];
        for(int i=0;i<4;i++){
            int a = in.nextInt();
            in.nextLine();
            String b = in.nextLine();
            int c= in.nextInt();
            in.nextLine();
            double d=in.nextDouble();
            in.nextLine();

            m[i]= new Music(a,b,c,d);
        }
        int inputcn= in.nextInt();
        in.nextLine();
        int inputdur=in.nextInt();
        in.nextLine();
        int ans= findAvgOfCount(m,inputcn);
        if(ans!=0){
            System.out.println(ans);
        }else{
            System.out.println("NO");
        }
        Music[] res= sortTypeByDuration(m,inputdur);
        if(res!=null){
            for(int i=0;i<res.length;i++) {
                System.out.println(res[i].type);
            }
        }else{
            System.out.println("NO");
        }
    }
    public static int findAvgOfCount(Music[] m,int inputcn){
        int cn=0,sum=0;
        for(int i=0;i<4;i++){
            if(m[i].count>inputcn){
                sum+=m[i].count;
                cn++;
            }
        }
        int avg=0;
        avg=sum/cn;
        return avg;
    }
    public static Music[] sortTypeByDuration(Music[] m,int inputdur){
        List<Music> ls= new ArrayList<>();
        for(int i=0;i<m.length;i++){
            if(m[i].getDuration()>inputdur){
                ls.add(m[i]);
            }
        }
        if(ls.isEmpty()){
            return null;
        }
        ls.sort((s1,s2)-> Double.compare(s1.getDuration(),s2.getDuration()));

        return ls.toArray(new Music[0]);

    }

}
class Music{
    int playListNo;
    String type;
    int count;
    double duration;
    public Music(int playListNo,String type,int count,double duration){
        this.playListNo=playListNo;
        this.type=type;
        this.count=count;
        this.duration=duration;
    }
    public double getDuration(){
        return duration;
    }
}
