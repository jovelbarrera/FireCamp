package services;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Dictionary;
import java.util.List;
import models.Model;

public abstract class DBManager<T extends Model> implements IDBManager<T>
{

    protected Connection Connection;

    public DBManager(String driver, String server, int port, String db, String user, String pass)
            throws Exception
    {

        Class.forName(String.format("com.%s.jdbc.Driver", driver)).newInstance();   
        String connectionString = String.format("jdbc:%s://%s:%d/%s", driver, server, port, db);
        Connection = DriverManager.getConnection(connectionString, user, pass);
    }

    protected void CloseConnection() throws Exception
    {
        Connection.close();
    }

    // IDBManager implementation
    @Override
    public abstract List<T> Select(String where) throws Exception;

    @Override
    public abstract T Select(int id) throws Exception;

    @Override
    public abstract boolean InsertOrUpdate(Dictionary<String, String> values) throws Exception;

    @Override
    public abstract boolean Delete(int id) throws Exception;

    @Override
    public abstract boolean Delete(String where) throws Exception;

}
