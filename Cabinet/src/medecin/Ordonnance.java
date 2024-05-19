package medecin;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import secretaire.Patient;

public class Ordonnance {
	

	private int num_ordo;
	private String nom;
	private String prenom;
    private List<Medicaments> medicaments;
    private static int nbrPrecedent = 0;
    private LocalDate date_ordo;
    private Patient patient;

    public Ordonnance(String nom,String prenom) {
        this.num_ordo = ++nbrPrecedent;
        this.nom = nom;
        this.prenom = prenom;
        LocalDate dateCourante = LocalDate.now();
        this.date_ordo = dateCourante;
        this.medicaments = new ArrayList<>();
    }

    public int getNum_ordo() {
        return num_ordo;
    }

    public void setNum_ordo(int num_ordo) {
        this.num_ordo = num_ordo;
    }

    public LocalDate getDate_ordo() {
        return date_ordo;
    }

    public void setDate_ordo(LocalDate date_ordo) {
        this.date_ordo = date_ordo;
    }
    public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
	
    public List<Medicaments> getMedicaments() {
        return medicaments;
    }

    public void ajouterMedicament(Medicaments medicament) {
        this.medicaments.add(medicament);
    }

    public void afficher() {
        System.out.println("Numéro de l'ordonnance: " + num_ordo);
        System.out.println("Nom : "+nom);
        System.out.println("Prénom : "+prenom);
        System.out.println("Date de l'ordonnance: " + date_ordo);
        System.out.println("Médicaments:");
        for (Medicaments medicament : medicaments) {
            medicament.afficher();
        }
    }
    public void modifier( List<Medicaments> nouveauxMedicaments) {
        this.medicaments = nouveauxMedicaments;
    }

    public void ajouterOrdonnanceAuDossier(Ordonnance ordonnace) {
	    for (Dossier_medical dossier : patient.getListeDossierMedical()) {
	        if (dossier.getPatient().getNom().equals(ordonnace.getNom()) &&
	            dossier.getPatient().getPrenom().equals(ordonnace.getPrenom())) {
	           
	            dossier.ajouterOrdonnance(ordonnace);
	            System.out.println("Ordonnance ajouté au dossier médical du patient : " + dossier.getPatient().getNom() + " " + dossier.getPatient().getPrenom());
	            return; 
	        }
	    }
	    System.out.println("Aucun dossier médical trouvé pour le patient : " + ordonnace.getNom() + " " + ordonnace.getPrenom());
	}

}
	
	
	
	
	