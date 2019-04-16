
var games;
// var gamePlayers;

function dataCall () {
    fetch("http://localhost:8080/api/games", {
        method: "GET"
    }).then(function (response) {
        if (response.ok) {
            return response.json();

        }
        throw new Error(response.statusText);
    }).then(function (json) {

        games = json;
        creatingList(games);
        // gamePlayers = games[1].gamePlayers;
        console.log(games, 1111);

    }).catch(function (error) {
        console.log("Request failed: " + error.message);
    });

}
dataCall ();

function creatingList(games) {

for (let i = 0; i < games.length; i++) {
    var gameList = document.getElementById("gameList");
    var orLlist = document.createElement("ol");
        gameList.appendChild(orLlist);
    var list = document.createElement("li");
    orLlist.appendChild(list);
        list.textContent = "Game ID:" + " " + games[i].id +"was created" + " " + games[i].created;
}
}
