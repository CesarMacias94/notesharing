app.controller('noteController', function($scope, $state, $stateParams, $rootScope, NoteService) {
    console.log("CODICE NOTA ---> ", $rootScope.noteCode);

    $scope.init = function() {
        //chiamata al backend per prendere i dati di questa nota
        NoteService.getNote($rootScope.noteCode)
        .then(function(res) {
            $scope.note = res.data;
            console.log("NOTA ---> ",$scope.note);
        });
    }

    $scope.init();
});
