package by.bsuir.trucking.command.ship;

import by.bsuir.trucking.command.Command;
import by.bsuir.trucking.dao.ShipDaoImpl;
import by.bsuir.trucking.entity.Entity;
import by.bsuir.trucking.entity.Ship;
import by.bsuir.trucking.entity.Batch;

import java.util.ArrayList;

/**
 * Created by ASUS on 08.04.2017.
 */
public class SelectShip implements Command {
    @Override
    public Batch execute(Entity date) {
        ShipDaoImpl insertInf = new ShipDaoImpl();
        ArrayList<Ship> shipList = insertInf.getAll();
        if(shipList!= null){
            return new Batch(true,null,shipList ,null);
        }
        else{
            return new Batch(false,null,shipList,null);
        }
    }
}
