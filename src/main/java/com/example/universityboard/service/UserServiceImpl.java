package com.example.universityboard.service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.universityboard.model.User;
import com.example.universityboard.repository.UserRepository;

@Service
public class UserServiceImpl implements UserDetailsService {
	@Autowired
	private PasswordEncoder passwordEncoder;

	@Autowired
	UserRepository userRepository;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User dbUser = this.userRepository.findByUsername(username);

		if (dbUser != null) {
			Collection<GrantedAuthority> grantedAuthorities = new ArrayList<>();

			for (String role : dbUser.getRoles()) {
				GrantedAuthority authority = new SimpleGrantedAuthority(role);
				grantedAuthorities.add(authority);
			}

			org.springframework.security.core.userdetails.User user = new org.springframework.security.core.userdetails.User(
					dbUser.getUsername(), dbUser.getPassword(), grantedAuthorities);
			return user;
		} else {
			throw new UsernameNotFoundException(String.format("User '%s' not found", username));
		}
	}

	public User saveUser(User user) {
		user.setPassword(this.passwordEncoder.encode(user.getPassword()));
		return this.userRepository.save(user);
	}

	public List<User> getAll() {
		return this.userRepository.findAll();
	}

}
