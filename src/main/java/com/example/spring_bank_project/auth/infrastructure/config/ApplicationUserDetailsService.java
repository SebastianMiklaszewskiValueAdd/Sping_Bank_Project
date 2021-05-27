package com.example.spring_bank_project.auth.infrastructure.config;

import com.example.spring_bank_project.auth.infrastructure.adapter.dpi.AuthAccountDpiAdapter;
import com.example.spring_bank_project.shared.domain.valueObject.UserId;
import com.example.spring_bank_project.shared.infrastructure.auth.UserSecurityData;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
@RequiredArgsConstructor
class ApplicationUserDetailsService implements UserDetailsService {
    private final AuthAccountDpiAdapter accountDpi;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        var userData = this.accountDpi.fetchUserSecurityDataOrFail(new UserId(username));

        return this.createUserDetails(userData);
    }

    public UserDetails loadByUserId(UserId userId) throws UsernameNotFoundException {
        var userData = this.accountDpi.fetchUserSecurityDataOrFail(userId);

        return this.createUserDetails(userData);
    }

    private UserDetails createUserDetails(UserSecurityData userData) {
        return new User(userData.getUserId().getUserId().toString(), userData.getEncodedPin().getEncodedPin(),
                new ArrayList<>());
    }
}
