angular.module('principal')
  .controller('Controller', ['$scope', '$http',
    function ($scope, $http) {

      $scope.produtos = null;
      $scope.tela = 'pedido';
      $scope.telaPedido = 'batatas';
      $scope.total = 0;

      $scope.mudarTela = function (tela) {
        $scope.tela = tela;
      }

      $scope.mudarTelaPedido = function (telaPedido) {
        $scope.telaPedido = telaPedido;
      }

      $scope.somarUm = function (batata) {
        batata.quantidade++;
        atualizarTotal(batata.preco);
      }


      $scope.subtrairUm = function (batata) {
        batata.quantidade--;
        atualizarTotal(-batata.preco);
      }

      $scope.somarUmAdicional = function (batata, adicional) {
        batata.adicionalNumber = adicional;
      }

      var inicializarProdutos = function () {
        angular.forEach($scope.produtos, function (value, key) {
          value.quantidade = 0;
          value.adicional1 = 0;
          value.adicional2 = 0;
          value.adicional3 = 0;
          value.adicional4 = 0;
          value.adicional5 = 0;
        });
      }

      var atualizarTotal = function (novoValor) {
        $scope.total = $scope.total + novoValor;
      }

      init = function () {
        $http.get("http://localhost:8080/produtos")
          .then(function (response) {
            $scope.produtos = response.data;
            inicializarProdutos();
          });


      };

      init();
    }]);