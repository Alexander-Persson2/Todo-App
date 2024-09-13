package dao;

import model.AppUser;

import java.util.List;

public interface AppUserDAO {
    void persist(AppUser appUser);
    AppUser findByUsername(String username);
    List<AppUser> findAll();
    boolean remove(AppUser appUser);
}
