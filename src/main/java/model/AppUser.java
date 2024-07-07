package model;

import java.util.Objects;
public class AppUser {
    private String username;
    private String password;
    private AppRole role;

    public AppUser(String username, String password, AppRole role) {
        if (username == null || username.trim().isEmpty() ||
        password == null || password.trim().isEmpty() ||
        role == null) {
            throw new IllegalArgumentException("Fields cannot be null or empty");
        }
        this.username = username;
        this.password = password;
        this.role = role;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public AppRole getRole() {
        return role;
    }

    @Override
    public String toString() {
        return "AppUser{" +
                "username='" + username + '\'' +
                ", role=" + role +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if(o == null || getClass() != o.getClass()) return false;
        AppUser appUser = (AppUser) o;
        return username.equals(appUser.username) && role == appUser.role;
    }

    @Override
    public int hashCode() {
        return Objects.hash(username, role);
    }
}
