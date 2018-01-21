app.controller('userController', function($scope, $state, $stateParams, $window, UserService, NoteService, LoginService) {
    $scope.init = function() {
        LoginService.redirect();

        //chiamata al backend per prendere tutti i dati dell'utente
        UserService.getUser($stateParams.userCode)
        .then(function(res) {
            $scope.user = res.data;
            $scope.user.date_of_birth = res.data.date_of_birth.substring(0,10);

            NoteService.getNotesByUser($stateParams.userCode)
            .then(function(res) {
                $scope.notes = res.data;
            })
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

    $scope.note = function(note) {
        $window.localStorage.noteCode = note.cod_note;
        $state.go('note', {
            name: note.name.split(" ").join("-")
        });
    }
});
