import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

class Author{
    int aid;
    String authorname;
    String nationality;

ArrayList<Book> books;
    public Author(int aid, String authorname, String nationality,ArrayList<Book> books) {
        this.aid = aid;
        this.authorname = authorname;
        this.nationality = nationality;
        this.books=books;
    }
}
class Book{
    int bookId;
    String title;
    int pubyear;

    public Book(int bookId, String title, int pubyear) {
        this.bookId = bookId;
        this.title = title;
        this.pubyear = pubyear;
    }
}
class Service{
    public void getUniquePublishedYear(ArrayList<Author> at, int id) {
        boolean found=false;
        Set<Integer> unique = new HashSet<>();
        for (Author a : at) {
            if (a.aid == id) {
                found=true;
                for (Book b : a.books) {
                    unique.add(b.pubyear);
                }
               break;
            }
        }
        if(!found){
            System.out.println("Not found");
        }else{
            for(Integer a: unique){
                System.out.println(a);
            }
        }
    }
    public void getBooksByNationality(ArrayList<Author> at,String input){
        boolean foundn=false;
        for(Author i: at){
            if(i.nationality.equalsIgnoreCase(input)){
                foundn=true;
                for(Book b: i.books){
                    System.out.println(b.title);
                }
            }
        }
        if(!foundn){
            System.out.println("Author not found");
        }

    }
}
public class Practice1_ai {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int na=Integer.parseInt(in.nextLine());
        ArrayList<Author>  at= new ArrayList<>();
        for(int i=0;i<na;i++){
            int aid=Integer.parseInt(in.nextLine());
            String name=in.nextLine();
            String nationality= in.nextLine();

            int nob= Integer.parseInt(in.nextLine());
            ArrayList<Book> bl = new ArrayList<>();

            for(int j=0;j<nob;j++){
                int bookId=Integer.parseInt(in.nextLine());
                String title= in.nextLine();
                int pubyear=Integer.parseInt(in.nextLine());

                bl.add(new Book(bookId,title,pubyear));
            }
            at.add(new Author(aid,name,nationality,bl));
         }
        int id= Integer.parseInt(in.nextLine());
        String input= in.nextLine();
        Service a= new Service();
        a.getUniquePublishedYear(at,id);
       a.getBooksByNationality(at,input);


    }

}
