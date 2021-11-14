package com.test.test.serviceimpl;

import com.test.test.dao.BillMastDao;
import com.test.test.model.BillMast;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service("billService")
public class BillServiceImpl {


    @Autowired
    BillMastDao billMastDao;
    public List<BillMast> getAllBillMast() {
        return billMastDao.findAll();
    }

    public Optional<BillMast> getBillById(Long id) {
        return billMastDao.findById(id);
    }

    public List<BillMast> getAllDuwBillMast(String date) {
        Date newDate = new Date(date);
        return billMastDao.getAllBillMastByDueDate(date);
    }
}
