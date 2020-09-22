USE Project2;

INSERT INTO Clients (FirstName, LastName, Mail) VALUES ("Giannis", "Giannakis", "Giannis@Giannakis.com");
INSERT INTO Clients (FirstName, LastName) VALUES ("Lazaros", "Lazarou");
INSERT INTO Clients (FirstName, LastName) VALUES ("Konstantinos", "Konstantinou");
INSERT INTO Clients (FirstName, LastName, Mail) VALUES ("Periklis", "Stergiou", "Periklis@gmail.com");
INSERT INTO Clients (FirstName, LastName, Mail) VALUES ("Maria", "Swtiriou", "maria@gmail.com");

INSERT INTO Orders (ClientID) VALUES ("1");
INSERT INTO Orders (ClientID) VALUES ("3");
INSERT INTO Orders (ClientID) VALUES ("2");
INSERT INTO Orders (ClientID) VALUES ("4");
INSERT INTO Orders (ClientID) VALUES ("5");

INSERT INTO SumOrder (OrderID, ItemID, Quantity) VALUES ("1", "2", "10"); 
INSERT INTO SumOrder (OrderID, ItemID, Quantity) VALUES ("1", "3", "10");
INSERT INTO SumOrder (OrderID, ItemID, Quantity) VALUES ("2", "3", "10");
INSERT INTO SumOrder (OrderID, ItemID, Quantity) VALUES ("2", "1", "10");
INSERT INTO SumOrder (OrderID, ItemID, Quantity) VALUES ("1", "1", "10");
INSERT INTO SumOrder (OrderID, ItemID, Quantity) VALUES ("3", "1", "10");
INSERT INTO SumOrder (OrderID, ItemID, Quantity) VALUES ("4", "3", "10");
INSERT INTO SumOrder (OrderID, ItemID, Quantity) VALUES ("5", "2", "10");

INSERT INTO ItemInfo (InfoID, LQuantity, colour) VALUES ("1", "3", "kokkino");
INSERT INTO ItemInfo (InfoID, LQuantity, colour) VALUES ("1", "2", "prasino");
INSERT INTO ItemInfo (InfoID, LQuantity, colour) VALUES ("3", "2", "mple");
INSERT INTO ItemInfo (InfoID, LQuantity, colour) VALUES ("2", "2", "mple");

INSERT INTO Items (ItemName, Price, ItemInfo) VALUES ("Mplouza", "30.0", "1");
INSERT INTO Items (ItemName, Price, ItemInfo) VALUES ("Panteloni", "40.0", "3");
INSERT INTO Items (ItemName, Price, ItemInfo) VALUES ("Kaltsa", "10.0", "2");


