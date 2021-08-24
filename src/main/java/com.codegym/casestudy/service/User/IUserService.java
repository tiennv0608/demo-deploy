package com.codegym.casestudy.service.User;


import com.codegym.casestudy.model.user.User;
import com.codegym.casestudy.service.IGeneralService;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.Optional;

public interface IUserService extends IGeneralService<User>, UserDetailsService {
    Optional<User> findByUserName(String username);
}
