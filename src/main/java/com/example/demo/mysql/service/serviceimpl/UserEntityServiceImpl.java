package com.example.demo.mysql.service.serviceimpl;

import com.example.demo.mysql.entity.UserEntity;
import com.example.demo.mysql.repository.UserEntityRepository;
import com.example.demo.mysql.service.UserEntityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

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

    @Override
    public Optional<UserEntity> findByUserId(Long id) {
        return userEntityRepository.findById(id);
    }

    @Override
    @Transactional
    public Optional<UserEntity> insertUser(UserEntity userEntity) {
        UserEntity user = userEntityRepository.save(userEntity);
        return Optional.of(user);
    }

    @Override
    public int deleteByUsername(String username) {
        return userEntityRepository.deleteByUsername(username);
    }

}
