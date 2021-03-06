package by.bsuir.trucking.command;

public enum Commands {

    AUTHORIZATION_USER("AUTHORIZATION_USER"),
    REGISTRATION_USER("REGISTRATION_USER"),
    DELETE_USER("DELETE_USER"),
    UPDATE_USER("UPDATE_USER"),
    SELECT_USER("SELECT_USER"),
    SELECT_USER_CARGO("SELECT_USER_CARGO"),

    INSERT_CARGO("INSERT_CARGO"),
    SELECT_CARGO("SELECT_CARGO"),
    DELETE_CARGO("DELETE_CARGO"),
    UPDATE_CARGO("UPDATE_CARGO"),

    INSERT_SHIP("INSERT_SHIP"),
    SELECT_SHIP("SELECT_SHIP"),
    DELETE_SHIP("DELETE_SHIP"),
    UPDATE_SHIP("UPDATE_SHIP"),

    FIND_MAX_QUANTITY("FIND_MAX_QUANTITY");

    private String command;
    Commands(String command){this.command=command;}
}
