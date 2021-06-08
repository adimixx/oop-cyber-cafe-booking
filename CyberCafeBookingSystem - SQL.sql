CREATE DATABASE oop_miniproject;
USE oop_miniproject;

create table location
(
    ID   int auto_increment
        primary key,
    Name varchar(255) not null
);

create table computer
(
    ID         int auto_increment
        primary key,
    Name       varchar(255) not null,
    LocationID int          null,
    constraint Computer_Location_ID_fk
        foreign key (LocationID) references location (ID)
);

create table `user`
(
    ID       int auto_increment
        primary key,
    Username varchar(255) not null,
    Password varchar(255) not null
);

create table membership
(
    ID        int auto_increment
        primary key,
    Name      varchar(255) not null,
    Email     varchar(255) null,
    HourSpend int          null
);


create table transaction
(
    ID           int auto_increment
        primary key,
    ComputerID   int        not null,
    StartDate    datetime   not null,
    EndDate      datetime   null,
    IsActive     tinyint(1) not null,
    Price        double     null,
    MembershipID int        null,
    constraint transaction_membership_fk
        foreign key (MembershipID) references membership (ID)
);


INSERT INTO oop_miniproject.location (ID, Name) VALUES (1, 'Main Hall');
INSERT INTO oop_miniproject.location (ID, Name) VALUES (2, 'Corner');

INSERT INTO oop_miniproject.computer (ID, Name, LocationID) VALUES (1, 'PC01', 1);
INSERT INTO oop_miniproject.computer (ID, Name, LocationID) VALUES (2, 'PC02', 1);
INSERT INTO oop_miniproject.computer (ID, Name, LocationID) VALUES (3, 'PC03', 1);


INSERT INTO oop_miniproject.user (ID, Username, Password) VALUES (1, 'test', 'test');
INSERT INTO oop_miniproject.user (ID, Username, Password) VALUES (2, 'test2', 'test2');
INSERT INTO oop_miniproject.user (ID, Username, Password) VALUES (3, 'test3', '1234');

INSERT INTO oop_miniproject.membership (ID, Name, Email, HourSpend) VALUES (1, 'Ahmad Albab', 'albab@ahmad.com', 0);

INSERT INTO oop_miniproject.transaction (ID, ComputerID, StartDate, EndDate, IsActive, Price, MembershipID) VALUES (1, 1, '2020-06-10 20:47:32', '2020-06-10 21:19:14', 0, 2, null);
INSERT INTO oop_miniproject.transaction (ID, ComputerID, StartDate, EndDate, IsActive, Price, MembershipID) VALUES (2, 1, '2020-06-10 20:47:32', '2020-06-10 21:19:14', 0, 2, null);
