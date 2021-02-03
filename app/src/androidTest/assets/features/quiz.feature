Feature: Quiz

  @quiz-feature
  Scenario Outline: responder a pregunta en pantalla Question

    Given iniciar pantalla Question
    And mostrar pregunta "<question>"
    And ocultar resultado
    And mostrar botones True y False y Cheat activados
    And mostrar boton Next desactivado
    And pulsar boton "<button>"
    And mostrar resultado "<result>" a respuesta "<answer>"
    And mostrar botones True y False y Cheat desactivados
    And mostrar boton Next activado
    When girar pantalla
    Then mostrar resultado "<result>" a respuesta "<answer>"
    And mostrar botones True y False y Cheat desactivados
    And mostrar boton Next activado

    Examples:
      | question                                                  | button | answer | result     |
      | Christian Bale played Batman in 'The Dark Knight Rises'?  | True   | True   | Correct!   |
      | Christian Bale played Batman in 'The Dark Knight Rises'?  | False  | True   | Incorrect! |


  @quiz-feature
  Scenario Outline: pasar a pantalla Cheat sin responder a pregunta en pantalla Question

    Given iniciar pantalla Question
    And mostrar pregunta "<question>"
    And ocultar resultado
    And mostrar botones True y False y Cheat activados
    And mostrar boton Next desactivado
    And pulsar boton Cheat
    And iniciar pantalla Cheat
    And mostrar mensaje Warning
    And ocultar respuesta
    And mostrar botones Yes y No activados
    When girar pantalla
    Then mostrar mensaje Warning
    And ocultar respuesta
    And mostrar botones Yes y No activados
    And pulsar boton Back

    Examples:
      | question                                                 |
      | Christian Bale played Batman in 'The Dark Knight Rises'? |


  @quiz-feature
  Scenario Outline: volver a pantalla Question sin mostrar respuesta en pantalla Cheat

    Given iniciar pantalla Question
    And mostrar pregunta "<question>"
    And ocultar resultado
    And mostrar botones True y False y Cheat activados
    And mostrar boton Next desactivado
    And pulsar boton Cheat
    And iniciar pantalla Cheat
    And mostrar mensaje Warning
    And ocultar respuesta
    And mostrar botones Yes y No activados
    And pulsar boton No
    And finalizar pantalla Cheat
    And resumir pantalla Question
    And mostrar pregunta "<question>"
    And ocultar resultado
    And mostrar botones True y False y Cheat activados
    And mostrar boton Next desactivado
    When girar pantalla
    Then mostrar pregunta "<question>"
    And ocultar resultado
    And mostrar botones True y False y Cheat activados
    And mostrar boton Next desactivado

    Examples:
      | question                                                 |
      | Christian Bale played Batman in 'The Dark Knight Rises'? |


  @quiz-feature
  Scenario Outline: mostrar respuesta en pantalla Cheat

    Given iniciar pantalla Question
    And mostrar pregunta "<question>"
    And ocultar resultado
    And mostrar botones True y False y Cheat activados
    And mostrar boton Next desactivado
    And pulsar boton Cheat
    And iniciar pantalla Cheat
    And mostrar mensaje Warning
    And ocultar respuesta
    And mostrar botones Yes y No activados
    And pulsar boton Yes
    And mostrar respuesta "<answer>" a pregunta "<question>"
    And mostrar botones Yes y No desactivados
    When girar pantalla
    Then mostrar respuesta "<answer>" a pregunta "<question>"
    And mostrar botones Yes y No desactivados
    And pulsar boton Back

    Examples:
      | question                                                 | answer |
      | Christian Bale played Batman in 'The Dark Knight Rises'? | True   |


  @quiz-feature
  Scenario Outline: volver a pantalla Question mostrando respuesta en pantalla Cheat

    Given iniciar pantalla Question
    And mostrar pregunta "<question1>"
    And ocultar resultado
    And mostrar botones True y False y Cheat activados
    And mostrar boton Next desactivado
    And pulsar boton Cheat
    And iniciar pantalla Cheat
    And mostrar mensaje Warning
    And ocultar respuesta
    And mostrar botones Yes y No activados
    And pulsar boton Yes
    And mostrar botones Yes y No desactivados
    And mostrar respuesta "<answer>" a pregunta "<question1>"
    And girar pantalla
    And pulsar boton Back
    And finalizar pantalla Cheat
    And resumir pantalla Question
    And mostrar pregunta "<question2>"
    And ocultar resultado
    And mostrar botones True y False y Cheat activados
    And mostrar boton Next desactivado
    When girar pantalla
    Then mostrar pregunta "<question2>"
    And ocultar resultado
    And mostrar botones True y False y Cheat activados
    And mostrar boton Next desactivado

    Examples:
      | question1                                                | answer | question2          |
      | Christian Bale played Batman in 'The Dark Knight Rises'? | True   | The Gremlins movie was released in 1986? |


  @quiz-feature
  Scenario Outline: pasar a siguiente pregunta en pantalla Question

    Given iniciar pantalla Question
    And mostrar pregunta "<question1>"
    And ocultar resultado
    And mostrar botones True y False y Cheat activados
    And mostrar boton Next desactivado
    And pulsar boton "<button>"
    And mostrar resultado "<result>" a respuesta "<answer>"
    And mostrar botones True y False y Cheat desactivados
    And mostrar boton Next activado
    And girar pantalla
    And mostrar resultado "<result>" a respuesta "<answer>"
    And mostrar botones True y False y Cheat desactivados
    And mostrar boton Next activado
    And pulsar boton Next
    And mostrar pregunta "<question2>"
    And ocultar resultado
    And mostrar botones True y False y Cheat activados
    And mostrar boton Next desactivado
    When girar pantalla
    Then mostrar pregunta "<question2>"
    And ocultar resultado
    And mostrar botones True y False y Cheat activados
    And mostrar boton Next desactivado

    Examples:
      | question1                                                | button  | answer  | result     | question2          |
      | Christian Bale played Batman in 'The Dark Knight Rises'? | True    | True    | Correct!   | The Gremlins movie was released in 1986? |
      | Christian Bale played Batman in 'The Dark Knight Rises'? | False   | True    | Incorrect! | The Gremlins movie was released in 1986? |




