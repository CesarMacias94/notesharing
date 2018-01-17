app.controller('loginController', function($scope, $state) {
    $scope.title = "Sign In";
    $scope.loginVisibility = "";
    $scope.signupVisibility = "none";

    $scope.signin = function(email, password) {
        if(email == undefined || password == undefined) {
            alert("All fields are required!");
        }
        else {
            firebase.auth().signInWithEmailAndPassword(email, password)
            .then(function() {
                $state.go('home');
            })
            .catch(function(error) {
                alert("ERROR ---> "+error.code+" - "+error.messagge);
            });
        }
    }

    $scope.signup = function() {
        $scope.loginVisibility = "none";
        $scope.signupVisibility = "";
        $state.go('signup');
    }
});
