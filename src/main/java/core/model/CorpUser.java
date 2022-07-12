package core.model;

public class CorpUser {

    protected String entityID;
    protected String userID;
    protected String role;
    protected String fullName;

    public CorpUser(String entityID, String userID, String role, String fullName) {
        this.entityID = entityID;
        this.userID = userID;
        this.role = role;
        this.fullName = fullName;
    }

    public String getEntityID() {
        return entityID;
    }

    public void setEntityID(String entityID) {
         this.entityID = entityID;
    }

    public String getUserID() {
        return userID;
    }

    public void setUserID(String userID) {
        this.userID = userID;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }
}
