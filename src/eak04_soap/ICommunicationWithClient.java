package eak04_soap;

import javax.jws.WebMethod;
import javax.jws.WebService;

@WebService
public interface ICommunicationWithClient {

    @WebMethod
    public Answer solution(double a, double b, double x);
}
