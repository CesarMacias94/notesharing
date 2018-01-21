app.controller('homeController', function($window, $scope, $state, $window, CourseService, LoginService) {
    $window.localStorage.user = firebase.auth().currentUser;

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
        $state.go('profile', {userCode: $window.localStorage.userCode});
    }

    $scope.logout = function() {
        firebase.auth().signOut()
        .then(function(res) {
            console.log("LOG OUT ---> ",res);
        });

        $state.go('login');
    }

    $scope.course = function(course) {
        $window.localStorage.courseCode = course.cod_course;
        $state.go('course', {
            name: course.name.split(" ").join("-")
        });
    }
});
