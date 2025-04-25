package com.nofifyHub.sms_api.dtos;


public class NotificationDTO {
    private String tipo;
    private String telefone;
    private String conteudo;

    public NotificationDTO() {}

    public NotificationDTO(String tipo, String telefone, String conteudo) {
        this.tipo = tipo;
        this.telefone = telefone;
        this.conteudo = conteudo;
    }

    public String getTipo() { return tipo; }
    public void setTipo(String tipo) { this.tipo = tipo; }

    public String getTelefone() { return telefone; }
    public void setTelefone(String telefone) { this.telefone = telefone; }

    public String getConteudo() { return conteudo; }
    public void setConteudo(String conteudo) { this.conteudo = conteudo; }
}