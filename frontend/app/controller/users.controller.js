app.controller('usersController', function($scope, $state, $rootScope, UserService) {
    $scope.init = function() {
        //rimuovere se stessi dai risultati
        //chiamata al backend per prendere tutti gli utenti
        UserService.getUsers()
        .then(function(res) {
            $scope.users = res.data;
            console.log("CORSI ---> ",$scope.users);
        });
    }

    $scope.init();

    $scope.user = function(user) {
        $rootScope.userCode = user.cod_user;
        //passare il codice utente
        $state.go('profile');
    }

});
