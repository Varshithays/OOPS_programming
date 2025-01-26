package PRA;

import java.util.ArrayList;
import java.util.List;

class Library{
    int lid;
    String lname;
    List<Bookl> books;

    public Library(int lid, String lname, List<Bookl> books) {
        this.lid = lid;
        this.lname = lname;
        this.books = books;
    }
}
class Bookl{
    int bid;
    String title;
    String athor;
    double price;

    public Bookl(int bid, String title, String athor, double price) {
        this.bid = bid;
        this.title = title;
        this.athor = athor;
        this.price = price;
    }
}
class ServiceLiberary{
    public void searchBooksByAuthor(List<Library> ll,String name){
        List<Bookl> match = new ArrayList<>();
        for(Library l: ll){
            for(Bookl b: l.books){
                if(b.athor.equalsIgnoreCase(name)){
                    match.add(b);
                }
            }
        }
        if(match.isEmpty()){
            System.out.println("No book found");
        }else{
            for(Bookl i: match){
                System.out.println(i.title);
            }
        }
    }
}
public class Libraryn {
    public static void main(String[] args) {

    }
}
