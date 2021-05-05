# --- !Ups

INSERT INTO "category" ("name", "description") VALUES
("Plecak", "Plecaki wyprawowe > 50L"),
("Plecak", "Plecaki biegowe"),
("Plecak", "Plecaki na krótkie, kilkudniowe wycieczki"),
("Plecak", "Plecaki szkolne"),

("Buty", "Buty alpinistyczne"),
("Buty", "Buty w góry wysokie");
INSERT INTO "color" ("name", "value") VALUES
("black", "#000000"),
("red", "#CC0000"),
("green", "#00CC00"),
("blue", "#0000CC"),
("white", "#FFFFFF"),
("silver", "#AAAAAA");

INSERT INTO "product" ("category","color", "name", "description","price") VALUES
(6, 2, "Zamberlan 8000 Everest EVO RR",  "Buty wyprawowe Zamberlan 8000 Everest EVO RR to model dla prawdziwych profesjonalistów wspinających się na ośmiotysięczniki, którzy oczekują maksymalnego wsparcie od swojego zaawansowanego ekwipunku. Nie inaczej jest w przypadku tej technicznie dopracowanej konstrukcji, która sprawi, że wejście na szczyt będzie lepiej zabezpieczone oraz skutecznie wsparte.", 312000),
(6, 3, "Zamberlan 8000 Everest EVO RR",  "Buty wyprawowe Zamberlan 8000 Everest EVO RR to model dla prawdziwych profesjonalistów wspinających się na ośmiotysięczniki, którzy oczekują maksymalnego wsparcie od swojego zaawansowanego ekwipunku. Nie inaczej jest w przypadku tej technicznie dopracowanej konstrukcji, która sprawi, że wejście na szczyt będzie lepiej zabezpieczone oraz skutecznie wsparte.", 312000),
(6, 1, "Garmont G-Radikal GTX",  "Buty wysokogórskie Garmont G-Radikal GTX to wysoce zaawansowana konstrukcja sprawdzająca się na trudnych szlakach i wymagających skalnych ścianach, gdy przychodzi Ci podejmować się aktywności typu alpejskiego. Zastosowano tutaj szereg rozwiązań mających zapewnić większe bezpieczeństwo w terenie, a jednocześnie wspierać użytkownika tego modelu na kolejnych kilometrach ścieżek lub metrach skalnych występu. Ta konstrukcja sprawdzi się w okresie przejściowym i latem, gdy mimo cieplejszej aury na wyższych partiach gór zalega śnieg.", 152700),
(6, 2, "Garmont G-Radikal GTX",  "Buty wysokogórskie Garmont G-Radikal GTX to wysoce zaawansowana konstrukcja sprawdzająca się na trudnych szlakach i wymagających skalnych ścianach, gdy przychodzi Ci podejmować się aktywności typu alpejskiego. Zastosowano tutaj szereg rozwiązań mających zapewnić większe bezpieczeństwo w terenie, a jednocześnie wspierać użytkownika tego modelu na kolejnych kilometrach ścieżek lub metrach skalnych występu. Ta konstrukcja sprawdzi się w okresie przejściowym i latem, gdy mimo cieplejszej aury na wyższych partiach gór zalega śnieg.", 152700),
(5, 2, "La Sportiva Trango Tower GTX",  "Buty wysokogórskie La Sportiva Trango Tower GTX to propozycja dla wytrawnych miłośników górskich wędrówek. Zapewnią niezbędne wsparcie techniczne na najbardziej wymagających odcinkach szlaków oraz zadbają o wygodę użytkowania i komfort termiczny, gdy wokół zapanuje mroźna zimowa aura.", 135700),

(3, 1, "Plecak turystyczny Gregory Zulu 30",  "Plecak turystyczny Gregory Zulu 30 - empire blue - pozwoli na podejmowanie się krótkich trekkingów lub szybkiego zdobywania szczytu odbywającego się w jeden dzień. Zmieścisz tutaj cały niezbędny ekwipunek, do którego zawsze będziesz miał wygodny dostęp. Gdziekolwiek wybierzesz się z tym modelem to liczyć możesz na maksymalną stabilność oraz komfortowe dopasowanie sprawiające, że pokonywanie kolejnych kilometrów stanie się o wiele łatwiejsze.", 52700),
(3, 3, "Plecak turystyczny Gregory Zulu 30",  "Plecak turystyczny Gregory Zulu 30 - empire blue - pozwoli na podejmowanie się krótkich trekkingów lub szybkiego zdobywania szczytu odbywającego się w jeden dzień. Zmieścisz tutaj cały niezbędny ekwipunek, do którego zawsze będziesz miał wygodny dostęp. Gdziekolwiek wybierzesz się z tym modelem to liczyć możesz na maksymalną stabilność oraz komfortowe dopasowanie sprawiające, że pokonywanie kolejnych kilometrów stanie się o wiele łatwiejsze.", 53800),
(3, 4, "Plecak turystyczny Gregory Zulu 30",  "Plecak turystyczny Gregory Zulu 30 - empire blue - pozwoli na podejmowanie się krótkich trekkingów lub szybkiego zdobywania szczytu odbywającego się w jeden dzień. Zmieścisz tutaj cały niezbędny ekwipunek, do którego zawsze będziesz miał wygodny dostęp. Gdziekolwiek wybierzesz się z tym modelem to liczyć możesz na maksymalną stabilność oraz komfortowe dopasowanie sprawiające, że pokonywanie kolejnych kilometrów stanie się o wiele łatwiejsze.", 53800),

(1, 2, "Plecak Osprey Kestrel 48",  "Plecak Osprey Kestrel 48 doskonale sprawdzi się na krótszych trekkingach, gdy w góry wybierasz się na kilka dni i chcesz spakować cały niezbędny ekwipunek. Jednak z tego modelu skorzystają także osoby podejmujące się turystyki lodowcowej, gdzie dochodzi konieczność zabierania ze sobą szpeju wspinaczkowego. Wynika to z jego niezwykle stabilnej konstrukcji oraz szeregu szpejarek, w które wepniesz wszego, czego potrzebujesz.", 77000),
(1, 4, "Plecak Osprey Kestrel 48",  "Plecak Osprey Kestrel 48 doskonale sprawdzi się na krótszych trekkingach, gdy w góry wybierasz się na kilka dni i chcesz spakować cały niezbędny ekwipunek. Jednak z tego modelu skorzystają także osoby podejmujące się turystyki lodowcowej, gdzie dochodzi konieczność zabierania ze sobą szpeju wspinaczkowego. Wynika to z jego niezwykle stabilnej konstrukcji oraz szeregu szpejarek, w które wepniesz wszego, czego potrzebujesz.", 78500);




--
--INSERT INTO "stock" ("id_product", "id_size", "pieces") VALUES
--(1, 380,9),
--(1, 390,3),
--(1, 400,12),
--(1, 415,3),
--(1, 420,6),
--(1, 445,2),
--(1, 450,1),
--
--(2, 380,5),
--(2, 390,4),
--(2, 400,2),
--(2, 415,2),
--(2, 420,1),
--(2, 445,1),
--
--(3, 380,2),
--(3, 390,1),
--(3, 420,1),
--
--(4, 410,2),
--(4, 425,3),
--(4, 440,5),
--(4, 450,6),
--
--(5, 380, 4),
--(5, 400,2),
--(5, 415,6),
--(5, 420, 3),
--
--
--(6, NULL, 3),
--(7, NULL, 6),
--(8, NULL, 2),
--(9, NULL, 2),
--(10, NULL, 1);
# --- !Downs
