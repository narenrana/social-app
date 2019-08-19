package com.sgroup.socialapp.entities;

import lombok.Data;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Objects;

@Entity
@Table(name = "subscribe_friend_update", schema = "", catalog = "")
@Data
public class SubscribeFriendUpdateEntity {

    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Basic
    @Column(name = "email", nullable = true, length = 50)
    private String email;

    @Basic
    @Column(name = "subscriber_email", nullable = true, length = 50)
    private String subscriberEmail;


    @Basic
    @Column(name = "created", nullable = true)
    private Timestamp created;

    @Basic
    @Column(name = "last_updated", nullable = true)
    private Timestamp lastUpdated;

}
