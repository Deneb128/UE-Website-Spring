package com.universalelements.APIControllers;

import com.universalelements.Entities.Account;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@ComponentScan({"com.universalelements"})
@EntityScan("com.universalelements")
@EnableJpaRepositories("com.universalelements")
public class AccountController {

    @Autowired
    private AccountServiceInterface accountService;
    @PostMapping(path="/register")
    public ResponseEntity<?> addNewAccount (@RequestParam(required = true) String login
            , @RequestParam(required = true) String password
            , @RequestParam(required = true) String email
            , @RequestParam(required = true) String social_id
    ) {
        Account a = accountService.createUser(login,password,email,social_id);
        return ResponseEntity.status(HttpStatus.OK).body(a);
    }
}
