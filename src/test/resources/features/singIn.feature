Feature: Inicio de Sesión en una Aplicación

  Scenario: Iniciar Sesión con Credenciales Válidas
    Given estoy en la página de inicio de sesión
    And soy un usuario registrado
    When ingreso mi nombre de usuario y contraseña
    And hago clic en el botón Ingresar
    Then debería estar en el Home Page

  Scenario: Iniciar Sesión con Credenciales Inválidas
    Given estoy en la página de inicio de sesión
    When ingreso un nombre de usuario inválido y/o contraseña incorrecta
    And hago clic en el botón "Ingresar"
    Then debería ver un mensaje de error de inicio de sesión