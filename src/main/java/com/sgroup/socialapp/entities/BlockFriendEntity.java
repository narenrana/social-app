package com.sgroup.socialapp.entities;

import lombok.Data;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Objects;

@Entity
@Table(name = "block_friend", schema = "", catalog = "")
@Data
public class BlockFriendEntity<B, L extends Number> {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Basic
    @Column(name = "email", nullable = true, length = 50)
    private String email;

    @Basic
    @Column(name = "blocked_email", nullable = true, length = 50)
    private String blockedEmail;

    @Basic
    @Column(name = "created", nullable = true)
    private Timestamp created;

    @Basic
    @Column(name = "last_updated", nullable = true)
    private Timestamp lastUpdated;


}
