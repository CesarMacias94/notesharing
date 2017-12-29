app.service("UserService", function() {
    //aggiungere nei percorsi http://localhost:8080/
    var _getUser = function (codUser) {
        return $http.get("api/user/"+codCourse);
    }

    return {
        getUser: _getUser
    }
});
