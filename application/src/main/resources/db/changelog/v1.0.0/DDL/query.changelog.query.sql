-- liquibase formatted sql

-- changeset rishabbhatnagar:create-table-branch
CREATE TABLE branch (
id BIGINT AUTO_INCREMENT PRIMARY KEY,
branch_name VARCHAR(255) NOT NULL,
address VARCHAR(255) NOT NULL,
contact_info VARCHAR(255) NOT NULL);

-- changeset rishabbhatnagar:create-table-vaccine
CREATE TABLE vaccine (
id BIGINT AUTO_INCREMENT PRIMARY KEY,
vaccine_name VARCHAR(255) NOT NULL,
manufacturer VARCHAR(255) NOT NULL,
type VARCHAR(255) NOT NULL,
description VARCHAR(255) NOT NULL);

-- changeset rishabbhatnagar:create-table-availability
CREATE TABLE availability (
id BIGINT AUTO_INCREMENT PRIMARY KEY,
branch_id BIGINT NOT NULL,
vaccine_id BIGINT NOT NULL,
available_date date NOT NULL,
available_time_slot time NOT NULL,
FOREIGN KEY (branch_id) REFERENCES branch(id),
FOREIGN KEY (vaccine_id) REFERENCES vaccine(id));

-- changeset rishabbhatnagar:create-table-schedule
CREATE TABLE schedule (
id BIGINT AUTO_INCREMENT PRIMARY KEY,
branch_id BIGINT NOT NULL,
vaccine_id BIGINT NOT NULL,
customer_name VARCHAR(255) NOT NULL,
customer_email VARCHAR(255) NOT NULL,
schedule_date_time TIMESTAMP NOT NULL,
payment_method VARCHAR(255) NOT NULL,
confirmation_status VARCHAR(255) NOT NULL,
FOREIGN KEY (branch_id) REFERENCES branch(id),
FOREIGN KEY (vaccine_id) REFERENCES vaccine(id));






