use hospify;

Select * from User;
select * from states;
select * from city;
select * from country;
select * from amount;
select * from doctor;
select * from hospital;
select * from appointment;

describe states;
describe Country;
describe city;
describe doctor;
describe hospital;
describe doctor;

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


-- INSERT FOR HOSPITAL TABLE

INSERT INTO Hospital (hospital_id, phone_number, pincode, city_id, country_id, hospital_email, hospital_name, hospital_password, state_id, street) VALUES
-- Hospitals in Mumbai (Maharashtra, India)
(1, 9876501234, 400001, 1, 1, 'apollo.mumbai@gmail.com', 'Apollo Hospital', 'password123', 1, 'Marine Lines'),
(2, 9876505678, 400058, 1, 1, 'fortis.mumbai@gmail.com', 'Fortis Hospital', 'password123', 1, 'Andheri West'),
(3, 9876509101, 400050, 1, 1, 'lilavati.mumbai@gmail.com', 'Lilavati Hospital', 'password123', 1, 'Bandra'),

-- Hospitals in Bangalore (Karnataka, India)
(4, 9876511234, 560100, 2, 1, 'narayana.bangalore@gmail.com', 'Narayana Hospital', 'password123', 2, 'Electronic City'),
(5, 9876515678, 560066, 2, 1, 'manipal.bangalore@gmail.com', 'Manipal Hospital', 'password123', 2, 'Whitefield'),
(6, 9876519101, 560076, 2, 1, 'fortis.bangalore@gmail.com', 'Fortis Hospital', 'password123', 2, 'Bannerghatta Road'),

-- Hospitals in Chennai (Tamil Nadu, India)
(7, 9876521234, 600100, 3, 1, 'global.chennai@gmail.com', 'Global Hospital', 'password123', 3, 'Perumbakkam'),
(8, 9876525678, 600006, 3, 1, 'apollo.chennai@gmail.com', 'Apollo Hospital', 'password123', 3, 'Greams Road'),
(9, 9876529101, 600020, 3, 1, 'fortismalar.chennai@gmail.com', 'Fortis Malar Hospital', 'password123', 3, 'Adyar'),

-- Hospitals in Kochi (Kerala, India)
(10, 9876531234, 682027, 62, 1, 'aster.kochi@gmail.com', 'Aster Medcity', 'password123', 4, 'Cheranellur'),
(11, 9876535678, 682024, 62, 1, 'amrita.kochi@gmail.com', 'Amrita Hospital', 'password123', 4, 'Edapally'),

-- Hospitals in Munich (Bavaria, Germany)
(12, 9876541234, 80804, 81, 2, 'munich.hospital@gmail.com', 'Munich University Hospital', 'password123', 5, 'Schwabing'),
(13, 9876545678, 81539, 81, 2, 'bavaria.hospital@gmail.com', 'Bavaria Hospital', 'password123', 5, 'Giesing'),

-- Hospitals in Tokyo (Tokyo, Japan)
(14, 9876551234, 1600022, 96, 3, 'tokyo.medical@gmail.com', 'Tokyo Medical Center', 'password123', 8, 'Shinjuku'),
(15, 9876555678, 1500043, 96, 3, 'keio.hospital@gmail.com', 'Keio University Hospital', 'password123', 8, 'Shibuya');


-- INSERT FOR DOCTOR

INSERT INTO Doctor (doctor_id, doctor_phone, hospital_id, doctor_name, email, gender, password, specialization) VALUES
-- Doctors in Apollo Hospital (Mumbai)
(1, 9876501001, 1, 'Dr. Ravi Kumar', 'ravi.kumar@apollo.mumbai.com', 'Male', 'password123', 'Cardiologist'),
(2, 9876501002, 1, 'Dr. Priya Sharma', 'priya.sharma@apollo.mumbai.com', 'Female', 'password123', 'Neurologist'),

-- Doctors in Fortis Hospital (Mumbai)
(3, 9876501003, 2, 'Dr. Amit Patel', 'amit.patel@fortis.mumbai.com', 'Male', 'password123', 'Orthopedic'),
(4, 9876501004, 2, 'Dr. Meera Verma', 'meera.verma@fortis.mumbai.com', 'Female', 'password123', 'Pediatrician'),

-- Doctors in Lilavati Hospital (Mumbai)
(5, 9876501005, 3, 'Dr. Anil Desai', 'anil.desai@lilavati.mumbai.com', 'Male', 'password123', 'Urologist'),
(6, 9876501006, 3, 'Dr. Seema Gupta', 'seema.gupta@lilavati.mumbai.com', 'Female', 'password123', 'Gynecologist'),

-- Doctors in Narayana Hospital (Bangalore)
(7, 9876501007, 4, 'Dr. Sunil Rao', 'sunil.rao@narayana.bangalore.com', 'Male', 'password123', 'Oncologist'),
(8, 9876501008, 4, 'Dr. Anjali Singh', 'anjali.singh@narayana.bangalore.com', 'Female', 'password123', 'General Surgeon'),

-- Doctors in Manipal Hospital (Bangalore)
(9, 9876501009, 5, 'Dr. Vikram Reddy', 'vikram.reddy@manipal.bangalore.com', 'Male', 'password123', 'Pulmonologist'),
(10, 9876501010, 5, 'Dr. Kavitha Iyer', 'kavitha.iyer@manipal.bangalore.com', 'Female', 'password123', 'Dermatologist'),

-- Doctors in Fortis Hospital (Bangalore)
(11, 9876501011, 6, 'Dr. Nitin Sharma', 'nitin.sharma@fortis.bangalore.com', 'Male', 'password123', 'ENT Specialist'),
(12, 9876501012, 6, 'Dr. Radha Krishnan', 'radha.krishnan@fortis.bangalore.com', 'Female', 'password123', 'Ophthalmologist'),

-- Doctors in Global Hospital (Chennai)
(13, 9876501013, 7, 'Dr. Pradeep Kumar', 'pradeep.kumar@global.chennai.com', 'Male', 'password123', 'Endocrinologist'),
(14, 9876501014, 7, 'Dr. Aarti Sharma', 'aarti.sharma@global.chennai.com', 'Female', 'password123', 'Cardiologist'),

-- Doctors in Apollo Hospital (Chennai)
(15, 9876501015, 8, 'Dr. Ramesh Raj', 'ramesh.raj@apollo.chennai.com', 'Male', 'password123', 'Gastroenterologist'),
(16, 9876501016, 8, 'Dr. Priya Menon', 'priya.menon@apollo.chennai.com', 'Female', 'password123', 'Nephrologist'),

-- Doctors in Fortis Malar Hospital (Chennai)
(17, 9876501017, 9, 'Dr. Anand Babu', 'anand.babu@fortismalar.chennai.com', 'Male', 'password123', 'Psychiatrist'),
(18, 9876501018, 9, 'Dr. Neelam Verma', 'neelam.verma@fortismalar.chennai.com', 'Female', 'password123', 'Pediatric Surgeon'),

-- Doctors in Aster Medcity (Kochi)
(19, 9876501019, 10, 'Dr. Arjun Nair', 'arjun.nair@aster.kochi.com', 'Male', 'password123', 'Pulmonologist'),
(20, 9876501020, 10, 'Dr. Sneha Patel', 'sneha.patel@aster.kochi.com', 'Female', 'password123', 'Orthopedist'),

-- Doctors in Amrita Hospital (Kochi)
(21, 9876501021, 11, 'Dr. Raghavan Nair', 'raghavan.nair@amrita.kochi.com', 'Male', 'password123', 'Neurosurgeon'),
(22, 9876501022, 11, 'Dr. Kavita Menon', 'kavita.menon@amrita.kochi.com', 'Female', 'password123', 'Pediatrician'),

-- Doctors in Munich University Hospital (Munich)
(23, 9876501023, 12, 'Dr. Heinrich Müller', 'heinrich.mueller@munich.hospital.com', 'Male', 'password123', 'Cardiologist'),
(24, 9876501024, 12, 'Dr. Anna Schneider', 'anna.schneider@munich.hospital.com', 'Female', 'password123', 'General Practitioner'),

-- Doctors in Bavaria Hospital (Munich)
(25, 9876501025, 13, 'Dr. Matthias Weber', 'matthias.weber@bavaria.hospital.com', 'Male', 'password123', 'Orthopedic Surgeon'),
(26, 9876501026, 13, 'Dr. Julia Hoffmann', 'julia.hoffmann@bavaria.hospital.com', 'Female', 'password123', 'Dermatologist'),

-- Doctors in Tokyo Medical Center (Tokyo)
(27, 9876501027, 14, 'Dr. Takashi Yamamoto', 'takashi.yamamoto@tokyo.medical.com', 'Male', 'password123', 'Oncologist'),
(28, 9876501028, 14, 'Dr. Yumi Tanaka', 'yumi.tanaka@tokyo.medical.com', 'Female', 'password123', 'Endocrinologist'),

-- Doctors in Keio University Hospital (Tokyo)
(29, 9876501029, 15, 'Dr. Kenji Sato', 'kenji.sato@keio.hospital.com', 'Male', 'password123', 'Gastroenterologist'),
(30, 9876501030, 15, 'Dr. Mari Fujimoto', 'mari.fujimoto@keio.hospital.com', 'Female', 'password123', 'Pediatrician');

