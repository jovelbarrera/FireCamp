package models;

import static com.oracle.jrockit.jfr.FlightRecorder.isActive;
import java.sql.ResultSet;
import static jdk.nashorn.internal.runtime.Debug.id;
import services.UserService;

public final class MappingModel {

    public static User UserSelectResult(ResultSet resultSet) {
        User user = new User();
        try {
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
            user.setIsInternal(resultSet.getBoolean("isInternal"));
            user.setIsAdmin(resultSet.getBoolean("isAdmin"));
        } catch (Exception e) {
            System.out.println("MappingModel.UserSelectResult Error: " + e.getMessage());
        }
        return user;
    }

    public static String UserInsertString(User user) {
        String id = String.valueOf(user.getId());
        String createdAt = "null";
        String updatedAt = "null";
        String username = user.getUsername();
        String email = user.getEmail();
        String password = user.getPassword();
        String picture = user.getPicture();
        String firstName = user.getFirstName();
        String lastName = user.getLastName();
        String organization = user.getOrganization();
        String isActive = String.valueOf(user.getIsActive());
        String position = user.getPosition();
        String isInternal = String.valueOf(user.getIsInternal());
        String isAdmin = String.valueOf(user.isAdmin());

        String insetString = String.format(
                "REPLACE INTO `User`("
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
                + "`position`,"
                + "`isInternal`,"
                + "`isAdmin`)"
                + "VALUES ("
                + "%s,"
                + "%s,"
                + "%s,"
                + "'%s',"
                + "'%s',"
                + "'%s',"
                + "'%s',"
                + "'%s',"
                + "'%s',"
                + "'%s',"
                + "%s,"
                + "'%s',"
                + "%s,"
                + "%s)",
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
                position,
                isInternal,
                isAdmin
        );
        return insetString;
    }

    public static Project ProjectSelectResult(ResultSet resultSet) {
        Project project = new Project();
        try {
            project.setId(resultSet.getInt("id"));
            project.setCreatedAt(resultSet.getDate("createdAt"));
            project.setUpdatedAt(resultSet.getDate("updatedAt"));
            project.setName(resultSet.getString("name"));
            project.setDescription(resultSet.getString("description"));
            project.setAccepted(resultSet.getBoolean("accepted"));
            project.setIsActive(resultSet.getBoolean("isActive"));
            User manager = UserService.getInstance().Select(resultSet.getInt("managerId"));
            project.setManager(manager);
            User client = UserService.getInstance().Select(resultSet.getInt("clientId"));
            project.setClient(client);
            project.setStaredAt(resultSet.getDate("startedAt"));
            project.setDeadlineAt(resultSet.getDate("deadlineAt"));

        } catch (Exception e) {
            System.out.println("MappingModel.ProjectSelectResult Error: " + e.getMessage());
        }
        return project;
    }

    public static String ProjectInsertString(Project project) {
        try {
            String id = String.valueOf(project.getId());
            String createdAt = "null";
            String updatedAt = "null";
            String name = project.getName();
            String description = project.getDescription();
            String accepted = String.valueOf(project.isAccepted());
            String isActive = String.valueOf(project.isActive());

            User manager = project.getManager();
            String managerId = "0";
            if (manager != null) {
                managerId = String.valueOf(manager.getId());
            }

            User client = project.getClient();
            String clientId = "0";
            if (client != null) {
                clientId = String.valueOf(client.getId());
            }
            String startedAt = String.valueOf(project.getStaredAt());
            if (!startedAt.equals("null")) {
                startedAt = "'" + startedAt + "'";
            }
            
            String deadlineAt = String.valueOf(project.getDeadlineAt());
            if (!deadlineAt.equals("null")) {
                deadlineAt = "'" + deadlineAt + "'";
            }

            String insetString = String.format(
                    "REPLACE INTO `project`("
                    + "`id`,"
                    + "`createdAt`,"
                    + "`updatedAt`,"
                    + "`name`,"
                    + "`description`,"
                    + "`accepted`,"
                    + "`isActive`,"
                    + "`managerId`,"
                    + "`clientId`,"
                    + "`startedAt`,"
                    + "`deadlineAt`)"
                    + "VALUES ("
                    + "%s,"
                    + "%s,"
                    + "%s,"
                    + "'%s',"
                    + "'%s',"
                    + "%s,"
                    + "%s,"
                    + "%s,"
                    + "%s,"
                    + "%s,"
                    + "%s)",
                    id,
                    createdAt,
                    updatedAt,
                    name,
                    description,
                    accepted,
                    isActive,
                    managerId,
                    clientId,
                    startedAt,
                    deadlineAt);
            return insetString;
        } catch (Exception e) {
            return "";
        }
    }
}
