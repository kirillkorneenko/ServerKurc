package by.bsuir.trucking.command.user;

import by.bsuir.trucking.command.Command;
import by.bsuir.trucking.dao.UserDaoImpl;
import by.bsuir.trucking.entity.Entity;
import by.bsuir.trucking.entity.User;
import by.bsuir.trucking.entity.Batch;

/**
 * Created by ASUS on 16.04.2017.
 */
public class UpdateUser implements Command {
    @Override
    public Batch execute(Entity date) {
        UserDaoImpl updateInf = new UserDaoImpl();
        User user = (User)date;
        if(updateInf.update(user)){
            return new Batch(true,null,null,user);
        }
        else{
            return new Batch(false, null,null,user);
        }
    }
}
