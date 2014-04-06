/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package championselect;

/**
 *
 * @author bertrandbrompton
 */

import javafx.scene.Group;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Pos;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ComboBoxBuilder;
import javafx.scene.layout.HBox;
import javafx.scene.layout.HBoxBuilder;
 
/**
 * A sample that shows both an un-editable and an editable ComboBox.
 *
 * @see javafx.scene.control.ComboBox
 * @see javafx.scene.control.ComboBoxBuilder
 */
public class DropDownMenu{
    private Group root;
    private final ObservableList strings = FXCollections.observableArrayList(
            "Default 1", "Default 2", "Default 3", "Default 4", "Default 5", "Default 6", "Default 7", "Default 8");
 
    public DropDownMenu() {
        root = new Group();        
        
        HBox hbox = HBoxBuilder.create().alignment(Pos.CENTER).spacing(15).build();
                
        //Non-editable combobox. Created with a builder
        ComboBox uneditableComboBox = ComboBoxBuilder.create()
                .id("uneditable-combobox")
                .promptText("Make a choice...")
                .items(FXCollections.observableArrayList(strings.subList(0, 8))).build();
        hbox.getChildren().add(uneditableComboBox);
        root.getChildren().add(hbox);
    }
    public Group get(){
        return root;
    }
    public void add(String page){
        strings.add(page);
    }
}
