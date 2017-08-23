package by.bsuir.trucking.command.user;

import by.bsuir.trucking.command.Command;
import by.bsuir.trucking.dao.UserDaoImpl;
import by.bsuir.trucking.entity.Entity;
import by.bsuir.trucking.entity.User;
import by.bsuir.trucking.entity.Batch;

/**
 * Created by ASUS on 08.04.2017.
 */
public class Registration implements Command {

    @Override
    public Batch execute(Entity date) {
        UserDaoImpl insertInf = new UserDaoImpl();
        User user = (User)date;
        if(insertInf.add(user)){
            return new Batch(true,null,null,user);
        }
        else{
            return new Batch(false, null,null,user);
        }
    }
}
