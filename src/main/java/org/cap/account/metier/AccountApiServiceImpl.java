package org.cap.account.metier;


import org.cap.account.constants.ApiConstants;
import org.cap.account.entities.*;
import org.cap.account.repository.AccountRestApi;
import org.cap.account.repository.ClientRestApiRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.Date;
import java.util.List;


@Service
@Transactional
public class AccountApiServiceImpl implements AccountApiService {
    @Autowired
    private AccountRestApi accountRestApiRepo;
    @Autowired
    private ClientRestApiRepo clientRestApiRepo;
    @Autowired
    private TransactionApiService transactionApiService;

    /**
     *
     * @param codeAcc
     * @return an Account
     */
    @Override
    public Account findOne(Long codeAcc) {
        Account account = accountRestApiRepo.findById(codeAcc).orElse(null);

        if (account == null) throw new RuntimeException(ApiConstants.accountNotFound);
        return account;
    }

    /**
     *
     * @return list of account
     */
    @Override
    public List<Account> findAll() {
        return accountRestApiRepo.findAll();
    }

    /**
     *
     * @param requestOpeningAccount
     * @return open new Account
     */
    @Override
    public Account open(RequestAccount requestOpeningAccount) {


        if (requestOpeningAccount.getClientId() != null) {


            Client client = clientRestApiRepo.findClientById(requestOpeningAccount.getClientId());

            Account currentAccount = accountRestApiRepo.save(new CurrentAccount(client));


            if (requestOpeningAccount.getInitCredit() > 0) {
                Double result = currentAccount.getBalance() + requestOpeningAccount.getInitCredit();
                currentAccount.setBalance(result);
                Transaction t = new Transaction(currentAccount.getBalance(), new Date(), currentAccount);
                t = transactionApiService.save(t);
                currentAccount.getTransactions().add(t);
            }
            return accountRestApiRepo.save(currentAccount);
        } else {
            throw new RuntimeException(ApiConstants.notValidIdClient);

        }

    }
}


