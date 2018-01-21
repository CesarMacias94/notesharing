app.controller('signupController', function($scope, $state, UserService) {
    $scope.$parent.title = "Sign Up";

    $scope.save = function(name, surname, date, email, username, password) {
        UserService.getUsers()
        .then(function(res) {
            $scope.users = res.data;
            $scope.existUser = false;
            $scope.users.forEach(function(user) {
                if(user.username == username) {
                    $scope.existUser = true;
                    alert("This username already exist!");
                }
            });

            if(name == undefined || surname == undefined || date == undefined || email == undefined || username == undefined || password == undefined) {
                $scope.undefined = true;
                if(!$scope.existUser) {
                    alert("All fields are required!");
                }
            }

            if(!$scope.existUser && !$scope.undefined) {
                var date_of_birth = new Date(date);
                var day = date_of_birth.getUTCDate()+1;
                var month = date_of_birth.getUTCMonth()+1;
                var year = date_of_birth.getUTCFullYear();
                var finalDate = year+"-"+month+"-"+day+" 00:00:00";
                $scope.user = {
                    name: name,
                    surname: surname,
                    date_of_birth: finalDate,
                    email: email,
                    username: username,
                    password: password
                };
                
                //chiamata al backend per salvare l'utente
                UserService.addUser($scope.user)
                .then(function(res) {
                    firebase.auth().createUserWithEmailAndPassword(email, password)
                    .then(function() {
                        $scope.$parent.title = "Sign In";
                        $scope.$parent.loginVisibility = "";
                        $scope.$parent.signupVisibility = "none";
                        alert("You are now registered!");
                        $state.go('login');
                    })
                    .catch(function(error) {
                        alert("ERROR ---> "+error.code+" - "+error.messagge);
                    });
                });
            }
        });
    }

    $scope.back = function() {
        $scope.$parent.title = "Sign In";
        $scope.$parent.loginVisibility = "";
        $scope.$parent.signupVisibility = "none";
        $state.go('login');
    }
});
