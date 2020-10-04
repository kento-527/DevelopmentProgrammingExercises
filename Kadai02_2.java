
import java.util.Scanner;
public class Kadai02_2 {
    public static void main(String[] args)
    {
        Scanner sc=new Scanner(System.in);

        System.out.print("input number n:");
        int n=sc.nextInt();

        int bar[] = new int[n];


        for (int i=0;i<n;i++){
          int v = sc.nextInt();
          bar[i] = v;
        }
        int Max = bar[0];
        int Min = bar[0];

        for(int j=0;j<n;j++){
          if(Max < bar[j]){
            Max = bar[j];
          }else if(Min > bar[j]){
            Min = bar[j];

            }
          }
          System.out.println("Max"+Max);
          System.out.println("Min"+Min);

        }

}

/*
input number n:8
2
5
4
2
7
9
1
3
Max9
Min1
*/
