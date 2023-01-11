# fitapp

Manapság számtalan sportolónak okoz nehézséget az interneten fellelhető temérdek edzésterv közül választani egyet. Erre a problémára kíván segítséget nyújtani a webalkalmazásom, melynek célja az edzéstervek generálása minimális idő alatt.

Telepítési útmutató:
1. lépés: PostgreSQL telepítése, melynek beszerzése az internet által megannyi weboldalról biztosított. A telepítés során felmerülő felhasználó név és jelszó párosra a 4. lépés során szükségessé válik.
2. lépés: A zökkenőmentes működés érdekében szükséges az alábbi linken (https://drive.google.com/drive/folders/1BVLytHqridIkjikQXPg_paBXnVauk1PA?usp=share_link) megtalálható Fitapp-db nevű fájlt importálni az adatbázisba.
3. lépés: Egy tetszőleges IDE megnyitása, mely alkalmas a Java futtatására.
4. lépés: A projekten belül megtalálható application.properties nevű fájl username és password sorát átírni a PostgreSQL telepítése során megadott adatoktra.
5. lépés: Mindezek után a Java alkalmazás futtatása következik.
6. lépés: Fájlkezelőben szükséges megnyitni a Frontend-hez tartozó mappastruktúrát, majd a fent található elérési út helyére beírni a „cmd” parancsot, aztán enter billentyűt nyomni.
7. lépés: „npm install” parancsot szükséges beírni a konzolba.
8. lépés: Miután véget ért a 7. lépés telepítése, a meglévő konzolba, következő sorba a(z) „npm run serve” parancsot indokolt beírni a Frontend megfelelő működése érdekében.
9. lépés: A konzolon láthatóvá válik a weboldal elérési útja, melyet böngészőbe beírva betöltődik a Fitapp.