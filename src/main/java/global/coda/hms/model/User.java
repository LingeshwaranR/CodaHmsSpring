package global.coda.hms.model;

public class User {
    int pkUserId;
    String username;
    String email;
    String password;
    int fkRoleId;

    public int getPkUserId() {
        return pkUserId;
    }

    public void setPkUserId(int pkUserId) {
        this.pkUserId = pkUserId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getFkRoleId() {
        return fkRoleId;
    }

    public void setFkRoleId(int fkRoleId) {
        this.fkRoleId = fkRoleId;
    }

    @Override
    public String toString() {
        return "User{" +
                "pk_user_id=" + pkUserId +
                ", username='" + username + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", fk_role_id=" + fkRoleId +
                '}';
    }
}
