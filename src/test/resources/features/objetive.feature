Feature: Objetivos SMS

  Scenario: Creación de objetivo exitoso
    Given soy un usuario autenticado
    When ingreso los datos del codigo y descripcion y creo el objetivo
    Then muestra mensaje de operación completada y objetivo en tabla

