package presentacion;

import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.ProgressMonitor;

import org.math.plot.Plot2DPanel;

public class VistaImp extends Vista {

	private  PanelInfo panelInfo;
	//private  Textos textos;
	private  JFrame frame;
	private  Plot2DPanel plot ;
	
	public VistaImp(){
		frame = new JFrame();
		frame.setTitle("Programación Evolutiva");
		frame.setSize(1200, 900);
		panelInfo = new PanelInfo();
		frame.setLayout(new BorderLayout());
		frame.add(panelInfo, BorderLayout.WEST);

		grafica();
		
		frame.setVisible(true);
	}
	private void grafica() {

		// Para crear un panel
		plot = new Plot2DPanel();
		//plot.setBackground(new java.awt.Color(187, 212, 238));
		// Para añadir la leyenda abajo
		plot.addLegend("SOUTH");
		// Para añadir lineas
		
		// Tambien se puede hacer con una matriz
		//plot.addLinePlot("my plot", x, y);
		// Para eliminar las herramientas que salen arriba
		plot.plotToolBar.removeAll();
		// Lo añado al jframe
		frame.add(plot, BorderLayout.CENTER);
	}
	@Override
	public void repintaGrafica(double[] x_generaciones, double[] y_mejorPoblacion,
			double[] y_mejorAbsoluto,double[] y_media, String mensaje, double mejorAbsoluto,
			double peorAbsoluto, Integer totalCruces, Integer totalMutaciones) {
		double aux = y_media[2] ;
		y_media[0] = aux;
		y_mejorPoblacion[0] = aux;
		y_mejorAbsoluto[0] = aux;
		
		double media = 0.0;
		for(int i = 0; i < y_media.length; i++)
		{
			media += y_media[i];
		}
		media = media / y_media.length;
		
		plot.removeAllPlots();
		plot.addLegend("SOUTH");
		plot.addLinePlot("Mejor absoluto", x_generaciones, y_mejorAbsoluto);
		plot.addLinePlot("Mejor de la generación", x_generaciones, y_mejorPoblacion);
		plot.addLinePlot("Media de la población", x_generaciones, y_media);
		String estadisticas = System.getProperty("line.separator")
				+ System.getProperty("line.separator") + "Mejor: " + mejorAbsoluto
				+ System.getProperty("line.separator") + "Peor: " + peorAbsoluto
				+ System.getProperty("line.separator") + "Media: " + media
				+ System.getProperty("line.separator") + "Total cruces: " + totalCruces
				+ System.getProperty("line.separator") + "Total mutaciones: " + totalMutaciones;
		this.panelInfo.setTexto(mensaje, estadisticas);
	}
	@Override
	public void pintaProgreso(int num) {
		
		this.panelInfo.setProgress(num);
		this.frame.repaint();
//		this.frame.repaint();
		panelInfo.repaint();
	}
	
}
