# [QuantumGamer](https://quantumgamer.vercel.app/) - Marketplace de Videojuegos

QuantumGamer es una aplicación web que sirve como un mercado en línea para comprar y vender videojuegos. Esta documentación proporciona una descripción general de la aplicación, las tecnologías utilizadas y cómo configurar el entorno de desarrollo.

## Configuración del Entorno

### Tecnologías Principales

- Java 17: Utilizamos Java para desarrollar la lógica de negocio y la capa de servidor de QuantumGamer.

- Angular 16: Angular se utiliza para la parte de frontend de la aplicación, proporcionando una experiencia de usuario interactiva y atractiva.

- MySQL: La base de datos de QuantumGamer se gestiona con MySQL. Hemos facilitado la configuración de la base de datos mediante Docker Compose.

### Configuración de la Base de Datos

QuantumGamer utiliza MySQL como sistema de gestión de base de datos. La estructura de las tablas se define en el script SQL proporcionado en la descripción del proyecto. Puedes configurar la base de datos de la siguiente manera:

1. Asegúrate de que Docker esté instalado en tu máquina.

2. Copia el contenido del script SQL a un archivo, por ejemplo, `quantumgamer.sql`.

3. Ejecuta el siguiente comando para iniciar un contenedor de MySQL con Docker Compose:

   ```bash
   docker-compose up -d
   ```
4. La base de datos se iniciará en un contenedor de Docker y estará disponible en el puerto 3306.

### Ejecución de la Aplicación
1. Clona este repositorio en tu máquina local.
2. Configura la conexión a la base de datos MySQL en la aplicación Java. Asegúrate de que las credenciales coincidan con las que configuraste en Docker Compose.
3. Navega a la carpeta de la aplicación Angular y ejecuta el siguiente comando para iniciar la aplicación en modo de desarrollo:

  ``` bash
  ng serve
  ```
## Funcionalidades Principales
QuantumGamer ofrece las siguientes funcionalidades principales:

- Registro de usuarios y gestión de cuentas.
- Búsqueda y exploración de videojuegos en venta.
- Agregar videojuegos al carrito de compras.
- Crear y administrar una lista de deseos de videojuegos.

## Capturas de pantalla

### Página de inicio
![image](https://github.com/No-Country/s11-11-n-java-angular/assets/114030068/d95894a6-76ba-4741-8bca-60b4b47335cf)

### Página de productos
![image](https://github.com/No-Country/s11-11-n-java-angular/assets/114030068/58439dff-7bd3-40f2-a0ac-bf4d5cc0f677)

### Página para agregar un producto a la venta
![image](https://github.com/No-Country/s11-11-n-java-angular/assets/114030068/170515c5-8d50-4a19-8996-e17bbee55241)

### Página de detalles del producto
![image](https://github.com/No-Country/s11-11-n-java-angular/assets/114030068/58ed66d8-5675-420e-828a-fb50463c8f1e)

### Modal de carrito de compras
![image](https://github.com/No-Country/s11-11-n-java-angular/assets/114030068/07f2c229-cfe3-4235-8ad3-64d5d4c6d89f)

### Página de carrito de compras
![image](https://github.com/No-Country/s11-11-n-java-angular/assets/114030068/7e114637-3a58-4b6a-8f80-485cfb485fe8)

### Página de inicio de sesión
![image](https://github.com/No-Country/s11-11-n-java-angular/assets/114030068/00369e9e-d140-4d92-b428-340d27692cc3)

### Página de registro de usuario
![image](https://github.com/No-Country/s11-11-n-java-angular/assets/114030068/4ebace62-ea9f-4c5b-8f7d-039e0b32ee66)

## Equipo de Desarrollo

Frontend
- Rubén Mantilla Quiroz
- Raul Quispe
- Andres betancur

UX/UI
- Samantha Sánchez
- Belén Muñoz

Backend
- Wilder Ruiz 
- Angelo Miguel Torreblanca Villa
- Oscar Jurado
- Damian Canteros
- Luis Angel
