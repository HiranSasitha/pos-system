package com.sprinbootacademy.pointofsale.dto.queryInterfaces;

import java.util.ArrayList;
import java.util.Date;

public interface OrderDetailsInterface {

    String getCustomerName();   //type method
    String getCustomerAddress();
    ArrayList getContactNumber();
    Date getDate();
    Double getTotal();






}
