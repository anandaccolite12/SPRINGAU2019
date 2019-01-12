create database taxi_management;
use taxi_management;

create table passenger(
passengerId int primary key,
passengerName varchar(255) not null,
phoneNo varchar(10) not null unique,
email varchar(50)not null unique,
location varchar(50) not null
);

drop table vehicle;

create table vehicle(
vehicleRegNo varchar(20) primary key,
vehicleName varchar(255) not null,
category varchar(10) not null check (category IN ('car','auto')),
model varchar(50)not null,
availability varchar(20) not null check (availability IN ('yes','no')),
noOfPassengers int not null check(noOfPassengers>0),
location varchar(50) not null,
vehicleStatus varchar(50) not null check (category IN ('available','booked'))
);

create table driver(
driverId int primary key,
driverName varchar(255) not null,
phoneNo varchar(10) not null unique,
vehicleRegNo varchar(50)not null,
foreign key (vehicleRegNo) references vehicle(vehicleRegNo)
);

create table bookingDetails(
bookingId int primary key,
passengerId int not null,
driverId int not null,
pickup varchar(255) not null,
dropPoint varchar(255) not null,
totalKilometers int not null,
paymentStatus varchar(255) not null check (availability IN ('cash','online')),
dateJourney varchar(255) not null,
amount int not null,
rideStatus varchar(255) not null check (drivingStatus IN ('success','pending','cancelled')),
foreign key (passengerId) references passenger(passengerId),
foreign key (driverId) references driver(driverId)
);

create table historyOfJourney(
passengerId int not null,
bookingId int not null,
foreign key (passengerId) references passenger(passengerId),
foreign key (bookingId) references bookingDetails(bookingId),
PRIMARY KEY (passengerId,bookingId)
);

create table paymentDetail(
passengerId int not null,
cardNo varchar(255) not null,
cardType varchar(255) not null check (availability IN ('debit','credit')),
foreign key (passengerId) references passenger(passengerId),
PRIMARY KEY (passengerId,cardNo)
);


INSERT INTO passenger VALUES (1, "Anand", "8526737875", "anandraj6532@gmail.com", "coimbatore");
INSERT INTO passenger VALUES (2, "Raj", "8226737875", "wgfuwgefjfw@gmail.com", "chennai");
INSERT INTO passenger VALUES (3, "Venu", "8126737875", "wjhefbjw@gmail.com", "bangalore");
INSERT INTO passenger VALUES (4, "Vinith", "1526737875", "wjkefbwjef@gmail.com", "bangalore");
INSERT INTO passenger VALUES (5, "Jaga", "3526737875", "kjnkjn@gmail.com", "chennai");


INSERT INTO vehicle VALUES ("KA37QW1234", "Honda", "car", "2016", "yes", 4, "bangalore", "available");
INSERT INTO vehicle VALUES ("TN37QW1234", "Maruthi", "car", "2012", "yes", 4, "chennai", "available");
INSERT INTO vehicle VALUES ("AP37QW1234", "zeep", "car", "2011", "yes", 4, "chennai", "booked");
INSERT INTO vehicle VALUES ("KL37QW1234", "Maruthi", "Auto", "2017", "no", 3, "bangalore", "booked");
INSERT INTO vehicle VALUES ("PY37QW1234", "Honda", "car", "2018", "yes", 4, "coimbatore", "available");


INSERT INTO driver VALUES (11, "qerewq", "3526737875", "KA37QW1234");
INSERT INTO driver VALUES (21, "ghj", "1234567890", "AP37QW1234");
INSERT INTO driver VALUES (31, "djkfsdfs", "0987654321", "TN37QW1234");
INSERT INTO driver VALUES (41, "kjhg", "1234509876", "PY37QW1234");
INSERT INTO driver VALUES (51, "jkh", "6789012345", "KL37QW1234");


INSERT INTO bookingDetails VALUES (111, 1, 31, "koyambedu", "velachery", 15, "cash", "04-02-2018", 150, "success");
INSERT INTO bookingDetails VALUES (112, 4, 11, "silboard", "marathaali", 10,"online", "12-02-2018", 250, "success");
INSERT INTO bookingDetails VALUES (113, 3, 31, "fwefwe", "marathaali", 12,"online", "12-02-2018", 450, "success");


INSERT INTO historyOfJourney VALUES (1, 111);
INSERT INTO historyOfJourney VALUES (4, 112);

INSERT INTO paymentDetail VALUES (1, "12345678901234567", "debit");

SELECT * FROM passenger WHERE NOT location = 'Bangalore';



#Joins example

SELECT * FROM driver INNER JOIN vehicle  ON driver.vehicleRegNo = vehicle.vehicleRegNo; #innerJoin

SELECT * FROM driver left outer JOIN vehicle  ON driver.vehicleRegNo = vehicle.vehicleRegNo; #leftouterJoin

SELECT * FROM driver right outer JOIN vehicle  ON driver.vehicleRegNo = vehicle.vehicleRegNo; #rightOuterJoin



#procedure for calculating total income of the driver
delimiter //
create procedure getTotalAmountOfDriver(
	IN driverNo INT,
    OUT sumOfAMount INT
    )
BEGIN 

 select sum(amount) into sumOfAMount from bookingDetails where driverId = driverNo;
END
//


call getTotalAmountOfDriver(31, @sumValue); #function call

select @sumValue;

 select * from bookingDetails where driverId = 4;
 
 
#MySQL stored function example
 
DELIMITER $$
 
CREATE FUNCTION checkCarAvailability(p_creditLimit varchar(255)) RETURNS VARCHAR(100)
    DETERMINISTIC
BEGIN
    DECLARE lvl varchar(100);
 
    IF p_creditLimit = "available" THEN
 SET lvl = 'Got it, You can book the car !!!!!';
    ELSEIF (p_creditLimit = "Booked") THEN
        SET lvl = 'Sorry, Booked';
    END IF;
 
 RETURN (lvl);
END;

drop function checkCarAvailability;

SELECT vehicleName, vehicleRegNo, checkCarAvailability(vehicleStatus) as StatusValue FROM vehicle ORDER BY vehicleName;
 
 drop trigger after_booking_details_update
 
#trigger Report 
DELIMITER $$
CREATE TRIGGER after_booking_details_update 
    AFTER UPDATE ON bookingDetails
    FOR EACH ROW 
BEGIN
    INSERT INTO historyOfJourney values (OLD.passengerId,OLD.bookingId); 
END$$
DELIMITER ;

update bookingDetails set rideStatus = "Success" where bookingId = 111;

SELECT * FROM bookingdetails;

select * from historyofjourney;

