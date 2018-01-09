app.service("NoteService", function($http) {
    var _getNotesByCourse = function (codCourse) {
        return $http.get("http://localhost:8080/notesharing/api/notescourse/"+codCourse);
    }

    var _getNotesByUser = function (codUser) {
        return $http.get("http://localhost:8080/notesharing/api/notesuser/"+codUser);
    }

    var _getNote = function (codNote) {
        return $http.get("http://localhost:8080/notesharing/api/note/"+codNote);
    }

    var _addNote = function (note) {
        return $http.post("http://localhost:8080/notesharing/api/addnote", note);
    }

    return {
        getNotesByCourse: _getNotesByCourse,
        getNotesByUser: _getNotesByUser,
        getNote: _getNote,
        addNote: _addNote
    }
});
