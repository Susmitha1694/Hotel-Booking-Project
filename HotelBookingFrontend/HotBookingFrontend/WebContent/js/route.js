var App = angular.module('mainApp', ['ui.router']);

App.config(function($stateProvider, $urlRouterProvider) {
    
    $urlRouterProvider.otherwise('/firstPage');
    
    $stateProvider
        
        // HOME STATES AND NESTED VIEWS ========================================
        .state('bookRoom', {
            url: '/bookRoom',
            templateUrl: 'bookRoom.jsp'
        })
         // HOME STATES AND NESTED VIEWS ========================================
        .state('firstPage', {
            url: '/firstPage',
            templateUrl: 'firstPage.jsp'
        })
        // HOME STATES AND NESTED VIEWS ========================================
        .state('viewHotels', {
            url: '/viewHotels',
            templateUrl: 'viewHotels.jsp'
        })
        .state('finalPage', {
            url: '/finalPage',
            templateUrl: 'finalPage.jsp'
        });        
});