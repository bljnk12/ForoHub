create table respuestas(

                        id_respuesta bigint not null auto_increment,
                        mensaje_respuesta varchar(100) not null,
                        topico_id int null,
                        fecha_respuesta varchar(20) not null,
                        usuario_respuesta_id int null,
                        solucion boolean null,

                        primary key(id_respuesta)

);