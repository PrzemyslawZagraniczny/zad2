# zad2
  <h1 class="detail"> Sklep - projekt polecenia 2 -4</h1>

<p class="detail"> Pierwsze trzy przyciski są widoczne dla klienta. Pozostałe to panel Administracyjny.</p>
<p>Nie wszystkie opcje są w przyciskach.</p>
<p>Program nie ma pełnej funkcjonalności sklepu. Skupiałem się na różnorodności a ta nie na funkcjonalnym sklepie</p>
<p>I tak w zakładce sklep wybiramy towar ale lista jest złączeniem (join) po cechach produktu z kluczy obcych (kolor i rozmiar) tak więc nie widzimy jaki rozmiar butów dodajemy do kosza</p>
<p><b> Stan magazynu</b>b> zawiera liczbę sztuk powiązaną z rozmiarem oraz danym produktem (nie rozdzielam tutaj tego na kolor nie wiemy jakiego koloru jest but - moja wina, źle znormalizowałem bazę)</p>
<p><b>Aktualizuj Magazyn</b> pozwala dodać sztuki dla danego produktu</p>
<p><b>Usuń z magazynu</b> usuwa po sztuce lub cały zestaw produktów. Produkty znikają z ekranu w bazie są widziane jako pieces == 0</p>
<p>magazyn (tabelka stock) to nie produkt - są odzielnymi encjami</p>
<p>Wiem, że dodawanie do koszyka i usuwanie z magazynu (bo tak to robię - nie przy finalizowaniu zakupu) powinny być atomowe - w tranzakcji - tutaj tego nie zaimplementowałem. Mało czasu i nie wiem jak utworzyć transakcje )</p>
<p>Nie wiem też jak zaimplementować kaskadowe usuwanie zależnych krotek w tablach powiązanych (CASCADE ON DELETE). W w tabelach to definiuję i nie działa.</p>
<p> dodaję w definicji klas pochodnych od Table tworzenie klucza np.:</p>
<p><i>    def discountFK = foreignKey("disc_fk",discount, col)(_.id, onUpdate=ForeignKeyAction.Restrict, onDelete = ForeignKeyAction.Cascade)</i></p>
<p>ale nie przynosi to żadnego skutku. W SQL Browser usunięcie wiersza zależnego usuwa kaskadowo pozostałe więc baza jest poprawna. Nie wiem czemu.</p>
<p> ostatecznie zakomentowałem referencje obce bo wstrzykiwanie obiektów <i>xxxxTable</i>  do innych klas Table powodowało błąd:</p>
<p><u>private value categoryRepository escapes its defining scope as part of type slick.lifted.ForeignKeyQuery</u></p>
<p> serializacja JSON jest dla wszystkich tabel za wyjątkiem PTU Tutaj Json nie chce konwertować typu Char (rodzaj podatku - 'A', 'B', C', 'D'). Mogłem zapsać do stringa ale...</p>

