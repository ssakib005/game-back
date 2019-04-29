package com.pavilion.cricket.service.imp;

import com.pavilion.cricket.model.UserAuth;
import com.pavilion.cricket.service.UserAuthService;
import com.pavilion.cricket.service.repo.UserAuthRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserAuthServiceImp implements UserAuthService {

    @Autowired
    UserAuthRepo repo;

    @Override
    public UserAuth add(UserAuth auth) {
        return repo.save(auth);
    }

    @Override
    public UserAuth get(String email) {
        return repo.findByEmail(email);
    }

    @Override
    public void delete(Long id) {

    }
}
