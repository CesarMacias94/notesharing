app.controller('addnoteController', function($scope, CourseService, NoteService) {
    $scope.note;
    $scope.name;
    $scope.text;
    $scope.course = "Choose a course";
    //chiamata al backend per prendere tutti i corsi
    /*CourseService.getCourse($rootScope.courseCode)
    .success(function(res) {
        //forse superflua
        $scope.courses = [];
        angular.forEach(res, function(data) {
            $scope.courses.push(data.name);
        });
    });*/

    $scope.courses = ["Processo E Sviluppo Del Software", "Machine Learning"];

    $scope.chooseCourse = function(course) {
        $scope.course = course;
    }

    $scope.save = function(name, text, course) {
        //verificare che course != "Choose a course"
        $scope.name = name;
        $scope.text = text;
        $scope.note = {
            name: name,
            text: text,
            course:course
        };
        //chiamata al backend per salvare il post
        /*NoteService.addNote($scope.note)
        .success(function(res) {
            alert("Nota aggiunta")
        });*/
        $scope.name = '';
        $scope.text = '';
        $scope.course = 'Choose a course';
    };
});
