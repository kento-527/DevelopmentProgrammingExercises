import java.util.Scanner;
import java.io.*;
import javafx.application.*;
import javafx.stage.*;
import javafx.scene.*;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.paint.*;
import javafx.geometry.*;
import javafx.scene.text.*;

public class Kadai05_2 extends Application
{
  private static int[][] board = new int[9][9];
  private TextField[][] tf = new TextField[9][9];
  private Button bt;

  public static void main(String[] args)
  {
    String fname = "input.txt";

    if(args.length>0) fname = args[0];

    try{
      Scanner sc = new Scanner(new File(fname));
      for(int i=0;i<9;i++){
        for(int j=0;j<9;j++){
          board[i][j] = sc.nextInt();
          if(board[i][j] < 0 ||9 < board[i][j]) board[i][j] = 0;
        }
      }
      for (int i=0;i<9;i++){
        for(int j=0;j<9;j++){
          System.out.print(board[i][j] + "");
        }
        System.out.println();
      }
    }
    catch (Exception e){
      e.printStackTrace();
    }
    launch(args);
  }
  public void start(Stage stage)throws Exception
  {
    for(int i=0;i<9;i++){
      for(int j=0;j<9;j++){
        if(board[i][j] == 0){
          tf[i][j] = new TextField();
        }else{
          tf[i][j] = new TextField(String.valueOf(board[i][j]));
          tf[i][j].setEditable(false);
          tf[i][j].setBackground(new Background (new BackgroundFill(Color.GRAY,null,null)));
        }
        tf[i][j].setMaxWidth(40);
        tf[i][j].setFont(Font.font("MonoSpace",20));
      }
    }
    GridPane gp = new GridPane();
    gp.setHgap(5);
    gp.setVgap(5);
    for(int i=0; i<9;i++){
      for(int j=0;j<9;j++){
      gp.add(tf[i][j],j,i);
      }
    }


    GridPane sub_gp1 = new GridPane();
    sub_gp1.setHgap(5);
    sub_gp1.setVgap(5);
    for(int i=0;i<3;i++){
      for(int j=0;j<3;j++){
        sub_gp1.add(tf[i][j],j,i);
      }
    }




    GridPane sub_gp2 = new GridPane();
    sub_gp2.setHgap(5);
    sub_gp2.setVgap(5);
    for(int i=0;i<3;i++){
      for(int j=3;j<6;j++){
        sub_gp2.add(tf[i][j],j,i);
      }
    }

    GridPane sub_gp3 = new GridPane();
    sub_gp3.setHgap(5);
    sub_gp3.setVgap(5);
    for(int i=0;i<3;i++){
      for(int j=6;j<9;j++){
        sub_gp3.add(tf[i][j],j,i);
      }
    }





    GridPane sub_gp4 = new GridPane();
    sub_gp4.setHgap(5);
    sub_gp4.setVgap(5);
    for(int i=3;i<6;i++){
      for(int j=0;j<3;j++){
        sub_gp4.add(tf[i][j],j,i);
      }
    }


    GridPane sub_gp5 = new GridPane();
    sub_gp5.setHgap(5);
    sub_gp5.setVgap(5);
    for(int i=3;i<6;i++){
      for(int j=3;j<6;j++){
        sub_gp5.add(tf[i][j],j,i);
      }
    }

    GridPane sub_gp6 = new GridPane();
    sub_gp6.setHgap(5);
    sub_gp6.setVgap(5);
    for(int i=3;i<6;i++){
      for(int j=6;j<9;j++){
        sub_gp6.add(tf[i][j],j,i);
      }
    }

    GridPane sub_gp7 = new GridPane();
    sub_gp7.setHgap(5);
    sub_gp7.setVgap(5);
    for(int i=6;i<9;i++){
      for(int j=0;j<3;j++){
        sub_gp7.add(tf[i][j],j,i);
      }
    }

    GridPane sub_gp8 = new GridPane();
    sub_gp8.setHgap(5);
    sub_gp8.setVgap(5);
    for(int i=6;i<9;i++){
      for(int j=3;j<6;j++){
        sub_gp8.add(tf[i][j],j,i);
      }
    }

    GridPane sub_gp9 = new GridPane();
    sub_gp9.setHgap(5);
    sub_gp9.setVgap(5);
    for(int i=6;i<9;i++){
      for(int j=6;j<9;j++){
        sub_gp9.add(tf[i][j],j,i);
      }
    }

    GridPane sub_gp10 = new GridPane();
    sub_gp10.setHgap(10);
    sub_gp10.setVgap(10);
    sub_gp10.add(sub_gp1,0,0);
    sub_gp10.add(sub_gp2,1,0);
    sub_gp10.add(sub_gp3,2,0);
    sub_gp10.add(sub_gp4,0,1);
    sub_gp10.add(sub_gp5,1,1);
    sub_gp10.add(sub_gp6,2,1);
    sub_gp10.add(sub_gp7,0,2);
    sub_gp10.add(sub_gp8,1,2);
    sub_gp10.add(sub_gp9,2,2);


    sub_gp10.setAlignment(Pos.CENTER);

    BorderPane bp = new BorderPane();
    bp.setTop(sub_gp10);


    bt = new Button("リセット");
    GridPane gp_bt = new GridPane();
    gp_bt.add(bt,0,0);
    gp_bt.setAlignment(Pos.CENTER);

    
    bp.setBottom(gp_bt);


    Scene sc = new Scene(bp,500,500);
    stage.setScene(sc);
    stage.setTitle("数独");
    stage.show();
  }
}
