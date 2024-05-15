package Thread.Controller;

import Thread.Entity.Entity;
import Thread.Model.Model;

import java.sql.SQLException;
import java.util.List;

public class Controller<T extends Entity<?>> {
    private Model<T> model;
    public Controller(Model<T> model) throws SQLException{
        this.model = model;
    }
    public void addEntityController(T entity) throws SQLException {
        model.addEntity(entity);
    }
    public List<T> getAllEntityController() throws SQLException{
        return model.getAllEntities();
    }
    public void updateEntityController(T entity) throws SQLException{
        model.updateEntity(entity);
    }
    public void deleteEntityController(T entity) throws SQLException{
        model.deleteEntity(entity);
    }
}
