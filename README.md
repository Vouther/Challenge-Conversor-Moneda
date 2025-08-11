# Conversor de Monedas

## Descripción

Este proyecto es una aplicación de consola en Java que permite convertir montos entre diferentes monedas utilizando la API pública de ExchangeRate-API. El programa ofrece un menú interactivo para que el usuario elija la conversión deseada, ingrese el monto y reciba el resultado de la conversión actualizado en tiempo real.

Las conversiones soportadas incluyen:

- Dólar (USD) ↔ Peso Argentino (ARS)
- Dólar (USD) ↔ Real Brasileño (BRL)
- Dólar (USD) ↔ Peso Colombiano (COP)

## Funcionalidades

- Menú interactivo para seleccionar el tipo de conversión.
- Validación de entradas para asegurar que el usuario ingrese opciones y montos válidos.
- Consulta en tiempo real de tasas de cambio mediante la API de ExchangeRate-API.
- Formato de salida amigable mostrando la cantidad convertida y la tasa aplicada.
- Manejo de errores para casos como claves API faltantes o problemas de conexión.

## Cómo usarlo

1. **Configuración inicial**

    - Obtener una API Key gratuita en [https://www.exchangerate-api.com](https://www.exchangerate-api.com).
    - Crear un archivo `config.properties` en la raíz del proyecto con el siguiente contenido:

      ```
      EXCHANGE_API_KEY=tu_api_key_aqui
      ```

2. **Compilar y ejecutar**

    - Asegurarse de tener instalado Java 11 o superior.
    - Compilar el proyecto (usando tu IDE favorito o desde consola):

      ```bash
      javac -cp gson.jar conversor/*.java
      ```

    - Ejecutar la clase principal:

      ```bash
      java -cp .:gson.jar conversor.Main
      ```

3. **Uso**

    - Al iniciar, se mostrará un menú con opciones para convertir entre monedas.
    - Ingresar el número correspondiente a la conversión deseada.
    - Ingresar la cantidad que se desea convertir.
    - Ver el resultado de la conversión en pantalla.
    - Elegir la opción "7" para salir del programa.

## Requisitos

- Java 11 o superior
- Librería [Gson](https://github.com/google/gson) para manejo de JSON (debes incluir gson.jar en el classpath)
- Conexión a internet para consultas a la API de ExchangeRate-API

