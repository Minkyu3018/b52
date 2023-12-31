package org.zerock.b52.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;

@Controller
@RequiredArgsConstructor
@Log4j2
@RequestMapping("/member")
public class MemberController {
    
    @PreAuthorize("permitAll")
    @GetMapping("/signup")
    public void signup(){
        log.info("signup...................");

    }

    @PreAuthorize("hasRole('USER')")
    @GetMapping("/mypage")
    public void mypage(){
        log.info("mypage...................");

    }

    @PreAuthorize("permitAll")
    @GetMapping("/signin")
    public void signin(){
        log.info("signin...................");

    }

    @PreAuthorize("permitAll")
    @GetMapping("/login")
    public void login(){
        log.info("login...................");

    }

}
