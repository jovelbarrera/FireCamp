package models;

import java.util.Date;

public class User extends Model {

    private String _username;
    private String _email;
    private String _password;
    private String _picture;
    private String _firstName;
    private String _lastName;
    private String _organization;
    private boolean _isActive;
    private String _position;
    private boolean _isInternal;
    private boolean _isAdmin;

    // Setters
    public void setUsername(String _username) {
        this._username = _username;
    }

    public void setEmail(String _email) {
        this._email = _email;
    }

    public void setPassword(String _password) {
        this._password = _password;
    }

    public void setPicture(String _picture) {
        this._picture = _picture;
    }

    public void setFirstName(String _firstName) {
        this._firstName = _firstName;
    }

    public void setLastName(String _lastName) {
        this._lastName = _lastName;
    }

    public void setOrganization(String _organization) {
        this._organization = _organization;
    }

    public void setIsActive(boolean _isActive) {
        this._isActive = _isActive;
    }

    public void setPosition(String _position) {
        this._position = _position;
    }

    public void setId(int Id) {
        this.Id = Id;
    }

    public void setCreatedAt(Date CreatedAt) {
        this.CreatedAt = CreatedAt;
    }

    public void setUpdatedAt(Date UpdatedAt) {
        this.UpdatedAt = UpdatedAt;
    }

    public void setIsInternal(boolean _isInternal) {
        this._isInternal = _isInternal;
    }

    public void setIsAdmin(boolean _isAdmin) {
        this._isAdmin = _isAdmin;
    }
    // Getterspublic int getId()

    public int getId() {
        return Id;
    }

    public Date getCreatedAt() {
        return CreatedAt;
    }

    public Date getUpdatedAt() {
        return UpdatedAt;
    }

    public String getUsername() {
        return _username;
    }

    public String getEmail() {
        return _email;
    }

    public String getPassword() {
        return _password;
    }

    public String getPicture() {
        return _picture;
    }

    public String getFirstName() {
        return _firstName;
    }

    public String getLastName() {
        return _lastName;
    }

    public String getOrganization() {
        return _organization;
    }

    public boolean getIsActive() {
        return _isActive;
    }

    public String getPosition() {
        return _position;
    }

    public boolean getIsInternal() {
        return _isInternal;
    }

    public boolean isAdmin() {
        return _isAdmin;
    }
}
