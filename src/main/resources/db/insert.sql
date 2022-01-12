insert into authorities (authority) values ('ROLE_USER');
insert into authorities (authority) values ('ROLE_ADMIN');

insert into users (username, enabled, password, authority_id)
values ('root', true, '$2a$10$oL9B0y6Fn7s0sBt1NjoU6utvN7oivcJ2d4DzBTlDGLewINv4ty.gu',
        (select id from authorities where authority = 'ROLE_ADMIN'));

insert into posts (name, description) values ('admin', 'О чем этот форум?');
insert into posts (name, description) values ('user', 'Правила форума.');