/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package championselect;

import java.util.LinkedList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.TilePane;

/**
 *
 * @author bertrandbrompton
 */
public class PopulateChampionOptions {
    LinkedList<ImageView> listOfChampions = new LinkedList<ImageView>();
    private static final Image ICON_48 = new Image(BorderPaneSample.class.getResourceAsStream("icon-48x48.png")); // mario
    private static final Image ICON_49 = new Image(BorderPaneSample.class.getResourceAsStream("draven.png"));
    
    Model m;
    ChosenChampionsPanel left;
    ChosenChampionsPanel right;
    TilePane tp;
    
    PopulateChampionOptions(final Model model, final ChosenChampionsPanel leftPanel, final ChosenChampionsPanel rightPanel, TilePane tilePane){
        // load up all images into a LinkedList        
        m = model;
        left = leftPanel;
        right = rightPanel;
        tp = tilePane;
        
        load(listOfChampions);
        // for loop over all images, loading up each image in turn. 
        Button[] buttons = new Button[listOfChampions.size()];
        ImageView mario = new ImageView(ICON_48); // done like this to faciliate easier controller setOnAction                  
            for(int k = 0; k < listOfChampions.size(); k++){                        
                buttons[k] = new Button("", listOfChampions.get(k));                
                mkBtHandler(buttons[k], listOfChampions.get(k)); // makes the eventhandling code for each button 
                tilePane.getChildren().add(buttons[k]);
            }                                                                    
    }
    // I feel brilliant :3
    private void load(LinkedList<ImageView> list){
        list.add(imgmk("aatrox.jpg"));
        list.add(imgmk("akali.jpg"));
        list.add(imgmk("amumu.jpg"));
        list.add(imgmk("ashe.jpg"));
        list.add(imgmk("blitz.jpg"));
        list.add(imgmk("caitlyn.jpg"));
        list.add(imgmk("cassio.jpg"));
        list.add(imgmk("chogath.jpg"));
        list.add(imgmk("draven.jpg"));
        list.add(imgmk("evelynn.jpg"));
        list.add(imgmk("ezreal.jpg"));
        list.add(imgmk("fiddle.jpg"));
        list.add(imgmk("garen.jpg"));
        list.add(imgmk("gragas.jpg"));
        list.add(imgmk("graves.jpg"));
        list.add(imgmk("heimer.jpg"));
        list.add(imgmk("irelia.jpg"));
        list.add(imgmk("j4.jpg"));
        list.add(imgmk("janna.jpg"));
        list.add(imgmk("karthus.jpg"));
        list.add(imgmk("kassa.jpg"));
        list.add(imgmk("katarina.jpg"));
        list.add(imgmk("kayle.jpg"));
        list.add(imgmk("kennen.jpg"));
        list.add(imgmk("kogmaw.jpg"));
        list.add(imgmk("lucian.jpg"));
        list.add(imgmk("lulu.jpg"));
        list.add(imgmk("lux.jpg"));
        list.add(imgmk("missfortune.jpg"));
        list.add(imgmk("muchdoge.jpg"));
        list.add(imgmk("nocturne.jpg"));
        list.add(imgmk("nunu.jpg"));
        list.add(imgmk("rammus.jpg"));
        list.add(imgmk("renekton.jpg"));
        list.add(imgmk("riven.jpg"));
        list.add(imgmk("rumble.jpg"));
        list.add(imgmk("ryze.jpg"));
        list.add(imgmk("syndra.jpg"));
        list.add(imgmk("taric.jpg"));
        list.add(imgmk("teemo.jpg"));
        list.add(imgmk("thresh.jpg"));
        list.add(imgmk("twistedfate.jpg"));
        list.add(imgmk("varus.jpg"));
        list.add(imgmk("veigar.jpg"));
        list.add(imgmk("wukong.jpg"));
        list.add(imgmk("xinzhao.jpg"));
        list.add(imgmk("zyra.jpg"));
    }
    private ImageView imgmk(String fileName){
        return new ImageView(new Image(BorderPaneSample.class.getResourceAsStream("icons/"+fileName)));
    }
    public void mkBtHandler(final Button button, final ImageView image){
        button.setOnAction(new EventHandler<ActionEvent>() {
                @Override public void handle(ActionEvent e) {
                    if(m.getCurrentPlayer() != 11){
                        if(m.getCurrentPlayer() <= 5){
                            left.updatePlayer(m.getCurrentPlayer(), image);
                            button.setGraphic(image);
                            m.nextPlayer();    
                        }else{
                            right.updatePlayer(m.getCurrentPlayer()-5, image);
                            m.nextPlayer();
                        }                  
                    } else {
                        // do nothing
                    }              
                }
                });    
    }
}
