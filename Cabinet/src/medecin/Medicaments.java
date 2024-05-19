package medecin;

public class Medicaments {
	private String nom;
    private int dosage;
    private int nbrFois;
    private int quantite;
    private String duree;

    public Medicaments(String nom, int dosage, int nbrFois, int quantite, String duree) {
        this.nom = nom;
        this.dosage = dosage;
        this.nbrFois = nbrFois;
        this.quantite = quantite;
        this.duree = duree;
    }

    public String getNom() {
        return nom;
    }

    public int getDosage() {
        return dosage;
    }

    public int getNbrFois() {
        return nbrFois;
    }

    public int getQuantite() {
        return quantite;
    }

    public String getDuree() {
        return duree;
    }

    public void afficher() {
        System.out.println("Nom: " + nom + ", Dosage: " + dosage + ", Nombre de fois: " + nbrFois + 
        		", Quantité: " + quantite + ", Durée: " + duree);
    }
}
