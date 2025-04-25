package com.notifyHub.email_api.models;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "notification_logs")
public class NotificationLog {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String tipo;
    private String destinatario;
    private String conteudo;
    private String status;
    private String assunto;
    private LocalDateTime dataEnvio;


    public NotificationLog() {
    }

    public NotificationLog(Long id, String tipo, String destinatario, String conteudo, String status, String assunto, LocalDateTime dataEnvio) {
        this.id = id;
        this.tipo = tipo;
        this.destinatario = destinatario;
        this.conteudo = conteudo;
        this.status = status;
        this.assunto = assunto;
        this.dataEnvio = dataEnvio;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getDestinatario() {
        return destinatario;
    }

    public void setDestinatario(String destinatario) {
        this.destinatario = destinatario;
    }

    public String getConteudo() {
        return conteudo;
    }

    public void setConteudo(String conteudo) {
        this.conteudo = conteudo;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getAssunto() {
        return assunto;
    }

    public void setAssunto(String assunto) {
        this.assunto = assunto;
    }

    public LocalDateTime getDataEnvio() {
        return dataEnvio;
    }

    public void setDataEnvio(LocalDateTime dataEnvio) {
        this.dataEnvio = dataEnvio;
    }
}