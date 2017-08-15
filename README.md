# TP9_GUI - Programacion avanzada 2017

Desarrollar una aplicaci�n JAVA con OO, componentes GUI, modelo de eventos y MVC, para el ingreso, consulta y actualizaci�n de una entidad seleccionada a su preferencia, que no haya sido desarrollada en clase o en otro trabajo pr�ctico.
�
La aplicaci�n debe incluir un men� desplegable con dos opciones principales: Sistemas y Operaciones. 
	� Sistemas. Incluir� dos sub opciones:
		? Acerca de: donde se incluye informaci�n del aplicativo: nombre, versi�n, a�o, autores.
		? Salir: para finalizar el uso del aplicativo, previa confirmaci�n con el usuario.
	� Operaciones. Incluir�, al menos tres sub-opciones:
		? Ingreso.
		? Consulta y actualizaci�n.
		? Consulta masiva.
�
Sub-opciones:
Ingreso. Permite el ingreso y registraci�n en uno o m�s archivos TXT plano separado por �;� (punto y coma), de toda la informaci�n relacionada con la entidad elegida.
La pantalla gr�fica para el ingreso de toda la informaci�n debe incluir:
	- T�tulo para la ventana activa : JFrame
	- Cuadro de texto : JTextArea
	- Etiquetas : JLabel
	- Leyenda o comentario extenso no editable, con longitud mayor a 3 renglones : JTextArea
	- Dos listas desplegables, donde la segunda sea dependiente de la primera : JComboBox
	- Listas est�tica y din�mica con selecci�n m�ltiple en ambas : Jlist
	- Botones de opciones, dentro de un panel espec�fico : JRadioButton
	- Casillas de verificaci�n : JCheckBox
	- Botones de acciones: Aceptar y Cancelar : JButton
Al �Aceptar� el ingreso, el sistema deber� validar que, al menos, 3 componentes de distinto tipo est�n informados. Luego, se agregar� la informaci�n ingresada en el archivo TXT.
La informaci�n origen de todas las listas deber� residir en distintos archivos TXT. Para el caso de la lista desplegable dependiente, el archivo TXT tiene al menos tres columnas formateadas con ancho fijo, siendo la segunda columna, la que participa en la lista.
Al �Cancelar� el ingreso, luego que el usuario de confirmaci�n a tal operaci�n, el sistema blanquear� los campos ingresados.
�
Consulta y Actualizaci�n. El sistema deber� incluir una pantalla con, al menos, dos datos aplicados como criterio de b�squeda de la informaci�n a modificar, a eliminar y/o a consultar. 
Una vez ingresado los datos a buscar, el usuario presionar� el bot�n �Consultar� y el sistema la localizar� entre la informaci�n registrada. Si la encuentra, mostrar� el resto de la informaci�n en formato no editable. De lo contario, un mensaje de error lanzando una excepci�n propia.
Al visualizar la informaci�n completa de la entidad, el usuario puede seleccionar: Modificaci�n o Anulaci�n. 
Para el primer caso, �Modificaci�n�, los componentes de la pantalla pasar�n a modo editable para que pueda ser modificada la informaci�n visualizada. Y luego, seleccionar� Aceptar o Cancelar, de acuerdo a lo deseado.
Para el segundo caso, �Anulaci�n�, el sistema confirmar� tal operaci�n y si es avalada por el usuario, se eliminar� la informaci�n del archivo TXT donde reside.
�
Consulta Masiva. Esta pantalla contar� con un cuadro de texto, donde el usuario completar� la informaci�n a consultar. 
El sistema mostrar� en una Grilla de Consulta de Registros, todos aquellos que coincidan total o parcialmente con el criterio de b�squeda ingresado. 
En caso, que el usuario no ingrese ning�n filtro, se mostrar�n la totalidad de los registros.
La pantalla deber� incluir la cantidad total de registros visualizados y la cantidad total de registros existentes.
�
El modelo de objetos debe incluir una entidad principal y una derivada con diversidad de tipos de datos miembros. Debe incluir tambi�n, al menos, dos clases secundarias asociadas, que se relacionen por agregaci�n en un caso y por composici�n, en otro. Alguno de ellos, implementando cardinalidad m�ltiple. 
Presentar el diagrama de clases correspondiente en formato jpg.
�
Para el desarrollo de esta gu�a, se deber� hacer uso de colecciones.
��
Aclaraciones: 
	� No se aceptan trabajos pr�cticos ni correcciones incompletas. Aquellos que no cumplan con la totalidad de lo solicitado ser�n considerados como no entregado sin aviso alguno.
	� El plazo m�ximo de pr�rroga de entrega es de 72hs. desde la fecha de entrega indicada. Transcurrido dicho plazo y si correspondiese, los trabajos pr�cticos ser�n considerados para el recuperatorio.
