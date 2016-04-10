package services;

import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Dictionary;
import java.util.List;
import models.Model;

public abstract class MySqlManager<T extends Model> extends DBManager<T>
{

    protected String _table;

    public MySqlManager(String driver, String server, int port, String db, String user, String pass)
            throws Exception
    {
        super(driver, server, port, db, user, pass);
        setTable(setTable());
    }

    // Getter
    public String getTable()
    {
        return _table;
    }

    // Setter
    public void setTable(String Table)
    {
        this._table = Table;
    }

    // Abstract methods
    protected abstract String setTable();

    protected abstract T mappingModel(ResultSet resultSet);

    // DBManager Implementation
    @Override
    public List<T> Select(String where)
            throws Exception
    {
        try
        {
            String selectQuery = String.format("SELECT * FROM %s", getTable());
            Statement stmt = Connection.createStatement();
            ResultSet resultSet = stmt.executeQuery(selectQuery);

            List<T> result = new ArrayList<>();
            while (resultSet.next())
            {
                result.add(mappingModel(resultSet));
            }
            return result;
        }
        catch (Exception ex)
        {
            System.out.println("Error: " + ex);
            return null;
        }
    }

    @Override
    public T Select(int id)
            throws Exception
    {
        try
        {
            List<T> user = Select(String.format("id=%d", id));
            return user.get(0);
        }
        catch (Exception e)
        {
            return null;
        }
    }

    @Override
    public boolean InsertOrUpdate(Dictionary<String, String> values)
            throws Exception
    {
        if (values == null)
        {
            return false;
        }
        try
        {
            String valueString = "";
            String[] keys = new String[0];
            Collections.list(values.keys()).toArray(keys);
            for (int i = 0; i < keys.length; i++)
            {
                String key = values.get(keys[i]);
                valueString += values.get(key);
                if (i < keys.length - 1)
                {
                    valueString += ", ";
                }
            }
            String insertQuery = String.format("INSERT INTO %s VALUES (%s)", getTable(), valueString);

            Statement statement = Connection.createStatement();
            statement.executeUpdate(insertQuery);
            System.out.println("Inserted records into the table...");
            CloseConnection();
            return true;
        }
        catch (Exception ex)
        {
            System.out.println("Error: " + ex);
            CloseConnection();
            return false;
        }
        finally
        {
            CloseConnection();
        }
    }

    @Override
    public boolean Delete(int id)
            throws Exception
    {
        try
        {
            String deleteQuery = String.format("DELETE %s WHERE id = %d", getTable(), id);

            Statement statement = Connection.createStatement();
            statement.executeUpdate(deleteQuery);
            System.out.println("Record deleted...");
            CloseConnection();
            return true;
        }
        catch (Exception ex)
        {
            System.out.println("Error: " + ex);
            CloseConnection();
            return false;
        }
        finally
        {
            CloseConnection();
        }
    }

    @Override
    public boolean Delete(String where)
            throws Exception
    {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
