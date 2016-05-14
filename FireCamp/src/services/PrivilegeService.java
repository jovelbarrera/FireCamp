package services;

import config.Config;
import config.managers.MySqlManager;
import java.sql.ResultSet;
import models.MappingModel;
import models.Privilege;

public class PrivilegeService extends MySqlManager<Privilege>
{
    private static PrivilegeService _instance;

    public static PrivilegeService getInstance()
            throws Exception
    {
        if (_instance == null)
        {
            _instance = new PrivilegeService();
        }
        return _instance;
    }

    public PrivilegeService() throws Exception
    {
        super(Config.FireCampDriver, Config.FireCampServer, Config.FireCampPort,
                Config.FireCampDB, Config.FireBaseUser, Config.FireBasePassword);

    }

    @Override
    protected String setTable()
    {
        return "privilege";
    }

    @Override
    protected Privilege ModelSelectResult(ResultSet resultSet)
    {
        Privilege selectResult = MappingModel.PrivilegeSelectResult(resultSet);
        return selectResult;
    }

    @Override
    protected String ModelInsertString(Privilege privilage)
    {
        String insertString = MappingModel.PrivilegesInsertString(privilage);
        return insertString;
    }
}
