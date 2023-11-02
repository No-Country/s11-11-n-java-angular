# Proyecto E-commerce Multi-Client en Angular

Este es un proyecto de E-commerce multi-client desarrollado en Angular. Permite crear una plataforma de compras en línea que puede servir a múltiples clientes con diferentes tiendas.

## Características

- **Multi-Client**: Este proyecto está diseñado para atender a múltiples clientes, cada uno con su propia tienda y catálogo de productos.

- **Interfaz de Usuario Atractiva**: Utilizamos Angular, Angular Material y SCSS avanzado para crear una interfaz de usuario atractiva y fácil de usar para los clientes.

- **Gestión de Productos**: Permite a los administradores de la tienda agregar, editar y eliminar productos de su tienda.

- **Carrito de Compras**: Los usuarios pueden agregar productos a su lista de deseados, pasarlos a su carrito de compras y realizar pedidos.

- **Proceso de Pago**: Implementamos un proceso de pago seguro y fácil de usar para completar las transacciones.

## Requisitos

Antes de comenzar con este proyecto, asegúrate de tener instalado lo siguiente:

- Node.js & npm
- Angular CLI
- [ESLint](https://marketplace.visualstudio.com/items?itemName=dbaeumer.vscode-eslint) & [Prettier](https://marketplace.visualstudio.com/items?itemName=esbenp.prettier-vscode) extensions

## Instalación

1. Clona este repositorio en tu máquina local:

```bash
git clone https://github.com/No-Country/s11-11-n-java-angular.git
```

2. Navega al directorio del proyecto:

```bash
cd frontend
```

3. Instala las dependencias del proyecto:

```bash
npm install
```

## Uso

1. Inicia la aplicación en modo de desarrollo:

```bash
ng serve
```

2. Abre tu navegador y visita [http://localhost:4200/](http://localhost:4200/) para ver la aplicación en funcionamiento.

## Dockerfile component

1. Abre la aplicación de docker en tu ordenador

2. Abre la terminal en la carpeta del proyecto

3. Navega al directorio del proyect:

```bash
cd frontend
```

4. Construye la imagen de docker:

```bash
docker build --no-cache --progress=plain -t quantumgamer .
```

5. Lanza la imagen de docker a un contenedor para ejectuarlo:

```bash
docker run -d -i -p 4000:4000 --name quantumgamer quantumgamer
```

## Contribución

Si deseas contribuir a este proyecto, por favor sigue los siguientes pasos:

1. Haz un fork del repositorio.
2. Crea una rama para tu contribución: `git checkout -b my-contribution`.
3. Realiza tus cambios y commitea: `git commit -m "add new feature"`.
4. Sube tus cambios: `git push origin my-contribution`.
5. Abre un pull request en GitHub.

## Contacto

Si tienes preguntas o necesitas ayuda, no dudes en contactarme:

- Nombre: ...
- Correo Electrónico: ...

## Licencia

Este proyecto está bajo la Licencia MIT - consulta el archivo [LICENSE.md](LICENSE.md) para más detalles.
