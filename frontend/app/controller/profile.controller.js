app.controller('userController', function($scope, $state, $stateParams, $rootScope, UserService, NoteService) {
    console.log("CODICE UTENTE ---> ", $rootScope.userCode);

    $scope.init = function() {
        //la login ci dira il codice da passare
        //chiamata al backend per prendere tutti i dati dell'utente
        UserService.getUser(1)
        .then(function(res) {
            $scope.user = res.data;
            $scope.user.date_of_birth = res.data.date_of_birth.substring(0,10);
            console.log("UTENTE ---> ",$scope.user);

            NoteService.getNotesByUser(1)
            .then(function(res) {
                $scope.notes = res.data;
                console.log("NOTE ---> ",$scope.notes);
            })
        });
    }

    $scope.init();

    $scope.note = function(note) {
        $rootScope.noteCode = note.cod_note;
        $state.go('note', {
            name: note.name.split(" ").join("-")
        });
    }
});
