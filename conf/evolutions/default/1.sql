# --- !Ups

CRETE TABLE "Product" (
    "id"            INTEGER NOT NULL, PRIMARY KEY AUTOINCREMENT,
    "Name"          VARCHAR(125) NOT NULL,
    "Description"   VARCHAR(255),
);

CRETE TABLE "Category" (
    "id"            INTEGER NOT NULL, PRIMARY KEY AUTOINCREMENT,
    "Name"          VARCHAR(125) NOT NULL ,
 );


# --- !Downs

DROP TABLE "Product" IF EXISTS;
DROP TABLE "Category" IF EXISTS;

