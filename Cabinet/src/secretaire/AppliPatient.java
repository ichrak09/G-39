package secretaire;
import java.util.Scanner;

import medecin.Dossier_medical;


public class AppliPatient {

	public static void main(String[] args) {
			
		try (Scanner scanner = new Scanner(System.in)) {
			System.out.println("************** Fichier de patient ***************");
			
			
			
			System.out.println("   Entrer les informations du fiche de patient : ");
			System.out.println("Cin de patient : ");
			int cin_pat=scanner.nextInt();
			    
			System.out.println("Nom : ");
			String nom = scanner.nextLine();
			    
			System.out.println("Prénom : ");
			String prenom = scanner.nextLine();
			    
			System.out.println("H : Homme    F : Femme  ");
			System.out.println("Sexe : ");
			String sexe =scanner.nextLine();
			    
			    System.out.println("Date de naissance : ");
			    String date_naiss = scanner.nextLine();
			    
			    System.out.println("Numéro de téléphone : ");
			    int tel_pat = scanner.nextInt();
			    
			    System.out.println("Adresse : ");
			    String adresse = scanner.nextLine();
			    
			    System.out.println("Profession : ");
			    String profession = scanner.nextLine();
			    
			    
			    System.out.println("Antécédents de patient : ");
			    String antecedent_pat = scanner.nextLine();
			    	        	   	        
				Patient patient = new Patient(cin_pat,tel_pat,nom,prenom,adresse,sexe,profession,date_naiss,antecedent_pat);
				Dossier_medical dossier = new Dossier_medical();
				patient.getListeDossierMedical().add(dossier);
				patient.afficher();
		}
	              
	        
		}
	}

