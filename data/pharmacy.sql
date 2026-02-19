
DROP DATABASE pharmacy;
CREATE DATABASE pharmacy;
USE pharmacy;

CREATE TABLE employee (
                          employee_id INT PRIMARY KEY AUTO_INCREMENT,
                          name VARCHAR(100) NOT NULL,
                          user_name VARCHAR(50) NOT NULL UNIQUE,
                          password_hash VARCHAR(255) NOT NULL,
                          role VARCHAR(50) NOT NULL
);

CREATE TABLE payment (
                         payment_id INT PRIMARY KEY,
                         amount DECIMAL(10,2) NOT NULL,
                         type VARCHAR(50),
                         payment_type VARCHAR(50),
                         date DATE NOT NULL
);

CREATE TABLE supplier (
                          company_name VARCHAR(100) PRIMARY KEY,
                          supplier_name VARCHAR(100) NOT NULL,
                          supplier_contact VARCHAR(20),
                          company_contact VARCHAR(20),
                          address TEXT,
                          email VARCHAR(100)
);

CREATE TABLE bill (
                      bill_id INT PRIMARY KEY,
                      received_date DATE NOT NULL,
                      today_date DATE NOT NULL,
                      status VARCHAR(50),
                      invoice_number VARCHAR(100),
                      payment_id INT,
                      company_name VARCHAR(100),

                      FOREIGN KEY (payment_id) REFERENCES payment(payment_id),
                      FOREIGN KEY (company_name) REFERENCES supplier(company_name)
);

CREATE TABLE item (
                      item_code VARCHAR(50) PRIMARY KEY,
                      description TEXT NOT NULL
);

CREATE TABLE batch (
                       batch_id INT PRIMARY KEY,
                       batch_number VARCHAR(50) NOT NULL,
                       sell_price DECIMAL(10,2) NOT NULL,
                       cost_price DECIMAL(10,2) NOT NULL,
                       available_qty INT NOT NULL,
                       qty INT NOT NULL,
                       status VARCHAR(50),
                       expire_date DATE NOT NULL,
                       bill_id INT,
                       item_code VARCHAR(50),

                       FOREIGN KEY (bill_id) REFERENCES bill(bill_id),
                       FOREIGN KEY (item_code) REFERENCES item(item_code)
);

CREATE TABLE Free (
                      free_id INT PRIMARY KEY,
                      qty INT NOT NULL,
                      ava_qty INT NOT NULL,
                      batch_id INT,

                      FOREIGN KEY (batch_id) REFERENCES batch(batch_id)
);

CREATE TABLE orders (
                        order_id INT PRIMARY KEY,
                        customer_NIC VARCHAR(20),
                        date DATE NOT NULL,
                        status VARCHAR(50),
                        employee_id INT,
                        payment_id INT,

                        FOREIGN KEY (employee_id) REFERENCES employee(employee_id),
                        FOREIGN KEY (payment_id) REFERENCES payment(payment_id)
);

CREATE TABLE order_Detail (
                              order_detail_id INT PRIMARY KEY,
                              order_id INT,
                              batch_id INT,
                              qty_at_sold INT NOT NULL,
                              unit_price_at_sale DECIMAL(10,2) NOT NULL,
                              sub_total DECIMAL(10,2) NOT NULL,

                              FOREIGN KEY (order_id) REFERENCES orders(order_id),
                              FOREIGN KEY (batch_id) REFERENCES batch(batch_id)
);

# ///////////////////////////////////////////////////////////////////////////////////////////
# Sample Data
# ///////////////////////////////////////////////////////////////////////////////////////////

# employee sample data add

INSERT INTO supplier VALUES
                         ('ABC Pharma','Ruwan','0771111111','0111111111','Colombo','abc@gmail.com'),
                         ('HealthCare Lanka','Kasun','0772222222','0112222222','Kandy','health@gmail.com'),
                         ('MedLife','Nimal','0773333333','0113333333','Galle','medlife@gmail.com'),
                         ('PharmaPlus','Sunil','0774444444','0114444444','Matara','plus@gmail.com'),
                         ('BioHealth','Amal','0775555555','0115555555','Negombo','bio@gmail.com'),
                         ('Lanka Pharma','Kamal','0776666666','0116666666','Kurunegala','lanka@gmail.com'),
                         ('Global Med','Saman','0777777777','0117777777','Colombo','global@gmail.com'),
                         ('Care Pharma','Ravi','0778888888','0118888888','Kandy','care@gmail.com'),
                         ('City Medical','Ajith','0779999999','0119999999','Gampaha','city@gmail.com'),
                         ('Union Pharma','Chamara','0770000000','0110000000','Jaffna','union@gmail.com');

INSERT INTO item VALUES
                     ('ITM001','Paracetamol 500mg'),
                     ('ITM002','Amoxicillin 250mg'),
                     ('ITM003','Vitamin C'),
                     ('ITM004','Panadol'),
                     ('ITM005','Ibuprofen'),
                     ('ITM006','Aspirin'),
                     ('ITM007','Cetirizine'),
                     ('ITM008','Metformin'),
                     ('ITM009','Atorvastatin'),
                     ('ITM010','Omeprazole'),
                     ('ITM011','Losartan'),
                     ('ITM012','Azithromycin'),
                     ('ITM013','Vitamin D'),
                     ('ITM014','Calcium'),
                     ('ITM015','Cough Syrup'),
                     ('ITM016','Insulin'),
                     ('ITM017','Antacid'),
                     ('ITM018','Eye Drops'),
                     ('ITM019','Nasal Spray'),
                     ('ITM020','Antibiotic Cream');

INSERT INTO payment VALUES
-- Supplier payments
(1,150000,'Supplier','Bank','2026-01-01'),
(2,120000,'Supplier','Bank','2026-01-02'),
(3,98000,'Supplier','Bank','2026-01-03'),

-- Customer payments
(4,3500,'Customer','Cash','2026-02-01'),
(5,4200,'Customer','Card','2026-02-02'),
(6,1800,'Customer','Cash','2026-02-03'),
(7,2600,'Customer','Cash','2026-02-04'),
(8,5100,'Customer','Card','2026-02-05');


INSERT INTO bill VALUES
                     (1,'2026-01-01','2026-01-01','Paid','INV001',1,'ABC Pharma'),
                     (2,'2026-01-02','2026-01-02','Paid','INV002',2,'HealthCare Lanka'),
                     (3,'2026-01-03','2026-01-03','Paid','INV003',3,'MedLife');

INSERT INTO batch VALUES
                      (1,'PARA-2026-A',12,8,500,500,'Available','2027-01-01',1,'ITM001'),
                      (2,'AMOX-2026-A',25,18,300,300,'Available','2027-02-01',1,'ITM002'),
                      (3,'VITC-2026-A',15,10,400,400,'Available','2027-03-01',2,'ITM003'),
                      (4,'IBU-2026-A',20,14,350,350,'Available','2027-04-01',2,'ITM005'),
                      (5,'INS-2026-A',1500,1200,100,100,'Available','2027-05-01',3,'ITM016'),
                      (6,'OME-2026-A',30,22,250,250,'Available','2027-06-01',3,'ITM010'),
                      (7,'LOS-2026-A',28,20,220,220,'Available','2027-07-01',1,'ITM011'),
                      (8,'ASP-2026-A',10,6,600,600,'Available','2027-08-01',2,'ITM006');

INSERT INTO orders VALUES
                       (1,'200000000001','2026-02-01','Completed',1,4),
                       (2,'200000000002','2026-02-02','Completed',1,5),
                       (3,'200000000003','2026-02-03','Completed',1,6),
                       (4,'200000000004','2026-02-04','Completed',1,7),
                       (5,'200000000005','2026-02-05','Completed',1,8);

INSERT INTO order_Detail VALUES
                             (1,1,1,100,12,1200),
                             (2,1,2,50,25,1250),
                             (3,1,8,105,10,1050),

                             (4,2,3,100,15,1500),
                             (5,2,4,50,20,1000);


