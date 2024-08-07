package com.geoshare.backend.security;

import java.util.Arrays;
import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.geoshare.backend.entity.GeoshareUser;

public class SecurityUser implements UserDetails {

	private GeoshareUser user;
	
	public SecurityUser(GeoshareUser user) {
		this.user = user;
	}
	
	@Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return Arrays.stream(user
        		.getRoles()
        		.split(","))
        		.map(SimpleGrantedAuthority::new)
        		.toList();
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

	@Override
	public String getUsername() {
		return user.getUsername();
	}
    
	@Override
	public String getPassword() {
		return user.getPassword();
	}
	
	public Long getUserId() {
		return user.getId();
	}
	
}
