
package championselect;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.event.EventType;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.Tab;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

/**
 * The purpose of this class is to make it easier to create new chat tabs by reducing code repetition significantly. 
 * @author bertrandbrompton
 */
public class ChatTab {
    private ListView listview;
    private ObservableList<String> chatItems = FXCollections.observableArrayList();
    final TextField textField = new TextField();
    final private Tab tab;
    
    public ChatTab(String playerName){
        
        tab = new Tab();
        tab.setText(playerName);
        listview = new ListView();
        VBox vbox = new VBox();               
        listview.setItems(chatItems);
        
        textField.setText("write crap here");
        textField.setOnAction(new EventHandler<ActionEvent>() {
            @Override public void handle(ActionEvent e) {
                chatItems.add(textField.getText());
                textField.clear(); // once you send a msg, it disappears from the textfield              
            }
        });
        ScrollPane sp = new ScrollPane();
        sp.setContent(vbox);
        //sp.setMinWidth(700);
        vbox.setMinWidth(885); // this manipulates the chat box.
        tab.setContent(sp);
        HBox textFieldBox = new HBox();
        Button sendButton = new Button("Send");
        sendButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override public void handle(ActionEvent e) {
                chatItems.add(textField.getText());
                textField.clear(); // once you send a msg, it disappears from the textfield              
            }
        });
        textFieldBox.getChildren().addAll(textField, sendButton);
        vbox.getChildren().addAll(textFieldBox, listview);
    }
    public Tab getTab(){
        return tab;
    }
}
