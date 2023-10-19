Feature: Objetivos SMS

  Scenario: Creación de objetivo exitoso
    Given soy un usuario autenticado
    And estoy en el paso de "Objetivo"
    When ingreso los datos del codigo y descripcion y creo el objetivo
    Then muestra mensaje de operación completada y objetivo en tabla

  Scenario: Actualizar objetivo exitoso
    Given soy un usuario autenticado
    And estoy en el paso de "Objetivo"
    When busco el objetivo
    And acualizo su codigo y descripcion
    And confirmo la actualización
    Then muestra mensaje de operación completada y objetivo actualizado en tabla

  Scenario: Cancelar actualizacion de objetivo
    Given soy un usuario autenticado
    And estoy en el paso de "Objetivo"
    When busco el objetivo
    And acualizo su codigo y descripcion
    And cancelo la actualización
    Then muestra mensaje de operación cancelada y objetivo no se actualiza

  Scenario: Eliminar objetivo
    Given soy un usuario autenticado
    And estoy en el paso de "Objetivo"
    When busco el objetivo
    And lo elimino
    Then muestra mensaje de operación completada y objetivo no se encuentra en tabla

  Scenario: Cancelar eliminacion objetivo
    Given soy un usuario autenticado
    And estoy en el paso de "Objetivo"
    When busco el objetivo
    And presiono en eliminar y cancelo operacion
    Then el objetivo sigue en la tabla