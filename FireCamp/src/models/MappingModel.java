package models;

import java.sql.ResultSet;
import java.sql.Timestamp;
import java.time.Instant;
import java.util.Date;

public final class MappingModel
{

    public static User UserSelectResult(ResultSet resultSet)
    {
        User user = new User();
        try
        {
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
        }
        catch (Exception e)
        {
            System.out.println("MappingModel Error: "+e.getMessage());
        }
        return user;
    }

    public static String UserInsertString(User user)
    {
        String id = "0";
        String createdAt = String.valueOf(new Timestamp(new Date().getTime()));
        String updatedAt = String.valueOf(new Timestamp(new Date().getTime()));
        String username = user.getUsername();
        String email = user.getEmail();
        String password = user.getPassword();
        String picture = user.getPicture();
        String firstName = user.getFirstName();
        String lastName = user.getLastName();
        String organization = user.getOrganization();
        String isActive = String.valueOf(user.getIsActive());
        String position = user.getPosition();

        String insetString = String.format(
                "INSERT INTO `User`("
                + "`id`,"
                + "`createdAt`,"
                + "`updatedAt`,"
                + "`username`,"
                + "`email`,"
                + "`password`,"
                + "`picture`,"
                + "`firstName`,"
                + "`lastName`,"
                + "`organization`,"
                + "`isActive`,"
                + "`position`)"
                + "VALUES ("
                + "%s,"
                + "'%s',"
                + "'%s',"
                + "'%s',"
                + "'%s',"
                + "'%s',"
                + "'%s',"
                + "'%s',"
                + "'%s',"
                + "'%s',"
                + "%s,"
                + "'%s')",
                id,
                createdAt,
                updatedAt,
                username,
                email,
                password,
                picture,
                firstName,
                lastName,
                organization,
                isActive,
                position);
        return insetString;
    }
}
