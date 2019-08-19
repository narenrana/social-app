package com.sgroup.socialapp.services;

import com.sgroup.socialapp.controller.request.BlockFriendsUpdateRequest;
import com.sgroup.socialapp.controller.response.BaseResponse;
import com.sgroup.socialapp.entities.BlockFriendEntity;

import java.util.List;

public interface BlockFriendsService {

    BaseResponse blockFriend(BlockFriendsUpdateRequest request);

    List<BlockFriendEntity> findBlockedUserList(String email);
}
