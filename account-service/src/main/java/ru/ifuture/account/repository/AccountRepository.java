package ru.ifuture.account.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.ifuture.account.model.Account;

/**
 * account repository
 */
@Repository
public interface AccountRepository extends JpaRepository<Account, Integer> {
}
