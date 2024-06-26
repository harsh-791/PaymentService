package com.harsh.paymentservice.controllers;

import com.harsh.paymentservice.dtos.InitiatePaymentRequestDto;
import com.harsh.paymentservice.services.PaymentService;
import com.razorpay.RazorpayException;
import com.stripe.exception.StripeException;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/payments")
public class PaymentController {
    private PaymentService paymentService;

    PaymentController(@Qualifier("razorpay") PaymentService paymentService){
        this.paymentService = paymentService;
    }

    @PostMapping("/")
    public String initiatePayment(@RequestBody InitiatePaymentRequestDto requestDto) throws StripeException, RazorpayException {
//        return "Order Id" + requestDto.getOrderId();
        return paymentService.initiatePayment(
                requestDto.getOrderId(),
                requestDto.getEmail()
        );
    }

}
