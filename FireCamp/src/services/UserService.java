package services;

import config.Config;
import config.managers.MySqlManager;
import java.sql.ResultSet;
import models.MappingModel;
import models.User;

public class UserService extends MySqlManager<User>
{

    private static UserService _instance;

    public static UserService getInstance()
            throws Exception
    {
        if (_instance == null)
        {
            _instance = new UserService();
        }
        return _instance;
    }

    public UserService() throws Exception
    {
        super(Config.FireCampDriver, Config.FireCampServer, Config.FireCampPort,
                Config.FireCampDB, Config.FireBaseUser, Config.FireBasePassword);

    }

    @Override
    protected String setTable()
    {
        return "user";
    }

    @Override
    protected User ModelSelectResult(ResultSet resultSet)
    {
        User selectResult = MappingModel.UserSelectResult(resultSet);
        return selectResult;
    }

    @Override
    protected String ModelInsertString(User user)
    {
        String insertString = MappingModel.UserInsertString(user);
        return insertString;
    }
}
