package services;

import java.util.Dictionary;
import java.util.List;

public interface IDBManager<T>
{

    List<T> Select(String where) throws Exception;

    T Select(int id) throws Exception;

    boolean InsertOrUpdate(Dictionary<String, String> values) throws Exception;

    boolean Delete(int id) throws Exception;

    boolean Delete(String where) throws Exception;

}
