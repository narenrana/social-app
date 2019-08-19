package com.sgroup.socialapp.services;

import com.sgroup.socialapp.controller.request.RecepientsListRequest;
import com.sgroup.socialapp.controller.request.SubscribeFriendUpdateRequest;
import com.sgroup.socialapp.controller.response.BaseResponse;
import com.sgroup.socialapp.controller.response.RecepientsListResponse;
import com.sgroup.socialapp.entities.SubscribeFriendUpdateEntity;
import com.sgroup.socialapp.repository.SubscribeFriendUpdateEntityRepository;
import com.sgroup.socialapp.services.impl.SubscribeFriendUpdateServiceImpl;
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
import java.util.List;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(loader= AnnotationConfigContextLoader.class)
public class SubscribeFriendUpdateServiceTest {

    @MockBean
    private SubscribeFriendUpdateEntityRepository repository;

    @Autowired
    private SubscribeFriendUpdateService service;


    @Test
    void subscribeFriendTest() {
        String requester="lisa@example.com";
        String targetEmail="lisa@example.com";

        SubscribeFriendUpdateEntity entity= new SubscribeFriendUpdateEntity();
        entity.setId(100);
        entity.setEmail(requester);
        entity.setSubscriberEmail(targetEmail);

        Mockito.when(repository.save(Mockito.any(SubscribeFriendUpdateEntity.class))).thenReturn(entity);

        SubscribeFriendUpdateRequest request= new SubscribeFriendUpdateRequest();
        request.setRequestor(requester);
        request.setTarget(targetEmail);
        BaseResponse response=service.subscribeFriend(request);

        Assert.assertTrue("Test - SubscribeFriendUpdateService.subscribeFriend ", response.getSuccess());
    }

    @Test
    void getRecepientListTest() {
        String requester="lisa@example.com";
        String targetEmail="lisa@example.com";

        List<SubscribeFriendUpdateEntity> list= new ArrayList<>();
        SubscribeFriendUpdateEntity entity= new SubscribeFriendUpdateEntity();
        entity.setId(100);
        entity.setEmail(requester);
        entity.setSubscriberEmail(targetEmail);
        list.add(entity);
        Mockito.when(repository.findByEmail(Mockito.anyString())).thenReturn(list);

        RecepientsListRequest request= new RecepientsListRequest();
        request.setSender(requester);
        request.setText("Hello World! kate@example.com");
        RecepientsListResponse response=service.getRecepientList(request);

        Assert.assertTrue("Test - SubscribeFriendUpdateService.getRecepientList ", response.getSuccess());
    }

    @org.springframework.context.annotation.Configuration
    public static class ContextConfiguration {

        @Bean
        public SubscribeFriendUpdateService getSubscribeFriendUpdateService() {
            return new SubscribeFriendUpdateServiceImpl();
        }
    }
}
