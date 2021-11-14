package com.test.test.model;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@ToString
public class BillMast {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long id;
    String billNo;
    Date billDate;
    Date billDueDate;
    Double billAmt;
    Double tax;
    Double totalAmt;


}
