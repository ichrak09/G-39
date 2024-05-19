package medecin;

import java.time.LocalDate;
import java.util.List;
import secretaire.Patient;

public class Consultation {
	
	    private String nom;
	    private String prenom;
	    private int num_cons;
	    private LocalDate dat_cons;
	    private List<String> diag_cons;
	    private String moti_cons;
	    private String nom_maladie;
	    private static int numPrecedent = 0;
	    private Patient patient;

	    public Consultation(String nom,String prenom,List<String> diag_cons, String moti_cons, String nom_maladie) {
	        this.num_cons = ++numPrecedent;
	        LocalDate dateCourante = LocalDate.now();
	        this.dat_cons = dateCourante;
	        this.nom = nom;
	        this.prenom = prenom;
	        this.diag_cons = diag_cons;
	        this.moti_cons = moti_cons;
	        this.nom_maladie = nom_maladie;
	    }

	    public int getNum_cons() {
	        return num_cons;
	    }

	    public void setNum_cons(int num_cons) {
	        this.num_cons = num_cons;
	    }

	    public LocalDate getDat_cons() {
	        return dat_cons;
	    }

	    public void setDat_cons(LocalDate dat_cons) {
	        this.dat_cons = dat_cons;
	    }

	    public List<String> getDiag_cons() {
	        return diag_cons;
	    }

	    public void setDiag_cons(List<String> diag_cons) {
	        this.diag_cons = diag_cons;
	    }

	    public String getMoti_cons() {
	        return moti_cons;
	    }

	    public void setMoti_cons(String moti_cons) {
	        this.moti_cons = moti_cons;
	    }

	    public String getNom_maladie() {
	        return nom_maladie;
	    }

	    public void setNom_maladie(String nom_maladie) {
	        this.nom_maladie = nom_maladie;
	    }
     	public String getPrenom() {
			return prenom;
		}

		public void setPrenom(String prenom) {
			this.prenom = prenom;
		}

		public String getNom() {
			return nom;
		}

		public void setNom(String nom) {
			this.nom = nom;
		}
	    public void afficher() {
	        System.out.println("Numéro de consultation : " + num_cons);
	        System.out.println("Nom : "+nom);
	        System.out.println("Prénom : "+prenom);
	        System.out.println("Date de consultation : " + dat_cons);
	        System.out.println("Diagnostic de la consultation : " );
	        for (String diag : diag_cons) {
	            System.out.println(" - " + diag);
	        }
	        System.out.println("Motif de la consultation : " + moti_cons);
	        System.out.println("Nom de la maladie : " + nom_maladie);
	    }

	    public void ajouterDiagnostic(String diagnostic) {
	        this.diag_cons.add(diagnostic);
	    }

	    public void modifier(String nom,String prenom,List<String> diag_cons, String moti_cons, String nom_maladie) {
	    	this.nom = nom;
	    	this.prenom = prenom;
	        this.diag_cons = diag_cons;
	        this.moti_cons = moti_cons;
	        this.nom_maladie = nom_maladie;
	    }
	    public void ajouterConsulationAuDossier(Consultation consultation) {
		    for (Dossier_medical dossier : patient.getListeDossierMedical()) {
		        if (dossier.getPatient().getNom().equals(consultation.getNom()) &&
		            dossier.getPatient().getPrenom().equals(consultation.getPrenom())) {
		           
		            dossier.ajouterConsultation(consultation);
		            System.out.println("Consultation ajouté au dossier médical du patient : " + dossier.getPatient().getNom() + " " + dossier.getPatient().getPrenom());
		            return; 
		        }
		    }
		    System.out.println("Aucun dossier médical trouvé pour le patient : " + consultation.getNom() + " " + consultation.getPrenom());
		}

	
	}
	
	