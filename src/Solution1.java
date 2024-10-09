import java.util.Scanner;

class Solution1 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        HeadSets[] hs = new HeadSets[4];
        for (int i = 0; i < hs.length; i++) {
            String a = in.nextLine();
            String b = in.nextLine();
            int c = in.nextInt();
            boolean d = in.nextBoolean();
            in.nextLine();

            hs[i] = new HeadSets(a, b, c, d);
        }

        String new_brand = in.nextLine();
        int sum = findTotalPriceForGivenBrand(hs, new_brand);
        if (sum > 0) {
            System.out.println(sum);
        } else {
            System.out.println("No Headsets available with the given brand");
        }

        HeadSets res = findAvailableHeadsetWithSecondMinPrice(hs);
        if (res != null) {
            System.out.println(res.getHeadsetName());
            System.out.println(res.getPrice());
        } else {
            System.out.println("No Headsets avilable");
        }
    }

    public static int findTotalPriceForGivenBrand(HeadSets[] hs, String brand) {
        int sum = 0;
        for (int i = 0; i < hs.length; i++) {
            if (hs[i].getBrand().equalsIgnoreCase(brand)) {
                sum = sum + hs[i].getPrice();
            }
        }
        return sum;
    }

    public static HeadSets findAvailableHeadsetWithSecondMinPrice(HeadSets[] hs) {
        int count = 0;
        HeadSets temp = null;

        for (int i = 0; i < hs.length; i++) {
            if (hs[i].isAvailable()) {
                count++;
            }
        }
        HeadSets[] newheadset = new HeadSets[count];
        int k = 0;
        for (int i = 0; i < hs.length; i++) {
            if (hs[i].isAvailable()) {
                newheadset[k] = hs[i];
                k++;
            }
        }

        for (int i = 0; i < newheadset.length; i++) {
            for (int j = i + 1; j < newheadset.length; j++) {
                if (newheadset[i].getPrice() > newheadset[j].getPrice()) {
                    temp = newheadset[i];
                    newheadset[i] = newheadset[j];
                    newheadset[j] = temp;
                }
            }
        }
        if(count>0){
            return newheadset[1];
        }else{
            return null;
        }
    }
}
class HeadSets {
    private String headsetName;
    private String brand;
    private int price;
    private boolean available;

    public HeadSets(String headsetName,String brand,int price,boolean available){
        this.headsetName=headsetName;
        this.brand=brand;
        this.price=price;
        this.available= available;

    }

    public boolean isAvailable() {
        return available;
    }

    public int getPrice() {
        return price;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }

    public String getBrand() {
        return brand;
    }

    public String getHeadsetName() {
        return headsetName;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public void setHeadsetName(String headsetName) {
        this.headsetName = headsetName;
    }

    public void setPrice(int price) {
        this.price = price;
    }
}
