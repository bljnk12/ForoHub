create table usuarios(

                           id_usuario bigint not null auto_increment,
                           nombre varchar(100)  null,
                           correo_electronico varchar(100) null,
                           contrasena varchar(20) null,
                           perfiles json  null,

                           primary key(id_usuario)

);