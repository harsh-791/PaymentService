package com.harsh.paymentservice.services;

import com.harsh.paymentservice.paymentgateways.PaymentGateway;
import com.razorpay.RazorpayException;
import com.stripe.exception.StripeException;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service("stripe")
public class StripepayService implements PaymentService {
    private PaymentGateway paymentGateway;

    StripepayService(@Qualifier("Stripe") PaymentGateway paymentGateway){
        this.paymentGateway = paymentGateway;
    }

    @Override
    public String initiatePayment(Long orderId, String email) throws RazorpayException, StripeException {
        return paymentGateway.
                generatePaymentLink(orderId,email);
    }
}
