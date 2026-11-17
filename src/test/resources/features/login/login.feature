@loginExitoso
  Feature: Inicio de sesionn

    Scenario: Inicio de sesion exitoso
      Given que el usuario se encuentra en la pagina de inicio de sesion
      When ingresa credenciales validas
      Then debería visualizar la pagina principal


    Scenario: Inicio de sesion fallido por credenciales incorrectas
      Given que el usuario se encuentra en la pagina de inicio de sesion
      When ingresa credenciales invalidas
      Then debería visualizar un mensaje de error

