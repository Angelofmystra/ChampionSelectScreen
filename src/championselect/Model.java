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
public class Model {
    private int currentPlayer;
    public Model(){
        currentPlayer = 1;
    }
    public void nextPlayer(){
        currentPlayer++;
        checkIfAllPlayersDone(currentPlayer);
    }
    /*
    Returns true if all players have done their actions.
    */
    private Boolean checkIfAllPlayersDone(int currentPlayer) {
        if(currentPlayer == 11){
            return true;
        }else{
            return false;      
        }
    }
    public int getCurrentPlayer(){
        return currentPlayer;
    }
}
