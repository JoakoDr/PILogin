package LogiN;

public class Main {

	public static void main(String[] args) {
	controller miControlador = new controller ();
	Model miModelo = new Model ();
	Vista miVista = new Vista();
	//login miLogin = new login();
	miControlador.setVista(miVista);
	miControlador.setModelo(miModelo);
	
	miModelo.setVista(miVista);
	
	miVista.setModelo(miModelo);
	miVista.setControlador(miControlador);
	
	miVista.setVisible(true);
	}
}

