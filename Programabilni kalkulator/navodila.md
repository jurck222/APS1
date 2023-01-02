- echo - v vrstici izpiše vrh sklada 0 (sklad pusti nespremenjen); če je sklad prazen, izpiše prazno vrstico <br />
- pop - odstrani vrh sklada 0 <br />
- dup - podvoji vrh sklada 0 (x -> x x)<br />
- dup2 - podvoji par na vrhu sklada 0 (x y -> x y x y)<br />
- swap - zamenja vrhnja dva elementa sklada 0 (x y -> y x)<br />
Naslednje operacije zamenjajo vrh glavnega  sklada z ustreznim rezultatom (x -> y):<br />

- char - vrh sklada 0 zamenja z znakom, ki ima ASCII/Unicode kodo vrha sklada<br />
- even - vrh sklada 0 zamenja z 1, če je vrh sod, sicer z 0<br />
- odd - vrh sklada 0 zamenja z 1, če je vrh lih, sicer z 0<br />
- ! - vrh sklada 0 zamenja s faktorielo vrha<br />
- len - vrh sklada 0 zamenja z dolžino elementa na vrhu<br />

Naslednje operacije zamenjajo vrhnja dva elementa glavnega sklada z ustreznim rezultatom (x y -> r):<br />

- <> - primerja zgornja dva elementa (x y) sklada 0 in na sklad porine 1 (če x <> y) ali 0 (če x == y)<br />
- < - primerja zgornja dva elementa sklada 0 in na sklad porine 1 (če x < y) ali 0 (sicer)<br />
- <= - primerja zgornja dva elementa sklada 0 in na sklad porine 1 (če x <= y) ali 0 (sicer)<br />
- == - primerja zgornja dva elementa sklada 0 in na sklad porine 1 (če x == y) ali 0 (sicer)<br />
- \> - primerja zgornja dva elementa sklada 0 in na sklad porine 1 (če x > y) ali 0 (sicer)<br />
- \>= - primerja zgornja dva elementa sklada 0 in na sklad porine 1 (če x >= y) ali 0 (sicer)<br />
- \+ - na sklad 0 porine vsoto vrhnjih dveh elementov sklada<br />
- \- - na sklad 0 porine razliko vrhnjih dveh elementov sklada<br />
- \* - na sklad 0 porine zmnožek vrhnjih dveh elementov sklada<br />
- / - na sklad 0 porine kvocient (celoštevilsko deljenje) vrhnjih dveh elementov sklada<br />
- % - na sklad 0 porine ostanek po deljenju elementa pod vrhom z elementom na vrh<br />
- . - stakne (združi, zlepi) vrhnja dva elementa sklada 0 v en element (x y -> xy)<br />
- rnd - na sklad 0 porine naključno število, ki ima vrednost >= x in <= y <br />

Naslednje operacije omogočajo izvedbo pogojnega stavka (izpolnjenost pogoja hranimo v interni spremeljivki):<br />

- then  - z glavnega sklada 0 vzame vrhnje število; če je to različno od 0, nastavi izpolnjenost pogoja na true, sicer pa na false<br />
- else - zanika izpolnjenost pogoja<br />
- ?... - vsak ukaz, ki se začne z ?, se izpolni (ali pa ne) glede na prednastavljeno izpolnjenost pogoja<br />

Za delo s poljubnim skladom (glavnim ali pomožnimi) imamo na voljo spodnje ukaze. Pri tem velja, da število na vrhu glavnega sklada 0 določa indeks sklada, nad katerim se izvaja ukaz:<br />

- print - v vrstici izpiše vsebino sklada (z indeksom, ki je podan na vrhu glavnega sklada 0) od dna do vrha <br />
- clear – izprazne sklad (z indeksom, ki je podan na vrhu glavnega sklada 0)<br />
- run – izvede vse ukaze na (pomožnem) skladu (z indeksom, ki je podan na vrhu glavnega sklada 0) od dna do vrha (sklad ostane nespremenjen)<br />
- loop - izvede vse ukaze na (pomožnem) skladu (z indeksom, ki je podan na vrhu glavnega sklada 0) od dna do vrha (sklad ostane nespremenjen), pri čemer to ponovi <br tolikokrat, kot je podano s  številom pod vrhom sklada 0<br />
- fun – na pomožni sklad  (z indeksom, ki je podan na vrhu glavnega sklada 0) zapiše toliko naslednjih ukazov, kolikor določa število pod vrhom glavnega sklada 0 <br />
- move – z glavnega sklada prenese na pomožni sklad  (z indeksom, ki je podan na vrhu glavnega sklada 0) toliko elementov, kolikor določa število pod vrhom glavnega sklada 0 (elementi se prenesejo eden za drugim)<br />
- reverse - obrne vrstni red vseh elementov na skladu  (z indeksom, ki je podan na vrhu glavnega sklada 0) - u v x y z -> z y x v u<br />

Če ukaz ni na seznamu zgoraj naštetih, potem gre za element (število ali niz), ki se porine na vrh glavnega sklada 0 (push).<br />
