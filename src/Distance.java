import java.util.Scanner;
public class Distance {
    public static void main(String args[] ) throws Exception {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT */
        Scanner in =new Scanner(System.in);
        int x1,y1,x2,y2;
        x1=in.nextInt();//0
        y1=in.nextInt();//0
        x2=in.nextInt();//3
        y2=in.nextInt();//4
        Point p1=new Point(x1,y1);
        Point p2=new Point(x2,y2);
        double dis=findDistance(p1,p2);
        System.out.format("%.3f",dis);

    }

    public static double findDistance(Point p1, Point p2)
    {
        double dis=Math.sqrt((p2.x-p1.x)*(p2.x-p1.x)+(p2.y-p1.y)*(p2.y-p1.y));//25 ->5
        return dis;
    }
}

class Point
{
    int x,y;
    Point(int x,int y){
        this.x=x;
        this.y=y;
    }
}