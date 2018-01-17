app.service("UserService", function($http) {
    var _getUsers = function () {
        return $http.get("http://localhost:8080/notesharing/api/users");
    }

    var _getUser = function (codUser) {
        return $http.get("http://localhost:8080/notesharing/api/user/"+codUser);
    }

    var _addUser = function (user) {
        return $http.post("http://localhost:8080/notesharing/api/adduser", user);
    }

    return {
        getUsers: _getUsers,
        getUser: _getUser,
        addUser: _addUser
    }
});
