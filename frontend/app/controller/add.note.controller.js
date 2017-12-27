app.controller('addnoteController', function($scope) {
    $scope.note;
    $scope.name;
    $scope.text;
    $scope.course = "Choose a course";
    //chiamata al backend per prendere tutti i corsi
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
        $scope.name = '';
        $scope.text = '';
        $scope.course = 'Choose a course';
    };
});
