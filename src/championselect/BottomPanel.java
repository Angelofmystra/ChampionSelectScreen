/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package championselect;

import javafx.collections.FXCollections;
import javafx.scene.control.ListView;
import javafx.scene.control.TabPane;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;

/**
 * This class is dedicated to the bottom panel View in the Champion Selection screen. It creates the Ban boxes for both sides as well as the Chat box.
 * @author bertrandbrompton
 */
class BottomPanel {
    private HBox botBox = new HBox();
    public BottomPanel(ChampionSelect championSelect){
        Image ICON_48 = championSelect.getIcon_48();
        /*
        Bans Box - both blue and purple
        */
        final ListView<ImageView> blueBans = new ListView<ImageView>();
        final ListView<ImageView> purpleBans = new ListView<ImageView>();
        blueBans.setItems(FXCollections.observableArrayList(
                new ImageView(ICON_48), new ImageView(ICON_48), new ImageView(ICON_48)
        ));
        
        purpleBans.setItems(FXCollections.observableArrayList(
                new ImageView(ICON_48), new ImageView(ICON_48), new ImageView(ICON_48)
        ));
        /*
        Chat Tab(s)
        */
        ChatTab allyChatTab = new ChatTab("Ally Chat");
        ChatTab enemyChatTab = new ChatTab("Enemy Chat");
        TabPane tabPane = new TabPane();
        tabPane.setMinWidth(900);
        tabPane.getTabs().add(allyChatTab.getTab());
        tabPane.getTabs().add(enemyChatTab.getTab());
        tabPane.setTabClosingPolicy(TabPane.TabClosingPolicy.UNAVAILABLE);
        botBox.getChildren().addAll(blueBans, tabPane, purpleBans);
    }
    public HBox get(){
        return botBox;
    }
}
