package by.bsuir.trucking.command.cargo;

import by.bsuir.trucking.command.Command;
import by.bsuir.trucking.dao.CargoDaoImpl;
import by.bsuir.trucking.entity.Cargo;
import by.bsuir.trucking.entity.Entity;
import by.bsuir.trucking.entity.Batch;

/**
 * Created by ASUS on 08.04.2017.
 */
public class DeleteCargo implements Command {
    @Override
    public Batch execute(Entity date) {
        CargoDaoImpl deleteInf = new CargoDaoImpl();
        Cargo cargo = (Cargo)date;
        if(deleteInf.delete(cargo.getId())){
            return new Batch(true,null,null,cargo);
        }
        else{
            return new Batch(false, null,null,cargo);
        }
    }
}
