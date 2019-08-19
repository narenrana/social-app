package com.sgroup.socialapp.services;

import com.sgroup.socialapp.controller.request.AddFriendRequest;
import com.sgroup.socialapp.controller.request.CommonFriendsRequest;
import com.sgroup.socialapp.controller.request.GetFriendsRequest;
import com.sgroup.socialapp.controller.response.BaseResponse;
import com.sgroup.socialapp.controller.response.CommonFriendsResponse;
import com.sgroup.socialapp.controller.response.GetFriendsResponse;
import com.sgroup.socialapp.entities.FriendsEntity;
import com.sgroup.socialapp.repository.FriendsEntityRepository;
import com.sgroup.socialapp.services.impl.FriendsServiceImpl;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.AnnotationConfigContextLoader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(loader= AnnotationConfigContextLoader.class)
public class FriendsServiceTest {


    @MockBean
    private FriendsEntityRepository repository;

    @Autowired
    private FriendsService friendsService;


    @Test
    public void connectFriendTest() {
        /**
         * Mock Save Method or repository
         */
        String email="lisa@example.com";
        String friendEmail="lisa@example.com";

        FriendsEntity entity= new FriendsEntity();
        entity.setId(100l);
        entity.setEmail(email);
        entity.setFriendEmail(friendEmail);

        Mockito.when(repository.save(Mockito.any(FriendsEntity.class))).thenReturn(entity);

        AddFriendRequest request= new AddFriendRequest();
        request.setFriends(Arrays.asList(email,friendEmail));
        BaseResponse response=friendsService.connectFriend(request);

        Assert.assertTrue("Test - FriendsService.connectFriend ", response.getSuccess());

    }

    @Test
    public void getFriendsListTest() {

        String email="lisa@example.com";
        String friendEmail="lisa@example.com";
        List<FriendsEntity> entityList= new ArrayList<>();
        FriendsEntity entity= new FriendsEntity();
        entity.setEmail(email);
        entity.setFriendEmail(friendEmail);
        entityList.add(entity);
        Mockito.when(repository.getFriendsByEmail(Mockito.anyString())).thenReturn(entityList);

        GetFriendsRequest request= new GetFriendsRequest();
        request.setEmail("lisa@example.com");
        GetFriendsResponse response=friendsService.getFriendsList(request);

        Assert.assertTrue("Test - FriendsService.getFriendsList ", response.getSuccess());

    }


    @Test
    public void getCommonFriendsTest() {
        String email="lisa@example.com";
        String friendEmail="lisa@example.com";
        List<FriendsEntity> entityList= new ArrayList<>();
        FriendsEntity entity= new FriendsEntity();
        entity.setEmail(email);
        entity.setFriendEmail(friendEmail);
        entityList.add(entity);
        Mockito.when(repository.getFriendsByEmail(Mockito.anyString())).thenReturn(entityList);

        CommonFriendsRequest request= new CommonFriendsRequest();
        request.setFriends(Arrays.asList(email,friendEmail));
        CommonFriendsResponse response=friendsService.getCommonFriends(request);

        Assert.assertTrue("Test - FriendsService.getCommonFriends ", response.getSuccess());

    }


    @org.springframework.context.annotation.Configuration
    public static class ContextConfiguration {


        @Bean
        public FriendsService getBlockFriendsService() {
            return new FriendsServiceImpl();
        }
    }
}
