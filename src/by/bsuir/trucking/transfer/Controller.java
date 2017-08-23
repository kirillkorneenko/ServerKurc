package by.bsuir.trucking.transfer;

import by.bsuir.trucking.command.cargo.*;
import by.bsuir.trucking.command.Command;
import by.bsuir.trucking.command.Commands;
import by.bsuir.trucking.command.logic.ShipApp;
import by.bsuir.trucking.command.ship.*;
import by.bsuir.trucking.command.user.*;

public class Controller {

    public static Command getCommand(String command){
        switch (Commands.valueOf(command.toUpperCase())){
            case AUTHORIZATION_USER :
                return new Authorization();
            case DELETE_CARGO:
                return new DeleteCargo();
            case DELETE_SHIP:
                return new DeleteShip();
            case DELETE_USER:
                return new DeleteUser();
            case FIND_MAX_QUANTITY:
                return new ShipApp();
            case INSERT_CARGO:
                return new InsertCargo();
            case INSERT_SHIP:
                return new InsertShip();
            case UPDATE_USER:
                return  new UpdateUser();
            case SELECT_CARGO:
                return new SelectCargo();
            case SELECT_SHIP:
                return new SelectShip();
            case REGISTRATION_USER:
                return new Registration();
            case UPDATE_CARGO:
                return new UpdateCargo();
            case UPDATE_SHIP:
                return new UpdateShip();
            case SELECT_USER:
                return new SelectUser();
            case SELECT_USER_CARGO:
                return new SelectUserCargo();
                default:  return null;
        }
    }
}
