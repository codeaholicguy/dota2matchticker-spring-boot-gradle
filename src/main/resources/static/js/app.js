var Configuration = {
    API_URL: "http://127.0.0.1:9999/"
}

var dota2matchticker = angular.module('components', ['ngResource'])
    .directive('liveMatch', function () {
        return {
            restrict: 'E',
            templateUrl: '/templates/live-match.html'
        }
    })
    .directive('upcommingMatch', function () {
        return {
            restrict: 'E',
            templateUrl: '/templates/upcomming-match.html'
        }
    })
    .directive('recentMatch', function () {
        return {
            restrict: 'E',
            templateUrl: '/templates/recent-match.html'
        }
    })

dota2matchticker.controller('MatchesController', function ($scope, $resource, $interval) {
    var apiUrl = Configuration.API_URL + 'matches/:action';
    $scope.matchesAPI = $resource(apiUrl,
        {action: 'live'},
        {get: {method: 'GET'}});

    $scope.matchesAPI.get({action: 'live'}, function (result) {
        $scope.liveMatches = result.data.matches;
    })
    $scope.matchesAPI.get({action: 'upcomming'}, function (result) {
        $scope.upcommingMatches = result.data.matches;
    })
    $scope.matchesAPI.get({action: 'result'}, function (result) {
        $scope.recentMatches = result.data.matches;

        for (var i = 0; i < $scope.recentMatches.length; i++) {
            if ($scope.recentMatches[i].team1.name == $scope.recentMatches[i].winner.name) {
                $scope.recentMatches[i].team1.isWinner = true;
                $scope.recentMatches[i].team2.isWinner = false;
            } else {
                $scope.recentMatches[i].team1.isWinner = false;
                $scope.recentMatches[i].team2.isWinner = true;
            }
        }
    })

    // Refresh data after 60s
    $interval(function () {
        $scope.matchesAPI.get({action: 'live'}, function (result) {
            $scope.liveMatches = result.data.matches;
        })
        $scope.matchesAPI.get({action: 'upcomming'}, function (result) {
            $scope.upcommingMatches = result.data.matches;
        })
    }, 60000)

})

angular.module('Dota2Matchticker', ['components'])


