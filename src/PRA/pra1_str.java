import java.util.Scanner;

class pra1_str{
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String w=in.nextLine();
        double we= Double.parseDouble(w);
        System.out.println(we);
        String h= in.nextLine();
        bmi(w,h);
        }

        public static void bmi(String weight,String height){
            double w,h;
            if(weight.contains(" pounds")){
                weight = weight.replaceAll("([a-z])", "");
                 w= Double.parseDouble(weight);
                w=w*0.452;
            }else{
                weight = weight.replaceAll("([a-z])", "");
                w= Double.parseDouble(weight);
            }
            if(height.contains(" inches")){
                height = height.replaceAll("([a-z])", "");
                h= Double.parseDouble(height);
                h=h*0.0254;
            }else{
                
                height= height.replaceAll("([a-z])", "");
                h= Double.parseDouble(height);
               // System.out.println(h);
            }
            double ans1=h*h;
            double ans2=w/ans1;
         //   System.out.println(ans1);
          //  double bmia = (w/h*h);
            System.out.printf("%.1f",ans2);

        }
}