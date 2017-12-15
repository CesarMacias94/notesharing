app.controller('homeController', function($scope, $state, $firebaseArray) {
    var ref  = firebase.database().ref().child("users");
    $scope.user = $firebaseArray(ref);
    var en = true;

    $scope.add = function() {
        $state.go('add')
    }

    $scope.home = function() {
        $state.go('home');
    }

    $scope.search = function() {
        $scope.user;
    }

    $scope.remove = function(user) {
        $scope.user.$remove(user);
    }

    $scope.save = function(user) {
        $scope.user.$save(user);
    }

    $scope.showNotes = function(user) {
        $scope.user.$save(user);
    }
});
