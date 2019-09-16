package com.example.demo.mysql.service.serviceimpl;

import com.example.demo.mysql.entity.UserEntity;
import com.example.demo.mysql.repository.UserEntityRepository;
import com.example.demo.mysql.service.UserEntityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("userEntityService")
public class UserEntityServiceImpl implements UserEntityService {

    @Autowired
    private UserEntityRepository userEntityRepository;

    @Override
    public List<UserEntity> findAll() {
        return (List<UserEntity>) userEntityRepository.findAll();
    }

    @Override
    public List<UserEntity> findByUserName(String userName) {
        return userEntityRepository.findByUserName(userName);
    }
}
