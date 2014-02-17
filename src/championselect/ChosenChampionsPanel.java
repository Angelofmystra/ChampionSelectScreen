/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package championselect;

import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;

/**
 * The purpose of this View class is to show the champions that have been selected in champion select. This panel is used twice - first in the left side and on the right side (two different instances of this same class). It is unlikely that this class would be used elsewhere.
 * @author bertrandbrompton
 */
public class ChosenChampionsPanel {
    private VBox vbox = new VBox();
    
    Image ICON_48;
    private static final Image ICON_BLANK = new Image(BorderPaneSample.class.getResourceAsStream("black.png"));
    /*
    The constructor for this class currently uses the default mario image. It will need to be expanded later such that this image will change whenever a champion is selected, and will have an Empty image until that occurs.
    */
    public ChosenChampionsPanel(ChampionSelect championSelect, String label){
        
        Label header = new Label(label);
        vbox.getChildren().add(header);
        ICON_48 = championSelect.getIcon_48();
        Button champion1 = new Button("", new ImageView(ICON_BLANK));
        Button champion2 = new Button("", new ImageView(ICON_BLANK));
        Button champion3 = new Button("", new ImageView(ICON_BLANK));
        Button champion4 = new Button("", new ImageView(ICON_BLANK));
        Button champion5 = new Button("", new ImageView(ICON_BLANK));
        
        vbox.getChildren().add(champion1);
        vbox.getChildren().add(champion2);
        vbox.getChildren().add(champion3);
        vbox.getChildren().add(champion4);
        vbox.getChildren().add(champion5);
        for(int i=0; i<vbox.getChildren().size(); i++){
            vbox.getChildren().get(i).setStyle("-fx-padding: 12 30 12 30; -fx-focus-color: firebrick;");    
        }
        vbox.setSpacing(50);
    }
    public VBox get(){
        return vbox;
    }
    /*
    The purpose of this function is to update the player's icon when a new champion is selected from the grid of champions available.
    */
    public void updatePlayer(int index, ImageView imageview){
        Button button = new Button("", imageview);
        button.setStyle("-fx-padding: 12 30 12 30; -fx-focus-color: firebrick;");
        vbox.getChildren().set(index, button);   
    }
}
