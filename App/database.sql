create database database_Project;
create table user(
      id_user int,
      first_name varchar(25),
      last_name varchar(25),
      email varchar(30),
      password varchar(25),
      phone_number varchar(20),
      primary key(id_user)
);

create table invoices(
      id_invoice int,
      due_date date,
      payment int,
      id_user int,
      id_apartment int,
      primary key(id_invoice),
      foreign key(id_user) references user(id_user),
      foreign key(id_apartment) references apartments(id_apartment)
);

create table apartments(
      id_apartment int,
      id_user int,
      floor int,
      apartment_number int,
      water_consumption int,
      numberOfRooms int,
      numberOfPeople int,
      expenses int,
      debt int,
      outstanding_payments int,
      primary key(id_apartment),
      foreign key(id_user) references user(id_user)
);

create table payment(
      id_payment int,
      id_user int,
      payment_amount int,
      payment_date date,
      primary key(id_payment),
      foreign key(id_user) references user(id_user)
);

create table repair_request(
      id_request int,
      id_user int,
      problem varchar(50),
      foreign key(id_user) references user(id_user)
);

create table contracts(
      id_contract int,
      id_user int,
      start_date date,
      end_date date,
      foreign key(id_user) references user(id_user)
);















