CREATE TABLE usuario(
	id_usuario serial primary key,
	nome_usuario text not null,
	email_usuario varchar(45) not null,
	senha_usuario text not null,
	CONSTRAINT email_usuario_unique UNIQUE (email_usuario)
);

CREATE TABLE professor(
	id_professor serial primary key,
	nome_professor text not null
);

CREATE TABLE orientacao(
	id_orientacao serial primary key,
	descricao_orientacao text not null,
	orientado_orientacao text not null,
	id_professor_orientacao int not null,
	CONSTRAINT fkProfessorOrientacao FOREIGN KEY (id_professor_orientacao) REFERENCES professor (id_professor)
)