app.config(function($stateProvider) {
    $stateProvider.state({
        name: 'home',
        url: '/home',
        templateUrl: 'app/fragments/home.fragment.html',
        controller: 'homeController'
    }).state({
        name: 'add',
        url: '/add',
        templateUrl: 'app/fragments/add.note.fragment.html',
        controller: 'addnoteController',
        parent: 'home'
    });
});
