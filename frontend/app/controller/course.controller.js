app.controller('courseController', function($scope, $state, $stateParams, $window, CourseService, NoteService, LoginService) {
    $scope.init = function() {
        LoginService.redirect();

        //chiamata al backend per prendere tutti i dati di questo corso
        CourseService.getCourse($window.localStorage.courseCode)
        .then(function(res) {
            $scope.course = res.data;

            NoteService.getNotesByCourse($scope.course.cod_course)
            .then(function(res) {
                if(res == [])
                    $scope.notesAvailability = "flex center";
                else $scope.notesAvailability = "none";
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
