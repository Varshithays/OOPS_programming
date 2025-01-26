import java.util.*;

class Doctor{
    int did;
    String dname;
    String special;
    List<Patient> patientList;

    public Doctor(int did, String dname, String special, List<Patient> patientList) {
        this.did = did;
        this.dname = dname;
        this.special = special;
        this.patientList=patientList;
    }
}
class Patient{
    int pid;
    String name;
    private String ill;

    public Patient(int pid,String name, String ill) {
        this.pid=pid;
        this.name = name;
        this.ill = ill;
    }
    public String getIll(){
        return ill;
    }
}
public class Practice3_ai {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n= Integer.parseInt(in.nextLine());
        List<Doctor> dl = new ArrayList<>();
        for(int i=0;i<n;i++){
            int a=Integer.parseInt(in.nextLine());
            String b=in.nextLine();
            String c= in.nextLine();

            int nop=Integer.parseInt(in.nextLine());
            List<Patient> pl = new ArrayList<>();
            for(int j=0;j<nop;j++){
                int f=Integer.parseInt(in.nextLine());
                String d=in.nextLine();
                String e=in.nextLine();

                pl.add(new Patient(f,d,e));
            }
            dl.add(new Doctor(a,b,c,pl));
        }
        int id= Integer.parseInt(in.nextLine());
        String specialization= in.nextLine();
        getUniqueIllness(dl,id);
        getDoctorBySpecialization(dl,specialization);
    }
    public static void getUniqueIllness(List<Doctor> dl,int id){
        Set<String> match = new TreeSet<>();
        for(Doctor i:dl){
            if(i.did==id){
                for(Patient c:i.patientList){
                    if(!match.contains(c.getIll())){
                        match.add(c.getIll());

                    }
                }
            }
        }
       // match.sort(Comparator.comparing(Patient :: getIll));
        if(match.isEmpty()){
            System.out.println("No doctor found");
        }else{
            for(String i: match){
                System.out.println(i);
            }
        }
    }
    public static void getDoctorBySpecialization(List<Doctor> dl,String specialization){
        List<Doctor> match = new ArrayList<>();
        boolean found=false;
        for(Doctor i:dl){
            if(i.special.equalsIgnoreCase(specialization)){
                found=true;
                match.add(i);
            }
        }
        if(found){
            for(Doctor d:match)
            System.out.println(d.dname);
        }else{
            System.out.println("No doctor found");
        }
    }
}
