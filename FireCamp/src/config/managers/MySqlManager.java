package config.managers;

import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import models.Model;

public abstract class MySqlManager<T extends Model> extends DBManager<T> {

    protected String _table;

    public MySqlManager(String driver, String server, int port, String db, String user, String pass) {
        super(driver, server, port, db, user, pass);
        setTable(setTable());
    }

    // Getter
    public String getTable() {
        return _table;
    }

    // Setter
    public void setTable(String Table) {
        this._table = Table;
    }

    // Abstract methods
    protected abstract String setTable();

    protected abstract T ModelSelectResult(ResultSet resultSet);

    protected abstract String ModelInsertString(T model);

    // DBManager Implementation
    @Override
    public List<T> Select(String insertString) {
        try {
            String selectQuery = "";
            if (insertString == null || insertString.equals("")) {
                selectQuery = String.format("SELECT * FROM %s", getTable());
            } else {
                selectQuery = String.format("SELECT * FROM %s WHERE %s", getTable(), insertString);
            }

            OpenConnection();
            Statement stmt = Connection.createStatement();
            ResultSet resultSet = stmt.executeQuery(selectQuery);

            List<T> result = new ArrayList<>();
            while (resultSet.next()) {
                result.add(ModelSelectResult(resultSet));
            }
            return result;
        } catch (Exception ex) {
            CloseConnection();
            System.out.println("MySqlManager.Select Error: " + ex);
            return null;
        } finally {
            CloseConnection();
        }
    }

    @Override
    public T Select(int id) {
        List<T> user = Select(String.format("id=%d", id));
        if (user != null && user.size() > 0) {
            return user.get(0);
        } else {
            return null;
        }
    }

    @Override
    public boolean InsertOrUpdate(T model) {
        if (model == null) {
            return false;
        }
        try {
            String insertQuery = ModelInsertString(model);

            OpenConnection();
            Statement statement = Connection.createStatement();
            statement.executeUpdate(insertQuery);
            System.out.println("Inserted records into the table...");
            return true;
        } catch (Exception ex) {
            System.out.println("MySqlManager.InsertOrUpdate Error: " + ex);
        } finally {
            CloseConnection();
            return false;
        }
    }

    @Override
    public boolean Delete(String where) {
        try {
            String deleteQuery = String.format("DELETE %s WHERE %s", getTable(), where);

            OpenConnection();
            Statement statement = Connection.createStatement();
            statement.executeUpdate(deleteQuery);
            System.out.println("Record deleted...");
            return true;
        } catch (Exception ex) {
            System.out.println("MySqlManager.Delete Error: " + ex);
        } finally {
            CloseConnection();
            return false;
        }
    }

    @Override
    public boolean Delete(int id) {
        boolean success = Delete(String.format("id=%d", id));
        return success;
    }
}
