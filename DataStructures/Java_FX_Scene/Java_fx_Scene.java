/* *****************************************
 *  Author : Anatolie Jentimirn   
 *  Created On : Tue Apr 16 2024
 *  File : Topic5Lab1.java
 *  Description: 
 * ******************************************/



 import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;

public class Java_fx_Scene extends Application {

    @Override
    public void start(Stage primaryStage) {
        VBox vbox = new VBox(20); // spacing 

        Label label = new Label("Top Label");
     
        Button button = new Button("press");

        Circle circle = new Circle(25);
        circle.setStroke(Color.BLUE);
        circle.setFill(Color.ALICEBLUE);
    
        vbox.getChildren().addAll(label, button, circle);
     
        Scene scene = new Scene(vbox, 400, 300);
    
        primaryStage.setTitle(" Jentimir Anatolie");
        
        primaryStage.setScene(scene);
    
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
//