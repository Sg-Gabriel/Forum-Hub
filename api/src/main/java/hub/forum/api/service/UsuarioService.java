package hub.forum.api.service;

import hub.forum.api.dto.DadosCadastroUsuario;
import hub.forum.api.model.Usuario;
import hub.forum.api.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UsuarioService {

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    UsuarioRepository repository;

    public Usuario cadastrar(DadosCadastroUsuario dados){

        String senha = passwordEncoder.encode(dados.senha());

        Usuario usuario = new Usuario(
                dados.nome(),
                dados.email(),
                senha
        );

        return repository.save(usuario);
    }
}

