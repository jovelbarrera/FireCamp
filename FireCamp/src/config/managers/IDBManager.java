package config.managers;

import java.util.List;

public interface IDBManager<T>
{

    void CloseConnection();

    void OpenConnection();

    List<T> Select(String where);

    T Select(int id);

    boolean InsertOrUpdate(T model);

    boolean Delete(int id);

    boolean Delete(String where);

}
