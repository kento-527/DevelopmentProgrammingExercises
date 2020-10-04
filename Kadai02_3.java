

  import java.util.Scanner;
  import java.io.File;
  import java.io.IOException;

  public class Kadai02_3 {

      public static void main(String[] av)
      {

        String fname = "test.dat";
        if(av.length > 0){
          fname = av[0];
        }
        try{
          Scanner sc = new Scanner(new File(fname));
          int n = sc.nextInt();
          System.out.println("n="+n);


          int bar[] = new int[n];


          for (int i=0;i<n;i++){
            int v = sc.nextInt();
            bar[i] = v;
          }
          int Max1 = bar[0];
          int Max2 = bar[0];
          int x=0,y=1;




              for(int j=0;j<n;j++){
                if(Max1 < bar[j]){
                  Max1 = bar[j];
                  x=j;

                }
                }
  System.out.println("Max1="+Max1);
            for(int t=1;t<n;t++){
              if(bar[t-1]==bar[t]){
                y++;
              }
            }
            if(y!=n){
              for(int g=0;g<n;g++){
                if(Max2 < bar[g]){
                  if(Max1 >= bar[g] && x!=g){
                    Max2 = bar[g];
                  }

                }
              }

              System.out.println("Max2="+Max2);
  }



        }catch (IOException e){
          System.out.println(e);
        }

      }
  }

/*
n=9
Max1=9
Max2=7


n=9
Max1=1
*/
