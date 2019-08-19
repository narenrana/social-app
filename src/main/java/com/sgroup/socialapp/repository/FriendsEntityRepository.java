package com.sgroup.socialapp.repository;

import com.sgroup.socialapp.entities.FriendsEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import java.util.List;
import org.springframework.data.repository.query.Param;

@Repository
public interface FriendsEntityRepository extends CrudRepository<FriendsEntity, Long> {


   @Query(value="SELECT frnds.id,frnds.name, frnds.email, frnds.friend_email, frnds.created, frnds.last_updated   FROM FRIENDS  frnds where frnds.email=:email UNION SELECT frnds.id, frnds.name,frnds.friend_email as email, frnds.email  as friend_email, frnds.created, frnds.last_updated  FROM FRIENDS  frnds where frnds.friend_email=:email", nativeQuery = true)
   List<FriendsEntity> getFriendsByEmail(@Param("email") String email);

}
