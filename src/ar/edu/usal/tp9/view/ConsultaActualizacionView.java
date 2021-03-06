package ar.edu.usal.tp9.view;

import java.awt.Color;
import java.awt.Component;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;

import ar.edu.usal.tp9.controller.ConsultaActualizacionController;
import ar.edu.usal.tp9.model.dao.PasajerosDao;
import ar.edu.usal.tp9.model.dto.Pasajeros;
import ar.edu.usal.tp9.utils.Constants;
import ar.edu.usal.tp9.utils.GuiUtilities;

public class ConsultaActualizacionView {
	
	private JFrame ventana = new JFrame("Consulta y actualizacion");
	
	private JLabel lblLocalidades = new JLabel("Seleccionar localidad: ");
	private JComboBox cmbLocalidades;
	
	private JButton btnConsultar =  new JButton("Consultar");
	private JButton btnModificar =  new JButton("Modificacion");
	private JButton btnAnular =  new JButton("Anulacion");
	private JButton btnAceptar =  new JButton("Calcular Importe");
	private JButton btnCancelar =  new JButton("Cancelar");
	
//	private JLabel lblPasajeroPaquete = new JLabel("Pasajero: ");
//	private JComboBox cmbPasajerosPaquete;
	
	///////////////  20170913
	
	private JLabel lblPasajero = new JLabel("Pasajero: ");
	private JComboBox cmbPasajeros;

	private JLabel lblPasajeroPaquete = new JLabel("Pasajeros: ");

	private JList listaPasajerosOriginal;
	private JScrollPane scrPane2Original;
	private JButton btn2Agregar = new JButton("Agregar >>");
	private JButton btn2Quitar = new JButton("<< Quitar");
	private DefaultListModel listModelPasajeros;
	private JList listaPasajerosCopia;
	private JScrollPane scrPane2Copia;
	private JPanel pnl2Copia;
	
	//////////////
	
	private JLabel lblLocalidadesPaquete = new JLabel("Localidades: ");
	private JList listaLocalidadesOriginal;
	private JScrollPane scrPaneOriginal;
	private JButton btnAgregar = new JButton("Agregar >>");
	private JButton btnQuitar = new JButton("<< Quitar");
	private JList listaLocalidadesCopia;
	private JScrollPane scrPaneCopia;
	private DefaultListModel listModel;
	private JPanel pnlCopia;
	
	private JLabel lblFechaSalida = new JLabel("Fecha salida: ");
	private JTextField txtFechaSalida = new JTextField(Constants.TEXTO_ANCHO * 3/4);
	
	private JLabel lblHorarioSalida = new JLabel("Horario salida: ");
	private JComboBox cmbHorarios;
	private JComboBox cmbHoras;
	private DefaultComboBoxModel comboModel;

	private JLabel lblCantidadDias = new JLabel("Cantidad de dias: ");
	private JTextField txtCantidadDias = new JTextField(Constants.TEXTO_ANCHO * 3/4);

	private JLabel lblSeguro = new JLabel("Quiere seguro?: ");
	private JRadioButton rdbSi;
	private JRadioButton rdbNo;
	private JRadioButton rdbOcultoSeguro;
	private ButtonGroup grpSeguro;
		
	private static final String LEYENDA = "Brindar copia de condiciones y limites del contrato de seguro junto " +
			"con los datos de contacto ante cualquier emergencia"; 	 
	private JTextArea leyenda = new JTextArea(LEYENDA, 4, Constants.TEXTO_ANCHO);

	private JCheckBox quiereAbonoTransporteLocal = new JCheckBox("Requiere abono transporte");
	
	private JCheckBox quiereVisitasGuiadas = new JCheckBox("Requiere guia");
	
	private JLabel lblHoteles = new JLabel("Hotel/es: ");
	private JComboBox cmbHoteles;
	
	private JCheckBox esPensionCompleta = new JCheckBox("Pension completa");
	
	private JLabel lblImporte = new JLabel("Importe: ");
	private JTextField txtImporte = new JTextField(Constants.TEXTO_ANCHO * 3/4);
	
	private Component[] componentesPaqueteEncontrado;
	private int idPaqueteEncontrado = 0;
	
	private ConsultaActualizacionController consultaActualizacionController;

	
	public ConsultaActualizacionView(ConsultaActualizacionController consultaActualizacionController) {
		
		consultaActualizacionController.setView(this);
		this.consultaActualizacionController = consultaActualizacionController;
		
		GuiUtilities.aplicarFormatoVentana(ventana);
		
		cmbHorarios = new JComboBox(this.consultaActualizacionController.getTurnosFromTxt());

		///////////
		PasajerosDao pasajerosDao = PasajerosDao.getInstance();
		ArrayList<Pasajeros> pasajerosList = pasajerosDao.getPasajeros();
		
		Object[] pasajeros = pasajerosList.toArray();
		cmbPasajeros = new JComboBox(pasajeros);

		cmbLocalidades = new JComboBox(this.consultaActualizacionController.getLocalidadesFromTxt());
		
		GuiUtilities.setearComandoBoton(btnConsultar, "Consultar", consultaActualizacionController);
		GuiUtilities.setearComandoBoton(btnModificar, "Modificacion", consultaActualizacionController);
		GuiUtilities.setearComandoBoton(btnAnular, "Anulacion", consultaActualizacionController);
		
		Component[] componentesArray = {lblPasajero, cmbPasajeros, lblLocalidades, cmbLocalidades, 
				btnConsultar, btnModificar, btnAnular};
		
		GuiUtilities.agregarComponentesVentana(ventana, componentesArray);
		
		ocultarVisibilizarBotonesVentana(false);

//		cmbPasajerosPaquete = new JComboBox(this.consultaActualizacionController.getPasajerosFromTxt());
		
 		int opcionSeleccion = ListSelectionModel.MULTIPLE_INTERVAL_SELECTION;

		/////////////////////////////////

		listaPasajerosOriginal = new JList(pasajeros);		
		GuiUtilities.aplicarFormatoLista(ventana, listaPasajerosOriginal, opcionSeleccion);
		scrPane2Original = new JScrollPane(listaPasajerosOriginal); 

		GuiUtilities.setearComandoBoton(btn2Agregar, "AgregarPasajero", consultaActualizacionController);
		GuiUtilities.setearComandoBoton(btn2Quitar, "QuitarPasajero", consultaActualizacionController);
		
		listModelPasajeros = new DefaultListModel();
		
		listaPasajerosCopia = new JList(listModelPasajeros);
		GuiUtilities.aplicarFormatoLista(ventana, listaPasajerosCopia, opcionSeleccion);
		scrPane2Copia = new JScrollPane(listaPasajerosCopia); 
		
		pnl2Copia = new JPanel();
		GuiUtilities.aplicarFormatoPanel(ventana, pnl2Copia, listaPasajerosOriginal, listaPasajerosCopia);
		/////////////////////////////////
		
		listaLocalidadesOriginal = new JList(this.consultaActualizacionController.getLocalidadesFromTxt());
		GuiUtilities.aplicarFormatoLista(ventana, listaLocalidadesOriginal, opcionSeleccion);
		scrPaneOriginal = new JScrollPane(listaLocalidadesOriginal); 

		GuiUtilities.setearComandoBoton(btnAgregar, "AgregarLocalidad", consultaActualizacionController);
		GuiUtilities.setearComandoBoton(btnQuitar, "QuitarLocalidad", consultaActualizacionController);

		listModel = new DefaultListModel();
		
		listaLocalidadesCopia = new JList(listModel);
		GuiUtilities.aplicarFormatoLista(ventana, listaLocalidadesCopia, opcionSeleccion);
		scrPaneCopia = new JScrollPane(listaLocalidadesCopia); 
		
		pnlCopia = new JPanel();
		GuiUtilities.aplicarFormatoPanel(ventana, pnlCopia, listaLocalidadesOriginal, listaLocalidadesCopia);
				
		GuiUtilities.aplicarFormatoTextField(ventana, txtFechaSalida);
		txtFechaSalida.setText("dd/mm/yyyy");
		
		txtFechaSalida.addMouseListener(new MouseAdapter() { 
	          
			public void mousePressed(MouseEvent e) { 
	              
	        	  txtFechaSalida.setText("");
	          }
		});

		cmbHorarios.setActionCommand("Seleccionar");
		cmbHorarios.addActionListener(consultaActualizacionController);
		
		comboModel = new DefaultComboBoxModel();
		cmbHoras = new JComboBox(comboModel);
		cmbHoras.setMaximumRowCount(Constants.ITEMS_MOSTRAR);
		
		GuiUtilities.aplicarFormatoTextField(ventana, txtCantidadDias);
		txtCantidadDias.setText("1");
		
		rdbSi = new JRadioButton("Si");
		GuiUtilities.aplicarFormatoRadioButton(ventana, rdbSi, rdbSi.getText(), consultaActualizacionController);
		rdbNo = new JRadioButton("No");
		GuiUtilities.aplicarFormatoRadioButton(ventana, rdbNo, rdbNo.getText(), consultaActualizacionController);
		rdbOcultoSeguro = new JRadioButton("");
		rdbOcultoSeguro.setVisible(false);
		
		grpSeguro = new ButtonGroup();
		this.addBotonesGrupo(grpSeguro);
		
		GuiUtilities.aplicarFormatoTextArea(ventana, leyenda);
		leyenda.setBorder(BorderFactory.createLineBorder(Color.RED));
		leyenda.setVisible(false);
		
		cmbHoteles = new JComboBox(this.consultaActualizacionController.getHotelesFromTxt());
		
		GuiUtilities.aplicarFormatoTextField(ventana, txtImporte);
		txtImporte.setEditable(false);

		GuiUtilities.setearComandoBoton(btnAceptar, "Calcular", consultaActualizacionController);
		GuiUtilities.setearComandoBoton(btnCancelar, "Cancelar", consultaActualizacionController);
		
		Component[] componentesPaqueteArray = {lblPasajeroPaquete, scrPane2Original, btn2Agregar, btn2Quitar, 
				pnl2Copia, scrPane2Copia, lblLocalidadesPaquete, 
				scrPaneOriginal, btnAgregar, btnQuitar, pnlCopia, scrPaneCopia, lblFechaSalida, txtFechaSalida, 
				lblHorarioSalida, cmbHorarios, cmbHoras, lblCantidadDias, txtCantidadDias, lblSeguro, 
				rdbOcultoSeguro, rdbSi, rdbNo, leyenda, quiereAbonoTransporteLocal, quiereVisitasGuiadas, 
				lblHoteles, cmbHoteles, esPensionCompleta, lblImporte, txtImporte, btnAceptar, btnCancelar};
		
		this.componentesPaqueteEncontrado = componentesPaqueteArray;
		
		GuiUtilities.agregarComponentesVentana(ventana, componentesPaqueteArray);
		this.ocultarVisibilizarComponentesVentana(componentesPaqueteArray, false, false);
		
		ventana.setVisible(true);

	}

	public void ocultarVisibilizarBotonesVentana(boolean visible){
		
		btnModificar.setVisible(visible);
		btnAnular.setVisible(visible);

	}

	public void ocultarVisibilizarComponentesVentana(Component[] componentes, boolean visible, boolean habilitado) {
		
		for (int i = 0; i < componentes.length; i++) {
				
			componentes[i].setVisible(visible);
			componentes[i].setEnabled(habilitado);
			
		}
		
		leyenda.setVisible(false);
		
	}
	
	private void addBotonesGrupo(ButtonGroup grupoBotones) {

		grpSeguro.add(rdbOcultoSeguro);
		grpSeguro.add(rdbSi);
		grpSeguro.add(rdbNo);
				
	}

	public void mostrarMensajeDialog(String mensajeBody, String titulo) {
		
		JOptionPane.showMessageDialog(null, mensajeBody, titulo, JOptionPane.INFORMATION_MESSAGE);
//		this.cerrar();
	}
	
	public JComboBox getCmbPasajeros() {
		return cmbPasajeros;
	}

	public JComboBox getCmbLocalidades() {
		return cmbLocalidades;
	}

	public void fillForm(Object[] pasajeros, Object[] documentosList, Object[] localidades,
			String fecha, String hora,
			boolean tieneSeguro, boolean quiereAbonoTransporteLocal2,
			boolean quiereVisitasGuiadas2, String hotel, boolean pensionCompleta, String importe) {

		for (int i = 0; i < localidades.length; i++) {
			
			this.listModel.addElement((String)localidades[i]);
		}
		
//		cmbPasajerosPaquete.setSelectedItem(nombreApellido);
		
		for (int i = 0; i < pasajeros.length; i++) {
			
			this.listModelPasajeros.addElement(pasajeros[i]);
		}

		txtFechaSalida.setText(fecha);
		cmbHoras.setSelectedItem(hora);
		cmbHorarios.setSelectedItem(this.getTurnoByHora(hora));
		rdbOcultoSeguro.setSelected(tieneSeguro);
		esPensionCompleta.setSelected(pensionCompleta);
		quiereAbonoTransporteLocal.setSelected(quiereAbonoTransporteLocal2);
		quiereVisitasGuiadas.setSelected(quiereVisitasGuiadas2);
		 
		if(hotel != null && !hotel.trim().isEmpty()){
			
			cmbHoteles.setSelectedItem(hotel);
		}else{
			
			cmbHoteles.setSelectedIndex(0);
		}
		
		txtImporte.setText(importe);
		
		this.ocultarVisibilizarComponentesVentana(this.componentesPaqueteEncontrado, true, false);
		this.ocultarVisibilizarBotonesVentana(true);
	}
	
	public Component[] getComponentesPaqueteEncontrado() {
		return componentesPaqueteEncontrado;
	}

	//hh:mm
	public String getTurnoByHora(String horaMinutos){
		
		int hora = Integer.valueOf(horaMinutos.substring(0,2));
		
		if(hora >= 0 && hora < 12){
			
			return "Manana";
		}else if(hora >= 12 && hora < 21){
			
			return "Tarde";
		}else{
			
			return "Noche";
		}
	}

	public boolean validar() {

		ArrayList<String> errores = new ArrayList<>();
		boolean datosValidos = true;

		if(this.listModel.getSize() < 1){

			errores.add("localidades");
		}
//		if(this.cmbPasajeros.getSelectedIndex() <= 0){
		if(this.listModelPasajeros.getSize() < 1){
			
			errores.add("pasajero");
		}
		if(this.txtFechaSalida.getText().trim().isEmpty()
				|| this.txtFechaSalida.getText().trim().equals("dd/mm/yyyy")
				){

			errores.add("fecha salida");
		}else{

			try{
				int dia = Integer.valueOf(this.txtFechaSalida.getText().trim().substring(0,2));
				int mes = Integer.valueOf(this.txtFechaSalida.getText().trim().substring(3,5));
				int anio = Integer.valueOf(this.txtFechaSalida.getText().trim().substring(6,10));

				if(!((dia > 0 && dia <=31) && (mes > 0 && mes <= 12) && (anio >= 2017 && anio <= 9999))){

					errores.add("fecha salida");
				}
			}catch(NumberFormatException e){

				errores.add("fecha salida");
			}
		}

		if(this.cmbHorarios.getSelectedIndex() <= 0){

			errores.add("turno");
		}
		if(this.cmbHoras.getSelectedIndex() <= 0){

			errores.add("hora");
		}
		try{

			Integer cantidadDias = Integer.valueOf(txtCantidadDias.getText());

			if(cantidadDias < 1){

				errores.add("cantidad de dias");	
			}

		}catch(Exception ex){

			errores.add("cantidad de dias");
		}

		if(!errores.isEmpty()){

			String error = "Los datos de:\n";

			for (int i = 0; i < errores.size(); i++) {

				error = error + "\n- " + errores.get(i);
			}

			error += "\n\nson invalidos.";

			datosValidos = false;

			JOptionPane.showMessageDialog(null, error, "Datos obligatorios", 
					JOptionPane.INFORMATION_MESSAGE);
		}

		return datosValidos;
	}
	
	public int getIdPaqueteEncontrado() {
		return idPaqueteEncontrado;
	}

	public void setIdPaqueteEncontrado(int idPaqueteEncontrado) {
		this.idPaqueteEncontrado = idPaqueteEncontrado;
	}
	
	public void limpiar() {
		
		this.habilitarCampos(true);
		
		String output =  "dd/mm/yyyy";
		
//		cmbPasajerosPaquete.setSelectedIndex(0);
		listModelPasajeros.removeAllElements();
		listaLocalidadesOriginal.clearSelection();
		listModel.removeAllElements();
		txtFechaSalida.setText(output);
		cmbHorarios.setSelectedIndex(0);
		comboModel.removeAllElements();
		txtCantidadDias.setText("1");
		cmbHoteles.setSelectedIndex(0);
		txtImporte.setText("");
		rdbOcultoSeguro.setSelected(true);
		esPensionCompleta.setSelected(false);
		quiereAbonoTransporteLocal.setSelected(false);
		quiereVisitasGuiadas.setSelected(false);
		this.btnAceptar.setText("Calcular Importe");
		GuiUtilities.setearComandoBoton(btnAceptar, "Calcular", this.consultaActualizacionController);	
	}
	
	public void habilitarCampos(boolean b) {

		cmbPasajeros.setEnabled(b);
		
		listaPasajerosOriginal.setEnabled(b);
		listaPasajerosCopia.setEnabled(b);
		listaLocalidadesOriginal.setEnabled(b);
		listaLocalidadesCopia.setEnabled(b);
		txtFechaSalida.setEnabled(b);
		cmbHorarios.setEnabled(b);
		cmbHoras.setEnabled(b);
		txtCantidadDias.setEnabled(b);
		cmbHoteles.setEnabled(b);
		txtImporte.setEnabled(b);
		rdbOcultoSeguro.setEnabled(b);
		esPensionCompleta.setEnabled(b);
		quiereAbonoTransporteLocal.setEnabled(b);
		quiereVisitasGuiadas.setEnabled(b);
		btnAgregar.setEnabled(b);
		btnQuitar.setEnabled(b);
		rdbSi.setEnabled(b);
		rdbNo.setEnabled(b);
	}

	public JList getListaLocalidadesOriginal() {
		return listaLocalidadesOriginal;		
	}

	public DefaultListModel getModelo() {
		return listModel;
	}

	public void cerrar() {
		ventana.dispose();
	}

	public JRadioButton getRdbSi() {
		return rdbSi;
	}
	
	public JRadioButton getRdbNo() {
		return rdbNo;
	}

	public JTextArea getLeyenda() {
		return leyenda;
	}

	public JComboBox getComboHorarios() {
		return cmbHorarios;
	}

	public int getComboHorariosIndex() {
		return getComboHorarios().getSelectedIndex();
	}

	public JComboBox getComboHoras() {
		return cmbHoras;
	}

	public DefaultComboBoxModel getComboModel() {
		return comboModel;
	}

	public JList getListaLocalidadesCopia() {
		return listaLocalidadesCopia;
	}

	public JTextField getTxtImporte() {
		return txtImporte;
	}

	public JTextField getTxtFechaSalida() {
		return txtFechaSalida;
	}

	public JList getListaPasajerosCopia() {
		return listaPasajerosCopia;
	}

	public JCheckBox getQuiereAbonoTransporteLocal() {
		return quiereAbonoTransporteLocal;
	}

	public JCheckBox getQuiereVisitasGuiadas() {
		return quiereVisitasGuiadas;
	}

	public ButtonGroup getGrpSeguro() {
		return grpSeguro;
	}
	
	public JComboBox getCmbHoteles() {
		return cmbHoteles;
	}

	public JCheckBox getEsPensionCompleta() {
		return esPensionCompleta;
	}

	public JTextField getTxtCantidadDias() {
		return txtCantidadDias;
	}
	
	public void mostrarImporte(double importe) {

		this.txtImporte.setText(String.valueOf(importe));
		
		this.habilitarCampos(false);
		
		this.btnAceptar.setText("Aceptar");
		GuiUtilities.setearComandoBoton(btnAceptar, "Aceptar", this.consultaActualizacionController);

	}
}