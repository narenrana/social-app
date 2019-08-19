package com.sgroup.socialapp.services;

import com.sgroup.socialapp.controller.request.AddFriendRequest;
import com.sgroup.socialapp.controller.request.GetFriendsRequest;
import com.sgroup.socialapp.controller.response.BaseResponse;
import com.sgroup.socialapp.controller.response.CommonFriendsResponse;
import com.sgroup.socialapp.controller.response.GetFriendsResponse;
import com.sgroup.socialapp.controller.request.CommonFriendsRequest;

public interface FriendsService {

    BaseResponse connectFriend(AddFriendRequest request);

    GetFriendsResponse getFriendsList(GetFriendsRequest request);

    CommonFriendsResponse getCommonFriends(CommonFriendsRequest request);


}
