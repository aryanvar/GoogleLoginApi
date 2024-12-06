package com.example.googleapilogin.Service;

import com.example.googleapilogin.Entity.User;
import com.example.googleapilogin.Repositry.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
   private UserRepository userRepository;

    public User processOAuthPostLogin(OAuth2User oAuth2User) {
        String googleId = oAuth2User.getAttribute("sub");
        String email = oAuth2User.getAttribute("email");
        String name = oAuth2User.getAttribute("name");

        User existingUser = userRepository.findByGoogleId(googleId);
        if (existingUser == null) {
            User newUser = new User();
            newUser.setGoogleId(googleId);
            newUser.setEmail(email);
            newUser.setName(name);
            return userRepository.save(newUser);
        }
        return existingUser;
    }
}
