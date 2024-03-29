package com.portafolio.Roman_Dario_Esquivel.Security.Controller;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseAuthException;
import com.google.firebase.auth.UserRecord;
import com.portafolio.Roman_Dario_Esquivel.Security.Dto.JwtDto;
import com.portafolio.Roman_Dario_Esquivel.Security.Dto.LoginUsuario;
import com.portafolio.Roman_Dario_Esquivel.Security.Dto.NuevoUsuario;
import com.portafolio.Roman_Dario_Esquivel.Security.Entity.Rol;
import com.portafolio.Roman_Dario_Esquivel.Security.Entity.usuario;
import com.portafolio.Roman_Dario_Esquivel.Security.Enums.RolNombre;
import com.portafolio.Roman_Dario_Esquivel.Security.Jwt.JwtProvider;
import com.portafolio.Roman_Dario_Esquivel.Security.Service.RolService;
import com.portafolio.Roman_Dario_Esquivel.Security.Service.UsuarioService;

import java.util.HashSet;
import java.util.Set;
import javax.validation.Valid;
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
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
@CrossOrigin(origins = {"https://romandarioesquivel-9162f.web.app/", "https://romandarioesquivel-9162f.firebaseapp.com/", "http://localhost:4200"})
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

    @PostMapping("/nuevoUsuario")
    public ResponseEntity<?> nuevoUsuario(@Valid @RequestBody NuevoUsuario nuevoUsuario,
            BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return new ResponseEntity(new Mensaje("Campos mal puestos o email invalido"), HttpStatus.BAD_REQUEST);
        }

        if (usuarioService.existsByNombreUsuario(nuevoUsuario.getNombreUsuario())) {
            return new ResponseEntity(new Mensaje("Ese nombre de usuario ya existe"), HttpStatus.BAD_REQUEST);
        }

        if (usuarioService.existsByEmail(nuevoUsuario.getEmail())) {
            return new ResponseEntity(new Mensaje("Ese email ya existe"), HttpStatus.BAD_REQUEST);
        }

        FirebaseAuth auth = FirebaseAuth.getInstance();
        String uid = "";
        String email = nuevoUsuario.getEmail();
        String password = nuevoUsuario.getPassword();
        try {
            UserRecord.CreateRequest request = new UserRecord.CreateRequest()
                    .setEmail(email)
                    .setPassword(password);
            UserRecord userRecord = FirebaseAuth.getInstance().createUser(request);
            uid = userRecord.getUid();
            System.out.println("UID: " + uid);
        } catch (FirebaseAuthException e) {
            System.out.println("Error creating user: " + e.getMessage());
        }

        usuario usuario = new usuario(nuevoUsuario.getNombre(), nuevoUsuario.getNombreUsuario(),
                nuevoUsuario.getEmail(), passwordEncoder.encode(nuevoUsuario.getPassword()), uid);

        Set<Rol> roles = new HashSet<>();
        roles.add(rolService.getByRolNombre(RolNombre.ROLE_USER).get());

        if (nuevoUsuario.getRoles().contains("admin")) {
            roles.add(rolService.getByRolNombre(RolNombre.ROLE_ADMIN).get());
        }
        usuario.setRoles(roles);
        usuarioService.save(usuario);

        return new ResponseEntity(new Mensaje("Usuario guardado"), HttpStatus.CREATED);
    }

    @PostMapping("/login")
    public ResponseEntity<JwtDto> login(@Valid @RequestBody LoginUsuario loginUsuario, BindingResult bindingResult) throws FirebaseAuthException {
        if (bindingResult.hasErrors()) {
            return new ResponseEntity(new Mensaje("Campos mal puestos"), HttpStatus.BAD_REQUEST);
        }

        Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(
                loginUsuario.getNombreUsuario(), loginUsuario.getPassword()));

        SecurityContextHolder.getContext().setAuthentication(authentication);

        String jwt = jwtProvider.generateToken(authentication);

        UserDetails userDetails = (UserDetails) authentication.getPrincipal();

        JwtDto jwtDto = new JwtDto(jwt, userDetails.getUsername(), userDetails.getAuthorities());

        return new ResponseEntity(jwtDto, HttpStatus.OK);
    }

}
