package com.gga.danmsusuario.model;

import java.util.List;
import java.util.Objects;

public class Cliente {
    private Integer id;
    private String razonSocial;
    private String cuit;
    private String mail;
    private Double maxCuentaCorriente;
    private Boolean habilitadoOnline;
    private List<Obra> obras;
    private Usuario usuario;


    @Override
    public String toString() {
        return "{" +
            " id='" + getId() + "'" +
            ", razonSocial='" + getRazonSocial() + "'" +
            ", cuit='" + getCuit() + "'" +
            ", mail='" + getMail() + "'" +
            ", maxCuentaCorriente='" + getMaxCuentaCorriente() + "'" +
            ", habilitadoOnline='" + isHabilitadoOnline() + "'" +
            ", obras='" + getObras() + "'" +
            ", usuario='" + getUsuario() + "'" +
            "}";
    }


    public Cliente() {
    }

    public Cliente(Integer id, String razonSocial, String cuit, String mail, Double maxCuentaCorriente, Boolean habilitadoOnline, List<Obra> obras, Usuario usuario) {
        this.id = id;
        this.razonSocial = razonSocial;
        this.cuit = cuit;
        this.mail = mail;
        this.maxCuentaCorriente = maxCuentaCorriente;
        this.habilitadoOnline = habilitadoOnline;
        this.obras = obras;
        this.usuario = usuario;
    }

    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getRazonSocial() {
        return this.razonSocial;
    }

    public void setRazonSocial(String razonSocial) {
        this.razonSocial = razonSocial;
    }

    public String getCuit() {
        return this.cuit;
    }

    public void setCuit(String cuit) {
        this.cuit = cuit;
    }

    public String getMail() {
        return this.mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public Double getMaxCuentaCorriente() {
        return this.maxCuentaCorriente;
    }

    public void setMaxCuentaCorriente(Double maxCuentaCorriente) {
        this.maxCuentaCorriente = maxCuentaCorriente;
    }

    public Boolean isHabilitadoOnline() {
        return this.habilitadoOnline;
    }

    public Boolean getHabilitadoOnline() {
        return this.habilitadoOnline;
    }

    public void setHabilitadoOnline(Boolean habilitadoOnline) {
        this.habilitadoOnline = habilitadoOnline;
    }

    public List<Obra> getObras() {
        return this.obras;
    }

    public void setObras(List<Obra> obras) {
        this.obras = obras;
    }

    public Usuario getUsuario() {
        return this.usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
    

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof Cliente)) {
            return false;
        }
        Cliente cliente = (Cliente) o;
        return Objects.equals(id, cliente.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }
    
}
