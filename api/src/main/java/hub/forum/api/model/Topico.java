package hub.forum.api.model;

import hub.forum.api.dto.DadosAtualizacaoTopico;
import hub.forum.api.dto.DadosCadastroTopico;
import jakarta.persistence.*;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity(name = "Topico")
@Table(name = "topicos")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Topico {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String titulo;

    private String mensagem;

    private LocalDateTime data;

    private boolean deletado;

    @Enumerated(value = EnumType.STRING)
    private Status status;

    @ManyToOne
    @JoinColumn(name = "curso_id")
    private Curso curso;

    @ManyToOne
    @JoinColumn(name = "usuario_id")
    private Usuario usuario;

    public Topico(DadosCadastroTopico dados, Curso curso, Usuario usuario) {
        this.deletado = false;
        this.titulo = dados.titulo();
        this.mensagem = dados.mensagem();
        this.data = LocalDateTime.now();
        this.status = Status.ABERTO;
        this.curso = curso;
        this.usuario = usuario;
    }

    public Topico(@NotBlank String titulo, @NotBlank String mensagem, Usuario usuario, Curso curso) {
        this.deletado = false;
        this.titulo = titulo;
        this.mensagem = mensagem;
        this.data = LocalDateTime.now();
        this.status = Status.ABERTO;
        this.curso = curso;
        this.usuario = usuario;
    }


    public void atualizarInformacaoes(@Valid DadosAtualizacaoTopico dados, Curso curso) {
        if (dados.titulo()!=null){
            this.titulo = dados.titulo();
        }
        if (dados.mensagem()!=null){
            this.mensagem = dados.mensagem();
        }
        if (dados.nomeCurso()!=null){
            this.curso = curso;
        }

        if (dados.status()!=null){
            this.status = dados.status();
        }
    }

    public void excluir() {
        this.deletado = true;
    }
}
