/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.beneficio.api.dto;

import com.beneficio.api.entity.Piloto;
import com.beneficio.api.entity.Transporte;
import com.beneficio.api.security.entity.Usuario;
import java.util.Date;

/**
 *
 * @author BYRON
 */
public class CuentaDto {
    
    private Usuario usuario;
    
    private Piloto piloto;
    
    private Transporte transporte;
    
    private Double pesoTotal;
    
    private int parcialidades;
    
    private int parcialidadesF;
    
    private Date fechaEntrega;
    
    private String usuarioCreacion;
    
    private Date fechaCreacion;
    
    private String usuarioModificacion;
    
    private Date fechaModificacion;
    
    private String estado;
    
    public CuentaDto() {
    }

    public CuentaDto(Usuario usuario) {
        this.usuario = usuario;
    }

    public CuentaDto(Usuario usuario, Piloto piloto, Transporte transporte, Double pesoTotal, int parcialidades, int parcialidadesF, Date fechaEntrega, String usuarioCreacion) {
        this.usuario = usuario;
        this.piloto = piloto;
        this.transporte = transporte;
        this.pesoTotal = pesoTotal;
        this.parcialidades = parcialidades;
        this.parcialidadesF = parcialidadesF;
        this.fechaEntrega = fechaEntrega;
        this.usuarioCreacion = usuarioCreacion;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Piloto getPiloto() {
        return piloto;
    }

    public void setPiloto(Piloto piloto) {
        this.piloto = piloto;
    }

    public Transporte getTransporte() {
        return transporte;
    }

    public void setTransporte(Transporte transporte) {
        this.transporte = transporte;
    }

    public Double getPesoTotal() {
        return pesoTotal;
    }

    public void setPesoTotal(Double pesoTotal) {
        this.pesoTotal = pesoTotal;
    }

    public int getParcialidades() {
        return parcialidades;
    }

    public void setParcialidades(int parcialidades) {
        this.parcialidades = parcialidades;
    }

    public int getParcialidadesF() {
        return parcialidadesF;
    }

    public void setParcialidadesF(int parcialidadesF) {
        this.parcialidadesF = parcialidadesF;
    }

    public Date getFechaEntrega() {
        return fechaEntrega;
    }

    public void setFechaEntrega(Date fechaEntrega) {
        this.fechaEntrega = fechaEntrega;
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

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
    
}
