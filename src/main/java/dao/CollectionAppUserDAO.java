package dao;

import model.AppUser;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class CollectionAppUserDAO implements AppUserDAO {
    private List<AppUser> appUsers = new ArrayList<>();

    @Override
    public void persist(AppUser appUser) {
        appUsers.add(appUser);
    }

    @Override
    public AppUser findByUsername(String username) {
        Optional<AppUser> result = appUsers.stream()
                .filter(user -> user.getUsername().equals(username))
                .findFirst();
        return result.orElse(null);
    }

    @Override
    public List<AppUser> findAll() {
        return new ArrayList<>(appUsers);
    }

    @Override
    public boolean remove(AppUser appUser) {
        return appUsers.remove(appUser);
    }
}
