app.controller('addnoteController', function($scope, $state, $window, CourseService, NoteService, LoginService) {
    $scope.note;
    $scope.name;
    $scope.text;
    $scope.course =  "Choose A Course";

    $scope.init = function() {
        LoginService.redirect();

        //chiamata al backend per prendere tutti i corsi
        CourseService.getCourses()
        .then(function(res) {
            $scope.courses = [];
            angular.forEach(res.data, function(data) {
                $scope.courses.push(data);
            });
        });
    }

    $scope.init();

    $scope.profile = function() {
        console.log("SESSION ---> ",$window.localStorage);
        $state.go('profile', {userCode: $window.localStorage.userCode});
    }

    $scope.logout = function() {
        firebase.auth().signOut();
        $state.go('login');
    }

    $scope.chooseCourse = function(course) {
        $scope.course = course.name;
        $scope.cod_course = course.cod_course;
    }

    $scope.save = function(name, text, course) {
        if(course != "Choose A Course") {
            $scope.note = {
                text: text,
                name: name,
                cod_user: $window.localStorage.userCode,
                cod_course: $scope.cod_course
            };
            //chiamata al backend per salvare il post
            NoteService.addNote($scope.note)
            .then(function(res) {
                alert("Note saved!");
            });
            $scope.name = '';
            $scope.text = '';
            $scope.course = 'Choose a course';
        }
        else alert("You must choose a course!");
    };
});
