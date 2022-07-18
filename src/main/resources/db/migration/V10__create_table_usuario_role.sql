create table if not exists usuario_role(
    id bigint auto_increment,
    usuario_id bigint not null,
    role_id bigint not null,
    primary key (id),
    foreign key (usuario_id) references usuario(id),
    foreign key (role_id) references role(id)
);

insert into usuario_role (id, usuario_id, role_id) values (1, 1, 1);