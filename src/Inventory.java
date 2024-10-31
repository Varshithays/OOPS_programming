import java.util.Arrays;
import java.util.Scanner;

class OOPS2{
    public static  void main(String[] args)
    {
        Scanner in= new Scanner(System.in);
        Inventory[] inv= new Inventory[4];
        for(int i=0;i<inv.length;i++)
        {
            int InventoryId = in.nextInt();
            in.nextLine();
            int maximumQuantity=in.nextInt();
            in.nextLine();
            int currentQuantity=in.nextInt();in.nextLine();
            int threshold = in.nextInt();in.nextLine();

            inv[i]= new Inventory(InventoryId,maximumQuantity,currentQuantity,threshold);
        }
        int limit = in.nextInt();
        Inventory[] newInventory = replenish(inv,limit);
        for(int i=0;i< newInventory.length;i++)
        {
            if(newInventory[i].getThreshold() >= 75)
            {
                System.out.println(newInventory[i].getInventoryId()+"Critical Filling");
            }
            else if(newInventory[i].getThreshold()<=74 && newInventory[i].getThreshold()>=50)
            {
                System.out.println(newInventory[i].getInventoryId()+"Moderate Filling");
            }else{
                System.out.println(newInventory[i].getInventoryId()+"Non-Critical Filling");
            }
        }
    }

    public static Inventory[] replenish(Inventory[] it,int limit){
        //int count = 0;
        Inventory[] newInventory= new Inventory[0];
        for(int i=0;i<it.length;i++){
            if(it[i].getThreshold()<=limit){
                newInventory= Arrays.copyOf(newInventory,newInventory.length+1);
                newInventory[newInventory.length-1]=it[i];
            }
        }

        return newInventory;
    }
}
class Inventory {
    int InventoryId;
    int maximumQuantity;
    int currentQuantity;
    int threshold;

    public Inventory(int InventoryId,int maximumQuantity,int currentQuantity,int threshold){
        this.InventoryId=InventoryId;
        this.maximumQuantity=maximumQuantity;
        this.currentQuantity=currentQuantity;
        this.threshold=threshold;
    }
    public int getInventoryId() {
        return InventoryId;
    }

    public void setInventoryId(int InventoryId) {
        InventoryId = InventoryId;
    }

    public int getCurrentQuantity() {
        return currentQuantity;
    }

    public int getMaximumQuantity() {
        return maximumQuantity;
    }

    public int getThreshold() {
        return threshold;
    }

    public void setCurrentQuantity(int currentQuantity) {
        this.currentQuantity = currentQuantity;
    }

    public void setMaximumQuantity(int maximumQuantity) {
        this.maximumQuantity = maximumQuantity;
    }

    public void setThreshold(int threshold) {
        this.threshold = threshold;
    }
}
