package com.lanchonete.order.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/pagamentos")
public class WebhookController {

    @PostMapping("/webhook")
    public ResponseEntity<Void> receiveNotification(@RequestBody String payload) {
        System.out.println("🔔 Notificação recebida do Mercado Pago: " + payload);
        return ResponseEntity.ok().build();
    }
}
