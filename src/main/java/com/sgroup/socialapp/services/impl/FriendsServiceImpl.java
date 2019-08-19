package com.sgroup.socialapp.services.impl;

import com.sgroup.socialapp.controller.request.AddFriendRequest;
import com.sgroup.socialapp.controller.request.CommonFriendsRequest;
import com.sgroup.socialapp.controller.request.GetFriendsRequest;
import com.sgroup.socialapp.controller.response.BaseResponse;
import com.sgroup.socialapp.controller.response.GetFriendsResponse;
import com.sgroup.socialapp.entities.FriendsEntity;
import com.sgroup.socialapp.repository.FriendsEntityRepository;
import com.sgroup.socialapp.services.FriendsService;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import com.sgroup.socialapp.controller.response.CommonFriendsResponse;
import java.util.stream.Collectors;

@Service
@Slf4j
public class FriendsServiceImpl implements FriendsService {


    @Autowired
    private FriendsEntityRepository repository;


    /**
     * Connect friends
     * @param request
     * @return
     */
    @Override
    public BaseResponse connectFriend(AddFriendRequest request) {

        FriendsEntity friend= new FriendsEntity();
        friend.setEmail(request.getFriends().get(0));
        friend.setFriendEmail(request.getFriends().get(1));
        friend.setCreated(new Timestamp(System.currentTimeMillis()));
        friend.setLastUpdated(new Timestamp(System.currentTimeMillis()));

        BaseResponse baseResponse = new BaseResponse();

        baseResponse.setSuccess(false);

         try {
             FriendsEntity  success = repository.save(friend);
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
    public GetFriendsResponse getFriendsList(GetFriendsRequest request) {

        GetFriendsResponse response= new GetFriendsResponse();
        List<String> friendsList= new ArrayList<>();

        try {
            List<FriendsEntity> list = repository.getFriendsByEmail(request.getEmail());
            list.stream().forEach(friend -> friendsList.add(friend.getFriendEmail()));
            response.setSuccess(true);
            response.setCount(list.size());
        }catch (Exception e) {
            log.error("Error while getting friends list - {} ", e.getMessage());
            response.setSuccess(false);
        }

        response.setFriends(friendsList);

        return response;
    }

    @Override
    public CommonFriendsResponse getCommonFriends(CommonFriendsRequest request) {

        //TODO add validation

        CommonFriendsResponse response= new CommonFriendsResponse();
        try {

            String firstUser = request.getFriends().get(0);
            String secondUser = request.getFriends().get(1);

            List<String> firstUserList = repository.getFriendsByEmail(firstUser)
                    .stream()
                    .map(FriendsEntity::getFriendEmail)
                    .collect(Collectors.toList());

            List<String> secondUserList = repository.getFriendsByEmail(secondUser)
                    .stream()
                    .map(FriendsEntity::getFriendEmail)
                    .collect(Collectors.toList());


            List<String> commonUserList = firstUserList.stream().distinct()
                    .filter(secondUserList::contains)
                    .collect(Collectors.toList());


            response.setFriends(commonUserList);
            response.setCount(commonUserList.size());
            response.setSuccess(true);
        }
        catch (Exception e){
            log.error("Error while getting common friends - {} ", e.getMessage());
            response.setSuccess(false);
            response.setFriends(new ArrayList<>());
        }
        return response;
    }


}
