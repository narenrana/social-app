package com.sgroup.socialapp.controller;

import com.sgroup.socialapp.controller.request.*;
import com.sgroup.socialapp.controller.response.BaseResponse;
import com.sgroup.socialapp.controller.response.CommonFriendsResponse;
import com.sgroup.socialapp.controller.response.GetFriendsResponse;
import com.sgroup.socialapp.controller.response.RecepientsListResponse;
import com.sgroup.socialapp.services.BlockFriendsService;
import com.sgroup.socialapp.services.FriendsService;
import com.sgroup.socialapp.services.SubscribeFriendUpdateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;


@RestController
@RequestMapping("/api/friend")
public class FriendsController {

    @Autowired
    private  FriendsService friendsService;

    @Autowired
    private SubscribeFriendUpdateService subscribeFriendUpdateService;

    @Autowired
    private BlockFriendsService blockFriendsService;

    /**
     * API to create a friend connection between two email addresses.
     * Sample Request payload
      {
       friends:
         [
           'andy@example.com',
            'john@example.com'
        ]
      }
     * @return
     */
    @PostMapping("/connect")
    public BaseResponse connectFriend( @Valid @RequestBody AddFriendRequest request) {

       return friendsService.connectFriend(request);

    }


    /**
     * API to retrieve the friends list for an email address.
     * Request payload
     * {
     *   email: 'andy@example.com'
     * }
     */
    @PostMapping("/list")
    public GetFriendsResponse getFriendsList(@Valid  @RequestBody GetFriendsRequest request) {

        return friendsService.getFriendsList(request);

    }



    /**
     * API to retrieve the common friends list between two email addresses.
     * Request payload
     {
     friends:
         [
             'andy@example.com',
             'john@example.com'
         ]
     }
     */
    @PostMapping("/common")
    public CommonFriendsResponse getCommonFriendsList(@RequestBody CommonFriendsRequest request) {

        return friendsService.getCommonFriends(request);

    }


    /**
     * API to subscribe to updates from an email address.
     * Request payload
     * {
     *   "requestor": "lisa@example.com",
     *   "target": "john@example.com"
     * }
     */
    @PostMapping("/subscribe")
    public BaseResponse subscribeFriendUpdate(@RequestBody SubscribeFriendUpdateRequest request) {

        return subscribeFriendUpdateService.subscribeFriend(request);

    }

    /**
     *  API to block updates from an email address.
     * Request payload
     * {
     *   "requestor": "lisa@example.com",
     *   "target": "john@example.com"
     * }
     */
    @PostMapping("/block")
    public BaseResponse blockFriendUpdate(@RequestBody BlockFriendsUpdateRequest request) {


        return blockFriendsService.blockFriend(request);

    }

    /**
     * I need an API to retrieve all email addresses that can receive updates from an email address.
     * {
     *   "sender":  "john@example.com",
     *   "text": "Hello World! kate@example.com"
     * }
     */
    @PostMapping("/subscribers")
    public RecepientsListResponse getRecipientsList( @RequestBody RecepientsListRequest request) {

        return subscribeFriendUpdateService.getRecepientList(request);

    }

    @PostMapping("*")
    public String defaultMethod( @RequestBody RecepientsListRequest request) {

        return  "{\"status\":\"no handler found\"}";

    }

}
