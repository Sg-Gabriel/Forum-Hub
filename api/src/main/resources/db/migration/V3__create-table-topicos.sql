CREATE TABLE topicos (
    id BIGINT NOT NULL AUTO_INCREMENT,
    titulo VARCHAR(255) NOT NULL,
    mensagem VARCHAR(500) NOT NULL,
    data DATETIME NOT NULL,
    status VARCHAR(50) NOT NULL,
    usuario_id BIGINT NOT NULL,
    curso_id BIGINT NOT NULL,

    PRIMARY KEY (id),

    CONSTRAINT fk_topico_usuario FOREIGN KEY (usuario_id) REFERENCES usuarios(id),

    CONSTRAINT fk_topico_curso FOREIGN KEY (curso_id) REFERENCES cursos(id),

    CONSTRAINT uk_topico_titulo_mensagem UNIQUE (titulo, mensagem)
);