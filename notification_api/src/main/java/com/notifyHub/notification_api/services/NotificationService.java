package com.notifyHub.notification_api.services;

import com.notifyHub.notification_api.dtos.NotificationDTO;
import com.notifyHub.notification_api.models.Notification;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class NotificationService {

    @Autowired
    private  RabbitTemplate rabbitTemplate;


    public void sendEmailNotification(NotificationDTO notificationDTO) {
        // Converte NotificationDTO para Notification (entidade ou modelo de domínio)

        Notification notification = toEntity(notificationDTO);
        rabbitTemplate.convertAndSend("notificationQueue", notification);
    }

    public void sendSmsNotification(NotificationDTO notificationDTO) {
        // Converte NotificationDTO para Notification (entidade ou modelo de domínio)

        Notification notification = toEntity(notificationDTO);
        rabbitTemplate.convertAndSend("sms_queue", notification);
    }



    public static Notification toEntity(NotificationDTO dto) {
        return new Notification(dto.getTipo(), dto.getEmail(), dto.getTelefone(), dto.getAssunto(), dto.getConteudo());
    }

    public static NotificationDTO toDTO(Notification entity) {
        return new NotificationDTO(entity.getTipo(), entity.getEmail(), entity.getTelefone(),entity.getAssunto(), entity.getConteudo());
    }
}