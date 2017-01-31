/**
 * Copyright (C) 2016 Guillermo Díaz Solís. Todos los derechos reservados.
 */
package com.example.exampleapp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.exampleapp.repository.UserRepository;

/**
 * @author Guillermo Díaz Solís
 * @date 30 oct. 2016
 */
@Service("userDetailsServiceImpl")
public class UserDetailsServiceImpl implements UserDetailsService {

  private UserRepository userRepository;

  @Autowired
  public UserDetailsServiceImpl(UserRepository userRepository) {
    this.userRepository = userRepository;
  }

  /*
   * (non-Javadoc)
   * 
   * @see
   * org.springframework.security.core.userdetails.UserDetailsService#loadUserByUsername(java.lang.
   * String)
   */
  @Transactional
  public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
    return (UserDetails) userRepository.findUserByUsername(username);
  }


}
