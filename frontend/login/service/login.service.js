app.service("LoginService", function($rootScope, $window) {
    var _redirect = function () {
        $rootScope.user = firebase.auth().currentUser;
        console.log("UTENTE LOGGATO ---> ",$rootScope.user);

        if (!$rootScope.user) {
            console.log("NOT LOGGED");
            $window.location.href = '/notesharing/#!/login';
        }
    }

    return {
        redirect: _redirect
    }
});
