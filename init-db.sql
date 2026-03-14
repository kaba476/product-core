CREATE DATABASE IF NOT EXISTS productdb;
USE productdb;

CREATE TABLE IF NOT EXISTS products (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    description TEXT,
    price DOUBLE NOT NULL,
    quantity INT NOT NULL
);
