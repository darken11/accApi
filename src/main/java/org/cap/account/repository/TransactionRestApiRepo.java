package org.cap.account.repository;

import org.cap.account.entities.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;


public interface TransactionRestApiRepo extends JpaRepository<Transaction, Long> {

}
