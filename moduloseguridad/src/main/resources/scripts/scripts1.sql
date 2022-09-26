/*Crear tabla*/
create table USUARIOS( id int,
							name varchar(255),
							lastname varchar(255),
							 username varchar(20),
							 pass varchar(100)
							 )

alter table USUARIOS add primary key (id)

alter table USUARIOS modify column id int auto_increment not null

/*Agregar registros*/
insert into USUARIOS (name,lastname,username,pass)
value('Gonzalo', 'Morales', 'Gnz', '123456');
insert into USUARIOS (name,lastname,username,pass)
value('Maria', 'Segura', 'Mari', '111');
insert into USUARIOS (name,lastname,username,pass)
value('Dante', 'Saenz', 'Dans5', '12345');

/*Sp*/
create procedure leerUsuarios()
begin
	select *from USUARIOS;
END

call leerUsuarios();
