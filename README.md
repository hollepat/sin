# SIN

__Software Architecture__ - komponenty/ aplikaci či částí aplikace používající design patterny s jasným důvodemd

## Hodina 2

### Monolitická aplikace

- Vhodné pro měnší aplikace

### Vícevrstevná architektůra

_BusinessObjects_ - POJOs object
_repository, DAO_ - CRUD, získává data
_service_ - logika (visitor, adaptér, state, strategy)
_controller_ - přístupy, API k servisám (facade se používá mezi service a controller)
_cache_ - 
_FrontEnd_ -


### Load Balancer
`
Client -> Dispatcher -> multiple workers -> database to each worker
`

### Spring Boot (technologie používané s tím)

[Spring boot inititalizer:](https://start.spring.io)

Jar a War -> Jar spíše pro serverside aplikace a War je dělán spíše pro webové aplikace. Jenom doporučené použití.
Maven\Gradle -> package managment systems

xml - data a sémantická informace
html - struktůra jak reprezentova data
JSON - 

deploy - vezmu JAR a spustím

mvn install - localne nainstaluje dependency do .m2 složky pro všechny projekty
mvn clean - smaže dependency
mvn package - ideální pro jenkins, stáhne dependency pro projekt


### APP DESIGN

obrázek s panáčkem a databází !!!!

- Kde můžu použít UML?

> V každý fázi vývoje. Analýza, návrh, požadavky...

- Kde můžu použít anotace?

> Kde se to hodí.

- Kam se hodí cache?

> Čím blíž ke klientovi tím míň paměti, ale větší rychlost.

- Loose coupling and high collison. Antipattern -> sluníčko - všechny services závislé na jedné komponentně.

- Listener je implementace design patternu observer. Observable a observer.

>Listener je FE, controller nebo service.
>Observer na nejaky separatni service.

### Software Design

#### ORM features
Locking - 2 users are modifying the same object/entity

#### Service Layer

DPI - constructor, setter, attribute

#### Recursive types
1. simple
2. linear
3. cascade

# Ukol 5

- 3 testy pro 3 services