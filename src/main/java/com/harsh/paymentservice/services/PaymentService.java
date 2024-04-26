package com.harsh.paymentservice.services;

import com.harsh.paymentservice.paymentgateways.PaymentGateway;
import com.razorpay.RazorpayException;
import com.stripe.exception.StripeException;
import org.springframework.stereotype.Service;

@Service
public interface PaymentService {

    public String initiatePayment(Long orderId, String email) throws RazorpayException, StripeException;
}
