# LutemonFighter
Olio-ohjelmoinnin harjoitustyö
Antti Kuru, Juho Rekonen
Työn kuvaus
•	Harjoitustyössä käyttäjä pääsee pelaamaan Pokemoneja vastaavilla Lutemoneilla. Lutemoneja on viittä erilaista väriä ja tyyppiä (visuaalinen kuva), joita käyttäjä pystyy halutessaan luomaan. Näitä lutemoneja voi luomisen jälkeen siirtää treenaamaan tai vaihtoehtoisesti taistelemaan. Taistelu tapahtuu vuoropohjaisesti, kuten oikeissakin Pokemon-peleissä, eli vuorotellen toinen hyökkää ja toinen puolustaa. Lutemonien siirtelyn lisäksi niiden tilastoja pääsee tarkastelemaan. Sinne tallentuu esimerkiksi treeni- ja taistelukerrat sekä voitot ja häviöt. Lutemonien tallentaminen tiedostoon ja sieltä niiden lataaminen on myös mahdollista.

**Ominaisuudet (pakollisten ominaisuuksien lisäksi)**

•	Recycleview: Lutemonien listaus useassa eri aktiviteetissa, jokaisessa käytetty RecycleView-komponenttia (3p)

•	Visuaalinen kuva: Lutemoneja luodessa on näille mahdollista valita kuva / avatar, joka näytetään käyttäjälle tilastoja tarkastellessa (2p)

•	Tilastot: Mahdollisuus lutemonien tilastojen tarkasteluun. Tilastoitavia tietoja ovat esimerkiksi ”perus statsit” kuten hyökkäys, puolustus ja elämäpisteet, sekä niiden lisäksi muun muassa treeni- ja taistelukerrat (2p)

•	Kuoleman poisto: Lutemonien hävitessä taisteluita ne pokemoneiden tapaan ”pyörtyvät” eli vain häviävät. Tällöin ne jäävät henkiin eikä niitä poisteta listauksista. (1p)

•	Satunnaisuus: Taistelun yhteydessä lutemonilla on 20 % mahdollisuus käyttää superiskua, joka normaalin hyökkäyksen sijaan tekee +2 vahinkoa. Lisäksi puolustavalla lutemonilla on 10 % mahdollisuus väistää vastaantuleva hyökkäys. Superiskua ei kuitenkaan voi väistää. (1p)

•	Tietojen tallennus ja lataus: Käyttäjä voi halutessaan tallentaa lutemonit tiedostoon ja ladata ne sieltä myöhemmin. (2p)

Eli yhteensä 11 pisteen edestä lisäominaisuuksia.





Työnjako meni todella hyvin eli työmäärällisesti 50% - 50%.

**Työnjako (aktiviteetit) **

•	Visuaalinen ilme näkymiin (Juho)

•	Lutemonien lisäys (Antti)

•	Päänäkymä / kotinäkymä (Antti)

•	Lutemonien listaus niitä siirtäessä (Antti)

•	Lutemonien listaus tilastoja tarkastellessa (Juho)

•	Taistelu – ja treeninäkymä (Juho)

•	view.xml tiedostot (Juho)

**Työnjako (luokat ja toiminnallisuudet)**

•	Lutemonien lisäys eli AddLutemonActivity (Antti)

•	Lutemon luokka sekä siitä periytyvät luokat eri väreille (Antti)

•	MainActivity (Antti)

•	Taistelu + satunnaisuus (Juho)

•	Treenaaminen (Juho)

•	Storage (Antti)

•	Tallennus ja lataaminen (Antti)

•	Lutemonien listaus (Antti)

•	Tilastot (Juho)




![image](https://user-images.githubusercontent.com/128390200/235636057-7e6eea15-af65-4575-b4e5-54fa428ab6e1.png)
