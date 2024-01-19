create sequence payment_seq start with 1 increment by 1;
create table payment (amount integer, payment_id integer not null, bic varchar(255), currency varchar(255), iban varchar(255), primary key (payment_id));
