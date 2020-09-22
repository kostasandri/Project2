CREATE USER 'Lazaros'@'%' IDENTIFIED BY 'lazaros';
GRANT ALL ON Project2.* TO 'Lazaros'@'%';

USE Project2;

CREATE TABLE Clients
(
    ClientID INT NOT NULL AUTO_INCREMENT,
    FirstName VARCHAR(30) NOT NULL,
    LastName VARCHAR(30) NOT NULL,
    Mail VARCHAR(30),
    PRIMARY KEY (ClientID) 
);

CREATE TABLE Orders
(
    OrderID INT(6) NOT NULL AUTO_INCREMENT,
    ClientID int,
    PRIMARY KEY (OrderID),
    FOREIGN KEY (ClientID) REFERENCES Clients(ClientID)
);

CREATE TABLE SumOrder
(
    OrderID INT NOT NULL,
    ItemID INT NOT NULL,
    Quantity INT,
    PRIMARY KEY (OrderID, ItemID),
    FOREIGN KEY (OrderID) REFERENCES Orders(OrderID)
);

CREATE TABLE ItemInfo
(
    InfoID INT NOT NULL ,
    LeftQuantity INT NOT NULL,
    colour VARCHAR(30) NOT NULL,
    PRIMARY KEY (InfoID, colour)
);

CREATE TABLE Items
(
    ItemID INT NOT NULL AUTO_INCREMENT,
    ItemName VARCHAR(30) NOT NULL,
    Price DOUBLE NOT NULL,
    ItemInfo INT,
    PRIMARY KEY (ItemID),
    FOREIGN KEY (ItemInfo) REFERENCES ItemInfo(InfoID)
);


/*CREATE USER 'Lazaros'@'%' IDENTIFIED BY 'lazaros';

GRANT ALL ON project2.* TO 'Lazaros'@'%'; 

CREATE TABLE MyGuests (
id INT(6) UNSIGNED AUTO_INCREMENT PRIMARY KEY,
firstname VARCHAR(30) NOT NULL,
lastname VARCHAR(30) NOT NULL,
email VARCHAR(50));



USE Project2;

CREATE TABLE Sumorder (
    SumID INT(10) UNSIGNED AUTO_INCREMENT,
    ItemID INT(10) NOT NULL,
    PRIMARY KEY (SumID, ItemID)
);

CREATE TABLE ItemInfo
(
    InfoID INT,
    quantity INT,
    colour VARCHAR(30),
    PRIMARY KEY (InfoID)
)

CREATE TABLE Orders
(
    OrderID INT(6) NOT NULL,
    OrderNumber INT(6) NOT NULL,
    ClientID int,
    PRIMARY KEY (OrderID),
    FOREIGN KEY (ClientID) REFERENCES Clients(ClientID),
    FOREIGN KEY (OrderNumber) REFERENCES SumOrder(SumID)
)

CREATE TABLE Clients
(
    ClientID INT NOT NULL AUTO_INCREMENT,
    FirstName VARCHAR NOT NULL,
    LastName VARCHAR NOT NULL,
    Mail VARCHAR,
    PRIMARY KEY (ClientID) 
);

CREATE TABLE Items
(
    ItemID INT NOT NULL AUTO_INCREMENT,
    ItemName VARCHAR NOT NULL,
    Price DOUBLE NOT NULL,
    ItemInfo INT,
    PRIMARY KEY (ItemID),
    FOREIGN KEY (ItemInfo) REFERENCES ItemInfo(InfoID)
);
*/

