use hospify;

Select * from User;
select * from states;
select * from city;
select * from country;
select * from amount;
select * from appointment;

describe states;
describe Country;
describe city;


-- INSERT DATA FOR COUNTRY

INSERT INTO Country (country_id, country_name) VALUES
(1, 'India'),
(2, 'Germany'),
(3, 'Japan');

-- INSERT DATA FOR STATES


-- INSERT DATA FOR STATES


INSERT INTO States (state_id, country_id, state_name) VALUES
-- States in India
(1, 1, 'Maharashtra'),
(2, 1, 'Karnataka'),
(3, 1, 'Tamil Nadu'),
(4, 1, 'Kerala'),

-- States in Germany
(5, 2, 'Bavaria'),
(6, 2, 'Berlin'),
(7, 2, 'Hamburg'),

-- States in Japan
(8, 3, 'Tokyo'),
(9, 3, 'Osaka'),
(10, 3, 'Kyoto');

-- CITY FOR Maharashtra

INSERT INTO City (city_id, city_name, state_id) VALUES
(1, 'Mumbai', 1),
(2, 'Pune', 1),
(3, 'Nagpur', 1),
(4, 'Nashik', 1),
(5, 'Thane', 1),
(6, 'Aurangabad', 1),
(7, 'Kolhapur', 1),
(8, 'Amravati', 1),
(9, 'Solapur', 1),
(10, 'Jalgaon', 1),
(11, 'Sangli', 1),
(12, 'Nanded', 1),
(13, 'Satara', 1),
(14, 'Latur', 1),
(15, 'Ahmednagar', 1),
(16, 'Chandrapur', 1),
(17, 'Parbhani', 1),
(18, 'Dhule', 1),
(19, 'Raigad', 1),
(20, 'Beed', 1);

-- CITY FOR Karnataka

INSERT INTO City (city_id, city_name, state_id) VALUES
(21, 'Bangalore', 2),
(22, 'Mysore', 2),
(23, 'Hubli', 2),
(24, 'Mangalore', 2),
(25, 'Belgaum', 2),
(26, 'Dharwad', 2),
(27, 'Shimoga', 2),
(28, 'Tumkur', 2),
(29, 'Bijapur', 2),
(30, 'Bellary', 2),
(31, 'Udupi', 2),
(32, 'Davangere', 2),
(33, 'Raichur', 2),
(34, 'Chitradurga', 2),
(35, 'Hassan', 2),
(36, 'Bidar', 2),
(37, 'Kolar', 2),
(38, 'Mandya', 2),
(39, 'Gulbarga', 2),
(40, 'Bagalkot', 2);

-- CITY FOR TAMILNADU

INSERT INTO City (city_id, city_name, state_id) VALUES
(41, 'Chennai', 3),
(42, 'Coimbatore', 3),
(43, 'Madurai', 3),
(44, 'Tiruchirappalli', 3),
(45, 'Salem', 3),
(46, 'Erode', 3),
(47, 'Tirunelveli', 3),
(48, 'Vellore', 3),
(49, 'Thoothukudi', 3),
(50, 'Tiruppur', 3),
(51, 'Dindigul', 3),
(52, 'Kanchipuram', 3),
(53, 'Thanjavur', 3),
(54, 'Nagercoil', 3),
(55, 'Karur', 3),
(56, 'Cuddalore', 3),
(57, 'Nagapattinam', 3),
(58, 'Pudukkottai', 3),
(59, 'Sivakasi', 3),
(60, 'Theni', 3);

-- CITY FOR KERALA

INSERT INTO City (city_id, city_name, state_id) VALUES
(61, 'Thiruvananthapuram', 4),
(62, 'Kochi', 4),
(63, 'Kozhikode', 4),
(64, 'Kannur', 4),
(65, 'Kollam', 4),
(66, 'Thrissur', 4),
(67, 'Palakkad', 4),
(68, 'Alappuzha', 4),
(69, 'Malappuram', 4),
(70, 'Pathanamthitta', 4),
(71, 'Idukki', 4),
(72, 'Ernakulam', 4),
(73, 'Kasargod', 4),
(74, 'Wayanad', 4),
(75, 'Kottayam', 4),
(76, 'Chengannur', 4),
(77, 'Muvattupuzha', 4),
(78, 'Ponnani', 4),
(79, 'Cherthala', 4),
(80, 'Varkala', 4);

-- CITY FOR Bavaria

INSERT INTO City (city_id, city_name, state_id) VALUES
(81, 'Munich', 5),
(82, 'Nuremberg', 5),
(83, 'Augsburg', 5),
(84, 'Regensburg', 5),
(85, 'Würzburg', 5);

-- Berlin

INSERT INTO City (city_id, city_name, state_id) VALUES
(86, 'Berlin City Center', 6),
(87, 'Charlottenburg', 6),
(88, 'Kreuzberg', 6),
(89, 'Pankow', 6),
(90, 'Spandau', 6);

-- Hamburg

INSERT INTO City (city_id, city_name, state_id) VALUES
(91, 'Hamburg City Center', 7),
(92, 'Altona', 7),
(93, 'Harburg', 7),
(94, 'Eimsbüttel', 7),
(95, 'Wandsbek', 7);


-- Tokyo

INSERT INTO City (city_id, city_name, state_id) VALUES
(96, 'Shibuya', 8),
(97, 'Shinjuku', 8),
(98, 'Chiyoda', 8),
(99, 'Akihabara', 8),
(100, 'Roppongi', 8);

-- Osaka

INSERT INTO City (city_id, city_name, state_id) VALUES
(101, 'Osaka City', 9),
(102, 'Sakai', 9),
(103, 'Higashiosaka', 9),
(104, 'Toyonaka', 9),
(105, 'Ikeda', 9);

-- Kyoto

INSERT INTO City (city_id, city_name, state_id) VALUES
(106, 'Kyoto City', 10),
(107, 'Uji', 10),
(108, 'Fushimi', 10),
(109, 'Arashiyama', 10),
(110, 'Yamashina', 10);