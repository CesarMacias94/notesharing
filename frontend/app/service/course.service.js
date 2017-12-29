app.service("CourseService", function($http) {
    //aggiungere nei percorsi http://localhost:8080/
    var _getCourses = function () {
        return $http.get("api/courses");
    }

    var _getCourse = function (codCourse) {
        return $http.get("api/course/"+codCourse);
    }

    return {
        getCourses: _getCourses,
        getCourse: _getCourse
    }
});
