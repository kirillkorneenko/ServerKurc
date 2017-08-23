package by.bsuir.trucking.command.user;

import by.bsuir.trucking.command.Command;
import by.bsuir.trucking.dao.UserDaoImpl;
import by.bsuir.trucking.entity.Entity;
import by.bsuir.trucking.entity.User;
import by.bsuir.trucking.entity.Batch;

import java.util.ArrayList;

public class SelectUser implements Command {

    @Override
    public Batch execute(Entity date) {
        UserDaoImpl insertInf = new UserDaoImpl();
        ArrayList<User> userList = insertInf.getAll();
        if(userList!= null){
            return new Batch(true,null,userList ,null);
        }
        else{
            return new Batch(false,null,userList,null);
        }
    }
}
