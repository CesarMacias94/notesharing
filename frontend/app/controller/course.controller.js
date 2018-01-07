app.controller('courseController', function($scope, $state, $stateParams, $rootScope, CourseService, NoteService) {
    console.log("CODICE CORSO ---> ", $rootScope.courseCode);

    $scope.init = function() {
        //chiamata al backend per prendere tutti i dati di questo corso
        CourseService.getCourse($rootScope.courseCode)
        .then(function(res) {
            $scope.course = res.data;
            console.log("CORSO ---> ",$scope.course);

            NoteService.getNotesByCourse($scope.course.cod_course)
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
