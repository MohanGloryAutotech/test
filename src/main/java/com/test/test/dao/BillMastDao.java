package com.test.test.dao;

import com.test.test.model.BillMast;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface BillMastDao extends JpaRepository<BillMast,Long> {

    @Query("select x from BillMast x where Date(x.billDueDate)=Date(:date)")
    List<BillMast> getAllBillMastByDueDate(String date);
}
