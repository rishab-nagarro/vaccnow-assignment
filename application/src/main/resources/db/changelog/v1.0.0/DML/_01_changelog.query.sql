-- liquibase formatted sql

-- changeset rishabbhatnagar:populate-branch-static-data
INSERT INTO branch (id, branch_name, address, contact_info) VALUES (1, 'BranchA', 'abc','124527244');
INSERT INTO branch (id, branch_name, address, contact_info) VALUES (2, 'BranchB', 'bbc','124527244');

-- changeset rishabbhatnagar:populate-vaccine-static-data
INSERT INTO vaccine (id, vaccine_name, manufacturer, type,description) VALUES (1, 'VaccineA', 'VaccineA Manufacturer','Fever','Vaccine for fever');
INSERT INTO vaccine (id, vaccine_name, manufacturer, type,description) VALUES (2, 'VaccineB', 'VaccineB Manufacturer','FevColder','Vaccine for Cold');

-- changeset rishabbhatnagar:populate-availability-static-data
INSERT INTO availability (id, branch_id, vaccine_id, available_date,available_time_slot) VALUES (1, 1, 1,'2024-03-04','09:00');
INSERT INTO availability (id, branch_id, vaccine_id, available_date,available_time_slot) VALUES (2, 1, 2,'2024-03-04','10:00');

-- changeset rishabbhatnagar:populate-schedule-static-data
--INSERT INTO schedule (id, branch_id, vaccine_id, customer_name,customer_email,schedule_date_time,payment_method,confirmation_status) VALUES (1, 1, 1,'CustomerA','abs@gmail.com','2024-03-03T09:00:00','Cash','Confirmed');
--INSERT INTO schedule (id, branch_id, vaccine_id, customer_name,customer_email,schedule_date_time,payment_method,confirmation_status) VALUES (2, 1, 1,'CustomerB','abc@gmail.com','2024-03-04T010:00:00','Cash','Confirmed');



