Daniel Estiven Garcia

Contexto: Un sistema para administrar la información de empleados, departamentos, y proyectos en una empresa.

	Clases:

		Empleado: Atributos incluyen nombre, ID de empleado, y departamento.
		Departamento: Atributos incluyen nombre, código y lista de empleados.
		Proyecto: Atributos incluyen nombre, código, y empleados asignados.
		Gerente: Hereda de Empleado, añade atributos y métodos relacionados con la gestión de proyectos y equipos.
		Técnico: Hereda de Empleado, especializado en tareas técnicas específicas.

	Relaciones:

		Un Departamento tiene varios Empleados.
		Un Proyecto puede tener asignados múltiples Empleados.
		Gerente y Técnico son tipos específicos de Empleados con roles diferentes en proyectos.

	Herencia:

		Gerente y Técnico heredan de Empleado.

	Polimorfismo:

		Podemos tener una interfaz Contribuyente con un método contribuir(), que tanto Gerente como Técnico implementen de maneras distintas para reflejar su contribución única a los proyectos.
