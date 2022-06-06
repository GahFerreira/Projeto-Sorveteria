CREATE TABLE Recipiente(

    id BIGINT PRIMARY KEY AUTO_INCREMENT,
    nome VARCHAR(100),
    preco DOUBLE,
    excluido BOOLEAN

)engine=innodb;

CREATE TABLE Adicional(

    id BIGINT PRIMARY KEY AUTO_INCREMENT,
    nome VARCHAR(100),
    preco DOUBLE,
    excluido BOOLEAN

)engine=innodb;

CREATE TABLE Sabor(

    id BIGINT PRIMARY KEY AUTO_INCREMENT,
    nome VARCHAR(100),
    categoria ENUM('PICOLE','PRODUTO_COMPOSTO'),
    preco DOUBLE,
    excluido BOOLEAN

)engine=innodb;

CREATE TABLE Tamanho(

    id BIGINT PRIMARY KEY AUTO_INCREMENT,
    mililitros BIGINT,
    preco DOUBLE,
    excluido BOOLEAN

)engine=innodb;




CREATE TABLE Sorvete(

    id BIGINT PRIMARY KEY AUTO_INCREMENT,
    recipiente_id BIGINT REFERENCES Recipiente(id),
    excluido BOOLEAN

)engine=innodb;

CREATE TABLE Sorvete_adicional(

    id BIGINT PRIMARY KEY AUTO_INCREMENT,
    sorvete_id BIGINT REFERENCES Sorvete(id),
    adicional_id BIGINT REFERENCES Adicional(id),
    quantidade BIGINT,
    UNIQUE (sorvete_id,adicional_id),
    excluido BOOLEAN

)engine=innodb;

/*relação sorvete com bolas de diferentes sabores*/
CREATE TABLE Sorvete_bolas(

    id BIGINT PRIMARY KEY AUTO_INCREMENT,
    sorvete_id BIGINT REFERENCES Sorvete(id),
    bolas_id BIGINT REFERENCES Sabor(id),
    quantidade BIGINT,
    UNIQUE (sorvete_id,bolas_id),
    excluido BOOLEAN

)engine=innodb;

CREATE TABLE Milkshake(

    id BIGINT PRIMARY KEY AUTO_INCREMENT,
    tamanho_id BIGINT REFERENCES Tamanho(id),
    excluido BOOLEAN

)engine=innodb;

CREATE TABLE Milkshake_bolas(

    id BIGINT PRIMARY KEY AUTO_INCREMENT,
    milkshake_id BIGINT REFERENCES Milkshake(id),
    bolas_id BIGINT REFERENCES Sabor(id),
    quantidade BIGINT,
    UNIQUE (milkshake_id,bolas_id),
    excluido BOOLEAN

)engine=innodb;

CREATE TABLE Picole(

    id BIGINT PRIMARY KEY AUTO_INCREMENT,
    tipo ENUM('NATURAL','ESPECIAL'),
    sabor_id BIGINT REFERENCES Sabor(id),
    excluido BOOLEAN

)engine=innodb;

CREATE TABLE Pedido(

    id BIGINT PRIMARY KEY AUTO_INCREMENT,
    data_ DATETIME,
    cliente VARCHAR(100),
    forma_de_pagamento VARCHAR(100),
    preco_total DOUBLE,
    excluido BOOLEAN

)engine=innodb;

CREATE TABLE Pedido_delivery(

    id BIGINT PRIMARY KEY AUTO_INCREMENT,
    pedido_id BIGINT REFERENCES Pedido(id),
    endereco VARCHAR(100),
    frete DOUBLE,
    excluido BOOLEAN

)engine=innodb;

CREATE TABLE Pedido_fisico(
	 
    id BIGINT PRIMARY KEY AUTO_INCREMENT,
    pedido_id BIGINT REFERENCES Pedido(id),
    gorjeta DOUBLE

)engine=innodb;

CREATE TABLE Pedido_sorvete(

    id BIGINT PRIMARY KEY AUTO_INCREMENT,
    pedido_id BIGINT REFERENCES Pedido(id),
    sorvete_id BIGINT REFERENCES Sorvete(id),
    quantidade BIGINT,
    UNIQUE (pedido_id,sorvete_id),
    excluido BOOLEAN

)engine=innodb;

CREATE TABLE Pedido_milkshake(

    id BIGINT PRIMARY KEY AUTO_INCREMENT,
    pedido_id BIGINT REFERENCES Pedido(id),
    milkshake_id BIGINT REFERENCES Milkshake(id),
    quantidade BIGINT,
    UNIQUE (pedido_id,milkshake_id),
    excluido BOOLEAN

)engine=innodb;

CREATE TABLE Pedido_picole(

    id BIGINT PRIMARY KEY AUTO_INCREMENT,
    pedido_id BIGINT REFERENCES Pedido(id),
    picole_id BIGINT REFERENCES Picole(id),
    quantidade BIGINT,
    UNIQUE (pedido_id,picole_id),
    excluido BOOLEAN

)engine=innodb;

CREATE TABLE Garcom(

    id BIGINT PRIMARY KEY AUTO_INCREMENT,
    nome VARCHAR(100),
    nascimento DATE,
    cpf VARCHAR(100),
    telefone BIGINT,
    salario DOUBLE,
    excluido BOOLEAN

)engine=innodb;

CREATE TABLE Entregador(

    id BIGINT PRIMARY KEY AUTO_INCREMENT,
    nome VARCHAR(100),
    nascimento DATE,
    cpf VARCHAR(100),
    telefone BIGINT,
    salario DOUBLE,
    excluido BOOLEAN

)engine=innodb;

CREATE TABLE Gerente(

    id BIGINT PRIMARY KEY AUTO_INCREMENT,
    nome VARCHAR(100),
    nascimento DATE,
    cpf VARCHAR(100),
    telefone BIGINT,
    salario DOUBLE,
    excluido BOOLEAN

)engine=innodb;

CREATE TABLE Garcom_pedido(

    id BIGINT PRIMARY KEY AUTO_INCREMENT,
    garcom_id BIGINT REFERENCES Garcom(id),
    pedido_id BIGINT REFERENCES Pedido(id),
    excluido BOOLEAN

)engine=innodb;

CREATE TABLE Entregador_pedido(

    id BIGINT PRIMARY KEY AUTO_INCREMENT,
    entregador_id BIGINT REFERENCES Entregador(id),
    pedido_id BIGINT REFERENCES Pedido(id),
    excluido BOOLEAN

)engine=innodb;
