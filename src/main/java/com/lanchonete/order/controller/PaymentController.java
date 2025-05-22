package com.lanchonete.order.controller;

import com.lanchonete.order.model.PaymentRequest;
import com.lanchonete.order.service.PaymentService;
import com.mercadopago.exceptions.MPException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/pagamentos")
public class PaymentController {

    private final PaymentService paymentService;

    public PaymentController(PaymentService paymentService) {
        this.paymentService = paymentService;
    }

    @PostMapping
    public ResponseEntity<String> createPayment(@RequestBody PaymentRequest request) {
        try {
            String urlPayment = paymentService.createPayment(
                    request.getValue(), request.getDescription(), request.getEmail()
            );
            return ResponseEntity.ok(urlPayment);
        } catch (MPException e) {
            return ResponseEntity.internalServerError().body("Erro ao criar pagamento: " + e.getMessage());
        }
    }
}
