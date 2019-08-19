package com.sgroup.socialapp.services;

import com.sgroup.socialapp.controller.request.BlockFriendsUpdateRequest;
import com.sgroup.socialapp.controller.response.BaseResponse;
import com.sgroup.socialapp.entities.BlockFriendEntity;
import com.sgroup.socialapp.repository.BlockFriendEntityRepository;
import com.sgroup.socialapp.services.impl.BlockFriendsServiceImpl;
import org.junit.Assert;
import org.junit.Before;
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
public class BlockFriendsServiceTest {


    @MockBean
    private BlockFriendEntityRepository blockFriendEntityRepository;

    @Autowired
    private BlockFriendsService blockFriendsService;

    @Before
    public void init() {

    }


    @Test
    public void blockFriendTest() {

        String requesterEmail="lisa@example.com";
        String targetEmail="lisa@example.com";

        /**
         * Mock Save Method or repository
         */

        BlockFriendEntity entity= new BlockFriendEntity();
        entity.setId(100l);
        entity.setEmail(requesterEmail);
        entity.setBlockedEmail(targetEmail);
        Mockito.when(blockFriendEntityRepository.save(Mockito.any(BlockFriendEntity.class))).thenReturn(entity);


        BlockFriendsUpdateRequest request= new BlockFriendsUpdateRequest();
        request.setRequestor(requesterEmail);
        request.setTarget(targetEmail);

        BaseResponse response= blockFriendsService.blockFriend(request);

        Assert.assertTrue("Test - BlockFriendsService.blockFriend", response.getSuccess());


    }


    @Test
    public void findBlockedUserListTest() {
        /**
         * Mock Save Method or repository
         */
        String requesterEmail="lisa@example.com";
        String targetEmail="lisa@example.com";
        List<BlockFriendEntity> entityList= new ArrayList<>();
        BlockFriendEntity entity= new BlockFriendEntity();
        entity.setEmail(requesterEmail);
        entity.setBlockedEmail(targetEmail);
        entityList.add(entity);
        Mockito.when(blockFriendEntityRepository.findByEmail(Mockito.anyString())).thenReturn(entityList);

        List<BlockFriendEntity>  list=blockFriendsService.findBlockedUserList(requesterEmail);

        Assert.assertTrue("Test- BlockFriendsService.findBlockedUserListTest ",list.size() > 0);


    }

    @org.springframework.context.annotation.Configuration
    public static class ContextConfiguration {


        @Bean
        public BlockFriendsService getBlockFriendsService() {
            return new BlockFriendsServiceImpl();
        }
    }
}
