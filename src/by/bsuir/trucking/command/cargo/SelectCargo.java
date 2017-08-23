package by.bsuir.trucking.command.cargo;

import by.bsuir.trucking.command.Command;
import by.bsuir.trucking.dao.CargoDaoImpl;
import by.bsuir.trucking.entity.Cargo;
import by.bsuir.trucking.entity.Entity;
import by.bsuir.trucking.entity.Batch;

import java.util.ArrayList;

/**
 * Created by ASUS on 08.04.2017.
 */
public class SelectCargo implements Command {
    @Override
    public Batch execute(Entity date) {
        CargoDaoImpl insertInf = new CargoDaoImpl();
        ArrayList<Cargo> cargoList = insertInf.getAll();
        if(cargoList!= null){
            return new Batch(true,null,cargoList,null );
        }
        else{
            return new Batch(false,null,cargoList,null);
        }

    }
}
