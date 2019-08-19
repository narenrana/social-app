package com.sgroup.socialapp.services.impl;

import com.sgroup.socialapp.controller.request.BlockFriendsUpdateRequest;
import com.sgroup.socialapp.controller.response.BaseResponse;
import com.sgroup.socialapp.repository.BlockFriendEntityRepository;
import com.sgroup.socialapp.services.BlockFriendsService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.sgroup.socialapp.entities.BlockFriendEntity;
import java.sql.Timestamp;
import java.util.List;

import org.springframework.util.StringUtils;

@Service
@Slf4j
public class BlockFriendsServiceImpl implements BlockFriendsService {

    @Autowired
    private BlockFriendEntityRepository blockFriendEntityRepository;

    @Override
    public BaseResponse blockFriend(BlockFriendsUpdateRequest request) {

        BlockFriendEntity entity= new BlockFriendEntity();
        entity.setEmail(request.getRequestor());
        entity.setBlockedEmail(request.getTarget());
        entity.setCreated(new Timestamp(System.currentTimeMillis()));
        entity.setLastUpdated(new Timestamp(System.currentTimeMillis()));

        BaseResponse baseResponse = new BaseResponse();
        baseResponse.setSuccess(false);

        try {
            BlockFriendEntity success = blockFriendEntityRepository.save(entity);
            if(!StringUtils.isEmpty(success.getId())) {
                baseResponse.setSuccess(true);
            }
            return baseResponse;
        } catch(Exception e){
            log.error("Error while connecting friends - {} ", e.getMessage());
        }
        return baseResponse;
    }

    @Override
    public List<BlockFriendEntity> findBlockedUserList(String email) {
        return blockFriendEntityRepository.findByEmail(email);
    }
}
