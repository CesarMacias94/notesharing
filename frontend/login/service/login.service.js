app.service("LoginService", function($rootScope, $window, $state) {
    var _redirect = function () {
        firebase.auth().onAuthStateChanged(function(user) {
            if (user)
                $rootScope.user = user;
            else {
                console.log("NOT LOGGED");
                $state.go('login');
            }
        });
    }

    return {
        redirect: _redirect
    }
});
