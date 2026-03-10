package hub.forum.api.dto;

import hub.forum.api.model.Status;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record DadosAtualizacaoTopico(

        @NotNull
        Long id,

        String mensagem,

        String titulo,

        String nomeCurso,

        Status status) {
}
