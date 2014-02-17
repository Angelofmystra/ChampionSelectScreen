/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package championselect;

import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;

/**
 * The purpose of this View class is to show the champions that have been selected in champion select. This panel is used twice - first in the left side and on the right side (two different instances of this same class). It is unlikely that this class would be used elsewhere.
 * @author bertrandbrompton
 */
public class ChosenChampionsPanel {
    VBox vbox = new VBox();
    Image ICON_48;
    /*
    The constructor for this class currently uses the default mario image. It will need to be expanded later such that this image will change whenever a champion is selected, and will have an Empty image until that occurs.
    */
    public ChosenChampionsPanel(ChampionSelect championSelect){
        ICON_48 = championSelect.getIcon_48();
        vbox.getChildren().add(new Button("", new ImageView(ICON_48)));
        vbox.getChildren().add(new Button("", new ImageView(ICON_48)));
        vbox.getChildren().add(new Button("", new ImageView(ICON_48)));
        vbox.getChildren().add(new Button("", new ImageView(ICON_48)));
        vbox.getChildren().add(new Button("", new ImageView(ICON_48)));
    }
    public VBox get(){
        return vbox;
    }
}
