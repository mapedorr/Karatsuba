package interfazgrafica;

import java.awt.event.ActionListener;
import javax.swing.JFrame;
import constantes.Constantes;
import karatsuba.KaratsubaAlgoritmo;

public class KaratsubaUI extends JFrame {
	
	//Atributo de identificación para la clase
	private static final long serialVersionUID = 1L;
	
	//Definición de atributos de ventana
	private javax.swing.JButton botonMultiplicar;
    private javax.swing.JTextField campoTextoY;
    private javax.swing.JTextField campoTextoResultado;
    private javax.swing.JTextField campoTextoX;
    private javax.swing.JLabel errorCampoX;
    private javax.swing.JLabel errorCampoY;
    private javax.swing.JLabel etiquetaCampoX;
    private javax.swing.JLabel etiquetaCampoY;
    private javax.swing.JLabel etiquetaResultado;
    private javax.swing.JPanel panelFormulario;
    private PanelLogo panelLogo;
    private javax.swing.JPanel panelPrincipal;
    
    //Objeto para acceder al resultado de la operación
    private KaratsubaAlgoritmo operador;
    
    /**
     * Método constructor
     */
    public KaratsubaUI(KaratsubaAlgoritmo operador){
    	//Se inician los atributos de la clase
    	panelPrincipal = new javax.swing.JPanel();
    	panelFormulario = new javax.swing.JPanel();
    	panelLogo = new PanelLogo();
        etiquetaCampoX = new javax.swing.JLabel();
        campoTextoX = new javax.swing.JTextField();
        errorCampoX = new javax.swing.JLabel();
        etiquetaCampoY = new javax.swing.JLabel();
        campoTextoY = new javax.swing.JTextField();
        errorCampoY = new javax.swing.JLabel();
        botonMultiplicar = new javax.swing.JButton();
        etiquetaResultado = new javax.swing.JLabel();
        campoTextoResultado = new javax.swing.JTextField();
        
        this.operador = operador;
        
        //Se definen las propiedades del frame en el que se ubicarán los campos
        //y páneles del formulario
        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle(Constantes.VENTANTA_TITULO);
        setBackground(new java.awt.Color(250, 250, 250));
        setName("framePrincipal");
        setResizable(false);
        
        //Se definen las propiedades del pánel principal
        panelPrincipal.setBackground(new java.awt.Color(255, 255, 255));
        
        //Se definen las propiedades del pánel que contendrá los campos del formulario
        panelFormulario.setBackground(new java.awt.Color(255, 255, 255));
        
        //Se definen las propiedades para el pánel del logotipo
        panelLogo.setBackground(new java.awt.Color(255, 255, 255));
        panelLogo.crearImagen("logo_calculadora_karatsuba.png");
        panelLogo.setOpaque(false);

        //Se definen las propiedades de la etiqueta para el campo del primer número
        etiquetaCampoX.setFont(new java.awt.Font("Tahoma", 0, 14));
        etiquetaCampoX.setForeground(new java.awt.Color(60, 60, 60));
        etiquetaCampoX.setText(Constantes.ETIQUETA_CAMPO_X);

        //Se definen las propiedades para el campo de texto del primer número
        campoTextoX.setBackground(new java.awt.Color(224, 224, 224));
        campoTextoX.setBorder(null);
        
        //Se definen las propiedades para la etiqueta de error del primer campo de texto
        errorCampoX.setForeground(new java.awt.Color(224, 0, 0));

        //Se definen las propiedades de la etiqueta para el campo del segundo número
        etiquetaCampoY.setFont(new java.awt.Font("Tahoma", 0, 14));
        etiquetaCampoY.setForeground(new java.awt.Color(60, 60, 60));
        etiquetaCampoY.setText(Constantes.ETIQUETA_CAMPO_Y);

        //Se definen las propiedades de la etiqueta para el campo del segundo número
        campoTextoY.setBackground(new java.awt.Color(224, 224, 224));
        campoTextoY.setBorder(null);
        
        //Se definen las propiedades para la etiqueta de error del segundo campo de texto
        errorCampoY.setForeground(new java.awt.Color(224, 0, 0));

        //Se definen las propiedades del botón Multiplicar
        botonMultiplicar.setBackground(new java.awt.Color(220, 100, 50));
        botonMultiplicar.setForeground(new java.awt.Color(255, 255, 255));
        botonMultiplicar.setFont(new java.awt.Font("Tahoma", 0, 14));
        botonMultiplicar.setText(Constantes.ETIQUETA_BOTON_MULTIPLICAR);
        botonMultiplicar.setBorderPainted(false);

        //Se definen las propiedades de la etiqueta para el campo del resultado
        etiquetaResultado.setBackground(new java.awt.Color(0, 0, 0));
        etiquetaResultado.setFont(new java.awt.Font("Tahoma", 0, 14));
        etiquetaResultado.setForeground(new java.awt.Color(60, 60, 60));
        etiquetaResultado.setText(Constantes.ETIQUETA_CAMPO_RESULTADO);

        //Se definen las propiedades para el campo de texto del resultado
        campoTextoResultado.setBorder(null);
        campoTextoResultado.setEditable(false);
        
        //Se configura y distribuye el pánel del logo
        javax.swing.GroupLayout panelLogoLayout = new javax.swing.GroupLayout(panelLogo);
        panelLogo.setLayout(panelLogoLayout);
        panelLogoLayout.setHorizontalGroup(
            panelLogoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 130, Short.MAX_VALUE)
        );
        panelLogoLayout.setVerticalGroup(
            panelLogoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        
        //Se configura y distribuyen los campos en el pánel para el formulario
        javax.swing.GroupLayout panelFormularioLayout = new javax.swing.GroupLayout(panelFormulario);
        panelFormulario.setLayout(panelFormularioLayout);
        panelFormularioLayout.setHorizontalGroup(
            panelFormularioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelFormularioLayout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addGroup(panelFormularioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(botonMultiplicar, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(panelFormularioLayout.createSequentialGroup()
                        .addGroup(panelFormularioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(etiquetaCampoY)
                            .addComponent(etiquetaResultado)
                            .addComponent(etiquetaCampoX))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 5, Short.MAX_VALUE)
                        .addGroup(panelFormularioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(campoTextoX, javax.swing.GroupLayout.DEFAULT_SIZE, 200, Short.MAX_VALUE)
                            .addComponent(campoTextoResultado)
                            .addComponent(campoTextoY))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 8, Short.MAX_VALUE)
                .addGroup(panelFormularioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(errorCampoX, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(errorCampoY, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        panelFormularioLayout.setVerticalGroup(
            panelFormularioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelFormularioLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelFormularioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(etiquetaCampoX)
                    .addComponent(campoTextoX, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(errorCampoX))
                .addGap(14, 14, 14)
                .addGroup(panelFormularioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(etiquetaCampoY)
                    .addComponent(campoTextoY, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(errorCampoY))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(botonMultiplicar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(panelFormularioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(etiquetaResultado)
                    .addComponent(campoTextoResultado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(39, 39, 39))
        );
        
        //Se configura y distribuye el pánel principal
        javax.swing.GroupLayout panelPrincipalLayout = new javax.swing.GroupLayout(panelPrincipal);
        panelPrincipal.setLayout(panelPrincipalLayout);
        panelPrincipalLayout.setHorizontalGroup(
            panelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelPrincipalLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(panelLogo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(panelFormulario, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        panelPrincipalLayout.setVerticalGroup(
            panelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelPrincipalLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(panelFormulario, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(panelLogo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelPrincipal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelPrincipal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        
        //Se ajusta el tamaño de la ventana a su contenido
        pack();
    }
    
    /**
     * Método que asigna al botón Multiplicar un objeto de control de eventos
     * 
     * @param escuchador Objeto que controlará los eventos en el botón
     */
    public void asignarListenerBotonMultiplicar(ActionListener escuchador){
    	botonMultiplicar.addActionListener(escuchador);
    }
    
    /**
     * Método que deshabilita los campos del formulario durante
     * el procesamiento de los datos
     * 
     */
    public void deshabilitarFormulario(){
    	campoTextoX.setEditable(false);
    	campoTextoX.setEnabled(false);
    	
    	campoTextoY.setEditable(false);
    	campoTextoY.setEnabled(false);
    	
    	botonMultiplicar.setEnabled(false);
    }
    
    /**
     * Método que habilita los campos del formulario
     */
    public void habilitarFormulario(){
    	campoTextoX.setEditable(true);
    	campoTextoX.setEnabled(true);
    	
    	campoTextoY.setEditable(true);
    	campoTextoY.setEnabled(true);
    	
    	botonMultiplicar.setEnabled(true);
    }
    
    //---------------- ---------------- ----------------
    //Métodos para establecer y obtener valores del formulario
    //---------------- ---------------- ----------------
    
    /**
     * Método que establece el resultado de la operación realizada
     * 
     */
    public void establecerResultado(){
    	campoTextoResultado.setText( operador.getResultadoOperacion() != null ? operador.getResultadoOperacion().toString() : "" );
    	pack();
    }
    
    public String obtenerNumeroX(){
    	return campoTextoX.getText();
    }
    
    public String obtenerNumeroY(){
    	return campoTextoY.getText();
    }
    
    public void mostrarErrorCampo(String error, javax.swing.JLabel campo){
    	campo.setText(error);
    	pack();
    }	
    
    //---------------- ---------------- ----------------
    //Métodos GET y SET de los atributos de la clase
    //---------------- ---------------- ----------------
    
    public javax.swing.JLabel getErrorCampoX() {
		return errorCampoX;
	}

	public void setErrorCampoX(javax.swing.JLabel errorCampoX) {
		this.errorCampoX = errorCampoX;
	}

	public javax.swing.JLabel getErrorCampoY() {
		return errorCampoY;
	}

	public void setErrorCampoY(javax.swing.JLabel errorCampoY) {
		this.errorCampoY = errorCampoY;
	}
    
}
