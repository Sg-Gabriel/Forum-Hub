package hub.forum.api.controller;

import hub.forum.api.dto.DadosAtualizacaoTopico;
import hub.forum.api.dto.DadosCadastroTopico;
import hub.forum.api.dto.DadosDetalhesTopico;
import hub.forum.api.infra.exception.ValidacaoException;
import hub.forum.api.model.Curso;
import hub.forum.api.model.Topico;
import hub.forum.api.model.Usuario;
import hub.forum.api.repository.CursoRepository;
import hub.forum.api.repository.TopicoRepository;
import hub.forum.api.repository.UsuarioRepository;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

@RequestMapping("topicos")
@RestController
public class TopicoController {

    @Autowired
    private TopicoRepository topicoRepository;

    @Autowired
    private CursoRepository cursoRepository;

    @Autowired
    private UsuarioRepository usuarioRepository;


    @PostMapping
    @Transactional
    public ResponseEntity cadastrar(@RequestBody @Valid DadosCadastroTopico dados, @AuthenticationPrincipal Usuario usuario, UriComponentsBuilder uriBuilder){

        Curso curso = cursoRepository.findByNome(dados.nomeCurso())
                .orElseGet(() -> {
                    Curso novoCurso = new Curso(dados.nomeCurso());
                    return cursoRepository.save(novoCurso);
                });


        var topico = new Topico(dados.titulo(), dados.mensagem(), usuario, curso
        );

        var uri = uriBuilder.path("/topicos/{id}").buildAndExpand(topico.getId()).toUri();

        if (topicoRepository.existsByTituloAndMensagem(dados.titulo(), dados.mensagem())) {
            return ResponseEntity.badRequest().body("Tópico já cadastrado");
        }
        topicoRepository.save(topico);

        return ResponseEntity.created(uri).body(new DadosDetalhesTopico(topico));
    }

    @GetMapping
    public ResponseEntity<Page<DadosDetalhesTopico>> listar(@PageableDefault(size = 10)Pageable pageable){
        var page = topicoRepository.findAllByDeletadoFalse(pageable)
                .map(DadosDetalhesTopico::new);
        return ResponseEntity.ok().body(page);
    }

    @GetMapping("/{id}")
    public ResponseEntity detalhar(@PathVariable Long id){
        var topico = topicoRepository.getReferenceById(id);
        return ResponseEntity.ok().body(new DadosDetalhesTopico(topico));

    }

    @PutMapping
    @Transactional
    public ResponseEntity atualizar(@RequestBody @Valid DadosAtualizacaoTopico dados){
        var topico = topicoRepository.getReferenceById(dados.id());
        Curso curso = cursoRepository.findByNome(dados.nomeCurso())
                .orElseThrow(() -> new RuntimeException("Curso não encontrado"));
        topico.atualizarInformacaoes(dados, curso);
        return ResponseEntity.ok().body(new DadosDetalhesTopico(topico));
    }

    @DeleteMapping("{id}")
    @Transactional
    public ResponseEntity excluir(@PathVariable Long id){
        var topico = topicoRepository.getReferenceById(id);
        if (topico.isDeletado()){
            throw new RuntimeException("Tópico não encontrado no banco de dados");
        }
        topico.excluir();
        return ResponseEntity.noContent().build();
    }

}
