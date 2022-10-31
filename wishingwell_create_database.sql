CREATE DATABASE IF NOT EXISTS wishingwell;
USE wishingwell;

CREATE TABLE IF NOT EXISTS wishlists
(
  id        			BIGINT          PRIMARY KEY 	NOT NULL 	AUTO_INCREMENT,
  user_id               BIGINT          NOT NULL,
  CONSTRAINT wishlist_user
  FOREIGN KEY (user_id) REFERENCES users(id)
);

CREATE TABLE IF NOT EXISTS wishes
(
  id        			BIGINT          PRIMARY KEY 	NOT NULL 	AUTO_INCREMENT,
  item_description		VARCHAR(50)     NOT NULL,
  price					DOUBLE,
  url					VARCHAR(255),
  item_comment			VARCHAR(255),
  reserved				BIT(1),
  wishlist_id			BIGINT			NOT NULL,
  CONSTRAINT wishlist_wish
    FOREIGN KEY (wishlist_id) REFERENCES wishlists(id)
);

CREATE TABLE IF NOT EXISTS users
(
  id        			BIGINT          PRIMARY KEY 	NOT NULL 	AUTO_INCREMENT,
  user_name   			VARCHAR(50)     UNIQUE,
  user_password			VARCHAR(100)
);