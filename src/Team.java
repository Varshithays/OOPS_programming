import java.util.Scanner;

class Teamc{
    int tId;
    String tName;
    String tCategory;
    String tGameName;
    int tNumberOfPlayer;

    public Teamc(int tId,String tName,String tCategory,String tGameName,int tNumberOfPlayer){
        this.tId=tId;
        this.tName=tName;
        this.tCategory=tCategory;
        this.tGameName=tGameName;
        this.tNumberOfPlayer=tNumberOfPlayer;

    }


}
class Team {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);

        int length = in.nextInt();
        Teamc[] arr = new Teamc[length];
        in.nextLine();
        for(int i=0;i<arr.length;i++){
            int a = in.nextInt();
            in.nextLine();
            String b  = in.nextLine();
            String c = in.nextLine();
            String d  = in.nextLine();
            int e = in.nextInt();
            in.nextLine();

            arr[i]=new  Teamc(a,b,c,d,e);

        }
        String inputcat= in.nextLine();
        int inputnum=in.nextInt();

        Teamc obj = findTeam(arr,inputcat,inputnum);

        if(obj == null){
            System.out.println("No match found");
        }else{
            System.out.println(obj.tId);
        }
    }

    public static Teamc findTeam(Teamc[] arr,String inputcat,int inputnum){
        for(int i=0;i<arr.length;i++){
            if(arr[i].tCategory.equalsIgnoreCase(inputcat)&& arr[i].tNumberOfPlayer==inputnum){
                if(arr[i].tNumberOfPlayer%3==0){
                    return arr[i];
                }
            }
        }
        return null;
    }
}
