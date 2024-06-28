# LiterAlura Challenge
Se presenta una tipo biblioteca en línea de comandos, donde se buscan libros por medio de la API GUTENDEX, para posteriormente guardarse en una base de datos postgresql

## Acerca del proyecto
1. Se hace una llamada a la API GUTENDEX disponible en [documentación gutendex](https://gutendex.com/)
2. Se guardan los datos en la base de datos postgresql
3. Existen 2 entidades las cuales son: Libro y Autor, sin embargo, se forma una tercera intermediaria al realizar una relacion ManyToMany
4. Se hacen uso de Enumeraciones con el fin de normalizar los lenguajes disponibles de libros
5. Es un ambiente en consola

## El usuario puede: 
1. Buscar un libro en la api y añadirlo en la base de datos
2. Listar los libros de la base de datos
3. Listar los autores de la base de datos
4. Listar autores por año
5. Listar libros por lenguaje

Este proyecto fue realizado para el programa #OracleNextEducation, gracia a Alura Latam y Oracle.
