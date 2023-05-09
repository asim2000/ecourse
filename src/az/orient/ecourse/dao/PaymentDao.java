package az.orient.ecourse.dao;

import az.orient.ecourse.model.Payment;

import java.util.List;

public interface PaymentDao {

    List<Payment> getPaymentList() throws Exception;
    
    void addPayment(Payment payment) throws Exception;

}
