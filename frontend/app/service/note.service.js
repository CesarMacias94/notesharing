app.service("NoteService", function() {
    //aggiungere nei percorsi http://localhost:8080/
    var _getNote = function (codNote) {
        return $http.get("api/note/"+codNote);
    }

    var _addNote = function (note) {
        return $http.post("api/addnote", note);
    }

    return {
        getNote: _getNote,
        addNote: _addNote
    }
});
