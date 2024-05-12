package com.perpro.rest.services.user.models;

import com.perpro.rest.common.persistence.AbstractEntity;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Data
@Table(name = "users")
public class User extends AbstractEntity {

    @Column
    private String name;

//    @ManyToOne
//    @JoinColumn(name = "tag_id", referencedColumnName = "id")
//    private Tag tag;
//
//    @Column
//    private String description;
//
//    @Column
//    private Integer memberCount;
//
//    @Column(nullable = false)
//    private Timestamp createdAt;
//
//    @Column(nullable = false)
//    private Timestamp updatedAt;
}