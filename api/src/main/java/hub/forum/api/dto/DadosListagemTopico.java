package hub.forum.api.dto;

import java.time.LocalDateTime;

public record DadosListagemTopico(String titulo, String mensagem, String curso, String usuario, String status, LocalDateTime data) {
}
