/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.beneficio.api.entity;

import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import javax.validation.constraints.NotNull;

/**
 *
 * @author BYRON
 */

@Entity
public class Piloto {
    
    @Id
    //@GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long licencia;
    
    @NotNull
    private String nombre;
    
    @NotNull
    private String apellido;
    
    private String telefono;
    
    private String correo;
    
    private String usuarioCreacion;
    
    private Date fechaCreacion;
    
    private String usuarioModificacion;
    
    private Date fechaModificacion;
    
    private Boolean estado;
    
    @PrePersist
    public void prePersist() {
        this.fechaCreacion = new Date();
        this.estado = true;
    }

    public Piloto() {
    }

    public Piloto(Long licencia) {
        this.licencia = licencia;
    }

    public Piloto(String usuarioCreacion) {
        this.usuarioCreacion = usuarioCreacion;
    }

    public Piloto(Long licencia, String nombre, String apellido, String telefono, String correo, String usuarioCreacion) {
        this.licencia = licencia;
        this.nombre = nombre;
        this.apellido = apellido;
        this.telefono = telefono;
        this.correo = correo;
        this.usuarioCreacion = usuarioCreacion;
    }

    public Long getLicencia() {
        return licencia;
    }

    public void setLicencia(Long licencia) {
        this.licencia = licencia;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
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
