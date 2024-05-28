# Team-Elite projektstyringsværktøj

## Introduktion

Velkommen til Team-Elite projektstyringsværktøj, et værktøj til projektoprettelse designet til at hjælpe dig med at administrere dine projekter effektivt. Denne vejledning vil hjælpe dig med at installere og køre programmet samt give en oversigt over dets funktioner.

## Forudsætninger

For at køre Team-Elite projektstyringsværktøj skal du have følgende installeret på dit system:

- MySQL Workbench
- Java
- Azure (Microsoft)
- Thymeleaf
- SpringBoot
- HTML
- CSS
- Qodana
  

## Installationsvejledning og Opsætning

1. Installér Java version 8 eller en nyere version fra den officielle hjemmeside.
2. Installér MySQL Workbench fra den officielle hjemmeside.
3. Klon projektet fra repositoryet.
4. Åbn projektet i din foretrukne IDE.

## Databaseopsætning

1. Åbn MySQL Workbench.
2. Kør database.sql-scriptet, som følger med Team-Elite projektet, for at oprette den nødvendige databasestruktur.

## Brugeroprettelse

Efter opsætningen af databasen skal du oprette en bruger til Team-Elite projektstyringsværktøj. Dette er nødvendigt for at få adgangskodekryptering til at fungere korrekt.

## Kørsel af Programmet

1. Sørg for, at din MySQL-server kører, før du starter programmet.
2. Kør projektet fra din IDE.
3. Åbn en webbrowser og navigér til http://localhost:8080. Du vil se login-siden.
4. Klik på registreringsknappen for at oprette en ny bruger.
5. Indtast brugernavn og adgangskode, og klik derefter på login-knappen. Du vil se dashboard-siden.
6. Klik på knappen 'Tilføj Projekt' for at tilføje et nyt projekt.

## Funktioner

Team-Elite projektstyringsværktøj tilbyder følgende funktioner for at hjælpe dig med at administrere dine projekter effektivt:

### Projektstyring

- Tilføj Projekter: Opret nye projekter og tildel dem til din bruger-ID.
- Slet Projekter: Fjern projekter, der ikke længere er nødvendige.
- Vis Projekter:
  - Detaljeret projekt frontside 
  - Detaljeret Visning når du trykker rediger projekt

### Brugerstyring

- Rediger projekt: Opdater dine projekt oplysninger i midten af applikationen.
- Slet Project: Fjern dit projekt, hvis nødvendigt.

### Sessionsstyring

- HTTP-sessions: Sessions er aktiveret, hvilket betyder, at du vil blive logget ud, hvis du er inaktiv i en vis periode. Du skal logge ind igen for at fortsætte med at bruge applikationen.

### Yderligere Information

- Projekter er tildelt til den bruger-ID, du oprettede under opsætningen.

Tak fordi du bruger Team-Elite projektstyringsværktøj! Hvis du har spørgsmål eller støder på problemer, se venligst afsnittet om fejlfinding eller kontakt support.

## Fejlfinding

- Databaseforbindelsesproblemer: Sørg for, at din MySQL-server kører, og at forbindelsesdetaljerne i konfigurationsfilen er korrekte.
- Problemer med brugeroprettelse: Kontroller, at du har de nødvendige tilladelser til at oprette brugere i MySQL.
- Sessionstimeouts: Hvis du ofte bliver logget ud, overvej at justere sessionstimeout-indstillingerne i applikationskonfigurationen.

## Support

Hvis du har brug for hjælp, kontakt venligst support. Berzoo2904@gmail.com
