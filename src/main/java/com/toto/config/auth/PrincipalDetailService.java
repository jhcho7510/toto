package com.toto.config.auth;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class PrincipalDetailService implements UserDetailsService {
    /*
    private UserRepository userRepository;

    @Autowired
    public PrincipalDetailService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }
*/
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        /*
        User principal = userRepository.findById(0L).orElseThrow(() -> {
            return new UsernameNotFoundException("해당 사용자를 찾을수 없습니다.:" + username);
        });

        User principal = userRepository.findByUsername(username);
        if(principal == null) {
            return (UserDetails) new UsernameNotFoundException("해당 사용자를 찾을수 없습니다.:" + username);
        }
        return new PrincipalDetail(principal); //시큐리티의 세션에 유저정보가 저장이됨. (원래는 콘솔창에 뜨는 user, pw가 있었음)
        */
        return null;
    }
}
