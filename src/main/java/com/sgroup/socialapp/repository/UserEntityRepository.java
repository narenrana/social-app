package com.sgroup.socialapp.repository;

import com.sgroup.socialapp.entities.UserEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface UserEntityRepository extends CrudRepository<UserEntity, Long> {

    UserEntity findByEmail(String email);

}
