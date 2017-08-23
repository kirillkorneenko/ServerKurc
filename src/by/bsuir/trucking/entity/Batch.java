package by.bsuir.trucking.entity;
import java.io.Serializable;
import java.util.ArrayList;

public class Batch  implements Serializable{
    private boolean result;
    private String command;
    private Entity date;
    private ArrayList<? extends Entity> list;

    public Batch() {
    }

    public Batch(boolean result, String command, ArrayList<? extends Entity> list, Entity date) {
        this.result = result;
        this.command = command;
        this.list = list;
        this.date = date;
    }

    public ArrayList<? extends Entity> getList() {
        return list;
    }

    public void setList(ArrayList<Entity> list) {
        this.list = list;
    }

    public boolean isResult() {
        return result;
    }

    public void setResult(boolean result) {
        this.result = result;
    }

    public String getCommand() {
        return command;
    }

    public void setCommand(String command) {
        this.command = command;
    }

    public Entity getDate() {
        return date;
    }

    public void setDate(Entity date) {
        this.date = date;
    }
}
