package com.sgroup.socialapp.repository;


import com.sgroup.socialapp.entities.SubscribeFriendUpdateEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface SubscribeFriendUpdateEntityRepository extends CrudRepository<SubscribeFriendUpdateEntity, Long> {

    List<SubscribeFriendUpdateEntity> findByEmail(String email);
}
