package com.qinweizhao.api;

import com.alibaba.cola.dto.MultiResponse;
import com.alibaba.cola.dto.Response;
import com.qinweizhao.dto.CustomerAddCmd;
import com.qinweizhao.dto.CustomerListByNameQry;
import com.qinweizhao.dto.data.CustomerDTO;

public interface CustomerServiceI {

    public Response addCustomer(CustomerAddCmd customerAddCmd);

    public MultiResponse<CustomerDTO> listByName(CustomerListByNameQry customerListByNameQry);
}
