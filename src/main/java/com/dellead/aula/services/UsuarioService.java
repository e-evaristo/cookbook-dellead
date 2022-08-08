package com.dellead.aula.services;

import com.dellead.aula.DTO.UsuarioCreateDTO;
import com.dellead.aula.models.Usuario;
import com.dellead.aula.repository.UsuarioRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.Optional;

@Service
public class UsuarioService {

    private final UsuarioRepository repository;

    public UsuarioService(UsuarioRepository repository) {
        this.repository = repository;
    }

    @Transactional(readOnly = false)
    public Usuario register(UsuarioCreateDTO dto) {
        Usuario usuario = new Usuario();
        usuario.setNome(dto.getNome());
        usuario.setEmail(dto.getEmail());
        usuario.setSenha(dto.getSenha());
        //usuario.setSenha(new BCryptPasswordEncoder().encode(dto.getSenha()));
        LocalDate dataNascimento = LocalDate.of(
                Integer.parseInt(dto.getDtnasc_ano()),
                Integer.parseInt(dto.getDtnasc_mes()),
                Integer.parseInt(dto.getDtnasc_dia())
        );
        usuario.setDataNascimento(dataNascimento);
        usuario.setSexo(dto.getSexo());
        return repository.save(usuario);
    }

    @Transactional(readOnly = true)
    public Optional<Usuario> findByEmail(String email) {
        return repository.findByEmail(email);
    }
}
