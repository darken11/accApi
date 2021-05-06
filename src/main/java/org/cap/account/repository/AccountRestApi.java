package org.cap.account.repository;

import org.cap.account.entities.Account;
import org.springframework.data.jpa.repository.JpaRepository;


public interface AccountRestApi extends JpaRepository<Account, Long> {

}
