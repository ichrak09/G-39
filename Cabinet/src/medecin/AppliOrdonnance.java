package medecin;

import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;

public class AppliOrdonnance {

	public static void main(String[] args) {
		
		
		Scanner scanner = new Scanner(System.in);
		System.out.println("******************* Ordonnance *********************");

		System.out.println("Remplissez les information de l'ordonnace : ");
      
		System.out.println("Nom du patient : ");
        String nom = scanner.nextLine();
        
        System.out.println("Prenom du patient : ");
        String prenom = scanner.nextLine();
     
        Ordonnance ordonnance = new Ordonnance(nom,prenom);
        boolean ajouterMedicaments = true;
        while (ajouterMedicaments) {
            System.out.print("Entrez le nom du médicament (ou 'fin' pour terminer) : ");
            String nomMedt = scanner.nextLine();
            if (nomMedt.equalsIgnoreCase("fin")) {
                ajouterMedicaments = false;
            } else {
                System.out.print("Entrez le dosage du médicament : ");
                int dosageMedt = scanner.nextInt();
                scanner.nextLine(); 

                System.out.print("Entrez le nombre de fois de la prise de médicament pendant la journée : ");
                int nbrFoisMedt = scanner.nextInt();
                scanner.nextLine();

                System.out.print("Entrez la quantité de médicament : ");
                int quantMedt = scanner.nextInt();
                scanner.nextLine();

                System.out.print("Entrez la durée de la prise de médicament : ");
                String dureeMedt = scanner.nextLine();

                Medicaments medicament = new Medicaments(nomMedt, dosageMedt, nbrFoisMedt, quantMedt, dureeMedt);
                ordonnance.ajouterMedicament(medicament);
            }
        }

        ordonnance.ajouterOrdonnanceAuDossier(ordonnance);
        ordonnance.afficher();
     
        System.out.println("Si vous voulez modifier l'ordonnance appuyer sur 1 : ");
        
        int choix = scanner.nextInt();
        switch(choix) {
        case 1 :
        System.out.println("\nModification de l'ordonnance :");
   
        List<Medicaments> nouveauxMedicaments = new ArrayList<>();
        System.out.println("Ajout de nouveaux médicaments à l'ordonnance :");
        while (true) {
            System.out.print("Entrez le nom du médicament (ou 'fin' pour terminer) : ");
            String nom_medi = scanner.nextLine();
            if (nom_medi.equalsIgnoreCase("fin")) {
                break;
            }
            System.out.print("Entrez le dosage (en mg) : ");
            int dosage = scanner.nextInt();
            System.out.print("Entrez le nombre de fois par jour : ");
            int nbr_fois = scanner.nextInt();
            System.out.print("Entrez la quantité : ");
            int quantite = scanner.nextInt();
            scanner.nextLine();  
            System.out.print("Entrez la durée : ");
            String duree = scanner.nextLine();

            Medicaments medicament = new Medicaments(nom_medi, dosage, nbr_fois, quantite, duree);
            nouveauxMedicaments.add(medicament);
        }

        ordonnance.modifier(nouveauxMedicaments);

        System.out.println("\nOrdonnance modifiée :");
        ordonnance.ajouterOrdonnanceAuDossier(ordonnance);
        ordonnance.afficher();break;
        default:
        	System.out.println("Création de l'ordonnance terminer .");
        }
        scanner.close();
    }
}
		
		
