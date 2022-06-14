package com.bezkoder.springjwt.security.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bezkoder.springjwt.models.User;
import com.bezkoder.springjwt.repository.UserRepository;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {
  @Autowired
  UserRepository userRepository;
  
  @Transactional(readOnly = true)
  public List<User> findAll(){
    return (List<User>) userRepository.findAll();     
  }
  
  @Transactional(readOnly = true)
  public Optional<User> getById(Long id){
    return userRepository.findById(id);     
  }

  //ESTE METODO SE USA CUANDO SE LLAMA AL "Authenticate"66 DE "AuthController"
  @Override
  @Transactional
  public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
    User user = userRepository.findByUsername(username)
        .orElseThrow(() -> new UsernameNotFoundException("User Not Found with username: " + username));

    return UserDetailsImpl.build(user);
  }
  
  @Transactional(readOnly = true)
  public List<User> loadUserByNombre(String username){
//    List<User> user = userRepository.findByNombre(username);
//    return user;
	  return userRepository.findByNombre(username);
  }


}
