package global.coda.hms.model;

/**
 * The type User.
 */
public class User {
    /**
     * The Pk user id.
     */
    int pkUserId;
    /**
     * The Username.
     */
    String username;
    /**
     * The Email.
     */
    String email;
    /**
     * The Password.
     */
    String password;
    /**
     * The Fk role id.
     */
    int fkRoleId;

    /**
     * Gets pk user id.
     *
     * @return the pk user id
     */
    public int getPkUserId() {
        return pkUserId;
    }

    /**
     * Sets pk user id.
     *
     * @param pkUserId the pk user id
     */
    public void setPkUserId(int pkUserId) {
        this.pkUserId = pkUserId;
    }

    /**
     * Gets username.
     *
     * @return the username
     */
    public String getUsername() {
        return username;
    }

    /**
     * Sets username.
     *
     * @param username the username
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * Gets email.
     *
     * @return the email
     */
    public String getEmail() {
        return email;
    }

    /**
     * Sets email.
     *
     * @param email the email
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * Gets password.
     *
     * @return the password
     */
    public String getPassword() {
        return password;
    }

    /**
     * Sets password.
     *
     * @param password the password
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * Gets fk role id.
     *
     * @return the fk role id
     */
    public int getFkRoleId() {
        return fkRoleId;
    }

    /**
     * Sets fk role id.
     *
     * @param fkRoleId the fk role id
     */
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
