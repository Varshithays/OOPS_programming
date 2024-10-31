import java.util.*;

public class MobileDetailsp {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        MobileDetails[] m= new MobileDetails[4];
        for(int i=0;i<4;i++){
            int a=in.nextInt();
            in.nextLine();
            int b = in.nextInt();
            in.nextLine();
            String c= in.nextLine();
            boolean d = in.nextBoolean();
            m[i]= new MobileDetails(a,b,c,d);
        }
        String inputbrand= in.nextLine();
        MobileDetails ans= getSecondMin(m,inputbrand);
        if(ans!=null){
            for(int i=0;i<m.length;i++){
                System.out.println(ans.MobileId+" "+ans.Price);
            }

        }


    }
    public static MobileDetails getSecondMin(MobileDetails[] m,String inputbrand ){
        List<Integer> match = new ArrayList<>();
        for(int i=0;i<m.length;i++){
            if(m[i].Brand.equalsIgnoreCase(inputbrand)){
                match.add(m[i].Price);
            }
        }
        Set<Integer> unique = new HashSet<>(match);
        List<Integer> sortedPrices = new ArrayList<>(unique);
        Collections.sort(sortedPrices);

        // Check if there is a second minimum price
        if (sortedPrices.size() < 2) {
            return null;
        }
        int secondmin= sortedPrices.get(1);
        for(MobileDetails mb: m){
            if(mb.Price == secondmin){
                return mb;
            }
        }
        return null;

    }
}
class MobileDetails{
    int MobileId;
    int Price;
    String Brand;
    boolean isFlagShip;
    public MobileDetails(int MobileId,int Price,String Brand,boolean isFlagShip){
        this.MobileId=MobileId;
        this.Price=Price;
        this.Brand=Brand;
        this.isFlagShip=isFlagShip;
    }
}
