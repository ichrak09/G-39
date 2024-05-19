package medecin;
import java.time.LocalDate;
import java.util.List;
import secretaire.Patient;

public class Certificat {
	private int idCertificat;
	private static int dernierNumCert = 0;
    private LocalDate dateCreation;
    private String nom;
    private String prenom;
    private String descriptionLesions;
    private List<String> signesCliniques;
    private List<String> symptomes;
    private List<String> resultatsExamen;
    private Patient patient;
 
    
    
	public int getIdCertificat() {
		return idCertificat;
	}
	public void setIdCertificat(int idCertificat) {
		this.idCertificat = idCertificat;
	}
	public LocalDate getDateCreation() {
		return dateCreation;
	}
	public void setDateCreation(LocalDate dateCreation) {
		this.dateCreation = dateCreation;
	}
	public String getDescriptionLesions() {
		return descriptionLesions;
	}
	public void setDescriptionLesions(String descriptionLesions) {
		this.descriptionLesions = descriptionLesions;
	}
	public List<String> getSignesCliniques() {
		return signesCliniques;
	}
	public void setSignesCliniques(List<String> signesCliniques) {
		this.signesCliniques = signesCliniques;
	}
	public List<String> getSymptomes() {
		return symptomes;
	}
	public void setSymptomes(List<String> symptomes) {
		this.symptomes = symptomes;
	}
	public List<String> getResultatsExamen() {
		return resultatsExamen;
	}
	public void setResultatsExamen(List<String> resultatsExamen) {
		this.resultatsExamen = resultatsExamen;
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
	public Certificat(String nom,String prenom, String descriptionLesions, List<String> signesCliniques,
			List<String> symptomes, List<String> resultatsExamen) {
		
		this.idCertificat = ++dernierNumCert;
		LocalDate dateCourante = LocalDate.now();
		this.dateCreation = dateCourante;
		this.nom = nom;
		this.prenom = prenom;
		this.descriptionLesions = descriptionLesions;
		this.signesCliniques = signesCliniques;
		this.symptomes = symptomes;
		this.resultatsExamen = resultatsExamen;
	}
    
    
	public void afficher() {
        System.out.println("Certificat Medical ID: " + idCertificat);
        System.out.println("Date de création: " + dateCreation);
        System.out.println("Nom :"+nom);
        System.out.println("Prénom :"+prenom);
        System.out.println("Description des lésions: " + descriptionLesions);
        System.out.println("Signes cliniques: " + String.join(", ", signesCliniques));
        System.out.println("Symptômes: " + String.join(", ", symptomes));
        System.out.println("Résultats d'examen: " + String.join(", ", resultatsExamen));
    }
	
	public void ajouterCertificatAuDossier(Certificat certificat) {
	    for (Dossier_medical dossier : patient.getListeDossierMedical()) {
	        if (dossier.getPatient().getNom().equals(certificat.getNom()) &&
	            dossier.getPatient().getPrenom().equals(certificat.getPrenom())) {
	           
	            dossier.ajouterCertificat(certificat);
	            System.out.println("Certificat ajouté au dossier médical du patient : " + dossier.getPatient().getNom() + " " + dossier.getPatient().getPrenom());
	            return; 
	        }
	    }
	    System.out.println("Aucun dossier médical trouvé pour le patient : " + certificat.getNom() + " " + certificat.getPrenom());
	}
	public Patient getPatient() {
		return patient;
	}
	public void setPatient(Patient patient) {
		this.patient = patient;
	}
}
    
    
    

