app.service("UserService", function($http) {
    var _getUser = function (codUser) {
        return $http.get("http://localhost:8080/notesharing/api/user/"+codUser);
    }

    return {
        getUser: _getUser
    }
});
