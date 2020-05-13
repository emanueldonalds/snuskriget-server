# Snuskriget general design
A brain storm document

## Description of game

This game is heavily inspired by the game Dope Wars. The major difference being the locations and the types of drugs.

Snuskriget is a game in which the player buys and sells various substances.
The player is able to travel to a predefined set of locations. When the player travels, the prices may go up or down.

Random events may occur on each time the player arrives to a location such as police razzias, thug encounters and more.
These events may affect the drug prices positively or negatively.

### Locations

* Strandäs
* Malmö
* Åbo
* Närpes
* Stockholm
* Viking Salmonella
* Christiania

### Things to do at a location

* Buy items
* Sell items
* Travel

### Events which may occur on arrival to destination

* Border guard
    * Only occurs when traveling in to finland
    * If the dealer carries more than 4 snus items, there is a chance that the border guard takes it.
    
## Software design

The interactive parts of the game will exist as a web page running on AngularJS. The front end will call the back end when buying/selling. The back end will handle transactions when buying/selling. This enables a vision of multiplayer. 

### Back end

Spring boot application with a REST interface for managing resources.

Secured with spring security.

### Front end

AngularJS single page application handling interaction with the user.

Might require the user to log in before playing.

### Authentication

Keycloak authn/authz for managing user logins and issuing of tokens.