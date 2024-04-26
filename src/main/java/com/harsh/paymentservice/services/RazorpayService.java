package com.harsh.paymentservice.services;

import com.harsh.paymentservice.paymentgateways.PaymentGateway;
import com.razorpay.RazorpayException;
import com.stripe.exception.StripeException;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service("razorpay")
public class RazorpayService implements PaymentService {
    private PaymentGateway paymentGateway;

    RazorpayService(@Qualifier("Razorpay") PaymentGateway paymentGateway){
        this.paymentGateway = paymentGateway;
    }

    @Override
    public String initiatePayment(Long orderId, String email) throws StripeException, RazorpayException {
        return paymentGateway.generatePaymentLink(orderId,email);
    }
}
