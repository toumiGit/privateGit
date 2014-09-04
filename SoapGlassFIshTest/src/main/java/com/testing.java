package com;

import javax.jws.WebMethod;
import javax.jws.WebService;

@WebService
public class testing {

    public testing()
    {

    }

    @WebMethod
    public String  methodTest()
    {
        return "alpha";
    }


}
