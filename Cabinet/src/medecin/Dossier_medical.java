package medecin;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import secretaire.Patient;
import secretaire.RDV;

public class Dossier_medical {
    private int num_doss;     
    private LocalDate dat_doss;
    private static int nbrPrecedent = 0;
    private String nom;
	private String prenom;
    private Patient patient;
    private List<Patient> listePatient;
    private List<Ordonnance> listeOrdonnance;
    private List<RDV> listeRendezVous;
    private List<Consultation> listeConsultations;
    private List<Certificat> listeCertificats;
    private List<Resume> listeResumes;
    
    
    
    public Patient getPatient() {
		return patient;
	}

	public void setPatient(Patient patient) {
		this.patient = patient;
	}

	public List<Ordonnance> getListeOrdonnance() {
		return listeOrdonnance;
	}

	public void setListeOrdonnance(List<Ordonnance> listeOrdonnance) {
		this.listeOrdonnance = listeOrdonnance;
	}

	public List<RDV> getListeRendezVous() {
		return listeRendezVous;
	}

	public void setListeRendezVous(List<RDV> listeRendezVous) {
		this.listeRendezVous = listeRendezVous;
	}

	public List<Consultation> getListeConsultations() {
		return listeConsultations;
	}

	public void setListeConsultations(List<Consultation> listeConsultations) {
		this.listeConsultations = listeConsultations;
	}

	public List<Certificat> getListeCertificats() {
		return listeCertificats;
	}

	public void setListeCertificats(List<Certificat> listeCertificats) {
		this.listeCertificats = listeCertificats;
	}

	public List<Resume> getListeResumes() {
		return listeResumes;
	}

	public void setListeResumes(List<Resume> listeResumes) {
		this.listeResumes = listeResumes;
	}

	public int getNum_doss() {
        return num_doss;
    }

    public void setNum_doss(int num_doss) {
        this.num_doss = num_doss;
    }

    public static int getNbrPrecedent() {
        return nbrPrecedent;
    }

    public static void setNbrPrecedent(int nbrPrecedent) {
        Dossier_medical.nbrPrecedent = nbrPrecedent;
    }

    public Dossier_medical() {        
        this.num_doss = ++nbrPrecedent;
        LocalDate dateCourante = LocalDate.now();
        this.setDat_doss(dateCourante);
        this.setListePatient(new ArrayList<>());
        this.listeOrdonnance = new ArrayList<>();
        this.listeRendezVous = new ArrayList<>();
        this.listeConsultations = new ArrayList<>();
        this.listeCertificats = new ArrayList<>();
        this.listeResumes = new ArrayList<>();
        
    }

   
    public void ajouterOrdonnance(Ordonnance ordonnance) {
        this.listeOrdonnance.add(ordonnance);
    }

    public void ajouterRendezVous(RDV rdv) {
        this.listeRendezVous.add(rdv);
    }

    public void ajouterConsultation(Consultation consultation) {
        this.listeConsultations.add(consultation);
    }

    public void ajouterCertificat(Certificat certificat) {
        this.listeCertificats.add(certificat);
    }

    public void ajouterResume(Resume resume) {
        this.listeResumes.add(resume);
    }

	public LocalDate getDat_doss() {
		return dat_doss;
	}

	public void setDat_doss(LocalDate dat_doss) {
		this.dat_doss = dat_doss;
	}

	public List<Patient> getListePatient() {
		return listePatient;
	}

	public void setListePatient(List<Patient> listePatient) {
		this.listePatient = listePatient;
	}
	public void afficherOrdonnances() {
        System.out.println("Liste des ordonnances :");
        for (Ordonnance ordonnance : listeOrdonnance) {
            System.out.println(ordonnance);
        }
    }

    public void afficherRendezVous() {
        System.out.println("Liste des rendez-vous :");
        for (RDV rdv : listeRendezVous) {
            System.out.println(rdv);
        }
    }

    public void afficherConsultations() {
        System.out.println("Liste des consultations :");
        for (Consultation consultation : listeConsultations) {
            System.out.println(consultation);
        }
    }

    public void afficherCertificats() {
        System.out.println("Liste des certificats :");
        for (Certificat certificat : listeCertificats) {
            System.out.println(certificat);
        }
    }

    public void afficherResumes() {
        System.out.println("Liste des résumés :");
        for (Resume resume : listeResumes) {
            System.out.println(resume);
        }
    }

	public void afficherInformations() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("Que souhaitez-vous afficher ?");
            System.out.println("1. Fiche patient");
            System.out.println("2. Ordonnances");
            System.out.println("3. Rendez-vous");
            System.out.println("4. Consultations");
            System.out.println("5. Certificats");
            System.out.println("6. Résumés");
            System.out.println("0. Quitter");
            System.out.print("Entrez votre choix : ");
            int choix = scanner.nextInt();
            scanner.nextLine(); 

            switch (choix) {
                case 1:
                    patient.afficher();
                    break;
                case 2:
                    afficherOrdonnances();
                    break;
                case 3:
                    afficherRendezVous();
                    break;
                case 4:
                    afficherConsultations();
                    break;
                case 5:
                    afficherCertificats();
                    break;
                case 6:
                    afficherResumes();
                    break;
                case 0:
                    System.out.println("Quitter.");
                    scanner.close();
                    return;
                default:
                    System.out.println("Choix invalide. Veuillez réessayer.");
            }
        }
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
	
}
