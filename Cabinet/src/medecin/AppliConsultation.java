package medecin;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class AppliConsultation {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("****************** Consultation ********************");
        System.out.println("Remplissez les informations de la consulation : ");
       
        System.out.println("Nom du patient : ");
        String nom = scanner.nextLine();
        
        System.out.println("Prenom du patient : ");
        String prenom = scanner.nextLine();
        
        List<String> diagCons = new ArrayList<>();
        System.out.print("Entrez le diagnostic de la consultation (tapez 'fin' pour terminer) : ");
        String diagnostic;
        while (!(diagnostic = scanner.nextLine()).equalsIgnoreCase("fin")) {
            diagCons.add(diagnostic);
            System.out.print("Entrez un autre diagnostic de la consultation (ou 'fin' pour terminer) : ");
        }

        System.out.print("Entrez le motif de la consultation : ");
        String motiCons = scanner.nextLine();

        System.out.print("Entrez le nom de la maladie : ");
        String nomMaladie = scanner.nextLine();

        Consultation consultation = new Consultation(nom,prenom,diagCons, motiCons, nomMaladie);

      
        System.out.println("\nConsultation initiale :");
        consultation.ajouterConsulationAuDossier(consultation);
        consultation.afficher();

        System.out.println("Si vous voulez modifier la consultation appuyer sur 1 : ");
        int choix = scanner.nextInt();
        switch(choix) {
        case 1 :
        
        System.out.println("\nModification de la consultation :");
        
        System.out.println("Nom du patient : ");
         nom = scanner.nextLine();
        
        System.out.println("Prenom du patient : ");
        prenom = scanner.nextLine();
        
        List<String> newDiagCons = new ArrayList<>();
        System.out.print("Entrez le nouveau diagnostic de la consultation (tapez 'fin' pour terminer) : ");
        while (!(diagnostic = scanner.nextLine()).equalsIgnoreCase("fin")) {
            newDiagCons.add(diagnostic);
            System.out.print("Entrez un autre diagnostic de la consultation (ou 'fin' pour terminer) : ");
        }

        System.out.print("Entrez le nouveau motif de la consultation : ");
        String newMotiCons = scanner.nextLine();

        System.out.print("Entrez le nouveau nom de la maladie : ");
        String newNomMaladie = scanner.nextLine();

        consultation.modifier(nom,prenom,newDiagCons, newMotiCons, newNomMaladie);

        System.out.println("\nConsultation modifiée :");
        consultation.afficher();
        
        break;
        default :
        	System.out.println("Création consultation terminer .");
        	
        }
        scanner.close();
    }
}


