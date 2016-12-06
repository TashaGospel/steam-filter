## Steam games database
The server will fetch the list of all available games on Steam, and send requests to Steam's API to ask for details about each game (limited to 200 requests per 5 minutes, which means this will take around 13 hours to complete). This information will then be saved on our own database for easy access later.

Every 2 days, the database will be updated using the same process, but games which are older than 1 year will no longer be updated, making subsequent updates much faster.

The database is MongoDB, and games will be stored in multiple collections to improve performance.

For each game, the following information is stored: name, appid, header image URL, release date, price, number of reviews, average review score.

## Query
When the front-end queries the server, the response will be 10 games at a time to reduce load on the bandwidth. MongoDB supports pagination to make this easier.

## Website layout
TO BE COMPLETED

## Back-end for the front-end
TO BE COMPLETED

Re-frame is the central pattern.

## Deployment
The project is hosted on Heroku.

The uberjar will allow runtime parameters to be specified to select between "server" and "database" mode. The "server" mode is the default, and acts as the server. The "database" mode handles the periodic update of the database.

On Heroku, the "web" process will run in "server" mode, while the "worker" process will run in "database" mode.