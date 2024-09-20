package com.Bank.Repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.Bank.Entity.Accounts;

@Repository
public interface AccountRepository extends JpaRepository<Accounts,Integer> {

}
