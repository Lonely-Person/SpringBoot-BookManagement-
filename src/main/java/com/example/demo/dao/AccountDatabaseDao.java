package com.example.demo.dao;

import com.example.demo.domain.AccountDatabase;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

public interface AccountDatabaseDao extends JpaRepository<AccountDatabase, String> {

    @Query(value = "insert into account_database(account_id) values(?1)", nativeQuery = true)
    @Modifying
    void insertAccount(String string);


    //@Query(value = "select * from account_database order by rand() limit 1", nativeQuery = true)  //600多万条数据 6466ms
    @Query(value = "SELECT * FROM account_database WHERE id >= ((SELECT MAX(id) FROM account_database)-(SELECT MIN(id) FROM " +
            "account_database)) * RAND() + (SELECT MIN(id) FROM account_database) limit 1", nativeQuery = true)  //600多万条数据 133ms
    AccountDatabase findRand();
}
