public class SimulatorePrecipitazioni {

	public static void main (String[] args){
		Precipitazioni p = new Precipitazioni();
		VisualizzatoreMatrice vm = new VisualizzatoreMatrice();

		p.aggiungivisualizzatore(vm);
		p.eseguiSimulazione();
	}
}