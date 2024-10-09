import java.util.Scanner;

class OOPS1{
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        Movie[] mv= new Movie[2];
        String search;
        for(int i=0;i<mv.length;i++)
        {
            String a = in.nextLine();
            String b = in.nextLine();
            String c = in.nextLine();
            int d = in.nextInt();in.nextLine();

            mv[i] = new Movie(a,b,c,d);

        }
        search = in.nextLine();
        Movie[] newMovie = budgetForGivenMovie(mv,search);
        for(int i=0;i<newMovie.length;i++){
            if(newMovie[i].getBudget()>80000000){
                System.out.println("High Budget Movie");
            }else{
                System.out.println("Low Budget Movie");
            }
        }


    }

    public static Movie[]  budgetForGivenMovie(Movie[] mv, String genre)
    {
        int c=0;
        for(int i=0;i<mv.length;i++){
            if(mv[i].getGenre().equals(genre)){
                c++;
            }
        }
        int b=0;
        Movie[] m = new Movie[c];
        for(int i =0;i<mv.length;i++){
            if(mv[i].getGenre().equals(genre)){
                m[b]=mv[i];
                b++;
            }
        }
        return m;
    }
}
public class Movie {
    String movieName;
    String producingCompany;
    String genre;
    int budget;

    public Movie(String movieName,String producingCompany,String genre,int budget){
        this.movieName=movieName;
        this.producingCompany=producingCompany;
        this.genre=genre;
        this.budget=budget;
    }

    public int getBudget() {
        return budget;
    }

    public String getGenre() {
        return genre;
    }

    public String getMovieName() {
        return movieName;
    }

    public String getProducingCompany() {
        return producingCompany;
    }

    public void setMovieName(String movieName) {
        this.movieName = movieName;
    }

    public void setBudget(int budget) {
        this.budget = budget;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public void setProducingCompany(String producingCompany) {
        this.producingCompany = producingCompany;
    }

}
