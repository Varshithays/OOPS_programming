import java.util.Scanner;

class Footwear {
    private int footwearId;
    private String footwearName;
    private String footwearType;
    private int price;

    public Footwear(int footwearId,String footwearName,String footwearType,int price){
        this.footwearId=footwearId;
        this.footwearName=footwearName;
        this.footwearType=footwearType;
        this.price=price;
    }

    public int getPrice() {
        return price;
    }

    public int getFootwearId() {
        return footwearId;
    }

    public String getFootwearName() {
        return footwearName;
    }

    public String getFootwearType() {
        return footwearType;
    }

}
class FootwearProgram{
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        Footwear[] arr  = new Footwear[5];

        for(int i=0;i<5;i++){
            int a = in.nextInt();
            in.nextLine();
            String b = in.nextLine();
            String c = in.nextLine();
            int d = in.nextInt();
            in.nextLine();

            arr[i]= new Footwear(a,b,c,d);
        }
        String inputType= in.nextLine();
        int result = getCountByType(arr,inputType);
        if(result>0){
            System.out.println(result);
        }else{
            System.out.println("Footwear is not available");
        }
    }
    public static int getCountByType(Footwear[] arr,String inputType){
        int count =0;
        for(int i=0;i<arr.length;i++){
            if(arr[i].getFootwearType().equalsIgnoreCase(inputType)){
                count++;
            }
        }
        return count;
    }
}
