DROP TABLE IF EXISTS person_movie_rel;
 
CREATE TABLE person_movie_rel (
  id INT AUTO_INCREMENT  PRIMARY KEY,
  person_id INTEGER(250) NOT NULL,
  imdb_id INTEGER(250) NOT NULL
);

INSERT INTO person_movie_rel (person_id,imdb_id) VALUES
(1,1),
(1,2),
(2,1),
(2,3);

--INSERT INTO Person (person_id,first_name, last_name,subscription_type,age) VALUES
--  (1,'Aliko', 'Dangote','Subscriber', 25),
--  (2,'Bill', 'Gates', 'Guest',45);
--  ('kill', 'Ramos', 4),
--  ('Folrunsho', 'Alakija', 5);