package com.universalelements.APIControllers;

import com.universalelements.Entities.Account;
import com.universalelements.Exception.GlobalExceptionMessageHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.stereotype.Service;
import static com.universalelements.Utilities.Utilities.*;

@Service
public class AccountService implements AccountServiceInterface {
    @Autowired
    private AccountRepository accountRepository;
    @Override
    public Account createUser(String userName, String pass, String email, String socialId) {
        Account ue_Acc = new Account();

        if(!isValidUserNameLow(userName)){
            throw new GlobalExceptionMessageHandler("Username too small", "Invalid Username", "/errors/invalidusernamelow", "Registration Error", HttpStatus.UNPROCESSABLE_ENTITY);
        }
        else if(!isValidUserNameHigh(userName)){
            throw new GlobalExceptionMessageHandler("Username too long", "Invalid Username","/errors/invalidusernamehigh", "Registration Error", HttpStatus.UNPROCESSABLE_ENTITY);
        }
        ue_Acc.setLogin(userName);

        String hash = BCrypt.hashpw(pass, BCrypt.gensalt(9));
        ue_Acc.setPassword(hash);

        if(!isValidEmail(email)){
            throw new GlobalExceptionMessageHandler("E-mail format not valid", "Invalid E-Mail format", "/errors/invalidemail", "Registration Error", HttpStatus.UNPROCESSABLE_ENTITY);
        }
        ue_Acc.setEmail(email);
        if(!isValidCharDeletionCodeLow(socialId)){
            throw new GlobalExceptionMessageHandler("Char Deletion code has less then 7 digits", "Invalid Char Deletion Code","/errors/invalidchardeletioncode", "Registration Error", HttpStatus.UNPROCESSABLE_ENTITY);
        }
        else if(!isValidCharDeletionCodeHigh(socialId)){
            throw new GlobalExceptionMessageHandler("Char Deletion code has more then 7 digits", "Invalid Char Deletion Code","/errors/invalidchardeletioncode", "Registration Error", HttpStatus.UNPROCESSABLE_ENTITY);
        }
        ue_Acc.setSocial_id(socialId);
        if(!accountRepository.findBylogin(userName).isEmpty()){
            throw new GlobalExceptionMessageHandler("The username already exists", "Existing Username","/errors/usernamealreadyexists", "Registration Error", HttpStatus.CONFLICT);
        }
        return accountRepository.save(ue_Acc);
    }
}
