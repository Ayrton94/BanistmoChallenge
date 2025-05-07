# features/convertidor_tasas.feature

Feature: Convertidor de Tasas de Interés

  Scenario: Convertir tasa nominal a efectiva
  Dado que "Usuario" accede a la página de herramientas de Bancolombia
  Cuando selecciona la opción "Negocios" del menú principal
  Y accede a la sección "Herramientas"
  Y selecciona la herramienta "Convertidor de tasas de interés"
  Y realiza la conversión con tasa "20", periodicidad "Semestral" y capitalización "Anual"
  Entonces debe visualizar el resultado "9.54%"