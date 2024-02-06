# Conversor de Divisas Android con RecyclerView

¡Bienvenido al Conversor de Divisas Android con RecyclerView!

## Descripción

Este proyecto consiste en una pequeña aplicación Android que permite convertir divisas utilizando un RecyclerView. La actividad principal incluye los siguientes elementos:

- Un campo EditText para introducir una cantidad en euros.
- Un RecyclerView con su adaptador para mostrar las divisas disponibles.
- Un elemento XML (`row_divisa.xml`) para definir el diseño de cada fila del RecyclerView.
- Una lista de strings en `arrays.xml` que contiene las divisas (por ejemplo, AUD, USD) junto con sus valores de cambio respecto al euro.
- Un método para seleccionar un elemento del RecyclerView al hacer clic.
- Un botón para realizar la conversión de la divisa seleccionada y un TextView para mostrar el resultado.
- Un Switch para aplicar un descuento a los clientes VIP.

## Instalación

1. Clona este repositorio: `https://github.com/carlos-benedito/RecyclerView_android.git`.
2. Abre el proyecto en Android Studio.
3. Compila y ejecuta la aplicación en un emulador o dispositivo Android.

## Uso

1. Abre la aplicación en tu dispositivo Android.
2. Introduce la cantidad en euros en el campo EditText.
3. Selecciona la divisa de destino haciendo clic en el RecyclerView.
4. Si eres cliente VIP, activa el Switch para aplicar el descuento.
5. Haz clic en el botón de conversión para obtener el resultado.


[Imagen de RecyclerView](images/inicio.png)
[Imagen de cambio](images/cambio.png)

