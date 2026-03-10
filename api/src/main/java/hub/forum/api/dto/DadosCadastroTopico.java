package hub.forum.api.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record DadosCadastroTopico(@NotBlank
                                  String mensagem,

                                  @NotBlank
                                  String titulo,

                                  String categoriaCurso,

                                  @NotNull
                                  String nomeCurso) {
}
