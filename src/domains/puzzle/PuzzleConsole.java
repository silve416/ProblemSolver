package domains.puzzle;

import framework.ui.ProblemConsole;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class PuzzleConsole
  extends Application
{
  public void start(Stage primaryStage)
  {
    Scene scene = new Scene(new ProblemConsole(new PuzzleProblem(), 600.0D, 800.0D));
    primaryStage.setTitle("Testing 8-Puzzle Console");
    primaryStage.setScene(scene);
    primaryStage.show();
  }
  
  public static void main(String[] args)
  {
    launch(args);
  }
}