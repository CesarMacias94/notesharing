app.controller('homeController', function($rootScope, $scope, $state, $window, CourseService, LoginService) {
    $rootScope.user = firebase.auth().currentUser;

    $scope.init = function() {
        LoginService.redirect();

        if($scope.courses == undefined) {
            //chiamata al backend per prendere tutti i corsi
            CourseService.getCourses()
            .then(function(res) {
                $scope.courses = res.data;
            });
        }
    }

    $scope.init();

    $scope.profile = function() {
        $state.go('profile', {userCode: $rootScope.userCode});
    }

    $scope.logout = function() {
        firebase.auth().signOut();
        $state.go('login');
    }

    $scope.course = function(course) {
        $rootScope.courseCode = course.cod_course;
        $state.go('course', {
            name: course.name.split(" ").join("-")
        });
    }
});
