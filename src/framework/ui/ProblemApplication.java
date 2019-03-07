package framework.ui;

import domains.farmer.FarmerProblem;
import javafx.application.Application;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.stage.Stage;

/**
 * This class presents problem solving domains in a tabbed pane.
 */
public class ProblemApplication extends Application {
    
    @Override
    public void start(Stage primaryStage) {
        TabPane tabPane = new TabPane();
        
	/* Add tabs using the following */
        ProblemGUI farmer = new ProblemGUI(new FarmerProblem(), 600, 750);
        Tab tab = new Tab();
        tab.setText("Prob");
        Node a = null;
        tab.setContent(farmer);
        tabPane.getTabs().add(tab);

	//... 
        
        Scene scene = new Scene(tabPane);
        primaryStage.setTitle("Problem Solver");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
    

    public static void main(String[] args) {
        launch(args);
    }
}