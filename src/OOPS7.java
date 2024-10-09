import java.util.Scanner;

class Phone{
    int phoneId;
    String os;
    String brand;
    int price;
    public Phone(int phoneId,String os,String brand,int price){
        this.phoneId=phoneId;
        this.os=os;
        this.brand=brand;
        this.price=price;
    }
}
public class OOPS7 {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        Phone[] arr = new Phone[4];
        for(int i=0;i<4;i++){
            int a =in.nextInt();
            in.nextLine();
            String b= in.nextLine();
            String c = in.nextLine();
            int d = in.nextInt();
            in.nextLine();

            arr[i] = new Phone(a,b,c,d);


        }
        String inputbrand = in.nextLine();
        String inputos = in.nextLine();
        int result = findPriceForGivenBrand(arr,inputbrand);
        if(result ==0){
            System.out.println("no");
        }else{
            System.out.println(result);
        }
        Phone obj= getPhonebasedOnOs(arr,inputos);
        if(obj == null){
            System.out.println("No phonwes");
        }else{
            System.out.println(obj.phoneId);
        }

    }

    public static int findPriceForGivenBrand(Phone[] arr,String inputbrand){
        int sum =0;
        for(int i=0;i<4;i++){
            if(arr[i].brand.equalsIgnoreCase(inputbrand)){
                sum+=arr[i].price;
            }
        }
        return sum;
    }

    public static Phone getPhonebasedOnOs(Phone[] arr,String inputos) {

        for (int i = 0; i < 4; i++) {
            if (arr[i].os.equalsIgnoreCase(inputos) ) {
                if(arr[i].price >= 50000){
                    return arr[i];
                }
            }

        }
        return null;
    }
}
