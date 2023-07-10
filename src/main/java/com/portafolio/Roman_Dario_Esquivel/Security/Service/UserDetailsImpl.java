package com.portafolio.Roman_Dario_Esquivel.Security.Service;

import com.portafolio.Roman_Dario_Esquivel.Security.Entity.UsuarioPrincipal;
import com.portafolio.Roman_Dario_Esquivel.Security.Entity.usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserDetailsImpl implements UserDetailsService{
  @Autowired
    UsuarioService usuarioService;  
  @Override
    public UserDetails loadUserByUsername(String nombreUsuario) throws UsernameNotFoundException {
        usuario usuario = usuarioService.getByNombreUsuario(nombreUsuario).get();
        return UsuarioPrincipal.build(usuario);
    }
}
