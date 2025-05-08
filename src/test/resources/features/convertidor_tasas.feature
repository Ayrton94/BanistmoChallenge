# features/convertidor_tasas.feature

Feature: Convertidor de Tasas de Interés Bancolombia

  Scenario: Conversión de tasa semestral a anual
    Given se ingresa a la pagina de Negocios con la opcion Herramientas
    When se selecciona la opcion "Gestionar las finanzas de mi negocio"
    And se selecciona la herramienta "Convertidor de tasas de interés"
    And se realiza la conversión con tasa "20", periodicidad "Semestral" y capitalización "Anual"
    Then se debe visualizar el resultado "9.54 %"