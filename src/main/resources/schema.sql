create table if not exists animals
(
    id_animal serial primary key,
    kind_of_animal varchar(255) not null,
    name_animal varchar(255) unique,
    date_of_adoption_of_the_animal timestamp
);