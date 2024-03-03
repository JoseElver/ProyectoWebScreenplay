# author: Nilo Chaverra
# date: 15/01/2024
# language: es


@HU
Característica: inicio de sesion
  Descricion: Yo como analista de banco necesito iniciar sesión en
  el sitio web guruBank con mis credenciales de acceso.

  Antecedentes:
    Dado que el usuario navega a la pagina de inicio de sesion

    @Test1
    Esquema del escenario: <Escenario>
      Cuando ingresa sus credenciales
        | <strUsuario> | <strClave>  |
      Entonces deberia ver la pagina principal

      Ejemplos:
        | Escenario     | strUsuario | strClave  |
        | Login failed  | adm1n      | seren1ty  |
        | Login exitoso | admin      | serenity  |






