app.controller('usersController', function($scope, $state, $window, UserService, LoginService) {
    $scope.init = function() {
        LoginService.redirect();

        //chiamata al backend per prendere tutti gli utenti
        UserService.getUsers()
        .then(function(res) {
            $scope.users = [];
            res.data.forEach(function(user) {
                if(!(user.cod_user == $window.localStorage.userCode)) {
                    user.date_of_birth = user.date_of_birth.substring(0,10);
                    $scope.users.push(user);
                }
            });
        });
    }

    $scope.init();

    $scope.profile = function() {
        $state.go('profile', {userCode: $window.localStorage.userCode});
    }

    $scope.logout = function() {
        firebase.auth().signOut();
        $state.go('login');
    }

    $scope.user = function(user) {
        $state.go('profile', {userCode: user.cod_user})
    }

});
