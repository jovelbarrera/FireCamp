package models;

import java.sql.ResultSet;

public final class MappingModel
{
    public static User User(ResultSet resultSet)
            throws Exception
    {
        User user = new User();
        user.setId(resultSet.getInt("id"));
        user.setCreatedAt(resultSet.getDate("createdAt"));
        user.setUpdatedAt(resultSet.getDate("updatedAt"));
        user.setUsername(resultSet.getString("username"));
        user.setEmail(resultSet.getString("email"));
        user.setPassword(resultSet.getString("password"));
        user.setPicture(resultSet.getString("picture"));
        user.setFirstName(resultSet.getString("firstName"));
        user.setLastName(resultSet.getString("lastName"));
        user.setOrganization(resultSet.getString("organization"));
        user.setIsActive(resultSet.getBoolean("isActive"));
        user.setPosition(resultSet.getString("position"));
        return user;
    }
}
