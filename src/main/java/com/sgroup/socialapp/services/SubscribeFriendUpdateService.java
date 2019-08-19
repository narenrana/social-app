package com.sgroup.socialapp.services;

import com.sgroup.socialapp.controller.request.RecepientsListRequest;
import com.sgroup.socialapp.controller.request.SubscribeFriendUpdateRequest;
import com.sgroup.socialapp.controller.response.BaseResponse;
import com.sgroup.socialapp.controller.response.RecepientsListResponse;

public interface SubscribeFriendUpdateService {

    BaseResponse subscribeFriend(SubscribeFriendUpdateRequest request);

    RecepientsListResponse getRecepientList(RecepientsListRequest request);

}
