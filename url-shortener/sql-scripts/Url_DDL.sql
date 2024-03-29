CREATE TABLE IF NOT EXISTS url
(
    id         bigint  not null
        constraint url_pkey primary key,
    long_url   varchar(1000) not null,
    short_url  varchar(50),
    sequence   bigint        not null,
    total_hit   bigint default 0,
    created    timestamp,
    updated    timestamp,
    row_status varchar(255)  not null
);

CREATE SEQUENCE url_seq START 1;