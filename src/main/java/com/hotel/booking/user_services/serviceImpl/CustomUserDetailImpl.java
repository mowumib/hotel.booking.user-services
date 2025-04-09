package com.hotel.booking.user_services.serviceImpl;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.hotel.booking.user_services.entity.User;

public class CustomUserDetailImpl implements UserDetails{

    private Collection<? extends GrantedAuthority> authorities; /* NEW */

    private String id;
    private String email;

    @JsonIgnore
    private String password;

    public String getId() {
        return id;
    }

    public String getEmail() {
        return email;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return email;
    }

    public CustomUserDetailImpl(String id, String email, String password, Collection<? extends GrantedAuthority> authorities) {
        this.id = id;
        this.email = email;
        this.password = password;
        this.authorities = authorities; /* NEW WASN'T THERE BEFORE*/
    }
    public static CustomUserDetailImpl build(User user) {
        List<GrantedAuthority> authorities = user.getRoles().stream()
                .map(role -> new SimpleGrantedAuthority(role.getRoleName().name()))
                .collect(Collectors.toList()); /* NEW */
        return new CustomUserDetailImpl(
            user.getId(),
            user.getEmail(),
            user.getPassword(),
            authorities); /* NEW */
      }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities;/* NEW, PREVIOUS WAS NULL*/
    }
}
