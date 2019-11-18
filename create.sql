create table "user"
(
    id       serial not null
        constraint user_pk
            primary key,
    login    varchar,
    email    varchar,
    password varchar
);

alter table "user"
    owner to postgres;

create table message
(
    id           serial        not null
        constraint message_pk
            primary key,
    from_user_id bigint
        constraint from_user_id
            references "user",
    to_user_id   bigint
        constraint to_user_id
            references "user",
    message      varchar(1000) not null
);

alter table message
    owner to postgres;

create unique index message_id_uindex
    on message (id);

create table product
(
    id          serial not null
        constraint product_pk
            primary key,
    price       integer,
    name        varchar,
    description varchar(1000),
    images      character varying[]
);

alter table product
    owner to postgres;

create table lot
(
    id                 serial not null
        constraint lot_pk
            primary key,
    owner_id           bigint
        constraint owner_id
            references "user",
    status             boolean,
    buyer_id           bigint
        constraint buyer_id
            references "user",
    start_date         timestamp,
    finish_date        timestamp,
    transaction_status boolean,
    product_id         bigint
        constraint product_id
            references product
);

alter table lot
    owner to postgres;

create unique index lot_id_uindex
    on lot (id);

create table bet
(
    id         serial not null
        constraint bet_pk
            primary key,
    lot_id     bigint
        constraint lot_id
            references lot,
    p_buyer_id bigint
        constraint p_buyer_id
            references "user",
    bet_val    bigint not null,
    date       timestamp
);

alter table bet
    owner to postgres;

create unique index bet_id_uindex
    on bet (id);

create unique index product_id_uindex
    on product (id);

