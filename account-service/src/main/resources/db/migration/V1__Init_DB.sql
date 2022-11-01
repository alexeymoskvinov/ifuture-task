drop schema if exists account_schema cascade;

create schema if not exists account_schema;

drop table if exists account_schema.account cascade;

create table account_schema.account
(
    id int,
    value int,
    primary key (id)
);