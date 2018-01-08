app.controller('userController', function($scope, $state, $stateParams, $rootScope, UserService, NoteService) {
    console.log("CODICE UTENTE ---> ", $rootScope.userCode);

    $scope.init = function() {
        //chiamata al backend per prendere tutti i dati dell'utente
        /*UserService.getUser($rootScope.courseCode)
        .then(function(res) {
            $scope.user = res.data;
            console.log("UTENTE ---> ",$scope.course);

            NoteService.getNotesByUser($rootScope.userCode)
            .then(function(res) {
                $scope.notes = res.data;
                console.log("NOTE ---> ",$scope.notes);
            })
        });*/
    }

    $scope.init();

});
