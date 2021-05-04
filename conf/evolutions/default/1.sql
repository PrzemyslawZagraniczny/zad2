
# --- !Ups


-- kategorie towarow
CREATE TABLE "category" (
	"id" INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT,
	"name" VARCHAR(200) NOT NULL,
	"description" VARCHAR(500) NOT NULL
);


CREATE TABLE "product" (
	"id" INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT,
    "category" INTEGER NOT NULL REFERENCES category(id),
	"name" VARCHAR(200) NOT NULL,
	"description" VARCHAR(500) NOT NULL,
	"price" INTEGER NOT NULL   -- price / 100 == PLN
);

# --- !Downs

DROP TABLE IF EXISTS  "paragon";
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