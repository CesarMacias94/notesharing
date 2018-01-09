app.controller('userController', function($scope, $state, $stateParams, $rootScope, UserService, NoteService) {
    console.log("CODICE UTENTE ---> ", $rootScope.userCode);

    $scope.init = function() {
        //la login ci dira il codice da passare
        //chiamata al backend per prendere tutti i dati dell'utente
        UserService.getUser(1)
        .then(function(res) {
            $scope.user = res.data;
            console.log("UTENTE ---> ",$scope.user);

            NoteService.getNotesByUser(1)
            .then(function(res) {
                $scope.notes = res.data;
                console.log("NOTE ---> ",$scope.notes);
            })
        });
    }

    $scope.init();

    //metodo per visualizzare la nota
});
