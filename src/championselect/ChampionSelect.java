/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package championselect;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.event.EventType;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.control.ToolBar;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
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
    private static final Image ICON_47 = new Image(BorderPaneSample.class.getResourceAsStream("Heal.png"));
    private static final Image ICON_46 = new Image(BorderPaneSample.class.getResourceAsStream("Flash.png"));
    @Override
    public void start(Stage primaryStage) {
        Group root = new Group();
        //ScrollPane windowScroller = new ScrollPane();
               
        primaryStage.setResizable(true);
        primaryStage.setFullScreen(true);
        primaryStage.setScene(new Scene(root, Color.BLACK)); // was 1600, 1200
              
        BorderPane borderPane = new BorderPane();
        borderPane.setMinWidth(1400);
        //windowScroller.setContent(borderPane);
        //windowScroller.setPrefSize(1600, 1200);
        
        /*ColumnConstraints columnConstraints = new ColumnConstraints();
        columnConstraints.setFillWidth(true);
        columnConstraints.setHgrow(Priority.ALWAYS);
        windowScroller.getColumnConstraints().add(columnConstraints);*/
        //sp.setFitToHeight(true);
        //sp.setFitToWidth(true);
        borderPane.setStyle("-fx-border-color: black;");
        //Top content
        Rectangle topRectangle = new Rectangle(800, 23, Color.BLACK);
        topRectangle.setStroke(Color.BLACK);
        borderPane.setTop(topRectangle);
     //   ToolBar toolbar = new ToolBar();
     //   borderPane.setTop(toolbar); 
        
        //Left content
        //Rectangle leftRectangle = new Rectangle(23, 400, Color.BLUE); //745
        //leftRectangle.setStroke(Color.BLUE);
        //borderPane.setLeft(leftRectangle);
        ChosenChampionsPanel leftPanel = new ChosenChampionsPanel(this, "Your Team");              
        borderPane.setLeft(leftPanel.get());
        //Right content
        //Rectangle rightRectangle = new Rectangle(23, 400, Color.GREENYELLOW);
        //rightRectangle.setStroke(Color.GREENYELLOW);
        //borderPane.setRight(rightRectangle);
        ChosenChampionsPanel rightPanel = new ChosenChampionsPanel(this, "Enemy Team");              
        borderPane.setRight(rightPanel.get());
        
        HBox topboxes = new HBox();
        topboxes.getChildren().addAll(new Button("1. Ban"), new Button("2. Pick"), new Button("3. Free"));
        topboxes.setAlignment(Pos.CENTER);
        borderPane.setTop(topboxes);
        
        //Bot content
        //Rectangle botRectangle = new Rectangle(800, 23, Color.ORANGE);
        //botRectangle.setStroke(Color.ORANGE);
        //borderPane.setBottom(botRectangle);       
        root.getChildren().add(borderPane);
        
        VBox centerBox = new VBox(8);
        HBox panelBox = new HBox(8);
        HBox statusBox = new HBox(8);
        Button yourTimer = new Button("");
        Button status = new Button("Please wait until the end of the ban phase. Team Captain nobody42 is currently banning.");
        Button theirTimer = new Button("26");
        statusBox.getChildren().addAll(yourTimer, status, theirTimer);
        statusBox.setAlignment(Pos.CENTER);
        statusBox.setStyle("-fx-padding: 12 30 12 30; -fx-focus-color: firebrick;");
        
        TilePane tilePane = new TilePane();
 
        Button[] buttons = new Button[100];
        for (int j = 0; j < buttons.length; j++) {
            buttons[j] = new Button("", new ImageView(ICON_48));
            tilePane.getChildren().add(buttons[j]);
        }
        
        TabPane champsAndSkinsPane = new TabPane();
        Tab championsTab = new Tab("Champions");
        Tab skinsTab = new Tab("Skins");
        ScrollPane championScroller = new ScrollPane();
        championScroller.setPrefSize(800, 500);
        tilePane.setPrefColumns(10);
        //tilePane.setTileAlignment(Pos.CENTER);
        championScroller.setContent(tilePane);
        
        championsTab.setContent(championScroller);
        
        Button temporary = new Button("Temporary Skin Object");
        skinsTab.setContent(temporary);
        champsAndSkinsPane.setTabClosingPolicy(TabPane.TabClosingPolicy.UNAVAILABLE);
        champsAndSkinsPane.getTabs().addAll(championsTab, skinsTab);
        champsAndSkinsPane.setMaxHeight(600);
        Button lockin = new Button("Lock In");
        HBox spells = new HBox();
        spells.getChildren().add(new ImageView(ICON_46));
        spells.getChildren().add(new ImageView(ICON_47));
        
        Button runesnmasteries = new Button("Runes and Masteries");
        
        panelBox.getChildren().addAll(runesnmasteries, spells, lockin);
        
        centerBox.getChildren().addAll(champsAndSkinsPane);
        VBox centerVBox = new VBox();
        centerVBox.getChildren().addAll(statusBox, centerBox, panelBox);
        borderPane.setCenter(centerVBox);
        
        //borderPane.setBottom(panelBox);
        BottomPanel bottomPanel = new BottomPanel(this);    
        borderPane.setBottom(bottomPanel.get());
        
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
    
    public Image getIcon_48(){
        return ICON_48;
    }
    
}
