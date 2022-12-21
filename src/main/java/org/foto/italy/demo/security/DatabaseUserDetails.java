package org.foto.italy.demo.security;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

import org.foto.italy.demo.pojo.Role;
import org.foto.italy.demo.pojo.User;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

public class DatabaseUserDetails implements UserDetails{

	
	private static final long serialVersionUID = -4066260198017435481L;
	private final User user;
	
	public DatabaseUserDetails(User user) {
		this.user = user;
	}
	
	
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		Set<Role> roles = user.getRoles();
		Set<GrantedAuthority> grantRole = new HashSet<>();
		for(Role role : roles) {
			grantRole.add(new SimpleGrantedAuthority(role.getName()));
		}
		return grantRole;
	}

	@Override
	public String getPassword() {
		
		return user.getPassword();
	}

	@Override
	public String getUsername() {
		return user.getUsername();
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
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isEnabled() {
		// TODO Auto-generated method stub
		return true;
	}

}
