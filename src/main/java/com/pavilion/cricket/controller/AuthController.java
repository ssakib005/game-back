package com.pavilion.cricket.controller;


import com.pavilion.cricket.model.UserAuth;
import com.pavilion.cricket.service.imp.UserAuthServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
public class AuthController {

    private static final String PATH = "user";
    private static final String LOGIN = PATH + "/login";

    @Autowired
    private UserAuthServiceImp imp;

    @PostMapping(value = LOGIN, consumes = MediaType.APPLICATION_JSON_VALUE)
    private ResponseEntity<UserAuth> getResponce(@RequestBody @Validated UserAuth auth){
        UserAuth auth1 = imp.get(auth.getEmail());
        if (auth1 == null){
            auth1 = imp.add(auth);
        }
        return ResponseEntity.ok(auth1);
    }


}
