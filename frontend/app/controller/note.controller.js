app.controller('noteController', function($scope, $state, $stateParams, $rootScope, NoteService, LoginService) {
    $scope.init = function() {
        LoginService.redirect();

        //chiamata al backend per prendere i dati di questa nota
        NoteService.getNote($rootScope.noteCode)
        .then(function(res) {
            $scope.note = res.data;
        });
    }

    $scope.init();

    $scope.profile = function() {
        $state.go('profile', {userCode: $rootScope.userCode});
    }

    $scope.logout = function() {
        firebase.auth().signOut();
        $state.go('login');
    }
});
