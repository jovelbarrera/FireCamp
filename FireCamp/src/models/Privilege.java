package models;

public class Privilege extends Model {

    private User _user;
    private int _level;
    private User _createdBy;

    public User getCreatedBy() {
        return _createdBy;
    }

    public int getLevel() {
        return _level;
    }

    public void setLevel(int _level) {
        this._level = _level;
    }

    public String LevelName() {
        String levelName;
        switch (_level) {
            case 1:
                levelName = "Administrador del sistema";
                break;
            case 2:
                levelName = "Administrativo";
                break;
            case 3:
                levelName = "Usuario Interno";
                break;
            case 4:
                levelName = "Usuario Externo";
                break;
            default:
                levelName = "Undefinied";
                break;
        }
        return levelName;
    }

    public User getUser() {
        return _user;
    }

    public void setUser(User _user) {
        this._user = _user;
    }

    public void setCreatedBy(User _createdBy) {
        this._createdBy = _createdBy;
    }
}
