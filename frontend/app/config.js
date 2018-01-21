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
    }).state({
        name: 'profile',
        url: '/profile/:userCode',
        templateUrl: 'app/view/profile.view.html',
        controller: 'userController'
    }).state({
        name: 'users',
        url: '/users',
        templateUrl: 'app/view/users.view.html',
        controller: 'usersController'
    }).state({
        name: 'login',
        url: '/login',
        templateUrl: 'login/view/login.html',
        controller: 'loginController'
    }).state({
        name: 'signup',
        url: '/signup',
        templateUrl: 'login/view/signup.html',
        controller: 'signupController',
        parent: 'login'
    });
});
