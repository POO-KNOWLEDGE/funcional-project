# Explicación de Conceptos 

## Clases y Objetos

Se utilizaron múltiples clases para representar entidades reales:

- Persona
- Cliente
- Tecnico
- Equipo
- Robot
- Dron
- OrdenServicio


## Encapsulamiento

Los atributos fueron declarados privados.

Ejemplo:

private String nombre;

El acceso se realiza mediante getters y setters.

## Herencia

La clase Persona funciona como clase padre.

Cliente y Tecnico heredan de Persona.

## Polimorfismo

La clase abstracta Equipo permite trabajar con distintos tipos de equipos:

Equipo equipo = new Robot();


## Interfaces

La interfaz Reparacion obliga a implementar el método reparar().


## Clases Abstractas

Equipo es abstracta porque representa un concepto general.


## Excepciones

Se implementaron las excepción personalizadas:

EquipoNoEncontradoException y DuplicadoException
