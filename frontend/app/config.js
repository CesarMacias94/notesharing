app.config(function($stateProvider) {
    $stateProvider.state({
        name: 'home',
        url: '/home',
        templateUrl: 'app/view/home.view.html',
        controller: 'homeController'
    }).state({
        name: 'add',
        url: '/addnote',
        templateUrl: 'app/view/add.note.view.html',
        controller: 'addnoteController'
    }).state({
        name: 'course',
        url: '/course/:name',
        templateUrl: 'app/view/course.view.html',
        controller: 'courseController'
    }).state({
        name: 'note',
        url: '/note/:name',
        templateUrl: 'app/view/note.view.html',
        controller: 'noteController'
    });
});
