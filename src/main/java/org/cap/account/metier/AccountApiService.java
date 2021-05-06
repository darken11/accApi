package org.cap.account.metier;

import org.cap.account.entities.Account;
import org.cap.account.entities.RequestAccount;
import java.util.List;


public interface AccountApiService {
    public Account open(RequestAccount account);

    List<Account> findAll();

    public Account findOne(Long codeAcc);
}
