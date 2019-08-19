package com.sgroup.socialapp.entities;

import lombok.Data;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Objects;

@Entity
@Table(name = "friends", schema = "", catalog = "")
@Data
public class FriendsEntity {

    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Basic
    @Column(name = "name", nullable = true, length = 20)
    private String name;

    @Basic
    @Column(name = "email", nullable = true, length = 50)
    private String email;

    @Basic
    @Column(name = "friend_email", nullable = true, length = 50)
    private String friendEmail;

    @Basic
    @Column(name = "created", nullable = true)
    private Timestamp created;

    @Basic
    @Column(name = "last_updated", nullable = true)
    private Timestamp lastUpdated;

  }
