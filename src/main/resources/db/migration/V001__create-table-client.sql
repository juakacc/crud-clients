CREATE TABLE IF NOT EXISTS client (
	id BIGINT AUTO_INCREMENT,
	nome varchar(255) NOT NULL,
	cpf varchar(11) NOT NULL UNIQUE,
	data_nascimento DATE NOT NULL,
	PRIMARY KEY(id)
);