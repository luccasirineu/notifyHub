package com.notifyHub.email_api.dtos;

public class NotificationDTO {

    private String tipo;
    private String email;
    private String assunto;
    private String conteudo;

    public NotificationDTO() {
    }

    public NotificationDTO(String tipo, String email, String assunto, String conteudo) {
        this.tipo = tipo;
        this.email = email;
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
                ", assunto='" + assunto + '\'' +
                ", conteudo='" + conteudo + '\'' +
                '}';
    }
}
