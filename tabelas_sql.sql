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
    recipiente_id BIGINT,
    excluido BOOLEAN,
    FOREIGN KEY (recipiente_id) REFERENCES Recipiente(id)

)engine=innodb;

CREATE TABLE Sorvete_adicional(

    id BIGINT PRIMARY KEY AUTO_INCREMENT,
    sorvete_id BIGINT,
    adicional_id BIGINT,
    quantidade BIGINT,
    UNIQUE (sorvete_id,adicional_id),
    excluido BOOLEAN,
    FOREIGN KEY (sorvete_id) REFERENCES Sorvete(id),
    FOREIGN KEY (adicional_id) REFERENCES Adicional(id)
	
)engine=innodb;

/*relação sorvete com bolas de diferentes sabores*/
CREATE TABLE Sorvete_bolas(

    id BIGINT PRIMARY KEY AUTO_INCREMENT,
    sorvete_id BIGINT,
    bolas_id BIGINT,
    quantidade BIGINT,
    UNIQUE (sorvete_id,bolas_id),
    excluido BOOLEAN,
    FOREIGN KEY (sorvete_id) REFERENCES Sorvete(id),
    FOREIGN KEY (bolas_id) REFERENCES Sabor(id)

)engine=innodb;

CREATE TABLE Milkshake(

    id BIGINT PRIMARY KEY AUTO_INCREMENT,
    tamanho_id BIGINT,
    excluido BOOLEAN,
    FOREIGN KEY (tamanho_id) REFERENCES Tamanho(id)

)engine=innodb;

CREATE TABLE Milkshake_bolas(

    id BIGINT PRIMARY KEY AUTO_INCREMENT,
    milkshake_id BIGINT,
    bolas_id BIGINT,
    quantidade BIGINT,
    UNIQUE (milkshake_id,bolas_id),
    excluido BOOLEAN,
    FOREIGN KEY (milkshake_id) REFERENCES Milkshake(id),
    FOREIGN KEY (bolas_id) REFERENCES Sabor(id) 	
	
)engine=innodb;

CREATE TABLE Picole(

    id BIGINT PRIMARY KEY AUTO_INCREMENT,
    tipo ENUM('NATURAL','ESPECIAL'),
    sabor_id BIGINT,
    excluido BOOLEAN,
    FOREIGN KEY (sabor_id) REFERENCES Sabor(id)	

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
    pedido_id BIGINT,
    endereco VARCHAR(100),
    frete DOUBLE,
    excluido BOOLEAN,
    FOREIGN KEY (pedido_id) REFERENCES Pedido(id)	

)engine=innodb;

CREATE TABLE Pedido_fisico(
	 
    id BIGINT PRIMARY KEY AUTO_INCREMENT,
    pedido_id BIGINT,
    gorjeta DOUBLE,
    FOREIGN KEY (pedido_id) REFERENCES Pedido(id)	

)engine=innodb;

CREATE TABLE Pedido_sorvete(

    id BIGINT PRIMARY KEY AUTO_INCREMENT,
    pedido_id BIGINT,
    sorvete_id BIGINT,
    quantidade BIGINT,
    UNIQUE (pedido_id,sorvete_id),
    excluido BOOLEAN,
    FOREIGN KEY (sorvete_id) REFERENCES Sorvete(id),
    FOREIGN KEY (pedido_id) REFERENCES Pedido(id)

)engine=innodb;

CREATE TABLE Pedido_milkshake(

    id BIGINT PRIMARY KEY AUTO_INCREMENT,
    pedido_id BIGINT,
    milkshake_id BIGINT,
    quantidade BIGINT,
    UNIQUE (pedido_id,milkshake_id),
    excluido BOOLEAN, 
    FOREIGN KEY (pedido_id) REFERENCES Pedido(id),
    FOREIGN KEY (milkshake_id) REFERENCES Milkshake(id)
	
)engine=innodb;

CREATE TABLE Pedido_picole(

    id BIGINT PRIMARY KEY AUTO_INCREMENT,
    pedido_id BIGINT,
    picole_id BIGINT,
    quantidade BIGINT,
    UNIQUE (pedido_id,picole_id),
    excluido BOOLEAN,
    FOREIGN KEY (pedido_id) REFERENCES Pedido(id),
    FOREIGN KEY (picole_id) REFERENCES Picole(id)
    
	

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
    garcom_id BIGINT,
    pedido_id BIGINT,
    excluido BOOLEAN,
    FOREIGN KEY (garcom_id) REFERENCES Garcom(id),
    FOREIGN KEY (pedido_id) REFERENCES Pedido(id)

)engine=innodb;

CREATE TABLE Entregador_pedido(

    id BIGINT PRIMARY KEY AUTO_INCREMENT,
    entregador_id BIGINT,
    pedido_id BIGINT REFERENCES Pedido(id),
    excluido BOOLEAN,
    FOREIGN KEY (entregador_id) REFERENCES Entregador(id),
    FOREIGN KEY (pedido_id) REFERENCES Pedido(id)

)engine=innodb;
