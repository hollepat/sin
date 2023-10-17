# SIN

__Software Architecture__ - komponenty/ aplikaci či částí aplikace používající design patterny s jasným důvodemd

## Hodina 2

### Monolitická aplikace

- Vhodné pro měnší aplikace

### Vícevrstevná architektůra

_BusinessObjects_ - POJOs object
_repository, DAO_ - CRUD, získává data
_service_ - logika (visitor, adaptér, state, strategy)
controller - přístupy, API k servisám (facade se používá mezi service a controller)
cache - 
FrontEnd -


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
