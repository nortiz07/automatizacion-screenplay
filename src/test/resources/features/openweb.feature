#language: es

Característica: Abrir una pagina web
  Yo como usuario
  quiero realizar una prueba de abrir una pagina
  para comprobar los error de la pagina web

  Antecedentes:
    Dado "Oscar" abre el sitio web de pruebas

  @successful
  Escenario: abrir con el navegador chrome la pagina web
    Y desea validar la funcion de la carta de elementos
    Cuando selecciona aleatoriamente alguna de las subfunciones
    Entonces visualizara en la cabecera el nombre de la opcion elegida