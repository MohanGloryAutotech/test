package com.test.test;




import com.test.test.model.BillMast;
import com.test.test.model.GeneralResponse;
import com.test.test.serviceimpl.BillServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class BillController {

    @Autowired
    BillServiceImpl billService;


    @GetMapping(value="/bills")
    public ResponseEntity<GeneralResponse<List<BillMast>>> getAllBills() throws Exception {

        GeneralResponse<List<BillMast>> result;
        boolean flag;
        try {

            List<BillMast> list =billService.getAllBillMast();
            if(list.isEmpty())
            {
                result = new GeneralResponse<>(list, "Data not found", true, System.currentTimeMillis(), HttpStatus.OK);
            }
            else
            result = new GeneralResponse<>(list, "Data found", true, System.currentTimeMillis(), HttpStatus.OK);


        }
        catch(Exception e)
        {
            e.printStackTrace();
            result = new GeneralResponse<>(null, e.getMessage(), false, System.currentTimeMillis(), HttpStatus.BAD_REQUEST);

        }
        return new ResponseEntity<>(result,HttpStatus.valueOf(result.getStatusCode()));
    }


    @GetMapping(value="/bills/{id}")
    public ResponseEntity<GeneralResponse<BillMast>> getBillById(@PathVariable(name = "id") Long id) throws Exception {

        GeneralResponse<BillMast> result;
        boolean flag;
        try {

            Optional<BillMast> record =billService.getBillById(id);
            if(!record.isPresent())
            {
                result = new GeneralResponse<>(null, "Data not found", true, System.currentTimeMillis(), HttpStatus.OK);
            }
            else
                result = new GeneralResponse<>(record.get(), "Data found", true, System.currentTimeMillis(), HttpStatus.OK);


        }
        catch(Exception e)
        {
            e.printStackTrace();
            result = new GeneralResponse<>(null, e.getMessage(), false, System.currentTimeMillis(), HttpStatus.BAD_REQUEST);

        }
        return new ResponseEntity<>(result,HttpStatus.valueOf(result.getStatusCode()));
    }

    @GetMapping(value="/bills/due/{date}")
    public ResponseEntity<GeneralResponse<List<BillMast>>> getAllDueBills(@PathVariable(name = "date") String date) throws Exception {

        GeneralResponse<List<BillMast>> result;
        boolean flag;
        try {

            List<BillMast> list =billService.getAllDuwBillMast(date);
            if(list.isEmpty())
            {
                result = new GeneralResponse<>(list, "Data not found", true, System.currentTimeMillis(), HttpStatus.OK);
            }
            else
                result = new GeneralResponse<>(list, "Data found", true, System.currentTimeMillis(), HttpStatus.OK);


        }
        catch(Exception e)
        {
            e.printStackTrace();
            result = new GeneralResponse<>(null, e.getMessage(), false, System.currentTimeMillis(), HttpStatus.BAD_REQUEST);

        }
        return new ResponseEntity<>(result,HttpStatus.valueOf(result.getStatusCode()));
    }



}
