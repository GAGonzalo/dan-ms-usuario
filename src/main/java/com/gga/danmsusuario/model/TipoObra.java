package com.gga.danmsusuario.model;

import java.util.Objects;

public class TipoObra {
    private Integer id;
    private String descripcion;

    public TipoObra() {
    }

    public TipoObra(Integer id, String descripcion) {
        this.id = id;
        this.descripcion = descripcion;
    }

    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDescripcion() {
        return this.descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof TipoObra)) {
            return false;
        }
        TipoObra tipoObra = (TipoObra) o;
        return Objects.equals(id, tipoObra.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }

}
