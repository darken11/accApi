package org.cap.account.metier;

import org.cap.account.entities.Transaction;
import org.cap.account.repository.TransactionRestApiRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;



@Service
@Transactional
public class TransactionApiServiceImpl implements TransactionApiService {
    @Autowired
    private TransactionRestApiRepo transactionRestApiRepo;

    /**
     *
     * @param transaction
     * @return save a transction
     */
    @Override
    public Transaction save(Transaction transaction) {

        return transactionRestApiRepo.save(transaction);
    }
}
