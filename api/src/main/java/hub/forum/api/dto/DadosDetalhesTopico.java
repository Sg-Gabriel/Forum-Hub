package hub.forum.api.dto;

import hub.forum.api.model.Curso;
import hub.forum.api.model.Status;
import hub.forum.api.model.Topico;
import hub.forum.api.model.Usuario;

import java.time.LocalDateTime;

public record DadosDetalhesTopico(Long id, String titulo, String mensagem, String curso, String usuario, String status, LocalDateTime data) {
    public DadosDetalhesTopico(Topico topico){
        this(topico.getId(), topico.getTitulo(), topico.getMensagem(), topico.getCurso().getNome(), topico.getUsuario().getNome(), topico.getStatus().name(), topico.getData());
    }
}
