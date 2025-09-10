-- ============================
-- Popolamento tabella oggetti
-- ============================

INSERT IGNORE INTO oggetti (modello, brand, costo_singolo_oggetto, quantita) VALUES ('iPhone 15', 'Apple', 1299.99, 10);
INSERT IGNORE INTO oggetti (modello, brand, costo_singolo_oggetto, quantita) VALUES ('MacBook Pro 14', 'Apple', 2399.50, 5);
INSERT IGNORE INTO oggetti (modello, brand, costo_singolo_oggetto, quantita) VALUES ('iPad Pro', 'Apple', 1099.00, 12);
INSERT IGNORE INTO oggetti (modello, brand, costo_singolo_oggetto, quantita) VALUES ('Apple Watch Ultra', 'Apple', 899.90, 8);
INSERT IGNORE INTO oggetti (modello, brand, costo_singolo_oggetto, quantita) VALUES ('AirPods Pro 2', 'Apple', 279.99, 25);

INSERT IGNORE INTO oggetti (modello, brand, costo_singolo_oggetto, quantita) VALUES ('Galaxy S24', 'Samsung', 999.99, 20);
INSERT IGNORE INTO oggetti (modello, brand, costo_singolo_oggetto, quantita) VALUES ('Galaxy Z Fold 5', 'Samsung', 1799.00, 4);
INSERT IGNORE INTO oggetti (modello, brand, costo_singolo_oggetto, quantita) VALUES ('Galaxy Tab S9', 'Samsung', 799.99, 15);
INSERT IGNORE INTO oggetti (modello, brand, costo_singolo_oggetto, quantita) VALUES ('Galaxy Watch 6', 'Samsung', 349.50, 18);
INSERT IGNORE INTO oggetti (modello, brand, costo_singolo_oggetto, quantita) VALUES ('Galaxy Buds 2 Pro', 'Samsung', 199.99, 30);

INSERT IGNORE INTO oggetti (modello, brand, costo_singolo_oggetto, quantita) VALUES ('ThinkPad X1 Carbon', 'Lenovo', 1599.00, 6);
INSERT IGNORE INTO oggetti (modello, brand, costo_singolo_oggetto, quantita) VALUES ('Legion 7', 'Lenovo', 2299.00, 3);
INSERT IGNORE INTO oggetti (modello, brand, costo_singolo_oggetto, quantita) VALUES ('Yoga Slim 7i', 'Lenovo', 1299.00, 7);
INSERT IGNORE INTO oggetti (modello, brand, costo_singolo_oggetto, quantita) VALUES ('IdeaPad 5', 'Lenovo', 899.00, 10);
INSERT IGNORE INTO oggetti (modello, brand, costo_singolo_oggetto, quantita) VALUES ('ThinkBook 14', 'Lenovo', 749.00, 12);

INSERT IGNORE INTO oggetti (modello, brand, costo_singolo_oggetto, quantita) VALUES ('XPS 13', 'Dell', 1399.00, 9);
INSERT IGNORE INTO oggetti (modello, brand, costo_singolo_oggetto, quantita) VALUES ('Alienware M15', 'Dell', 2499.00, 2);
INSERT IGNORE INTO oggetti (modello, brand, costo_singolo_oggetto, quantita) VALUES ('Inspiron 15', 'Dell', 699.00, 14);
INSERT IGNORE INTO oggetti (modello, brand, costo_singolo_oggetto, quantita) VALUES ('Latitude 7420', 'Dell', 1199.00, 5);


-- ============================
-- Popolamento tabella user
-- ============================


INSERT IGNORE INTO user (nome, cognome, indirizzo, numero_di_telefono, email)
VALUES ('Mario', 'Rossi', 'Via Roma 10, Milano', '3331112222', 'mario.rossi@example.com');

INSERT IGNORE INTO user (nome, cognome, indirizzo, numero_di_telefono, email)
VALUES ('Luca', 'Bianchi', 'Corso Italia 25, Torino', '3332223333', 'luca.bianchi@example.com');

INSERT IGNORE INTO user (nome, cognome, indirizzo, numero_di_telefono, email)
VALUES ('Giulia', 'Verdi', 'Piazza Garibaldi 5, Napoli', '3333334444', 'giulia.verdi@example.com');

INSERT IGNORE INTO user (nome, cognome, indirizzo, numero_di_telefono, email)
VALUES ('Francesca', 'Russo', 'Via Dante 18, Firenze', '3334445555', 'francesca.russo@example.com');

INSERT IGNORE INTO user (nome, cognome, indirizzo, numero_di_telefono, email)
VALUES ('Alessandro', 'Ferrari', 'Viale Marconi 77, Bologna', '3335556666', 'alessandro.ferrari@example.com');

-- ============================
-- Popolamento tabella carrello
-- ============================

-- creo carrelli vuoti. Gli oggetti che appartengono al carrello x vengono identificati dalla fk
-- idcarrello nella tabella oggetti

INSERT IGNORE INTO carrello (id) VALUES (NULL); -- Carrello 1
INSERT IGNORE INTO carrello (id) VALUES (NULL); -- Carrello 2
INSERT IGNORE INTO carrello (id) VALUES (NULL); -- Carrello 3
INSERT IGNORE INTO carrello (id) VALUES (NULL); -- Carrello 4
INSERT IGNORE INTO carrello (id) VALUES (NULL); -- Carrello 5


-- Carrello 1
UPDATE oggetti
SET carrello_id = 1
WHERE modello = 'iPhone 15' AND brand = 'Apple';

UPDATE oggetti
SET carrello_id = 1
WHERE modello = 'MacBook Pro 14' AND brand = 'Apple';


-- Carrello 2

UPDATE oggetti
SET carrello_id = 2
WHERE modello = 'Galaxy S24' AND brand = 'Samsung';

UPDATE oggetti
SET carrello_id = 2
WHERE modello = 'Galaxy Z Fold 5' AND brand = 'Samsung';

-- Carrello 3

UPDATE oggetti
SET carrello_id = 3
WHERE modello = 'ThinkPad X1 Carbon' AND brand = 'Lenovo';

UPDATE oggetti
SET carrello_id = 3
WHERE modello = 'Yoga Slim 7i' AND brand = 'Lenovo';

-- Carrello 4

UPDATE oggetti
SET carrello_id = 4
WHERE modello = 'XPS 13' AND brand = 'Dell';

UPDATE oggetti
SET carrello_id = 4
WHERE modello = 'Alienware M15' AND brand = 'Dell';

-- Carrello 5
UPDATE oggetti
SET carrello_id = 5
WHERE modello = 'AirPods Pro 2' AND brand = 'Apple';

UPDATE oggetti
SET carrello_id = 5
WHERE modello = 'Galaxy Buds 2 Pro' AND brand = 'Samsung';

-- ============================
-- Popolamento tabella ordini
-- ============================

-- Ordine 1 per carrello 1

INSERT IGNORE INTO ordine (user_id, stato, data_ordine, carrello_id)
VALUES (1, 'IN_LAVORAZIONE', NOW(), 1);

-- Ordine 2 per carrello 2
INSERT IGNORE INTO ordine (user_id, stato, data_ordine, carrello_id)
VALUES (2, 'CONSEGNATO', DATE_SUB(NOW(), INTERVAL 5 DAY), 4);

-- Ordine 3 per carrello 3
INSERT IGNORE INTO ordine (user_id, stato, data_ordine, carrello_id)
VALUES (3, 'IN_CONSEGNA', NOW(), 3);

-- Ordine 4 per carrello 4
INSERT IGNORE INTO ordine (user_id, stato, data_ordine, carrello_id)
VALUES (4, 'IN_LAVORAZIONE', DATE_SUB(NOW(), INTERVAL 2 DAY), 4);

-- Ordine 2 per carrello 2
INSERT IGNORE INTO ordine (user_id, stato, data_ordine, carrello_id)
VALUES (5, 'CANCELLATO', NOW(), 5);