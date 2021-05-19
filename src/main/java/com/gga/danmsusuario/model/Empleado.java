package com.gga.danmsusuario.model;

public class Empleado {
    private Integer id;
    private String mail;
    private Usuario usuario;

    public Empleado() {

    }

    public Empleado(Integer id, String mail, Usuario usuario) {
        this.id = id;
        this.mail = mail;
        this.usuario = usuario;
    }

    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getMail() {
        return this.mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public Usuario getUsuario() {
        return this.usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    @Override
    public String toString() {
        return "{" +
            " id='" + getId() + "'" +
            ", mail='" + getMail() + "'" +
            ", usuario='" + getUsuario() + "'" +
            "}";
    }

}
