alter table topicos add deletado tinyint;
update topicos set deletado = 0;