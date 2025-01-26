package PRA;
/*I enjoy eating spaghetti and meatballs for dinner
eating
meatballs
2*/
import java.util.Scanner;

public class Consecutive
{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine().toLowerCase();
        String[] str = s.split(" ");
        int count=0;
        for (int i = 0; i < str.length; i++) {
            for (int j = 1; j < str[i].length(); j++) {
                if(isVowel(str[i].charAt(j))==true && isVowel(str[i].charAt(j-1))==true)
                {
                    count++;
                    System.out.println(str[i]);
                    break;
                }
            }
        }
        System.out.println(count);

    }
    public static boolean isVowel(char c)
    {
        if(c=='a'||c=='e'||c=='i'||c=='o'||c=='u')
        {
            return true;
        }
        return false;
    }
}
