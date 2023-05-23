package az.orient.ecourse.service;

import az.orient.ecourse.model.Payment;

import java.util.List;

public interface PaymentService {

    List<Payment> getPaymentList() throws Exception;
    
    void addPayment(Payment payment) throws Exception;
    
    Payment getPaymentById(Long paymentId) throws Exception;

}
