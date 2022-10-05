package com.myorga.code.repository;

import com.myorga.code.domain.BankAccount;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Spring Data SQL repository for the BankAccount entity.
 */
@SuppressWarnings("unused")
@Repository
public interface BankAccountRepository extends JpaRepository<BankAccount, Long> {
    @Query("select bankAccount from BankAccount bankAccount where bankAccount.user.login = ?#{principal.username}")
    List<BankAccount> findByUserIsCurrentUser();
}
