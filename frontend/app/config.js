app.config(function($stateProvider) {
    $stateProvider.state({
        name: 'home',
        url: '/home',
        templateUrl: 'app/views/home.view.html',
        controller: 'homeController'
    }).state({
        name: 'add',
        url: '/add',
        templateUrl: 'app/views/add.note.view.html',
        controller: 'addnoteController'
    }).state({
        name: 'listnote',
        url: '/listnote',
        templateUrl: 'app/views/list.note.view.html',
        controller: 'listnoteController'
    }).state({
        name: 'note',
        url: '/note',
        templateUrl: 'app/views/note.view.html',
        controller: 'noteController'
    });
});
