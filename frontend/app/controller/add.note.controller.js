app.controller('addnoteController', function($scope, CourseService, NoteService) {
    $scope.note;
    $scope.name;
    $scope.text;
    $scope.course =  "Choose A Course";

    //chiamata al backend per prendere tutti i corsi,
    CourseService.getCourses()
    .then(function(res) {
        $scope.courses = [];
        angular.forEach(res.data, function(data) {
            $scope.courses.push(data);
        });
    });

    $scope.chooseCourse = function(course) {
        $scope.course = course.name;
        $scope.cod_course = course.cod_course;
    }

    $scope.save = function(name, text, course) {
        if(course != "Choose A Course") {
            //cod user, da definire come settarlo
            $scope.note = {
                text: text,
                name: name,
                cod_user: 1,
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
