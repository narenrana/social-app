package com.sgroup.socialapp.repository;


import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import  com.sgroup.socialapp.entities.BlockFriendEntity;

import java.util.List;

@Repository
public interface BlockFriendEntityRepository  extends CrudRepository<BlockFriendEntity, Long> {

    List<BlockFriendEntity> findByEmail(String email);
}
