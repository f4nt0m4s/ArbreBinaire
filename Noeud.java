/**
	Classe Noeud
	@author 	: -
	@version 	: 1.0
*/

public class Noeud
{
	static 	int nbNoeud;

	int 	numNoeud;
	String 	val;

	Noeud noeudGauche;
	Noeud noeudDroit;

	Noeud pere;


	public Noeud ( String val, Noeud pere )
	{
		this.numNoeud 	= Noeud.nbNoeud++;
		this.val 		= val;

		this.noeudGauche 	= null;
		this.noeudDroit 	= null;

		this.pere = pere; // pour la racine, pas de pere donc null
	}

	/**
	 * Méthode pour ajouter un noeud seulement pour les arbres binaires
	 */
	public void ajouterNoeud(Noeud noeud)
	{
		if ( noeud != null )
		{
			if ( this.noeudGauche == null && noeud.getVal().equals("0") )
			{
				this.noeudGauche = noeud;
			}
			else if ( this.noeudDroit == null && noeud.getVal().equals("1") )
			{
				this.noeudDroit = noeud;
			}
		}
	}


	public String 	getVal			() 				{ return this.val;				}
	public Noeud 	getFilsGauche 	() 				{ return this.noeudGauche;		}
	public Noeud 	getFilsDroit 	() 				{ return this.noeudDroit;		}
	public Noeud 	getPere			()				{ return this.pere; 			}


	// Forme textuelle le chemin permettant d'accéder à partir de la racine au noeud courant.
	public String getChemin()
	{
		String sRet = "";

		Noeud n = this;

		while( n != null )
		{
			sRet 	+= n.getVal();
			n 		= n.getPere();
		}

		return new StringBuffer(sRet).reverse().toString();
	}

	public String toString	()				{ return this.val + "(" + this.numNoeud + ")"; }
}