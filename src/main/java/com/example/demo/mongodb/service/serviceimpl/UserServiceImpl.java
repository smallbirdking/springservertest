package com.example.demo.mongodb.service.serviceimpl;

import com.example.demo.mongodb.service.UserService;
import com.example.demo.mongodb.dao.UserDao;
import com.example.demo.mongodb.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("userService")
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    @Override
    public List<User> findAll() {
        return userDao.findAll();
    }

  /*  @Override
    public User getUser(Integer id) {
        return userDao.getUser(id);
    }

    @Override
    public void update(User user) {
        userDao.update(user);
    }

    @Override
    public void insert(User user) {
        userDao.insert(user);
    }

    @Override
    public void insertAll(List<User> users) {
        userDao.insertAll(users);
    }

    @Override
    public void remove(Integer id) {
        userDao.remove(id);
    }

    @Override
    public List<User> findByPage(User user, Pageable pageable) {
        return userDao.findByPage(user, pageable);
    }
*/

}
