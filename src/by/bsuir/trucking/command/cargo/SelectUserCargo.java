package by.bsuir.trucking.command.cargo;

import by.bsuir.trucking.command.Command;
import by.bsuir.trucking.dao.CargoDaoImpl;
import by.bsuir.trucking.entity.Batch;
import by.bsuir.trucking.entity.Cargo;
import by.bsuir.trucking.entity.Entity;
import by.bsuir.trucking.entity.User;

import java.util.ArrayList;

/**
 * Created by ASUS on 03.05.2017.
 */
public class SelectUserCargo implements Command {
    @Override
    public Batch execute(Entity date) {
        CargoDaoImpl insertInf = new CargoDaoImpl();
        User user = (User) date;
        ArrayList<Cargo> cargoList = insertInf.selectCargoByUserId(user.getId());
        if(cargoList!= null){
            return new Batch(true,null,cargoList,null );
        }
        else{
            return new Batch(false,null,cargoList,null);
        }
    }
}
