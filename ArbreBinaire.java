/**
	* Classe ArbreBinaire
*/

public class ArbreBinaire
{
	private Noeud racine;

	/**
		* Constructeur ArbreBinaire pour la racine
	*/
	public ArbreBinaire(int levelMax)
	{
		this.racine = new Noeud("R", null);

 		this.construireArbre(1, levelMax, this.racine);
	}

	/**
		* Constructeur ArbreBinaire pour un noeud spécifique
	*/
	public ArbreBinaire(Noeud racine)
	{
		this.racine = racine;
	}

	private void construireArbre(int level, int levelMax, Noeud noeud)
	{
		Noeud tmp=null;

		if ( level <= levelMax )
		{
			// Les possibilités de noeuds sont 0 et 1
			for(char car='0'; car<'2'; car++)
			{
				tmp = new Noeud( Character.toString(car), noeud);
				noeud.ajouterNoeud(tmp);

				this.construireArbre(level+1, levelMax, tmp);
			}
			System.out.println( noeud.getFilsGauche().getVal() + "/" + noeud.getFilsDroit().getVal());
		}
	}

	public String toString()
	{
		return this.afficher(this.racine);
	}

	private String afficher(Noeud noeud)
	{
		String sRet = "";

		if ( noeud != null )
		{
			sRet += noeud.getVal();
			
			sRet += afficher(noeud.getFilsGauche());
			sRet += afficher(noeud.getFilsDroit());
		}

		return sRet;
	}

	//    		R
	// 	  0 		  1
	// 0	 1     0 	1
	//0 1 	0 1   0 1  0 1

   // R 00011011001101

	/**
	 * @return Retourne le sous arbre gauche.
	 */
	public ArbreBinaire getSag()
	{
		// Méthode 1 : on récupère directement le noeud gauche
		return new ArbreBinaire(this.racine.getFilsGauche());


		// Méthode 2 : on recrée l'abre
			// Le noeud du sous arbre gauche est représenté par un "0"
			// Construction de l'arbre
		/**
		Noeud sag = new Noeud("0", null);

		// Construction de l'arbre
		this.construireArbre(1, 3, sag);

		return new ArbreBinaire(sag);
		*/
	}

	/**
	 * @return Retourne le sous arbre droit.
	 */
	public ArbreBinaire getSad()
	{
		// Méthode 1 : on récupère directement le noeud droit
		return new ArbreBinaire(this.racine.getFilsDroit());

		// Méthode 2 : on recrée l'abre
			// Le noeud du sous arbre droit est représenté par un "1"
			// Construction de l'arbre
		/**
		Noeud sad = new Noeud("1", null);

		// Construction de l'arbre
		this.construireArbre(1, 3, sad);

		return new ArbreBinaire(sad);
		*/
	}

	public static void main(String[] args) 
	{
		/*------------TEST------------*/
		/*char c = 'A';
		Noeud racine = new Noeud( Character.toString(c), null );
		
		for(int cpt=c+1; cpt<'Z'; cpt++)
		{
			Noeud fils = new Noeud( Character.toString(cpt), null );
		}*/
		/*----------------------------*/
		
		int levelMax = 2;
		ArbreBinaire arbre = new ArbreBinaire(levelMax);
		System.out.println( arbre );

		System.out.println( arbre.getSad().toString() );

		
	}
}