# Gestione di istanze di classi e studenti

```mermaid
---
title: it.edu.marconiverona.listhashmapinstances
---

classDiagram
namespace listhashmapinstances {
                class ClasseSC
                class StudenteSC
                class ListHashMapInstances
            }
ClasseSC "1" o-- "N" ClasseSC : mappaClasseSC
StudenteSC "1" o-- "N" StudenteSC : mappaStudenteSC
```

Questo progetto Java dimostra l'utilizzo di una struttura dati basata su una mappa per gestire istanze di classi e studenti. Sono fornite tre classi principali:

## ListHashMapInstances.java

```mermaid
classDiagram
class ListHashMapInstances {
    +ListHashMapInstances()
    +void main(String args)$
}
```

Questa classe contiene il metodo principale `main` che illustra l'utilizzo delle istanze di `ClasseSC` e `StudenteSC`. Viene creato un insieme di istanze di entrambe le classi, vengono aggiunti studenti alle classi e vengono visualizzate informazioni sulle classi e sugli studenti.

## ClasseSC.java

```mermaid
classDiagram
class ClasseSC {
    -int id
    -String name
    -Map~Integer, ClasseSC~ mappaClasseSC$
    -List~Integer~ listaIdStudenteSC
    +ClasseSC(int id,String name)
    +int getId()
    +void setId(int id)
    +String getName()
    +void setName(String name)
    +String toString()
    +ClasseSC getClasseSCbyId(int id)$
    +void removeClasseSCById(int id)$
    +void addStudenteSCId(int idStudenteSC)
}
ClasseSC "1" o-- "N" ClasseSC : mappaClasseSC
```

Rappresenta un'entità di classe nel sistema. Ogni istanza di questa classe corrisponde a una classe nel sistema e mantiene una lista di ID studente associati ad essa. Alcuni metodi significativi includono:

- `getClasseSCbyId(int id)`: Restituisce un'istanza di `ClasseSC` corrispondente all'ID specificato.
- `removeClasseSCById(int id)`: Rimuove un'istanza di `ClasseSC` corrispondente all'ID specificato.
- `addStudenteSCId(int idStudenteSC)`: Aggiunge un ID studente alla lista di ID studente associati a questa istanza di classe.

## StudenteSC.java

```mermaid
classDiagram
class StudenteSC {
    -int id
    -String matricola
    -Map~Integer, StudenteSC~ mappaStudenteSC$
    -int idClasseSC
    +StudenteSC(int id,String matricola)
    +int getId()
    +void setId(int id)
    +String getMatricola()
    +void setMatricola(String matricola)
    +String toString()
    +int getIdClasseSC()
    +void setIdClasseSC(int idClasseSC)
    +StudenteSC getStudenteSCbyID(int id)$
    +void removeStudenteSCById(int id)$
}
StudenteSC "1" o-- "N" StudenteSC : mappaStudenteSC
```

Rappresenta un'entità studente nel sistema. Ogni istanza di questa classe corrisponde a uno studente nel sistema e mantiene un mapping degli ID studente alle istanze studente. Alcuni metodi significativi includono:

- `getStudenteSCbyID(int id)`: Restituisce l'istanza di `StudenteSC` corrispondente all'ID specificato.
- `removeStudenteSCById(int id)`: Rimuove l'istanza di `StudenteSC` corrispondente all'ID specificato.

## Utilizzo

Per utilizzare questo progetto, è sufficiente eseguire la classe `ListHashMapInstances.java`, che contiene il metodo principale. È possibile modificare e aggiungere istanze di classi e studenti a piacimento per testare la funzionalità del codice.

```bash
javac ListHashMapInstances.java
java ListHashMapInstances
```
