package org.itis.hib.domain;

/**
 * Created by SDS on 11.05.2016.
 */
public class RegistratedUser {
    String login;
    String hash_password;

    public RegistratedUser(String login, String hash_password) {
        this.login = login;
        this.hash_password = hash_password;
    }


    public RegistratedUser() {
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getHash_password() {
        return hash_password;
    }

    public void setHash_password(String hash_password) {
        this.hash_password = hash_password;
    }
}
