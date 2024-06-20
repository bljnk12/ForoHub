create table topicos(

                        id bigint not null auto_increment,
                        titulo varchar(100) not null,
                        mensaje varchar(100) not null,
                        fecha_creacion varchar(20) not null,
                        status boolean null,
                        usuario_id int null,
                        curso_id int null,
                        respuestas json  null,

                        primary key(id)

);