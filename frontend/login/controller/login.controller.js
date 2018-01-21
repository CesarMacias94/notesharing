app.controller('loginController', function($rootScope, $scope, $state, UserService) {
    $scope.title = "Sign In";
    $scope.loginVisibility = "";
    $scope.signupVisibility = "none";

    $scope.signin = function(username, password) {
        if(username == undefined || password == undefined) {
            alert("All fields are required!");
        }
        else {
            UserService.getUsers()
            .then(function(res) {
                $scope.users = res.data;
                $scope.users.forEach(function(user) {
                    if(user.username == username && user.password == password) {
                        $scope.existUser = true;
                        $scope.user = user;
                    }
                });

                if($scope.existUser) {
                    firebase.auth().setPersistence(firebase.auth.Auth.Persistence.LOCAL)
                    .then(function() {
                        return firebase.auth().signInWithEmailAndPassword($scope.user.email, password)
                        .then(function() {
                            $rootScope.userCode = $scope.user.cod_user;
                            $state.go('home');
                        })
                        .catch(function(error) {
                            alert("ERROR ---> "+error.code+" - "+error.messagge);
                        });
                    })
                    .catch(function(error) {
                        // Handle Errors here.
                        var errorCode = error.code;
                        var errorMessage = error.message;
                    });


                }
                else alert("Username and/or Password not valid!");
            });
        }
    }

    $scope.signup = function() {
        $scope.loginVisibility = "none";
        $scope.signupVisibility = "";
        $state.go('signup');
    }
});
