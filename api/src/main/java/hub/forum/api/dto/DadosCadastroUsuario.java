package hub.forum.api.dto;

import jakarta.validation.constraints.NotNull;

public record DadosCadastroUsuario(

        String nome,


        String email,


        String senha) {
}
