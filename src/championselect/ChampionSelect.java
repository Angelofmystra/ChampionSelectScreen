/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package championselect;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ToolBar;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.TilePane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

/**
 *
 * @author bertrandbrompton
 */
public class ChampionSelect extends Application {
    private static final Image ICON_48 = new Image(BorderPaneSample.class.getResourceAsStream("icon-48x48.png"));
    @Override
    public void start(Stage primaryStage) {
        Group root = new Group();
        primaryStage.setResizable(true);
        primaryStage.setScene(new Scene(root, 800,800));
        
        BorderPane borderPane = new BorderPane();
        borderPane.setStyle("-fx-border-color: black;");
        //Top content
        Rectangle topRectangle = new Rectangle(800, 23, Color.BLACK);
        topRectangle.setStroke(Color.BLACK);
        borderPane.setTop(topRectangle);
     //   ToolBar toolbar = new ToolBar();
     //   borderPane.setTop(toolbar); 
        
        //Left content
        Rectangle leftRectangle = new Rectangle(23, 745, Color.BLUE);
        leftRectangle.setStroke(Color.BLUE);
        borderPane.setLeft(leftRectangle);        
        //Right content
        Rectangle rightRectangle = new Rectangle(23, 745, Color.GREENYELLOW);
        rightRectangle.setStroke(Color.GREENYELLOW);
        borderPane.setRight(rightRectangle);        
        //Bot content
        Rectangle botRectangle = new Rectangle(800, 23, Color.ORANGE);
        botRectangle.setStroke(Color.ORANGE);
        borderPane.setBottom(botRectangle);
        
        root.getChildren().add(borderPane);
        
        /*VBox vbox = new VBox(8); // spacing = 8
        vbox.getChildren().addAll(new Button("Cut"), new Button("Copy"), new Button("Paste"));
        
        VBox vbox2 = new VBox(8); // spacing = 8
        vbox2.getChildren().addAll(new Button("Cut"), new Button("Copy"), new Button("Paste"));
        
        borderPane.setLeft(vbox);
        borderPane.setRight(vbox2);*/
        
        VBox centerBox = new VBox(8);
        HBox panelBox = new HBox(8);
        
        TilePane tilePane = new TilePane();
        tilePane.setPrefColumns(3); //preferred columns
 
        Button[] buttons = new Button[100];
        for (int j = 0; j < buttons.length; j++) {
            buttons[j] = new Button("", new ImageView(ICON_48));
            tilePane.getChildren().add(buttons[j]);
        }
        
        Button lockin = new Button("Lock In");
        Button spells = new Button("Spells");
        Button runesnmasteries = new Button("Runes and Masteries");
        
        panelBox.getChildren().addAll(runesnmasteries, spells, lockin);
        
        centerBox.getChildren().addAll(tilePane, panelBox);
        borderPane.setCenter(centerBox);
        primaryStage.setTitle("Champion Selection Screen");
        primaryStage.show();
    }

    /**
     * The main() method is ignored in correctly deployed JavaFX application.
     * main() serves only as fallback in case the application can not be
     * launched through deployment artifacts, e.g., in IDEs with limited FX
     * support. NetBeans ignores main().
     *
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
