package com.project.watcha.global.util;

import com.project.watcha.domain.user.User;
import com.project.watcha.domain.user.repository.UserRepository;
import com.project.watcha.global.exception.exceptions.UserNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import static com.project.watcha.global.exception.ErrorCode.USER_NOT_FOUND;

@Component
@RequiredArgsConstructor
public class CurrentUserUtil {

    private final UserRepository userRepository;

    public User getCurrentUser() {
        String email;
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        if(principal instanceof UserDetails) {
            email = ((User) principal).getEmail();
        } else {
            email = principal.toString();
        }
        return userRepository.findByEmail(email)
                .orElseThrow(() -> new UserNotFoundException("계정을 찾을 수 없습니다.", USER_NOT_FOUND));
    }
}
