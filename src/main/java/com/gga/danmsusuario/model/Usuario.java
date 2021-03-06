package com.gga.danmsusuario.model;

public class Usuario {
    private Integer id;
    private String user;
    private String password;


    public Usuario() {
    }

    public Usuario(Integer id, String user, String password) {
        this.id = id;
        this.user = user;
        this.password = password;
    }

    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUser() {
        return this.user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getPassword() {
        return this.password;
    }

    public void setPassword(String password) {
        this.password = password;
    }


    @Override
    public String toString() {
        return "{" +
            " id='" + getId() + "'" +
            ", user='" + getUser() + "'" +
            ", password='" + getPassword() + "'" +
            "}";
    }

  }
