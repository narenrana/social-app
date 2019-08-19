package com.sgroup.socialapp.services.impl;

import com.sgroup.socialapp.controller.request.RecepientsListRequest;
import com.sgroup.socialapp.controller.request.SubscribeFriendUpdateRequest;
import com.sgroup.socialapp.controller.response.BaseResponse;
import com.sgroup.socialapp.controller.response.RecepientsListResponse;
import com.sgroup.socialapp.entities.BlockFriendEntity;
import com.sgroup.socialapp.repository.SubscribeFriendUpdateEntityRepository;
import com.sgroup.socialapp.services.BlockFriendsService;
import com.sgroup.socialapp.services.SubscribeFriendUpdateService;
import com.sgroup.socialapp.services.UserService;
import com.sgroup.socialapp.utils.EmailUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.sgroup.socialapp.entities.SubscribeFriendUpdateEntity;
import org.springframework.util.StringUtils;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Slf4j
public class SubscribeFriendUpdateServiceImpl implements SubscribeFriendUpdateService {

    @Autowired
    private SubscribeFriendUpdateEntityRepository repository;

    @Autowired
    private UserService userService;

    @Autowired
    private BlockFriendsService blockFriendsService;

    @Override
    public BaseResponse subscribeFriend(SubscribeFriendUpdateRequest request) {


        SubscribeFriendUpdateEntity entity= new SubscribeFriendUpdateEntity();
        entity.setSubscriberEmail(request.getRequestor());
        entity.setEmail(request.getTarget());
        entity.setCreated(new Timestamp(System.currentTimeMillis()));
        entity.setLastUpdated(new Timestamp(System.currentTimeMillis()));

        BaseResponse baseResponse = new BaseResponse();
        baseResponse.setSuccess(false);

        try {
            SubscribeFriendUpdateEntity success = repository.save(entity);
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
    public RecepientsListResponse getRecepientList(RecepientsListRequest request) {

        RecepientsListResponse response= new RecepientsListResponse();

        try {
            String senderEmail = request.getSender();
            List<String> userList = new ArrayList<>();

            /**
             * Friends who has subscribed update
             */
            List<SubscribeFriendUpdateEntity> list = repository.findByEmail(senderEmail);
            if (list != null && !list.isEmpty()) {
                List<String> friendsList = list.stream().map(SubscribeFriendUpdateEntity::getSubscriberEmail).collect(Collectors.toList());
                userList.addAll(friendsList);
            }

            /**
             * Friends mentioned  in update
             */
            List<String> userListFoundInUpdate = getUsersFromText(request.getText());
            if (!userListFoundInUpdate.isEmpty()) {
                userList.addAll(userListFoundInUpdate);
            }

            /**
             * Find Blocked Users
             */

            List<String> blockedUser = blockFriendsService.findBlockedUserList(senderEmail)
                    .stream()
                    .map(BlockFriendEntity::getBlockedEmail)
                    .collect(Collectors.toList());

            if (!blockedUser.isEmpty()) {
                userList = userList.stream().filter(user -> !blockedUser.contains(user)).collect(Collectors.toList());
            }

            response.setRecipients(userList);
            response.setSuccess(true);
        }
        catch (Exception e){
            log.error("Error while getting recipients - {} ", e.getMessage());
            response.setRecipients(new ArrayList<>());
            response.setSuccess(false);
        }

        return response;
    }

    private List<String> getUsersFromText(String text) {

        List<String> list= new ArrayList<>();

        List<String> emailFoundInUpdateText=EmailUtils.findEmail(text);

        return emailFoundInUpdateText.stream().filter(email -> userService.isUserExist(email)).collect(Collectors.toList());

    }

}
