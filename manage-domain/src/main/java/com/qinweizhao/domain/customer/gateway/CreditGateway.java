package com.qinweizhao.domain.customer.gateway;

import com.qinweizhao.domain.customer.Customer;
import com.qinweizhao.domain.customer.Credit;

//Assume that the credit info is in antoher distributed Service
public interface CreditGateway {
    public Credit getCredit(String customerId);
}
