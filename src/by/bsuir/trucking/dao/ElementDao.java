package by.bsuir.trucking.dao;



import java.util.List;


public interface ElementDao<T> {
    public List<T> getAll();
    public boolean update(T t);
    public boolean delete(int id);
    public boolean add(T t);
}
