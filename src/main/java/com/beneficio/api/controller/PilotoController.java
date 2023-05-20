/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.beneficio.api.controller;

import com.beneficio.api.dto.Mensaje;
import com.beneficio.api.dto.PilotoDto;
import com.beneficio.api.entity.Piloto;
import com.beneficio.api.service.PilotoService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author BYRON
 */

@RestController
@RequestMapping("/piloto")
@CrossOrigin(origins = "*")
public class PilotoController {
    
    @Autowired
    PilotoService pilotoService;
    
    @GetMapping("/lista")
    public ResponseEntity<List<Piloto>> list(){
        List<Piloto> list = pilotoService.list();
        return new ResponseEntity(list, HttpStatus.OK);
    }
    
    @GetMapping("/id/{id}")
    public ResponseEntity<Piloto> getById(@PathVariable("id") Long id){
        if(!pilotoService.existsById(id))
            return new ResponseEntity(new Mensaje("no existe"), HttpStatus.NOT_FOUND);
        Piloto piloto = pilotoService.getOne(id).get();
        return new ResponseEntity(piloto, HttpStatus.OK);
    }
    
    //@PreAuthorize("hasRole('ROLE_PRODUCTOR')")
    @PostMapping("/registrar")
    public ResponseEntity<?> create(@RequestBody PilotoDto pilotoDto){
//        if(productorDtoparcialidadDto.getUsuario()==null)
//            return new ResponseEntity(new Mensaje("el id del productor es obligatorio"), HttpStatus.BAD_REQUEST);
//        if(parcialidadDto.getDpi()<0 || productorDto.getDpi()==null )
//            return new ResponseEntity(new Mensaje("el dpi debe ser mayor que 0"), HttpStatus.BAD_REQUEST);
//        if(productorService.existsByDpi(parcialidadDto.getDpi()))
//            return new ResponseEntity(new Mensaje("ese dpi ya existe"), HttpStatus.BAD_REQUEST);
        Piloto piloto = new Piloto(pilotoDto.getLicencia(), pilotoDto.getNombre(), pilotoDto.getApellido(), pilotoDto.getTelefono(), pilotoDto.getCorreo(), pilotoDto.getUsuarioCreacion());
        pilotoService.save(piloto);
        return new ResponseEntity(new Mensaje("Piloto Creado"), HttpStatus.OK);
    }
}
