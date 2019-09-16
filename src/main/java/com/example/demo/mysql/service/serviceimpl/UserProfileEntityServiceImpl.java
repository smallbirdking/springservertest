package com.example.demo.mysql.service.serviceimpl;

import com.example.demo.mysql.entity.UserProfileEntity;
import com.example.demo.mysql.repository.UserProfileEntityRepository;
import com.example.demo.mysql.service.UserProfileEntityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("userProfileEntityService")
public class UserProfileEntityServiceImpl implements UserProfileEntityService {
    @Autowired
    private UserProfileEntityRepository userProfileEntityRepository;

    @Override
    public List<UserProfileEntity> findByUserID(Long id) {
        return null;//userProfileEntityRepository.findByUserID(id);
    }
}
