# --- !Ups

INSERT INTO "category"("name") VALUES("sample1");
INSERT INTO "category"("name") VALUES("sample2");
INSERT INTO "product"("name", "description", "category") VALUES("Robot kuchenny", "miksuje, obiera i wyrzuca śmieci", 1);

# --- !Downs

DELETE FROM "category" WHERE name="sample1";
DELETE FROM "category" WHERE name="sample2";
DELETE FROM "product";