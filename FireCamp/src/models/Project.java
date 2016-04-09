package models;

import java.util.List;

public class Project extends Model {
    private String _name;
    private boolean _isActive;
    private User _manager;
    private List<User> _team;
}
