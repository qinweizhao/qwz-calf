package com.qinweizhao.domain.customer.gateway;

import com.qinweizhao.domain.customer.Customer;

public interface CustomerGateway {
    public Customer getByById(String customerId);
}
