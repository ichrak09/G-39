package medecin;
import java.util.Scanner;

public class AppliResume {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("*************** Résumé ***************");
        System.out.println("Remplissez les informations du résumé :  ");
        
        System.out.println("Nom de patient : ");
        String nom = scanner.nextLine();
        System.out.println("Prénom de patient : ");
        String prenom = scanner.nextLine();
        
        System.out.print("Entrez le nom de la maladie : ");
        String nomMaladie = scanner.nextLine();
        Resume resume = new Resume(nom,prenom,nomMaladie);

       
        System.out.println("Ajout de remarques : ");
        while (true) {
            System.out.print("Entrez une remarque (ou 'fin' pour terminer) : ");
            String remarque = scanner.nextLine();
            if (remarque.equalsIgnoreCase("fin")) {
                break;
            }
            resume.ajouterRemarque(remarque);
        }

        resume.ajouterResumeAuDossier(resume);
        resume.afficher();

       
        System.out.println("Voulez-vous modifier une remarque ? (oui/non)");
        String reponse = scanner.nextLine();
        if (reponse.equalsIgnoreCase("oui")) {
            System.out.print("Entrez l'index de la remarque à modifier : ");
            int index = scanner.nextInt();
            scanner.nextLine();  
            System.out.print("Entrez la nouvelle remarque : ");
            String nouvelleRemarque = scanner.nextLine();
            resume.modifierRemarque(index, nouvelleRemarque);
            System.out.println("Remarque modifiée avec succès.");
            resume.afficher();
            
        }else {
        	System.out.println("Création de Résumé est terminer .");
        }
        

        scanner.close();
    }
}


