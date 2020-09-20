USE Project2;

INSERT INTO SumOrder (OrderNumber, ItemID) VALUES ("1", "2"); 
INSERT INTO SumOrder (OrderNumber, ItemID) VALUES ("1", "3");
INSERT INTO SumOrder (OrderNumber, ItemID) VALUES ("2", "3");
INSERT INTO SumOrder (OrderNumber, ItemID) VALUES ("2", "1");
INSERT INTO SumOrder (OrderNumber, ItemID) VALUES ("1", "1");
INSERT INTO SumOrder (OrderNumber, ItemID) VALUES ("3", "1");
INSERT INTO SumOrder (OrderNumber, ItemID) VALUES ("10", "3");
INSERT INTO SumOrder (OrderNumber, ItemID) VALUES ("15", "2");


INSERT INTO Clients (FirstName, LastName, Mail) VALUES ("Giannis", "Giannakis", "Giannis@Giannakis.com");
INSERT INTO Clients (FirstName, LastName) VALUES ("Lazaros", "Lazarou");
INSERT INTO Clients (FirstName, LastName) VALUES ("Konstantinos", "Konstantinou");
INSERT INTO Clients (FirstName, LastName, Mail) VALUES ("Periklis", "Stergiou", "Periklis@gmail.com");
INSERT INTO Clients (FirstName, LastName, Mail) VALUES ("Maria", "Swtiriou", "maria@gmail.com");

INSERT INTO Orders (OrderNumber, ClientID) VALUES ("15", "1");
INSERT INTO Orders (OrderNumber, ClientID) VALUES ("2", "3");
INSERT INTO Orders (OrderNumber, ClientID) VALUES ("3", "2");
INSERT INTO Orders (OrderNumber, ClientID) VALUES ("10", "4");
INSERT INTO Orders (OrderNumber, ClientID) VALUES ("1", "5");

INSERT INTO ItemInfo (InfoID, quantity, colour) VALUES ("1", "3", "kokkino");
INSERT INTO ItemInfo (InfoID, quantity, colour) VALUES ("1", "2", "prasino");
INSERT INTO ItemInfo (InfoID, quantity, colour) VALUES ("3", "2", "mple");

INSERT INTO Items (ItemName, Price, ItemInfo) VALUES ("Mplouza", "30.0", "1");
INSERT INTO Items (ItemName, Price, ItemInfo) VALUES ("Panteloni", "40.0", "3");
INSERT INTO Items (ItemName, Price) VALUES ("Kaltsa", "10.0");


