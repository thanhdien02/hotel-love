package com.example.hotellove.controllers;

import com.example.hotellove.dtos.AccountDto;
import com.example.hotellove.dtos.TokenDetails;
import com.example.hotellove.exceptions.InvalidException;
import com.example.hotellove.exceptions.UserNotFoundAuthenticationException;
import com.example.hotellove.securities.CustomUserDetailsService;
import com.example.hotellove.securities.JwtTokenUtils;
import com.example.hotellove.securities.JwtUserDetails;
import com.example.hotellove.securities.UserAuthenticationToken;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import javax.validation.Valid;
import java.security.Principal;
import java.util.Date;

@Slf4j
@RestController
@RequestMapping("/rest/login")
public class AuthenticationController {
    private final AuthenticationManager authenticationManager;

    private final CustomUserDetailsService customUserDetailsService;

    private final JwtTokenUtils jwtTokenUtils;

    private final RestTemplate restTemplate = new RestTemplate();

    public AuthenticationController(AuthenticationManager authenticationManager, CustomUserDetailsService customUserDetailsService,
                                    JwtTokenUtils jwtTokenUtils) {
        this.authenticationManager = authenticationManager;
        this.customUserDetailsService = customUserDetailsService;
        this.jwtTokenUtils = jwtTokenUtils;
    }

//    @ApiOperation(value = "login form (username, password), avatar null")
    @PostMapping
    public ResponseEntity<TokenDetails> login(@Valid @RequestBody AccountDto dto) {
        UserAuthenticationToken authenticationToken = new UserAuthenticationToken(
                dto.getUsername(),
                dto.getPassword(),
                true
        );
        try {
            authenticationManager.authenticate(authenticationToken);
        } catch (UserNotFoundAuthenticationException | BadCredentialsException ex) {
            throw new InvalidException(ex.getMessage());
        }catch (Exception ex){
            System.out.println(ex.getMessage());
        }
        final JwtUserDetails userDetails = customUserDetailsService
                .loadUserByUsername(dto.getUsername());
        final TokenDetails result = jwtTokenUtils.getTokenDetails(userDetails, null);
        log.info(String.format("User %s login at %s", dto.getUsername(), new Date()));
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @GetMapping("/hello")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<String> sayHello(Principal principal) {
        return new ResponseEntity<>(String.format("Hello %s", principal.getName()), HttpStatus.OK);
    }

}
