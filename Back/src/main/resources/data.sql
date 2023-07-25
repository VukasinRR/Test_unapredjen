INSERT INTO adresa (id, ulica, broj) VALUES (1,'Bulevar Cara Lazara', 5);
INSERT INTO adresa (id, ulica, broj) VALUES (2, 'Dalmatinska', 7);

INSERT INTO korisnik (id, e_mail, korisnicko_ime, lozinka, ime, prezime, uloga, adresa_id)
              VALUES (1,'miroslav@maildrop.cc','miroslav','$2y$12$NH2KM2BJaBl.ik90Z1YqAOjoPgSd0ns/bF.7WedMxZ54OhWQNNnh6','Miroslav','Simic','ADMIN',1);
INSERT INTO korisnik (id, e_mail, korisnicko_ime, lozinka, ime, prezime, uloga, adresa_id)
              VALUES (2,'tamara@maildrop.cc','tamara','$2y$12$DRhCpltZygkA7EZ2WeWIbewWBjLE0KYiUO.tHDUaJNMpsHxXEw9Ky','Tamara','Milosavljevic','KORISNIK',2);
INSERT INTO korisnik (id, e_mail, korisnicko_ime, lozinka, ime, prezime, uloga, adresa_id)
              VALUES (3,'petar@maildrop.cc','petar','$2y$12$i6/mU4w0HhG8RQRXHjNCa.tG2OwGSVXb0GYUnf8MZUdeadE4voHbC','Petar','Jovic','KORISNIK',2);

INSERT INTO festival (id, naziv) VALUES (1, 'Exit');
INSERT INTO festival (id, naziv) VALUES (2, 'SeaDance');

INSERT INTO izvodjac (id, ime, zanr, drzava,broj_clanova) VALUES (1,'Manu Chao','Funk','Ftancuska',1);
INSERT INTO izvodjac (id, ime, zanr, drzava,broj_clanova) VALUES (2,'RHCP','Rock','USA',5);

INSERT INTO nastup (id, festival_id, izvodjac_id) VALUES (1,1,1);
INSERT INTO nastup (id, festival_id, izvodjac_id) VALUES (2,2,1);
INSERT INTO nastup (id, festival_id, izvodjac_id) VALUES (3,2,2);
INSERT INTO nastup (id, festival_id, izvodjac_id) VALUES (4,1,2);



