app.controller('homeController', function($scope, $state, $rootScope, CourseService) {
    $scope.init = function() {
        //chiamata al backend per prendere tutti i corsi
        CourseService.getCourses()
        .then(function(res) {
            $scope.courses = res.data;
        });

        /*$scope.courses = [{
            code: "27122017",
            name: "Processo E Sviluppo Del Software",
            description: "lorem ipsum",
            notes: [{
                name: "UML",
                text: "diagrammi UML"
            }]
        }];*/

        console.log("CORSI ---> ",$scope.courses);
    }

    $scope.init();

    $scope.profile = function() {
        //Ancora da sviluppare
        $state.go('profile');
    }

    $scope.course = function(course) {
        $rootScope.courseCode = course.cod_course;
        $state.go('course', {
            name: course.name.split(" ").join("-")
        });
    }

    /*$scope.search = function() {
        $scope.user;
    }*/
});
