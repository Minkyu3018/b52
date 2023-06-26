package org.zerock.b52.dto;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;

import lombok.Data;

@Data
public class MemberDTO extends User{

    private String mname;


    public MemberDTO(String email,
         String mpw, 
         String mname,
         List<String> roleNames) {
        
        super(email , mpw , roleNames.stream()
            .map(str -> new SimpleGrantedAuthority("ROLE_" + str))
            .collect(Collectors.toList())
        );

        this.mname = mname;

    }

}