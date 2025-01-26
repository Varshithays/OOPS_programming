import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Score {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int n= in.nextInt();
        int[] arr= new int[n];
        for(int i=0;i<arr.length;i++){
            arr[i]= in.nextInt();
        }
    List<Integer> valid= findValidScores(arr);
        if(valid==null){
            System.out.println("none");
        }else{
            System.out.println(valid);
        }

    }
    public static boolean validateScore(int score){

        return score>0 && score<=100;
    }
    public static List<Integer> findValidScores(int[] arr){
        List<Integer> match = new ArrayList<>();
        for(int i=0;i<arr.length;i++){
            if(validateScore(arr[i])){
                match.add(arr[i]);
            }
        }
        if(match.isEmpty()){
            return null;
        }else{
            return match;
        }
    }
}
