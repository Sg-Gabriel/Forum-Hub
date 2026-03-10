package hub.forum.api.controller;


import hub.forum.api.dto.DadosCadastroUsuario;
import hub.forum.api.model.Usuario;
import hub.forum.api.repository.UsuarioRepository;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("usuarios")
@RestController
public class UsuarioController {

    @Autowired
    private UsuarioRepository repository;

    @Autowired
    private PasswordEncoder encoder;

    @PostMapping
    @Transactional
    public ResponseEntity cadastrar(@RequestBody @Valid DadosCadastroUsuario dados) {

        String senhaCriptografada = encoder.encode(dados.senha());

        Usuario usuario = new Usuario(
                dados.nome(),
                dados.email(),
                senhaCriptografada
        );
        if(repository.existsByEmail(dados.email())){
            throw new RuntimeException("Email já cadastrado");
        }

        repository.save(usuario);

        return ResponseEntity.status(HttpStatus.CREATED).build();
    }
}
