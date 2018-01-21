app.controller('courseController', function($scope, $state, $stateParams, $rootScope, CourseService, NoteService, LoginService) {
    $scope.init = function() {
        LoginService.redirect();

        //chiamata al backend per prendere tutti i dati di questo corso
        CourseService.getCourse($rootScope.courseCode)
        .then(function(res) {
            $scope.course = res.data;

            NoteService.getNotesByCourse($scope.course.cod_course)
            .then(function(res) {
                $scope.notes = res.data;
            })
        });
    }

    $scope.init();

    $scope.profile = function() {
        $state.go('profile', {userCode: $rootScope.userCode});
    }

    $scope.logout = function() {
        firebase.auth().signOut();
        $state.go('login');
    }

    $scope.note = function(note) {
        $rootScope.noteCode = note.cod_note;
        $state.go('note', {
            name: note.name.split(" ").join("-")
        });
    }
});
