app.controller('courseController', function($scope, $state, $stateParams, $rootScope) {
    console.log("CODICE CORSO ---> ",$rootScope.courseCode);

    $scope.init = function() {
        //chiamata al backend per prendere tutte le note di questo i corso
        $scope.course = {
            name: "Processo E Sviluppo Del Software",
            description: "lorem ipsum",
            notes: [
                {
                    code: "127122017",
                    name: "UML",
                    text: "diagrammi UML"
                },
                {
                    code: "21227122017",
                    name:"Design Pattern",
                    text: "design Pattern"
                }
            ]};
        $scope.notes = $scope.course.notes;
        console.log("NOTE ---> ",$scope.notes);
    }

    $scope.init();

    $scope.note = function(note) {
        //chiamata al backend per prendere tutti le note di un corse, per ora non usata
        $rootScope.noteCode = note.code;
        $state.go('note', {
            name: note.name.split(" ").join("-")
        });
    }
});
