/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.beneficio.api.controller;

import com.beneficio.api.dto.CuentaDto;
import com.beneficio.api.dto.Mensaje;
import com.beneficio.api.entity.Cuenta;
import com.beneficio.api.service.CuentaService;
import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author BYRON
 */

@RestController
@RequestMapping("/cuenta")
@CrossOrigin(origins = "*")
public class CuentaController {
    
    @Autowired
    CuentaService cuentaService;
    
    @GetMapping("/lista")
    public ResponseEntity<List<Cuenta>> list(){
        List<Cuenta> list = cuentaService.list();
        return new ResponseEntity(list, HttpStatus.OK);
    }
    
    @GetMapping("/id/{id}")
    public ResponseEntity<Cuenta> getById(@PathVariable("id") int id){
        if(!cuentaService.existsById(id))
            return new ResponseEntity(new Mensaje("no existe"), HttpStatus.NOT_FOUND);
        Cuenta cuenta = cuentaService.getOne(id).get();
        return new ResponseEntity(cuenta, HttpStatus.OK);
    }
    
    //@PreAuthorize("hasRole('ADMIN')")
    @PostMapping("/crear")
    public ResponseEntity<?> create(@RequestBody CuentaDto cuentaDto){
//        if(productorDtoparcialidadDto.getUsuario()==null)
//            return new ResponseEntity(new Mensaje("el id del productor es obligatorio"), HttpStatus.BAD_REQUEST);
//        if(parcialidadDto.getDpi()<0 || productorDto.getDpi()==null )
//            return new ResponseEntity(new Mensaje("el dpi debe ser mayor que 0"), HttpStatus.BAD_REQUEST);
//        if(productorService.existsByDpi(parcialidadDto.getDpi()))
//            return new ResponseEntity(new Mensaje("ese dpi ya existe"), HttpStatus.BAD_REQUEST);
        Cuenta cuenta = new Cuenta(cuentaDto.getUsuario(), cuentaDto.getPiloto(), cuentaDto.getTransporte(), cuentaDto.getPesoTotal(), cuentaDto.getParcialidades(), cuentaDto.getFechaEntrega(), cuentaDto.getUsuarioCreacion());
        cuentaService.save(cuenta);
        return new ResponseEntity(new Mensaje("Cuenta Creada"), HttpStatus.OK);
    }
    
    @PutMapping("/actualizar/{id}")
    public ResponseEntity<?> update(@PathVariable("id")int id, @RequestBody CuentaDto cuentaDto){
        if(!cuentaService.existsById(id))
            return new ResponseEntity(new Mensaje("no existe"), HttpStatus.NOT_FOUND);

        Cuenta cuenta = cuentaService.getOne(id).get();
        cuenta.setUsuario(cuentaDto.getUsuario());
        cuenta.setPiloto(cuentaDto.getPiloto());
        cuenta.setTransporte(cuentaDto.getTransporte());
        cuenta.setPesoTotal(cuentaDto.getPesoTotal());
        cuenta.setParcialidades(cuentaDto.getParcialidades());
        cuenta.setParcialidadesF(cuentaDto.getParcialidadesF());
        cuenta.setUsuarioModificacion(cuentaDto.getUsuarioModificacion());
        cuenta.setFechaModificacion(new Date());
        cuenta.setEstado(cuentaDto.getEstado());
        
        cuentaService.save(cuenta);
        return new ResponseEntity(new Mensaje("Cuenta actualizada"), HttpStatus.OK);
    }
}
