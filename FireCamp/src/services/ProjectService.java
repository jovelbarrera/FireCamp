package services;

import config.Config;
import config.managers.MySqlManager;
import java.sql.ResultSet;
import models.MappingModel;
import models.Project;

public class ProjectService extends MySqlManager<Project>
{

    private static ProjectService _instance;

    public static ProjectService getInstance()
            throws Exception
    {
        if (_instance == null)
        {
            _instance = new ProjectService();
        }
        return _instance;
    }

    public ProjectService() throws Exception
    {
        super(Config.FireCampDriver, Config.FireCampServer, Config.FireCampPort,
                Config.FireCampDB, Config.FireBaseUser, Config.FireBasePassword);

    }

    @Override
    protected String setTable()
    {
        return "project";
    }

    @Override
    protected Project ModelSelectResult(ResultSet resultSet)
    {
        Project selectResult = MappingModel.ProjectSelectResult(resultSet);
        return selectResult;
    }

    @Override
    protected String ModelInsertString(Project project)
    {
        String insertString = MappingModel.ProjectInsertString(project);
        return insertString;
    }
}
