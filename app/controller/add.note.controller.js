app.controller('addnoteController', function($scope, $firebaseArray) {
    var ref  = firebase.database().ref().child("users");
    $scope.user = $firebaseArray(ref);
    $scope.name;
    $scope.surname;
    $scope.bio;
    $scope.job;

    $scope.save = function(name, surname, bio, job) {
        $scope.name = name;
        $scope.surname = surname;
        $scope.bio = bio;
        $scope.job = job;
        $scope.user.$add({
            name: name,
            surname: surname,
            bio: bio,
            job: job
        });
        $scope.name = '';
        $scope.surname = '';
        $scope.bio = '';
        $scope.job = '';
    }
});
