package com.notifyHub.notification_api.controllers;

import com.notifyHub.notification_api.dtos.NotificationDTO;
import com.notifyHub.notification_api.services.NotificationService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/notifications")
public class NotificationController {

    private static final Logger logger = LoggerFactory.getLogger(NotificationController.class);

    @Autowired
    private NotificationService notificationService;


    @PostMapping("/send")
    public ResponseEntity<String> sendNotification(@RequestBody NotificationDTO notificationDTO) {
        if (notificationDTO.getTipo().equalsIgnoreCase("EMAIL")) {
            notificationService.sendEmailNotification(notificationDTO);
            logger.info("Notificação de e-mail enviada para a fila de email.");
            return ResponseEntity.ok("Notificação de e-mail enviada para a fila.");

        } else if (notificationDTO.getTipo().equalsIgnoreCase("SMS")) {
            notificationService.sendSmsNotification(notificationDTO);
            logger.info("Notificação de e-mail enviada para a fila de SMS.");
            return ResponseEntity.ok("Notificação de SMS enviada para a fila.");
        }
        return ResponseEntity.badRequest().body("Tipo de notificação inválido.");
    }
}