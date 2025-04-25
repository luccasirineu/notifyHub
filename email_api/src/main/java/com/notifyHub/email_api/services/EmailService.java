package com.notifyHub.email_api.services;

import com.notifyHub.email_api.dtos.NotificationDTO;
import com.notifyHub.email_api.models.NotificationLog;
import com.notifyHub.email_api.repositories.NotificationLogRepository;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;


@Service
public class EmailService {

    @Autowired
    private JavaMailSender mailSender;

    @Autowired
    private NotificationLogRepository logRepository;


    @RabbitListener(queues = "notificationQueue")
    public void sendEmail(NotificationDTO notificationDTO) {
        try {
            System.out.println("Recebendo notificação para envio de e-mail: " + notificationDTO);

            SimpleMailMessage message = new SimpleMailMessage();
            message.setTo(notificationDTO.getEmail());
            message.setSubject(notificationDTO.getAssunto());
            message.setText(notificationDTO.getConteudo());

            mailSender.send(message);

            System.out.println("E-mail enviado para: " + notificationDTO.getEmail());

            NotificationLog log = new NotificationLog();
            log.setTipo("EMAIL");
            log.setDestinatario(notificationDTO.getEmail());
            log.setConteudo(notificationDTO.getConteudo());
            log.setStatus("ENVIADO");
            log.setAssunto(notificationDTO.getAssunto());
            log.setDataEnvio(LocalDateTime.now());

            logRepository.save(log);

            System.out.println("EMAIL enviado e log salvo.");

        } catch (Exception e) {
            NotificationLog log = new NotificationLog();
            log.setTipo("EMAIL");
            log.setDestinatario(notificationDTO.getEmail());
            log.setConteudo(notificationDTO.getConteudo());
            log.setStatus("FALHA");
            log.setAssunto(notificationDTO.getAssunto());
            log.setDataEnvio(LocalDateTime.now());

            logRepository.save(log);

            System.out.println("Erro ao enviar EMAIL: " + e.getMessage());
        }
    }
}