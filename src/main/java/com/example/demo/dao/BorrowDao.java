package com.example.demo.dao;

import com.example.demo.domain.Borrow;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Repository
public interface BorrowDao extends JpaRepository<Borrow, Long> {

    @Query(value = "select book_id from borrow where user_id = (?1) and returned=0", nativeQuery = true)
    List<Long> findCurrentBorrowByUserId(String userId);

    //由于还要设置归还时间以及罚款金额故不采用这个方法，但是这个方法上需要加 事务 的这一项值得注意
    //@Modifying
    //@Transactional  //好像执行update和delete语句时，必须在这里添加事务，只在service层添加不起作用
    //@Query(value = "update borrow set returned=1 where user_id = (?1) and book_id = (?2)", nativeQuery = true)
    //void returnBook(String userId, Long bookId);

    Borrow findBorrowByUserIdAndBookId(String userId, Long bookId);
}
