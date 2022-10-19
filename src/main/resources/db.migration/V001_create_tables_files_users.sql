CREATE TABLE if not exists USERS(
     id INT AUTO_INCREMENT,
     login VARCHAR(255),
     password VARCHAR(255),
     PRIMARY KEY (id)
);

CREATE TABLE IF NOT EXISTS FILES(
     id INT AUTO_INCREMENT,
     filename VARCHAR(255),
     date DATETIME,
     size LONG,
     type VARCHAR(255),
     content LONGBLOB,
     PRIMARY KEY (id)
);
