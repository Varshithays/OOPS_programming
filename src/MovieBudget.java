import java.util.Scanner;
class Movies{
    int movieId;
    String director;
    int rating;
    int budget;
    public Movies(int movieId,String director,int rating,int budget){
        this.movieId=movieId;
        this.director=director;
        this.rating=rating;
        this.budget=budget;
    }

}
public class MovieBudget {
    public  static void main(String[] args){
        Scanner in = new Scanner(System.in);
        Movies[] mv = new Movies[4];
        for(int i=0;i<4;i++){
            int a = in.nextInt(); in.nextLine();
            String b = in.nextLine();
            int c= in.nextInt();
            int d= in.nextInt();

            mv[i]=new Movies(a,b,c,d);
        }
        in.nextLine();
        String inputdir =in.nextLine();
        int inputrat=in.nextInt();
        in.nextLine();
        int inputbud=in.nextInt();
        in.nextLine();
        int ans= findAvgBudget(mv,inputdir);

        if(ans>0)
            System.out.println(ans);
        else
            System.out.println("Sorry");
        Movies obj = getMoviesByRatingBudget(mv,inputrat,inputbud);
        if(obj==null)
            System.out.println("Sorry");
        else
            System.out.println(obj.movieId);



    }

    public static int findAvgBudget(Movies[] mv,String inputdir){
        int avg=0;int j=0;
        int sum =0;
        for(int i=0;i<4;i++){
            if(mv[i].director.equalsIgnoreCase(inputdir)){
                sum+=mv[i].budget;
                j++;
            }
        }
            if(j>0){
                avg= sum/j;
                return avg;
            }else{
                return 0;
            }

    }

    public static Movies getMoviesByRatingBudget(Movies[] mv,int inputrat,int inputbud) {
        for (int i = 0; i < 4; i++)
        {
            if ((inputrat == mv[i].rating) && (inputbud == mv[i].budget) && (mv[i].budget % mv[i].rating == 0) )
            {
                return mv[i];
            }
        }
        return null;

    }
}
