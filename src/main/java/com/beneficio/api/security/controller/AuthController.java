package com.beneficio.api.security.controller;

import com.beneficio.api.dto.Mensaje;
import com.beneficio.api.entity.RandomCharGenerator;
import com.beneficio.api.security.dto.JwtDto;
import com.beneficio.api.security.dto.LoginUsuario;
import com.beneficio.api.security.dto.NuevoUsuario;
import com.beneficio.api.security.entity.Rol;
import com.beneficio.api.security.entity.Usuario;
import com.beneficio.api.security.enums.RolNombre;
import com.beneficio.api.security.jwt.JwtProvider;
import com.beneficio.api.security.service.RolService;
import com.beneficio.api.security.service.UsuarioService;
import com.beneficio.api.validaciones.Validar;
import java.util.HashMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashSet;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.springframework.security.access.prepost.PreAuthorize;

@RestController
@RequestMapping("/auth")
@CrossOrigin(origins = "*")
public class AuthController {

    @Autowired
    PasswordEncoder passwordEncoder;

    @Autowired
    AuthenticationManager authenticationManager;

    @Autowired
    UsuarioService usuarioService;

    @Autowired
    RolService rolService;

    @Autowired
    JwtProvider jwtProvider;

    @PreAuthorize("hasRole('ROLE_BENEFICIO')")
    @PostMapping("/nuevo")
    public ResponseEntity<?> nuevo(@Valid @RequestBody NuevoUsuario nuevoUsuario, BindingResult bindingResult){
        
        RandomCharGenerator generar = new RandomCharGenerator();
        
        String usuarioG = generar.generateUsuario(); 
        String contrasenia = generar.generateRandomPassword(10);
        
        Map<String, Object> response = new HashMap<>();
        
        // Patrón para validar el email
        Pattern pattern = Pattern.compile("^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@" + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$");
        Matcher mather = pattern.matcher(nuevoUsuario.getEmail());
        
        
        if(Long.toString(nuevoUsuario.getDpi()).length()<13 || Long.toString(nuevoUsuario.getDpi()).length()<13)
            return new ResponseEntity(new Mensaje("Formato de DPI es inválido"), HttpStatus.BAD_REQUEST);
        if(mather.find() == false)
            return new ResponseEntity(new Mensaje("Formato de email es inválido"), HttpStatus.BAD_REQUEST);
        if(usuarioService.existsByDpi(nuevoUsuario.getDpi()))
            return new ResponseEntity(new Mensaje("Dpi ya está registrado"), HttpStatus.BAD_REQUEST);
        if(usuarioService.existsByEmail(nuevoUsuario.getEmail()))
            return new ResponseEntity(new Mensaje("Email ya existe"), HttpStatus.BAD_REQUEST);
        if(Validar.isNumeric(nuevoUsuario.getTelefono()) == false)
            return new ResponseEntity(new Mensaje("Formato de telefono es inválido"), HttpStatus.BAD_REQUEST);
        if(bindingResult.hasErrors())
            return new ResponseEntity(new Mensaje("Campos Inválidos, revise todos los datos"), HttpStatus.BAD_REQUEST);
        
        Usuario usuario = new Usuario(nuevoUsuario.getDpi(), nuevoUsuario.getNombre(), nuevoUsuario.getApellido(), nuevoUsuario.getDireccion(), nuevoUsuario.getEmail(), nuevoUsuario.getTelefono(), usuarioG,
                        passwordEncoder.encode(contrasenia));
        Set<Rol> roles = new HashSet<>();
        roles.add(rolService.getByRolNombre(RolNombre.ROLE_PRODUCTOR).get());
        if(nuevoUsuario.getRoles().contains("beneficio"))
            roles.add(rolService.getByRolNombre(RolNombre.ROLE_BENEFICIO).get());
        if(nuevoUsuario.getRoles().contains("pesoCabal"))
            roles.add(rolService.getByRolNombre(RolNombre.ROLE_PESO_CABAL).get());
        usuario.setRoles(roles);
        usuarioService.save(usuario);
        
        response.put("mensaje","Usuario guardado.");
        response.put("usuario", usuarioG);
        response.put("contraseña", contrasenia);
        return new ResponseEntity<Map<String, Object>>(response, HttpStatus.CREATED);
        //return new ResponseEntity(new Mensaje("usuario guardado. La contraseña es: ".concat(contrasenia).concat(" y el usuario es: ".concat(Long.toString(nuevoUsuario.getDpi())))), HttpStatus.CREATED);
    }

    @PostMapping("/login")
    public ResponseEntity<JwtDto> login(@Valid @RequestBody LoginUsuario loginUsuario, BindingResult bindingResult){
        if(bindingResult.hasErrors())
            return new ResponseEntity(new Mensaje("campos mal puestos"), HttpStatus.BAD_REQUEST);
        Authentication authentication =
                authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(loginUsuario.getNombreUsuario(), loginUsuario.getPassword()));
        SecurityContextHolder.getContext().setAuthentication(authentication);
        String jwt = jwtProvider.generateToken(authentication);
        UserDetails userDetails = (UserDetails)authentication.getPrincipal();
        Optional<Usuario> usuario = usuarioService.getByNombreUsuario(userDetails.getUsername());
        JwtDto jwtDto = new JwtDto(jwt, userDetails.getUsername(), usuario, userDetails.getAuthorities());
        return new ResponseEntity(jwtDto, HttpStatus.OK);
    }
}
