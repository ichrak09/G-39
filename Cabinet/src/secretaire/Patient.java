package secretaire;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import medecin.Dossier_medical;


public class Patient {
	private int num_fich_pat;
	private int cin_pat,tel_pat;
	private String nom,prenom,adresse,sexe,profession,date_naiss,antecedent_pat;
	LocalDate date_fich;
	private static int dernierNumFich = 0;
	private List<Dossier_medical> listeDossierMedical = new ArrayList<>();
	
	public String getAntecedent_pat() {
		return antecedent_pat;
	}
	public void setAntecedent_pat(String antecedent_pat) {
		this.antecedent_pat = antecedent_pat;
	}
	public int getNum_fich_pat() {
		return num_fich_pat;
	}
	public void setNum_fich_pat(int num_fich_pat) {
		this.num_fich_pat = num_fich_pat;
	}
	public int getCin_pat() {
		return cin_pat;
	}
	public void setCin_pat(int cin_pat) {
		this.cin_pat = cin_pat;
	}
	public int getTel_pat() {
		return tel_pat;
	}
	public void setTel_pat(int tel_pat) {
		this.tel_pat = tel_pat;
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
	public String getAdresse() {
		return adresse;
	}
	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}
	public String getSexe() {
		return sexe;
	}
	public void setSexe(String sexe) {
		this.sexe = sexe;
	}
	public String getProfession() {
		return profession;
	}
	public void setProfession(String profession) {
		this.profession = profession;
	}
	public String getDate_naiss() {
		return date_naiss;
	}
	public void setDate_naiss(String date_naiss) {
		this.date_naiss = date_naiss;
	} 		 
	public static int getDernierNumFich() {
		return dernierNumFich;
	}
	public static void setDernierNumFich(int dernierNumFich) {
		Patient.dernierNumFich = dernierNumFich;
	}
	
	
	public Patient(int cin_pat, int tel_pat, String nom,
			String prenom, String adresse, String sexe, String profession, String date_naiss, String antecedent_pat) {	
		
		this.num_fich_pat = ++dernierNumFich;
		this.cin_pat = cin_pat;
		this.tel_pat = tel_pat;
		LocalDate dateCourante = LocalDate.now();
		this.date_fich = dateCourante;
		this.nom = nom;
		this.prenom = prenom;
		this.adresse = adresse;
		this.sexe = sexe;
		this.profession = profession;
		this.date_naiss = date_naiss;
		this.antecedent_pat = antecedent_pat;
	
	}
	
	public void afficher() {
		System.out.println("Numero de ficher :"+num_fich_pat+"cin de patient :"+cin_pat+
				"numero de telephone  :"+tel_pat+"date de creation de fichier : "+date_fich);
		System.out.println("Le nom :"+nom+"le prenom de patient :"+prenom+
				"l'adresse du patient :"+adresse+"le sexe du patient :"+sexe);
		System.out.println("La profession :"+profession+"Date de naissance :"+date_naiss+
				"Les antecedents : "+antecedent_pat);
		}
	public List<Dossier_medical> getListeDossierMedical() {
		return listeDossierMedical;
	}
	public void setListeDossierMedical(List<Dossier_medical> listeDossierMedical) {
		this.listeDossierMedical = listeDossierMedical;
	}
	

}
