import java.util.ArrayList;

public class Precipitazioni {

	private int[][] cartaPrecipitazioni;
	/*old code
	private VisualizzatoreMatrice visualizzatore;
    */
	private ArrayList<Visualizzatore> listvisualizzatore;
	
	public Precipitazioni () {
		this.cartaPrecipitazioni = new int[20][20];
		listvisualizzatore = new ArrayList(10);
	}

	int[][] getCartaPrecipitazioni() {
		return this.cartaPrecipitazioni;
	}
/*old code
	public void setVisualizzatore(VisualizzatoreMatrice v) {
		this.visualizzatore = v;
		v.setPrecipitazioni(this);
	}

*/ 
	public void aggiungivisualizzatore (Visualizzatore V) {
		if (listvisualizzatore.size() < 10) {
			listvisualizzatore.add(V);
			V.setPrecipitazioni(this);
		}
	}
	public void notificaAggiornamento(int tempo) {
			for (Visualizzatore V: listvisualizzatore)
			V.aggiornaSchermata(tempo);
	}

	private void calcolaPrecipitazioni(int istanteTemporale){
		for (int i=0; i<this.cartaPrecipitazioni.length; i++)
			for (int j=0; j<this.cartaPrecipitazioni[i].length; j++)
				this.cartaPrecipitazioni[i][j] = (int)(Math.random()*10);
		try { Thread.sleep( 100); }
		catch( InterruptedException e ) {
			e.printStackTrace();
		}
	}

	public void eseguiSimulazione() {
		for (int tempo=0; tempo<100; tempo++) {
			this.calcolaPrecipitazioni(tempo);
			this.notificaAggiornamento(tempo);
		}
	}
}