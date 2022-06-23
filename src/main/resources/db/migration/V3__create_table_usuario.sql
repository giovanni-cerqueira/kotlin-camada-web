
create table if not exists usuario(
    id bigint not null,
    nome varchar (50),
    email varchar (50),
    primary key (id)
);