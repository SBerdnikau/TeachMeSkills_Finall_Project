
comment on database postgres is 'default administrative connection database';

create table users
(
    id               bigserial
        constraint table_name_pk
            primary key,
    first_name       varchar(255)                        not null,
    last_name        varchar(255)                        not null,
    telephone_number varchar(255)                        not null,
    email            varchar(255)                        not null,
    is_deleted       boolean   default false,
    created          timestamp default CURRENT_TIMESTAMP not null,
    updated          timestamp default CURRENT_TIMESTAMP
);

alter table users
    owner to postgres;

create table security
(
    id       bigserial
        constraint security_pk
            primary key,
    login    varchar(100)                          not null,
    password varchar(255)                          not null,
    role     varchar(50) default USER              not null,
    created  timestamp   default CURRENT_TIMESTAMP not null,
    updated  timestamp   default CURRENT_TIMESTAMP,
    user_id  bigint
        constraint user_id
            references users
            on update cascade on delete cascade
);

alter table security
    owner to postgres;

create table smartphones
(
    id                bigserial
        constraint smartphones_pk
            primary key,
    name              varchar(255)                        not null,
    screen            varchar(255)                        not null,
    cpu               varchar(255)                        not null,
    e_sim_support     boolean   default false             not null,
    camera_resolution bigint                              not null,
    discount          bigint,
    image             varchar(255),
    created           timestamp default CURRENT_TIMESTAMP not null,
    updated           timestamp default CURRENT_TIMESTAMP
);

alter table smartphones
    owner to postgres;

create table leptops
(
    id         bigserial
        constraint leptops_pk
            primary key,
    name       varchar(255)                        not null,
    os         varchar(255),
    screen     varchar(255)                        not null,
    cpu        varchar(255)                        not null,
    video_card varchar(255)                        not null,
    memory     varchar(255)                        not null,
    discount   bigint,
    image      varchar(255),
    created    timestamp default CURRENT_TIMESTAMP not null,
    updated    timestamp default CURRENT_TIMESTAMP
);

alter table leptops
    owner to postgres;

create table "order"
(
    id         bigserial
        constraint order_pk
            primary key,
    product_id bigint
        constraint laptop_id
            references leptops
            on update cascade on delete cascade
        constraint smartphone_id
            references smartphones
            on update cascade on delete cascade,
    user_id    bigint
        constraint user_id
            references users
            on update cascade on delete cascade,
    amount     bigint           not null,
    total_sum  double precision not null
);

alter table "order"
    owner to postgres;

create table catalog_products
(
    id           bigserial
        constraint catalog_products_pk
            primary key,
    name_catalog varchar(100)                        not null,
    product_id   bigint                              not null
        constraint smartphone_id
            references smartphones
            on update cascade on delete cascade
        constraint laptop_id
            references leptops
            on update cascade on delete cascade,
    created      timestamp default CURRENT_TIMESTAMP not null,
    updated      timestamp default CURRENT_TIMESTAMP
);

alter table catalog_products
    owner to postgres;

create table l_user_products
(
    id         bigserial
        constraint l_user_products_pk
            primary key,
    user_id    bigint
        constraint user_id
            references users
            on update cascade on delete cascade,
    product_id bigint
        constraint smartphone_id
            references smartphones
            on update cascade on delete cascade
        constraint laptop_id
            references leptops
            on update cascade on delete cascade,
    created    timestamp default CURRENT_TIMESTAMP not null,
    updated    timestamp default CURRENT_TIMESTAMP
);

alter table l_user_products
    owner to postgres;

