
# --- !Ups
PRAGMA foreign_keys = ON;

CREATE TABLE "color" (
 "id" INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT,
 "name" VARCHAR(20) NOT NULL,
 "value" VARCHAR(27) NOT NULL
);

-- kategorie towarow
CREATE TABLE "category" (
	"id" INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT,
	"name" VARCHAR(220) NOT NULL,
	"description" VARCHAR(500) NOT NULL
);

-- promocje i obnizki
CREATE TABLE "discount" (
	"id" INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT,
     "name" VARCHAR(200) NOT NULL,
     "value" INTEGER  NOT NULL DEFAULT 0        --procent podatku jako liczba calkowita
);


CREATE TABLE "product" (
	"id" INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT,
    "category" INTEGER NOT NULL,
    "color" INTEGER DEFAULT NULL,
	"name" VARCHAR(200) NOT NULL,
	"description" VARCHAR(500) NOT NULL,
	"price" INTEGER NOT NULL,   -- price / 100 == PLN
	"discount" INTEGER NOT NULL REFERENCES discount(id),
	FOREIGN KEY(category) references category(id) ON DELETE CASCADE
	FOREIGN KEY(color) references color(id) ON DELETE CASCADE
);

CREATE TABLE "size" (
	"id" INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT,
    "size" INTEGER  --CHECK( "size" BETWEEN 0 AND 470 OR "size" = 0) -- rozmiar obuwia EU = 10
);

CREATE TABLE "stock" (
	"id" INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT,
    "product" INTEGER NOT NULL REFERENCES product(id),
    "size" INTEGER NOT NULL REFERENCES "size"(id),
    "pieces" INTEGER NOT NULL DEFAULT 0
);

CREATE TABLE "client" (
	"id"	INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT,
	"first_name"	VARCHAR(125) NOT NULL,
	"last_name"	VARCHAR(125) NOT NULL,
    "NIP" VARCHAR(12) DEFAULT NULL
);
CREATE TABLE "ptu" (
 "id" INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT,
 "name" CHAR(1) NOT NULL,
 "value" INTEGER NOT NULL

);

# --- !Downs

DROP TABLE IF EXISTS "paragon";
DROP TABLE IF EXISTS "faktura";
DROP TABLE IF EXISTS "purchase_unit";
DROP TABLE IF EXISTS "purchase_total";
DROP TABLE IF EXISTS "stock";
DROP TABLE IF EXISTS "product";
DROP TABLE IF EXISTS "size";
DROP TABLE IF EXISTS "category";
DROP TABLE IF EXISTS "discount";
DROP TABLE IF EXISTS "client";
DROP TABLE IF EXISTS "color";
DROP TABLE IF EXISTS "ptu";