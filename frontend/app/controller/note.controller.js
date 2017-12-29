app.controller('noteController', function($scope, $state, $stateParams, $rootScope, NoteService) {
    console.log("CODICE NOTA ---> ", $rootScope.noteCode);

    $scope.init = function() {
        //chiamata al backend per prendere i dati di questa nota
        /*NoteService.getNote($rootScope.noteCode)
        .success(function(res) {
            $scope.note = res;
        });*/
        $scope.note = {
            code: "127122017",
            name: "Prova",
            text: "nota di prova, questa sezione sara mooolto più lunga di così"
        };
        console.log("NOTA ---> ",$scope.note);
    }

    $scope.init();
});
