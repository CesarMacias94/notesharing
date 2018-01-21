app.controller('noteController', function($scope, $state, $stateParams, $window, NoteService, LoginService) {
    $scope.init = function() {
        LoginService.redirect();

        //chiamata al backend per prendere i dati di questa nota
        NoteService.getNote($window.localStorage.noteCode)
        .then(function(res) {
            $scope.note = res.data;
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
});
