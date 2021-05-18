package eak04_soap;

import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.jws.soap.SOAPBinding.Style;

@WebService
@SOAPBinding(style = Style.RPC)

public class CommunicationWithClient implements ICommunicationWithClient {

    @Override
    public Answer solution(double a, double b, double x) {
        double y;
        try {
            System.out.println("Значения переменных:\na = " + a + "\nb = " + b + "\nx = " + x);
            if (x >= 5) {
                y = (5 * x * x) / (6 * (a + b) * (a + b));
            } else {
                y = (x * x * x * (a + b));
            }
            if ((Double.isNaN(y)) || Double.isInfinite(y)) {
                return null;
            } else {
                Answer result = new Answer();
                result.setY(y);
                return result;
            }
        } catch (Exception e) {
            return null;
        }
    }

}
