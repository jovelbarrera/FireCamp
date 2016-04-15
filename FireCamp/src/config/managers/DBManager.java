package config.managers;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.List;
import models.Model;

public abstract class DBManager<T extends Model> implements IDBManager<T>
{

    protected Connection Connection;
    protected String ConnectionString;
    protected String User;
    protected String Pass;

    public DBManager(String driver, String server, int port, String db, String user, String pass)
    {
        try
        {
            Class.forName(String.format("com.%s.jdbc.Driver", driver)).newInstance();
            ConnectionString = String.format("jdbc:%s://%s:%d/%s", driver, server, port, db);
            User = user;
            Pass = pass;
        }
        catch (Exception e)
        {
            System.out.println("DBManager Error: " + e.getMessage());
        }
    }

    public void OpenConnection()
    {
        try
        {
            Connection = DriverManager.getConnection(ConnectionString, User, Pass);
        }
        catch (Exception e)
        {
            System.out.println("DBManager.OpenConnection Error: " + e.getMessage());
        }
    }

    public void CloseConnection()
    {
        try
        {
            Connection.close();
        }
        catch (Exception e)
        {
            System.out.println("DBManager.CloseConnection Error: " + e.getMessage());
        }
    }

    // IDBManager implementation
    @Override
    public abstract List<T> Select(String where);

    @Override
    public abstract T Select(int id);

    @Override
    public abstract boolean InsertOrUpdate(T model);

    @Override
    public abstract boolean Delete(int id);

    @Override
    public abstract boolean Delete(String where);

}
