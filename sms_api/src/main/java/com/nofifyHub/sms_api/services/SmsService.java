package com.nofifyHub.sms_api.services;

import com.nofifyHub.sms_api.dtos.NotificationDTO;
import com.nofifyHub.sms_api.models.NotificationLog;
import com.nofifyHub.sms_api.repositories.NotificationLogRepository;
import com.vonage.client.VonageClient;
import com.vonage.client.sms.MessageStatus;
import com.vonage.client.sms.SmsSubmissionResponse;
import com.vonage.client.sms.messages.TextMessage;
import jakarta.annotation.PostConstruct;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;


@Service
public class SmsService {

    @Value("${vonage.api.key}")
    private String apiKey;

    @Value("${vonage.api.secret}")
    private String apiSecret;

    @Value("${vonage.sms.from}")
    private String from;

    @Autowired
    private NotificationLogRepository logRepository;

    @RabbitListener(queues = "sms_queue")
    public void sendSms(NotificationDTO notificationDTO) {
        VonageClient client = VonageClient.builder()
                .apiKey(apiKey)
                .apiSecret(apiSecret)
                .build();

        TextMessage message = new TextMessage(
                from,
                notificationDTO.getTelefone(),
                notificationDTO.getConteudo()
        );

        try {

            SmsSubmissionResponse response = client.getSmsClient().submitMessage(message);

            if (response.getMessages().get(0).getStatus() == MessageStatus.OK) {
                System.out.println("SMS enviado com sucesso para: " + notificationDTO.getTelefone());
                NotificationLog log = new NotificationLog();
                log.setTipo("SMS");
                log.setDestinatario(notificationDTO.getTelefone());
                log.setConteudo(notificationDTO.getConteudo());
                log.setStatus("ENVIADO");
                log.setDataEnvio(LocalDateTime.now());

                logRepository.save(log);

                System.out.println("SMS enviado e log salvo.");

            }
        }

        catch (Exception e) {
            NotificationLog log = new NotificationLog();
            log.setTipo("SMS");
            log.setDestinatario(notificationDTO.getTelefone());
            log.setConteudo(notificationDTO.getConteudo());
            log.setStatus("FALHA");
            log.setDataEnvio(LocalDateTime.now());

            logRepository.save(log);

            System.out.println("Erro ao enviar SMS: " + e.getMessage());
        }




    }
}