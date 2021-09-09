package io.redbee.socialnetwork.users;

import io.redbee.socialnetwork.users.enums.Status;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    private final UserDao userDao;

    @Autowired
    public UserService(UserDao userDao) {
        this.userDao = userDao;
    }

    public List<User> get() {
        return this.userDao.get();
    }

    public User createUser(User user) {
        return this.userDao.save(user).orElseThrow();
    }

    public Optional<User> findById(Integer id) {
        return this.userDao.getById(id);
    }

    public void updateUser(User newUser) {
        this.userDao.update(newUser);
    }

    public void deleteUser(Integer id) {
        this.userDao.getById(id)
                .map(user -> this.userDao.update(user.withStatus(Status.DELETED.toString())))
                .orElseThrow();
    }


}
