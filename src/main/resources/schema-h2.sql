CREATE TABLE ENERGY_DATA
        (
        id INT AUTO_INCREMENT PRIMARY KEY,
        village_name VARCHAR2(50) NOT NULL,
        consumption_amount NUMBER(10) NOT NULL,
        counter_id NUMBER(10) NOT NULL,
        last_Updated_Date DATE NOT NULL
        );