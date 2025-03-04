Niklas Strobl 4CHIT

# MidEng GK8.2 Document Oriented Middleware using MongoDB [GK/EK] - 4h

### Mongo DB:

Der Erste Schritt ist das Aufsetzten einer MongoDB in Docker 

Unter Resources eine properties Datei erstellt.

Docker pull mongo (Login benötigt)

![](C:\Users\nikla\AppData\Roaming\marktext\images\2025-03-04-15-01-38-image.png)

![](C:\Users\nikla\AppData\Roaming\marktext\images\2025-03-04-15-02-19-image.png)

**Docker Container** auf Port 27017

![](C:\Users\nikla\AppData\Roaming\marktext\images\2025-03-04-15-03-52-image.png)

### DB exekutieren

In der Kommandozeile:

docker exec -it mongo bash
mongosh

use test

![](C:\Users\nikla\AppData\Roaming\marktext\images\2025-03-04-15-36-50-image.png)

#### Collections CRUD

use datenbank
db.createCollection("neue Collection");  

db."Collection".drop();  Löschen einer Collection



**insertOne**

insert({...}) ist depricated

<img src="file:///C:/Users/nikla/AppData/Roaming/marktext/images/2025-03-04-15-38-23-image.png" title="" alt="" width="482">

db.products.insertOne({ "warehouseID": "11111","productID":"00-123456789","productName":"nstrobl","productCategory":"Produkt","productQuantity":1000})

**deleteOne({...})**

![](C:\Users\nikla\AppData\Roaming\marktext\images\2025-03-04-15-39-57-image.png)

**updateOne({...})**

![](C:\Users\nikla\AppData\Roaming\marktext\images\2025-03-04-15-41-29-image.png)



Mit show collections die Kollektionen anzeigen lassen und dann die Inhalte der jeweiligen Kollektion mit db."kollektion".find( ausgeben lassen)

![](C:\Users\nikla\AppData\Roaming\marktext\images\2025-03-04-15-45-58-image.png)



## Code

 @Document(collection = "products")

Wichtig für die Collections, wird in der Zeile vor public class ... angeführt. 

@Id 

generiert automatisch eine individuelle Id 

Properties bearbeitet: 

spring.data.mongodb.host=localhost  
spring.data.mongodb.port=27017  
spring.data.mongodb.database=warehouse

damit die Verbindung zur DB funktionieren kann. 

## Fragen:

**Nennen Sie 4 Vorteile eines NoSQL Repository im Gegensatz zu einem relationalen DBMS**

1. Skalierbarkeit: NoSQL-Datenbanken sind horizontal skalierbar.
2. Flexibilität: Schemafrei, ermöglicht dynamische Änderungen an der Datenstruktur.
3. Performance: Schnelle Lese- und Schreiboperationen, besonders bei großen Datenmengen.
4. Verteilte Speicherung: Gute Unterstützung für verteilte Systeme und Replikation.

**Nennen Sie 4 Nachteile eines NoSQL Repository im Gegensatz zu einem relationalen DBMS**

1. Konsistenz: Oft eventual consistency statt ACID-Transaktionen.
2. Fehlende Standardisierung: Kein einheitlicher Abfrage-Standard wie SQL.
3. Weniger komplexe Abfragen: Fehlende Joins erfordern oft zusätzliche Verarbeitung.
4. Begrenzte Unterstützung für Transaktionen: Besonders problematisch für Finanzanwendungen.

**Welche Schwierigkeiten ergeben sich bei der Zusammenführung der Daten?**  
Daten können in unterschiedlichen Formaten, Strukturen und Systemen gespeichert sein, was Konvertierung und Harmonisierung erfordert. Redundanzen und Inkonsistenzen müssen erkannt und gelöst werden. Unterschiedliche Konsistenzmodelle können zu Konflikten führen.

**Welche Arten von NoSQL Datenbanken gibt es?**

1. Key-Value-Datenbanken
2. Dokumentenorientierte Datenbanken
3. Spaltenorientierte Datenbanken
4. Graphdatenbanken

**Nennen Sie einen Vertreter für jede Art?**

1. Key-Value: Redis
2. Dokumentenorientiert: MongoDB
3. Spaltenorientiert: Apache Cassandra
4. Graph: Neo4j

**Beschreiben Sie die Abkürzungen CA, CP und AP in Bezug auf das CAP Theorem**

- **CA (Consistency & Availability)**: Garantiert Konsistenz und Verfügbarkeit, aber keine Partitionstoleranz (z. B. traditionelle relationale DBs).
- **CP (Consistency & Partition Tolerance)**: Garantiert Konsistenz und Partitionstoleranz, aber kann unzugänglich sein (z. B. HBase).
- **AP (Availability & Partition Tolerance)**: Garantiert Verfügbarkeit und Partitionstoleranz, aber nicht immer Konsistenz (z. B. DynamoDB).

**Mit welchem Befehl können Sie den Lagerstand eines Produktes aller Lagerstandorte anzeigen?**

![](C:\Users\nikla\AppData\Roaming\marktext\images\2025-03-04-16-25-44-image.png)

**Mit welchem Befehl können Sie den Lagerstand eines Produktes eines bestimmten Lagerstandortes anzeigen?**


