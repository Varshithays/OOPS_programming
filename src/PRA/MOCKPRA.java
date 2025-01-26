package PRA;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;

class  Book{
    int id;
    String title;
    String genre;
    private int noc;
    double price;
    public Book(int id,String title,String genre,int noc,double price){
        this.id=id;
        this.title=title;
        this.genre=genre;
        this.noc=noc;
        this.price=price;
    }
    public int getNoc(){
        return noc;
    }
}
public class MOCKPRA {
    public static void main(String args[]) throws Exception {
        Scanner in = new Scanner(System.in);
        int nob= Integer.parseInt(in.nextLine());
        ArrayList<Book> bl = new ArrayList<Book>();
        for(int i=0;i<nob;i++){
            int id=Integer.parseInt(in.nextLine());
            String name=in.nextLine();
            String genre=in.nextLine();
            int noc=Integer.parseInt(in.nextLine());
            double price=Double.parseDouble(in.nextLine());

            bl.add(new Book(id,name,genre,noc,price));
        }
        String input=in.nextLine();
        bookwithhighst(bl);
        searchgenre(bl,input);

    }
    public static void bookwithhighst(ArrayList<Book> bl){
        if(bl.size()<1){
            System.out.println("No Book found");
            return;
        }
        bl.sort(Comparator.comparingInt(Book::getNoc).reversed());
        Book maxo=bl.get(0);
        // System.out.println(maxo.getNoc());

        for(Book i: bl){
            if(i.getNoc()==maxo.getNoc()){
                System.out.println("Book ID: "+i.id);
                System.out.println("Name: "+i.title);
                System.out.println("Genre: "+i.genre);
                System.out.println("Number Of Copies: "+i.getNoc());
                System.out.println("Price: "+i.price);

            }
        }

    }
    public static void searchgenre(ArrayList<Book> bl,String input){
        ArrayList<Book> match= new ArrayList<>();
        for(Book b:bl){
            if(b.genre.equalsIgnoreCase(input)){
                match.add(b);
            }
        }
        if(!match.isEmpty()){
            for(Book m: match){
                System.out.println("Book ID: "+m.id);
                System.out.println("Name: "+m.title);
                System.out.println("Price: "+m.price);
            }
        }else{
            System.out.println("No Book found");
        }
    }
}