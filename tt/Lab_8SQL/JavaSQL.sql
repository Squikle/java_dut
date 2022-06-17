CREATE DATABASE javatestdb;

CREATE TABLE Comments
(
    Id SERIAL PRIMARY KEY not null,
    Text TEXT,
    Username CHARACTER VARYING(30)
);

CREATE TABLE Users
(
    Id SERIAL PRIMARY KEY not null,
    Name CHARACTER VARYING(30) not null
);

CREATE TABLE Roles
(
    Id SERIAL PRIMARY KEY not null,
    Role CHARACTER VARYING(30) not null
);

CREATE TABLE UserRole
(
    Id SERIAL PRIMARY KEY not null,
    UserId INTEGER REFERENCES Users(id),
    RoleId INTEGER REFERENCES Roles(id)
);

INSERT INTO Comments (Text, Username) VALUES
('Haha Very funny joke. Typa like', 'Gus2006'),
('?', 'User2387642'),
('there could be your ad', 'User23234234'),
('Раньше было лучше...', 'old');

INSERT INTO Users (Name) VALUES ('User1'), ('User2'), ('User3'), ('User4');
INSERT INTO Roles (Role) VALUES ('USER'), ('ADMIN');

INSERT INTO UserRole (UserId, RoleId)
VALUES ((SELECT Id FROM Users WHERE Name = 'User1'), (SELECT Id FROM Roles WHERE Role= 'ADMIN')),
((SELECT Id FROM Users WHERE Name = 'User1'), (SELECT Id FROM Roles WHERE Role = 'USER')),
((SELECT Id FROM Users WHERE Name = 'User2'), (SELECT Id FROM Roles WHERE Role = 'USER')),
((SELECT Id FROM Users WHERE Name = 'User3'), (SELECT Id FROM Roles WHERE Role = 'USER')),
((SELECT Id FROM Users WHERE Name = 'User4'), (SELECT Id FROM Roles WHERE Role = 'ADMIN'));

SELECT U.Name, R.Role FROM UserRole UR
JOIN Users U ON UR.UserId = U.Id
JOIN Roles R On UR.RoleId = R.Id AND R.Role = 'ADMIN';