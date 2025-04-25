package com.notifyHub.notification_api.dtos;

public class NotificationDTO {

    private String tipo; // Pode ser "EMAIL" ou "SMS"
    private String email; // Para envio de e-mail
    private String telefone; // Para envio de SMS
    private String assunto; // Relevante para e-mails
    private String conteudo;

    public NotificationDTO() {
    }

    public NotificationDTO(String tipo, String email, String telefone, String assunto, String conteudo) {
        this.tipo = tipo;
        this.email = email;
        this.telefone = telefone;
        this.assunto = assunto;
        this.conteudo = conteudo;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getAssunto() {
        return assunto;
    }

    public void setAssunto(String assunto) {
        this.assunto = assunto;
    }

    public String getConteudo() {
        return conteudo;
    }

    public void setConteudo(String conteudo) {
        this.conteudo = conteudo;
    }

    @Override
    public String toString() {
        return "NotificationDTO{" +
                "tipo='" + tipo + '\'' +
                ", email='" + email + '\'' +
                ", telefone='" + telefone + '\'' +
                ", assunto='" + assunto + '\'' +
                ", conteudo='" + conteudo + '\'' +
                '}';
    }
}
