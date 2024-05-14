package com.shuaibu.outhuser;

import org.springframework.security.core.Authentication;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
public class UserController {

    // @GetMapping("/user")
    // public Map<String, Object> getUser(@AuthenticationPrincipal OAuth2User principal) {
    //     return principal.getAttributes();
    // }

    @GetMapping("/userDetails")
    public Map<String, Object> getUserDetails(Authentication authentication) {
        OAuth2User oAuth2User = (OAuth2User) authentication.getPrincipal();
        return oAuth2User.getAttributes();
    }

    // @GetMapping("/me")
    // public Principal getCurrentUser(Principal principal) {
    //     return principal;
    // }
}
