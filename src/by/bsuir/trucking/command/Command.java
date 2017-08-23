package by.bsuir.trucking.command;

import by.bsuir.trucking.entity.Entity;
import by.bsuir.trucking.entity.Batch;

public interface Command {
    Batch execute(Entity date);
}
