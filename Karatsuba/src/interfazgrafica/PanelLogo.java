package interfazgrafica;

import java.awt.Graphics;
import java.awt.Image;
import java.net.URL;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

/**
 * 
 * Código modificado de http://swing-facil.blogspot.com/2011/06/jpanel-transparente-jpanel-con-imagen.html
 *
 */
public class PanelLogo extends JPanel {

	//Definición de los atributos de la clase
	private static final long serialVersionUID = 1L;
	private Image imagenLogo;

	/**
	 * Método constructor
	 */
	public PanelLogo() {
		super();
	}
	
	/**
	 * Método que obtiene la imágen indicada en la 
	 * ruta recibida como parámetro
	 * 
	 * @param path La ruta donde se encuentra la imágen
	 * @return La imágen obtenida
	 */
	public void crearImagen(String rutaArchivo) {
		//Se arma la URL de la ubicación de la imágen
		URL imgURL = getClass().getResource(rutaArchivo);
		if (imgURL != null) {
			//Se asigna la imágen al atributo de la clase
			imagenLogo = new ImageIcon(imgURL).getImage();
		} else {
			System.err.println("No se encuentra el archivo: " + rutaArchivo);
		}
	}

	@Override
	public void paint(Graphics g) {
		//Se dibuja la imágen
		if (imagenLogo != null) {
			g.drawImage(imagenLogo, 0, 0, null);
		}
	}
}
