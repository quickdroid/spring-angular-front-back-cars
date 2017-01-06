


/* location data */
insert into location (id, country, post_code, state) values (1, 'United States', '35049', 'Alabama');
insert into location (id, country, post_code, state) values (2, 'United States', '35050', 'Alaska');
insert into location (id, country, post_code, state) values (3, 'United States', '35051', 'Arizona');
insert into location (id, country, post_code, state) values (4, 'United States', '35042', 'Arkansas');
insert into location (id, country, post_code, state) values (5, 'United States', '35043', 'California');
insert into location (id, country, post_code, state) values (6, 'United States', '35044', 'Colorado');
insert into location (id, country, post_code, state) values (7, 'United States', '35045', 'Connecticut');
insert into location (id, country, post_code, state) values (8, 'United States', '35046', 'Delaware');
insert into location (id, country, post_code, state) values (9, 'United States', '35047', 'Florida');
insert into location (id, country, post_code, state) values (10, 'United States', '35048', 'Georgia');
insert into location (id, country, post_code, state) values (11, 'United States', '35149', 'Hawaii');
insert into location (id, country, post_code, state) values (12, 'United States', '22212', 'Idaho');
insert into location (id, country, post_code, state) values (13, 'United States', '22213', 'Illinois');
insert into location (id, country, post_code, state) values (14, 'United States', '22214', 'Indiana');
insert into location (id, country, post_code, state) values (15, 'United States', '22215', 'Iowa');
insert into location (id, country, post_code, state) values (16, 'United States', '22216', 'Kansas');
insert into location (id, country, post_code, state) values (17, 'United States', '22217', 'Kentucky');
insert into location (id, country, post_code, state) values (18, 'United States', '22218', 'Louisiana');
insert into location (id, country, post_code, state) values (19, 'United States', '12345', 'Maine');
insert into location (id, country, post_code, state) values (20, 'United States', '22345', 'Maryland');
insert into location (id, country, post_code, state) values (21, 'United States', '32345', 'Massachusetts');
insert into location (id, country, post_code, state) values (22, 'United States', '42345', 'Michigan');
insert into location (id, country, post_code, state) values (23, 'United States', '52345', 'Minnesota');
insert into location (id, country, post_code, state) values (24, 'United States', '62345', 'Mississippi');
insert into location (id, country, post_code, state) values (25, 'United States', '72345', 'Missouri');
insert into location (id, country, post_code, state) values (26, 'United States', '82345', 'Montana');
insert into location (id, country, post_code, state) values (27, 'United States', '92345', 'Nebraska');
insert into location (id, country, post_code, state) values (28, 'United States', '10345', 'Nevada');
insert into location (id, country, post_code, state) values (29, 'United States', '11345', 'New Hampshire');
insert into location (id, country, post_code, state) values (30, 'United States', '12349', 'New Jersey');
insert into location (id, country, post_code, state) values (31, 'United States', '13348', 'New Mexico');
insert into location (id, country, post_code, state) values (32, 'United States', '13347', 'New York');
insert into location (id, country, post_code, state) values (33, 'United States', '13346', 'North Carolina');
insert into location (id, country, post_code, state) values (34, 'United States', '13344', 'North Dakota');
insert into location (id, country, post_code, state) values (35, 'United States', '13342', 'Ohio');
insert into location (id, country, post_code, state) values (36, 'United States', '15545', 'Oklahoma');
insert into location (id, country, post_code, state) values (37, 'United States', '15645', 'Oregon');
insert into location (id, country, post_code, state) values (38, 'United States', '16945', 'Pennsylvania');
insert into location (id, country, post_code, state) values (39, 'United States', '37549', 'Rhode Island');
insert into location (id, country, post_code, state) values (40, 'United States', '38849', 'South Carolina');
insert into location (id, country, post_code, state) values (41, 'United States', '32849', 'South Dakota');
insert into location (id, country, post_code, state) values (42, 'United States', '39349', 'Tennessee');
insert into location (id, country, post_code, state) values (43, 'United States', '37449', 'Texas');
insert into location (id, country, post_code, state) values (44, 'United States', '31449', 'Utah');
insert into location (id, country, post_code, state) values (45, 'United States', '39649', 'Vermont');
insert into location (id, country, post_code, state) values (46, 'United States', '31749', 'Virginia');
insert into location (id, country, post_code, state) values (47, 'United States', '11149', 'Washington');
insert into location (id, country, post_code, state) values (48, 'United States', '39949', 'West Virginia');
insert into location (id, country, post_code, state) values (49, 'United States', '35800', 'Wisconsin');
insert into location (id, country, post_code, state) values (50, 'United States', '35777', 'Wyoming');

/* model_type data */
insert into model_type (id, name) values (1, 'SUV');
insert into model_type (id, name) values (2, 'CONVERTIBLE');
insert into model_type (id, name) values (3, 'COUPE');
insert into model_type (id, name) values (4, 'PICKUP');
insert into model_type (id, name) values (5, 'SEDAN');
insert into model_type (id, name) values (6, 'HATCHBACK');

/* brand data */
insert into brand (id, name, location_id, yearly_turnover, creation_date, active) values (1, 'AUDI', 3, 950000, '1955-01-01', TRUE );
insert into brand (id, name, location_id, yearly_turnover, creation_date, active) values (2, 'BMV', 4, 940000, '1960-03-01', TRUE );
insert into brand (id, name, location_id, yearly_turnover, creation_date, active) values (3, 'BENTLEY', 5, 1945500, '1977-06-11', TRUE );
insert into brand (id, name, location_id, yearly_turnover, creation_date, active) values (4, 'HONDA', 5, 2220000, '1999-08-10', TRUE );
insert into brand (id, name, location_id, yearly_turnover, creation_date, active) values (5, 'OPEL', 6, 4444000, '1985-10-10', TRUE );
insert into brand (id, name, location_id, yearly_turnover, creation_date, active) values (6, 'MAZDA', 7, 7770000, '2000-01-09', FALSE );


/* brand data */
insert into model (id, name, engine_type, price, speed, brand_id, model_type_id) values (1, 'Audi A4', 'DIESEL', 100058, 220, 1, 5);
insert into model (id, name, engine_type, price, speed, brand_id, model_type_id) values (2, 'Mazda MX-5', 'DIESEL', 199444, 245, 6, 3);
insert into model (id, name, engine_type, price, speed, brand_id, model_type_id) values (3, 'Bentley Continental GT', 'DIESEL', 99999999, 235, 3, 5);
insert into model (id, name, engine_type, price, speed, brand_id, model_type_id) values (4, 'Bentley Bentayga', 'PETROL', 79999999, 190, 3, 5);
insert into model (id, name, engine_type, price, speed, brand_id, model_type_id) values (5, 'BMW i8', 'PETROL', 550058, 250, 2, 3);
insert into model (id, name, engine_type, price, speed, brand_id, model_type_id) values (6, 'OPEL GTC OPC', 'DIESEL', 560058, 220, 5, 2);
insert into model (id, name, engine_type, price, speed, brand_id, model_type_id) values (7, 'honda civic', 'DIESEL', 188058, 220, 4, 2);



