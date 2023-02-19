CREATE TABLE persons(
	name varchar,
	surname varchar,
	age int,
	phone_number varchar,
	city_of_living varchar,
	primary key (name, surname, age));

INSERT INTO
    persons (name, surname, age, phone_number, city_of_living)
VALUES
    ('Василий','Петров', 25, '+79500000000', 'MOSCOW'),
    ('Василий','Иванов', 28, '+79510000000', 'SARATOV'),
    ('Юлия','Петрова', 29, '+79520000000', 'MOSCOW');
