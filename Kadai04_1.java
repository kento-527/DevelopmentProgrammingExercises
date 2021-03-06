import javafx.application.*;
import javafx.stage.*;
import javafx.scene.*;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.paint.*;
import javafx.scene.canvas.*;
import javafx.scene.text.*;
import java.util.*;


public class Kadai04_1 extends Application
{
  private Canvas cv;
  final int WIDTH = 500;
  final int HEIGHT = 200;
  final int RADIUS = 80;

  public static void main(String[] args)
  {
    launch(args);
  }
  public void start(Stage stage)throws Exception
  {
    cv = new Canvas(WIDTH,HEIGHT);
    GraphicsContext gc = cv.getGraphicsContext2D();
    BorderPane bp = new BorderPane();
    bp.setCenter(cv);
    Scene sc = new Scene(bp,WIDTH,HEIGHT);
    stage.setScene(sc);
    stage.setTitle("60秒タイマー");
    stage.show();


    Thread th = new Thread(() -> {
      while (true)
      {
        gc.clearRect(0,0, WIDTH, HEIGHT);
        int rad_s = (int)(RADIUS * 0.8);
        int cx = WIDTH*5/7;
        int cy = HEIGHT/2;
        Calendar now = new GregorianCalendar();
        int hour = now.get(Calendar.HOUR_OF_DAY);
        int minute = now.get(Calendar.MINUTE);
        int second = now.get(Calendar.SECOND);
        double theta_sec = second/30.0*Math.PI-Math.PI/2;
        double xs = rad_s*Math.cos(theta_sec);
        double ys = rad_s*Math.sin(theta_sec);

        gc.setFont(new Font("Arial",32));
        gc.fillText(String.format("%02d:%02d:%02d",hour,minute,second),WIDTH/8,HEIGHT/2);
        gc.setStroke(Color.BLACK);
        gc.strokeOval(cx-RADIUS,cy-RADIUS,RADIUS*2,RADIUS*2);
        gc.setStroke(Color.RED);
        gc.strokeLine(cx,cy,(int)(cx+xs),(int)(cy+ys));
        try{
          Thread.sleep(1000);
        }catch(Exception e){
        }

      }
    });
    th.setDaemon(true);
    th.start();
  }
}
