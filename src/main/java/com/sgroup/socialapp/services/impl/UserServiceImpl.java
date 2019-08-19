package com.sgroup.socialapp.services.impl;

import com.sgroup.socialapp.entities.UserEntity;
import com.sgroup.socialapp.repository.UserEntityRepository;
import com.sgroup.socialapp.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl  implements UserService {

    @Autowired
    UserEntityRepository repository;

    @Override
    public boolean isUserExist(String email) {
        UserEntity user=repository.findByEmail(email);

        if(user!=null){
            return true;
        }

        return false;
    }
}
