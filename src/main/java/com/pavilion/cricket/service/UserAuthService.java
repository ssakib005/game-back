package com.pavilion.cricket.service;

import com.pavilion.cricket.model.UserAuth;

public interface UserAuthService {

    UserAuth add(UserAuth auth);
    UserAuth get(String email);
    void delete(Long id);

}
