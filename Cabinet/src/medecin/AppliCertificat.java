package medecin;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;

public class AppliCertificat {
    public static void main(String[] args) {
    	try (Scanner scanner = new Scanner(System.in)) {
			System.out.println("************ Certeficat *************");
			System.out.println("Pour crée une nouvelle certeficat appuyer sur 1 : ");
			
			int choix = scanner.nextInt();
			
			switch(choix) {
			case 1 :
				List<String> signesCliniques = new ArrayList<>();
				List<String> symptomes = new ArrayList<>();
				List<String> resultatsExamen = new ArrayList<>();
				
				System.out.println("Remplissez la cetificat : ");
				   	
				System.out.println("Nom :");
				String nom = scanner.nextLine();
				
				System.out.println("Prenom :");
				String prenom = scanner.nextLine();
				
				System.out.print("Description des lésions : ");
			    String descriptionLesions = scanner.nextLine();
			    
				System.out.println("Entrez les signes cliniques (entrez une ligne vide pour terminer) :");
			    while (true) {
			        String signeClinique = scanner.nextLine();
			        if (signeClinique.isEmpty()) {
			            break;
			        }
			        signesCliniques.add(signeClinique);
			    }
			    System.out.println("Entrez les symptômes (entrez une ligne vide pour terminer) :");
			    while (true) {
			        String symptome = scanner.nextLine();
			        if (symptome.isEmpty()) {
			            break;
			        }
			        symptomes.add(symptome);
			    }
				//System.out.println("");
			    System.out.println("Entrez les résultats d'examen (entrez une ligne vide pour terminer) :");
			    while (true) {
			        String resultatExamen = scanner.nextLine();
			        if (resultatExamen.isEmpty()) {
			            break;
			        }
			        resultatsExamen.add(resultatExamen);
			    }
			    Certificat certificat = new Certificat(nom,prenom, descriptionLesions, signesCliniques, symptomes, resultatsExamen);
			    certificat.ajouterCertificatAuDossier(certificat);
			    certificat.afficher();
				
				
			}
		}
        
    	
    }
}
