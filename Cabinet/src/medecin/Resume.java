package medecin;


import java.util.List;
import java.time.LocalDate;
import java.util.ArrayList;
import secretaire.Patient;

public class Resume {

	    private int num_resu;
	    private String nom;
	    private String prenom;
	    private LocalDate date_res;
	    private String nom_mald;
	    private List<String> remarques;
	    private Patient patient;
	    private static int dernierNumCert = 0;


	    public int getNum_resu() {
	        return num_resu;
	    }

	    public void setNum_resu(int num_resu) {
	        this.num_resu = num_resu;
	    }

	    public List<String> getRemarques() {
	        return remarques;
	    }

	    public void setRemarques(List<String> remarques) {
	        this.remarques = remarques;
	    }

	    public static int getDernierNumCert() {
	        return dernierNumCert;
	    }

	    public static void setDernierNumCert(int dernierNumCert) {
	        Resume.dernierNumCert = dernierNumCert;
	    }
		public LocalDate getDate_res() {
			return date_res;
		}

		public void setDate_res(LocalDate date_res) {
			this.date_res = date_res;
		}
		public String getNom_mald() {
			return nom_mald;
		}

		public void setNom_mald(String nom_mald) {
			this.nom_mald = nom_mald;
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
	    public Resume(String nom,String prenom,String nom_mald) {
	        this.num_resu = ++dernierNumCert;
	        LocalDate dateCourante = LocalDate.now();
	        this.nom = nom;
	        this.prenom = prenom;
	        this.nom_mald =nom_mald;
	        this.date_res = dateCourante ;
	        this.remarques = new ArrayList<>();
	      
	    }

	    public void ajouterRemarque(String remarque) {
	        this.remarques.add(remarque);
	    }

	    public void modifierRemarque(int index, String nouvelleRemarque) {
	        if (index >= 0 && index < remarques.size()) {
	            remarques.set(index, nouvelleRemarque);
	        } else {
	            System.out.println("Index invalide pour modification de remarque.");
	        }
	    }

	    public void afficher() {
	        System.out.println("Le numéro de résumé : " + num_resu);
	        System.out.println("Le nom du  patient : "+nom);
	        System.out.println("Le prenom du  patient : "+prenom);
	        System.out.println("Le nom de la maladie : "+nom_mald);
	        System.out.println("Les remarques : ");
	        for (String remarque : remarques) {
	            System.out.println("- " + remarque);
	        }
	    }

	    public void ajouterResumeAuDossier(Resume resume) {
		    for (Dossier_medical dossier : patient.getListeDossierMedical()) {
		        if (dossier.getPatient().getNom().equals(resume.getNom()) &&
		            dossier.getPatient().getPrenom().equals(resume.getPrenom())) {
		           
		            dossier.ajouterResume(resume);
		            System.out.println("Résumé ajouté au dossier médical du patient : " + dossier.getPatient().getNom() + " " + dossier.getPatient().getPrenom());
		            return; 
		        }
		    }
		    System.out.println("Aucun dossier médical trouvé pour le patient : " + resume.getNom() + " " + resume.getPrenom());
		}

		
	}
	