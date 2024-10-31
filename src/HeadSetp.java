import java.util.*;

public class HeadSetp {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        HeadSet[] hs = new HeadSet[4];
        for (int i = 0; i < hs.length; i++) {
            String a = sc.nextLine();
            String b = sc.nextLine();
            int c = sc.nextInt();sc.nextLine();
            boolean d = sc.nextBoolean();sc.nextLine();

            hs[i] = new HeadSet(a,b,c,d);
        }
        String br = sc.nextLine();
        int ans1 = findTotalPriceForGivenBrand(hs,br);
        if(ans1!=0)
        {
            System.out.println(ans1);
        }
        else
        {
            System.out.println("No Headsets available with the given brand");
        }
        HeadSet ans2 = findAvailableHeadsetWithSecondMinPrice(hs);
        if(ans2!=null)
        {
            System.out.println(ans2.getHname());
            System.out.println(ans2.getPrice());
        }
        else
        {
            System.out.println("No Headsets available");
        }
    }

    public static int findTotalPriceForGivenBrand(HeadSet[]h, String b)
    {
        int sum = 0;
       // boolean found = false;
        for (int i = 0; i < h.length; i++) {
            if(h[i].getBrand().equalsIgnoreCase(b))
            {
                sum += h[i].getPrice();
                //found=true;
            }
        }
        return   sum;
    }

    public static HeadSet findAvailableHeadsetWithSecondMinPrice(HeadSet[] h)
    {
        List<HeadSet> match = new ArrayList<>();
        for(int i=0;i<h.length;i++){
            if(h[i].getAvailable()==true){
                match.add(h[i]);
            }
        }

        //match.sort(Comparator.comparingInt(HeadSet::getPrice));
        match.sort((s1,s2)->Integer.compare(s1.getPrice(),s2.getPrice()));

        if (match.size() < 2) {
            return null; // Not enough available headsets
        }

        return match.get(1);
        /*
        for (int i = 0; i < h.length-1; i++) {
            for (int j = i+1; j < h.length; j++) {
                if(h[i].getPrice()>h[j].getPrice())
                {
                    HeadSet k = h[i];
                    h[i] = h[j];
                    h[j] = k;
                }
            }
        }
        if(h[1].getAvailable()==true)
        {
            return h[1];
        }
        else
        {
            return null;
        }*/

    }
}
class HeadSet
{
    private String hname;
    private String brand;
    private int price;
    private boolean available;
    public HeadSet(String hname, String brand, int price,boolean available)
    {
        this.hname = hname;
        this.brand = brand;
        this.price = price;
        this.available = available;
    }
    public String getHname()
    {
        return hname;
    }
    public void setHname(String hname)
    {
        this.hname = hname;
    }
    public String getBrand()
    {
        return brand;
    }
    public void setBrand(String brand)
    {
        this.brand = brand;
    }
    public int getPrice()
    {
        return price;
    }
    public void setPrice(int price)
    {
        this.price = price;
    }
    public boolean getAvailable()
    {
        return available;
    }
    public void setAvailable(boolean available)
    {
        this.available = available;
    }
}