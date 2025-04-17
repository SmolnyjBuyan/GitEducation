package ru.smolny.homework_03.util;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import ru.smolny.homework_03.model.User;

import java.util.Collection;
import java.util.Set;

public class UserPrincipal implements UserDetails {
    private final User user;
    private final Set<GrantedAuthority> authorities;

    public UserPrincipal(User user, Set<GrantedAuthority> authorities) {
        this.user = user;
        this.authorities = authorities;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities;
    }

    @Override
    public String getPassword() {
        return user.getPassword();
    }

    @Override
    public String getUsername() {
        return user.getUsername();
    }
}
