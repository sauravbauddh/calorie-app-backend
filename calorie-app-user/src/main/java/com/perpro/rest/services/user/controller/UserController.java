package com.perpro.rest.services.user.controller;


import com.perpro.rest.common.controller.BaseController;
import com.perpro.rest.common.mapper.BaseMapper;
import com.perpro.rest.services.user.dtos.UserResponse;
import com.perpro.rest.services.user.models.User;
import com.perpro.rest.services.user.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/api/v1/users")
@Slf4j
@Api(tags = "User Services", description = "Manage user related services.")
public class UserController implements BaseController {

    @Autowired
    UserService userService;

    @Autowired
    private BaseMapper<?, ?> mapper;

    @GetMapping("/{userId}")
    @ApiOperation(value = "Get a user by ID")
    public ResponseEntity<UserResponse> getGroupById(@PathVariable("userId") UUID userId) {
        User user = userService.getUserById(userId);
        UserResponse userResponse = getMapper().map(user, UserResponse.class);
        return ResponseEntity.ok(userResponse);
    }
    @Override
    public BaseMapper<?, ?> getMapper() {
        return mapper;
    }

}
