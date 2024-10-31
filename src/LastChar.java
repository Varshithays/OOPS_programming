import java.util.Scanner;

public class LastChar
{
    public static void main(String[] args)
    {
        Scanner in = new Scanner(System.in);
        String str = in.nextLine();
        str.toLowerCase();
        int count=0;
        String words[] = str.split(" ");
        for(int i=0;i<words.length;i++){
            System.out.println(str.charAt(words.length));
        }
    }
}
