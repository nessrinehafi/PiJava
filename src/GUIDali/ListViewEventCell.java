/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import Entities.Evenement;
import javafx.scene.control.ListCell;

/**
 *
 * @author asus
 */
public class ListViewEventCell extends ListCell<Evenement> {

    @Override
    public void updateItem(Evenement p, boolean empty) {
        super.updateItem(p, empty);
        if (p != null) {
            EventItemController data = new EventItemController();
            data.setInfo(p);
            setGraphic(data.getBox());
        }
    }

}
