app.service("CourseService", function($http) {
    var _getCourses = function () {
        return $http.get("http://localhost:8080/notesharing/api/courses");
    }

    var _getCourse = function (codCourse) {
        return $http.get("http://localhost:8080/notesharing/api/course/"+codCourse);
    }

    return {
        getCourses: _getCourses,
        getCourse: _getCourse
    }
});
