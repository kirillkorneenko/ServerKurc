package by.bsuir.trucking.command.ship;

import by.bsuir.trucking.command.Command;
import by.bsuir.trucking.dao.ShipDaoImpl;
import by.bsuir.trucking.entity.Entity;
import by.bsuir.trucking.entity.Ship;
import by.bsuir.trucking.entity.Batch;

/**
 * Created by ASUS on 08.04.2017.
 */
public class InsertShip implements Command {

    @Override
    public Batch execute(Entity date) {
        ShipDaoImpl insertInf = new ShipDaoImpl();
        Ship ship = (Ship)date;
        if(insertInf.add(ship)){
            return new Batch(true,null,null,ship);
        }
        else{
            return new Batch(false, null,null,ship);
        }
    }
}
