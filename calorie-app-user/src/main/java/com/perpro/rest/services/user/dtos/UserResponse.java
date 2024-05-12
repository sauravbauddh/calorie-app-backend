package com.perpro.rest.services.user.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserResponse {
    private UUID id;
    private String name;
    private UUID tagId;
    private UUID ownerId;
    private String description;
    private Integer memberCount;
}
