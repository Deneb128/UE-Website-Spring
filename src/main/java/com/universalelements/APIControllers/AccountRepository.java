package com.universalelements.APIControllers;
import com.universalelements.Entities.Account;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

public interface AccountRepository extends CrudRepository<Account, Integer> {

	public Optional<Account> findBylogin(String login);
}
