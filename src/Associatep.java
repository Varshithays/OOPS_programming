import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
public class Associatep{

    public static void main(String[] args) {
        Scanner in=new Scanner(System.in);
        Associate[] asso=new Associate[5];
        for(int i=0;i<5;i++) {
            String aName=in.nextLine();
            int aId=in.nextInt();
            in.nextLine();
            String technology=in.nextLine();
            int exp=in.nextInt();
            in.nextLine();
            asso[i]=new Associate(aName,aId,technology,exp);
        }
        String tech=in.nextLine();
        List<Integer> list1=getAssociateId(asso,tech);
        //Collections.sort(list1);
        for(int a:list1) System.out.println(a);
    }
    public static List<Integer> getAssociateId(Associate[] temp, String tech){
        List<Integer> list=new ArrayList<Integer>();
        for(int i=0;i<5;i++) {
            if(temp[i].getExperienceInYrs()%5==0 &&
                    temp[i].getAssociatTechnology().equalsIgnoreCase(tech)) {
                list.add(temp[i].getAssociateId());
            }
        }
        list.sort(Comparator.comparingInt(Integer::intValue));
        return list;
    }
}
class Associate{
    private String associateName;
    private int associateId;
    private String associatTechnology;
    private int experienceInYrs;
    public String getAssociateName() {
        return associateName;
    }
    public void setAssociateName(String associateName) {
        this.associateName = associateName;
    }
    public int getAssociateId() {
        return associateId;
    }
    public void setAssociateId(int associateId) {
        this.associateId = associateId;
    }
    public String getAssociatTechnology() {
        return associatTechnology;
    }
    public void setAssociatTechnology(String associatTechnology) {
        this.associatTechnology = associatTechnology;
    }
    public int getExperienceInYrs() {
        return experienceInYrs;
    }
    public void setExperienceInYrs(int experienceInYrs) {
        this.experienceInYrs = experienceInYrs;
    }
    public Associate(String associateName, int associateId, String associatTechnology, int
            experienceInYrs) {

        this
                .associateName = associateName
        ;

        this
                .associateId = associateId
        ;

        this
                .associatTechnology = associatTechnology
        ;

        this
                .experienceInYrs = experienceInYrs
        ;

    }
}