package com.universalelements.APIControllers;

import com.universalelements.Entities.Account;

public interface AccountServiceInterface {
    public Account createUser(String userName, String pass, String email, String socialId);
}
