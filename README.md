# Phonebook Application

Phonebook adalah aplikasi manajemen kontak sederhana yang dibangun menggunakan Java Spring Boot dan MySQL. Aplikasi ini memiliki fitur CRUD (Create, Read, Update, Delete) dengan antarmuka berbasis HTML.

## Langkah-langkah Instalasi

### 1. Clone Repository dari GitHub

Untuk memulai, clone repository ini ke dalam lokal mesin Anda:

```bash
git clone https://github.com/arvan8709/test_msig.git
cd test_msig
```
### 2. Install Dependencies
```bash
mvn clean install
```

### 3. Konfigurasi Database di Aplikasi
```bash
Buka Application.properties

spring.datasource.url=jdbc:mysql://localhost:3306/test_MSIG
spring.datasource.username=your_username
spring.datasource.password=your_password
```

### 4. Create DATABASE + Insert Dummy Data
```bash

CREATE DATABASE test_MSIG;

USE test_MSIG;

CREATE TABLE phonebook (
    id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(100) NOT NULL,
    phone_number VARCHAR(15) NOT NULL,
    email VARCHAR(100),
    address VARCHAR(255)
);

INSERT INTO phonebook (name, phone_number, email, address) VALUES
('John Doe', '081234567890', 'johndoe@gmail.com', 'Jl. Sudirman No. 1'),
('Jane Smith', '081298765432', 'janesmith@yahoo.com', 'Jl. Thamrin No. 2'),
('David Brown', '081223344556', 'davidbrown@hotmail.com', 'Jl. Merdeka No. 3');

```

### 5. Menjalankan Aplikasi
```bash
mvn spring-boot:run
```

### 6. Mengakses Halaman HTML
```bash
Setelah aplikasi berjalan, Anda bisa mengakses halaman-halaman HTML melalui URL berikut:

Halaman List Phonebook: http://localhost:8080/list.html (UTAMA)
Halaman Create Phonebook: http://localhost:8080/create.html
Halaman Update Phonebook: http://localhost:8080/update.html?id={id}
Halaman Delete Phonebook: http://localhost:8080/delete.html?id={id}
```

### 7. Mengakses Via POSTMAN
```bash
Import collection msig.postman_collection.json ke dalam Postman 
```


