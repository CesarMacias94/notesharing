app.controller('homeController', function($scope, $state) {

    $scope.add = function() {
        $state.go('add')
    }

    $scope.home = function() {
        $state.go('home');
    }

    $scope.search = function() {
        //search
    }

    $scope.remove = function(user) {
        //remove
    }

    $scope.save = function(user) {
        //save
    }

    $scope.showNotes = function(user) {
        $state.go('listnote');
    }
});
