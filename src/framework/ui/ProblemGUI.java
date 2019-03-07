/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package framework.ui;

import framework.problem.Problem;
import framework.solution.SolvingAssistant;
import framework.problem.Mover;
import java.util.ArrayList;

import java.util.List;
import java.util.stream.Stream;
import javafx.animation.Animation;
import javafx.animation.ScaleTransition;
import javafx.animation.TranslateTransition;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonBuilder;
import javafx.scene.control.Label;
import javafx.scene.control.Spinner;
import javafx.scene.control.Slider;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderStroke;
import javafx.scene.layout.BorderStrokeStyle;
import javafx.scene.layout.BorderWidths;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Circle;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import javafx.util.Duration;

/**
 *
 * @author Maxwell
 */
public class ProblemGUI extends VBox{
    
    Problem problem;
    double height;
    double width;
    Label welcomeMessage;
    Label problemPrompt;
    
    Label curState;
    Label goalState;
    Label curLabel;
    Label moveLabel;
    Label goalLabel;
    Label solvedLabel;
    
    VBox curBox;
    VBox moveBox;
    VBox goalBox;   
    VBox resetBox;
    HBox mainBox;
    
    Button resetButton;
    
    private static final String SKIP_LINE = "\n\n";
    private static final String NEW_LINE = "\n";
    private static final String BLANK_LINE = "";
    
    private static final String solved = "YOU SOLVED THE PROBLEM!";
    
    Border a;
    //Label options;
       
    SolvingAssistant solver;
    
    private List<Button> buttons;
    List<String> names;
    
   public ProblemGUI(Problem problem, double width, double height) {
       this.width = width;
       this.height = height;
       this.problem = problem;
       solver = new SolvingAssistant(problem);      
       this.welcomeMessage = new Label("Welcome to the " + problem.getName() + " problem!");
       welcomeMessage.setPadding(new Insets(0,40,0,40));
       welcomeMessage.setFont(new Font("Times New Roman",20));
       
       buttons = new ArrayList();
       this.problemPrompt = new Label(problem.getIntroduction());
       problemPrompt.setWrapText(true);
       problemPrompt.setMaxWidth(400);
       problemPrompt.setPadding(new Insets(0, 200, 0, 40));
       problemPrompt.setAlignment(Pos.CENTER);
       
       this.curState = new Label(problem.getCurrentState().toString());
       curState.setPadding(new Insets(0,40,0,40));
       this.a = new Border(new BorderStroke(Color.BLACK, BorderStrokeStyle.SOLID, CornerRadii.EMPTY, new BorderWidths(1)));
       this.curState.setBorder(a);       
               
        solvedLabel = new Label("");
        solvedLabel.setAlignment(Pos.CENTER);
        solvedLabel.setPadding(new Insets(0,200,0,200)); 
        solvedLabel.setTextFill(Color.RED);        
       
       resetButton = new Button("Reset");
       resetButton.setAlignment(Pos.CENTER);
//       resetButton.setPadding(new Insets(0,20,0,200));       
       resetButton.setOnAction(e -> {
                                    solvedLabel.setText("");
                                    problem.setCurrentState(problem.getInitialState());
                                    curState.setText(problem.getCurrentState().toString());
                                    solver = new SolvingAssistant(problem);
                                    moveLabel.setText("Moves: "+ solver.getMoveCount());                                            
                                    });
       resetBox = new VBox();
       resetBox.setAlignment(Pos.BOTTOM_CENTER);
       resetBox.getChildren().addAll(solvedLabel, resetButton);
       
       goalState = new Label(problem.getFinalState().toString());
       goalState.setPadding(new Insets(0,40,0,40));      
       goalState.setBorder(a);       
           
        curLabel = new Label("Current State:");
        curBox = new VBox();
        curBox.setAlignment(Pos.CENTER_LEFT);
        curBox.getChildren().addAll(curLabel,curState);
        
        moveLabel = new Label("Moves: "+ solver.getMoveCount());
        moveBox = new VBox();
        moveBox.setAlignment(Pos.CENTER);
        moveBox.getChildren().addAll(moveLabel);
	
        goalLabel = new Label("Goal State:");
        goalBox = new VBox();
        goalBox.setAlignment(Pos.CENTER_LEFT);
        goalBox.getChildren().addAll(goalLabel,goalState);

        
        mainBox = new HBox();
        mainBox.setAlignment(Pos.BOTTOM_CENTER);
        mainBox.getChildren().addAll(curBox, moveBox, goalBox);
        
        
        
        super.getChildren().addAll(welcomeMessage,
                                    problemPrompt,
                                    mainBox,
                                    resetBox);
   
        makeButtons();
    }
    
   private void makeButtons(){       
      List<String> names = problem.getMover().getMoveNames();
   
        for (String name : names){
            Button button = new Button(name);
            moveBox.getChildren().addAll(button);
            button.setOnAction(e-> {mainBox.getChildren().clear();
                                               curBox.getChildren().clear();
                                               solver.tryMove(name);
                                               moveLabel.setText(String.valueOf(solver.getMoveCount()));
                                               curState = new Label(problem.getCurrentState().toString());
                                               curState.setPadding(new Insets(0,40,0,40));
                                               curState.setBorder(a);
                                               if (problem.getCurrentState().equals(problem.getFinalState())){
                                                   solvedLabel.setText(solved);
                                               }
                                               curBox.getChildren().addAll(curLabel, curState);
                                               mainBox.getChildren().addAll(curBox, moveBox, goalBox);});
                        
        }
        
   
    }
}