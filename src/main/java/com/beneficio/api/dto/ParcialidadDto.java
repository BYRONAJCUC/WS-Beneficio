/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.beneficio.api.dto;

import com.beneficio.api.entity.Cuenta;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 *
 * @author BYRON
 */

public class ParcialidadDto {
        
    private Cuenta cuenta;
    
    private int noParcialidad;
    
    private Double pesoTotal;
    
    private Date fechaRecibido;
    
     private String usuarioCreacion;
    
    private Date fechaCreacion;
    
    private String usuarioModificacion;
    
    private Date fechaModificacion;
    
    private Boolean estado;

    public ParcialidadDto() {
    }

    public ParcialidadDto(Cuenta id) {
        this.cuenta = id;
    }

    public ParcialidadDto(Cuenta cuenta, int noParcialidad, Double pesoTotal, Date fechaRecibido, String usuarioCreacion) {
        this.cuenta = cuenta;
        this.noParcialidad = noParcialidad;
        this.pesoTotal = pesoTotal;
        this.fechaRecibido = fechaRecibido;
        this.usuarioCreacion = usuarioCreacion;
    }

    public Cuenta getCuenta() {
        return cuenta;
    }

    public void setCuenta(Cuenta cuenta) {
        this.cuenta = cuenta;
    }

    public int getNoParcialidad() {
        return noParcialidad;
    }

    public void setNoParcialidad(int noParcialidad) {
        this.noParcialidad = noParcialidad;
    }

    public Double getPesoTotal() {
        return pesoTotal;
    }

    public void setPesoTotal(Double pesoTotal) {
        this.pesoTotal = pesoTotal;
    }

    public Date getFechaRecibido() {
        return fechaRecibido;
    }

    public void setFechaRecibido(Date fechaRecibido) {
        this.fechaRecibido = fechaRecibido;
    }

    public String getUsuarioCreacion() {
        return usuarioCreacion;
    }

    public void setUsuarioCreacion(String usuarioCreacion) {
        this.usuarioCreacion = usuarioCreacion;
    }

    public Date getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(Date fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    public String getUsuarioModificacion() {
        return usuarioModificacion;
    }

    public void setUsuarioModificacion(String usuarioModificacion) {
        this.usuarioModificacion = usuarioModificacion;
    }

    public Date getFechaModificacion() {
        return fechaModificacion;
    }

    public void setFechaModificacion(Date fechaModificacion) {
        this.fechaModificacion = fechaModificacion;
    }

    public Boolean getEstado() {
        return estado;
    }

    public void setEstado(Boolean estado) {
        this.estado = estado;
    }

}
