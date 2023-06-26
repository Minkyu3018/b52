package org.zerock.b52.security;

import java.util.List;

import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.zerock.b52.dto.MemberDTO;
import org.zerock.b52.dto.MemberReadDTO;
import org.zerock.b52.mappers.MemberMapper;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;

@Service
@Log4j2
@RequiredArgsConstructor
public class CustomUserDetailsService implements UserDetailsService{

    private final MemberMapper memberMapper;

    private PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        
        log.info("-----------------------");

        log.info("loadUserByUsername: " + username);

        log.info("-----------------------");

        MemberDTO memberDTO = null;
        MemberReadDTO readDTO = memberMapper.selectOne(username);

        log.info("======시작=%+%+%+%+%+%+%+%" + readDTO);
        if(readDTO != null){
            
            // 아니라면
            memberDTO = new MemberDTO(
                readDTO.getEmail(), 
                readDTO.getMpw(), 
                readDTO.getMname(), 
                readDTO.getRolenames());


            return memberDTO;

        }


        memberDTO = 
        new MemberDTO(
            username,
            readDTO.getMpw(),
            readDTO.getMname(),            
            readDTO.getRolenames()
        );
            
          
        return memberDTO;

    }

    
}
