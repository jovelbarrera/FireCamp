package models;

import java.util.Date;

public class Model
{
    protected int Id;
    protected Date CreatedAt;
    protected Date UpdatedAt;
    
    public int getId() {
        return Id;
    }

    public Date getCreatedAt() {
        return CreatedAt;
    }

    public Date getUpdatedAt() {
        return UpdatedAt;
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
}
