package models;

import java.util.Date;

public class Project extends Model {
    private String _name;
    private String _description;
    private boolean _accepted;
    private boolean _isActive;
    private User _manager;
    private User _client;
    private Date _staredAt;
    private Date _deadlineAt;

    // Setters
    public void setName(String _name)
    {
        this._name = _name;
    }

    public void setDescription(String _description)
    {
        this._description = _description;
    }

    public void setAccepted(boolean _accepted)
    {
        this._accepted = _accepted;
    }

    public void setIsActive(boolean _isActive)
    {
        this._isActive = _isActive;
    }

    public void setManager(User _manager)
    {
        this._manager = _manager;
    }

    public void setClient(User _client)
    {
        this._client = _client;
    }

    public void setStaredAt(Date _staredAt)
    {
        this._staredAt = _staredAt;
    }

    public void setDeadlineAt(Date _deadlineAt)
    {
        this._deadlineAt = _deadlineAt;
    }

    public void setId(int Id)
    {
        this.Id = Id;
    }

    public void setCreatedAt(Date CreatedAt)
    {
        this.CreatedAt = CreatedAt;
    }

    public void setUpdatedAt(Date UpdatedAt)
    {
        this.UpdatedAt = UpdatedAt;
    }

    // Getters
    public String getName()
    {
        return _name;
    }

    public String getDescription()
    {
        return _description;
    }

    public boolean isAccepted()
    {
        return _accepted;
    }

    public boolean isActive()
    {
        return _isActive;
    }

    public User getManager()
    {
        return _manager;
    }

    public User getClient()
    {
        return _client;
    }

    public Date getStaredAt()
    {
        return _staredAt;
    }

    public Date getDeadlineAt()
    {
        return _deadlineAt;
    }

    public int getId()
    {
        return Id;
    }

    public Date getCreatedAt()
    {
        return CreatedAt;
    }

    public Date getUpdatedAt()
    {
        return UpdatedAt;
    }
}
