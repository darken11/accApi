package org.cap.account.web;

import org.cap.account.entities.Account;
import org.cap.account.entities.RequestAccount;
import org.cap.account.metier.AccountApiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@CrossOrigin(origins = "*")
public class AccountRestController {
    @Autowired
    AccountApiService accountRestApi;

    /**
     *
     * @return list of account
     */
    @GetMapping(path = "/accounts", produces = {MediaType.APPLICATION_JSON_VALUE})
    @ResponseBody
    public List<Account> getCurrentAccounts() {

        return accountRestApi.findAll();
    }

    /**
     *
     * @param accountId
     * @return an account
     */
    @GetMapping(path = "/accounts/{accountId}", produces = {MediaType.APPLICATION_JSON_VALUE})
    @ResponseBody
    public Account getCurrentAccountsById(@PathVariable Long accountId) {

        return accountRestApi.findOne(accountId);
    }

    /**
     *
     * @param request
     * @return open aan account
     */
    @PostMapping(path = "/accounts")
    @ResponseBody
    public Account save(@RequestBody RequestAccount request) {

        return accountRestApi.open(request);
    }


}
