package secretaire;
import java.util.Date;
import java.util.Scanner;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;


public class AppliRendez_vous {
    	    public static void main(String[] args) {
    	      
    	        Object[][] liste_rendez_vous_annee = new Object[365][RDV.HEURES_PAR_JOUR + 1]; 
    	        
    	        RDV rdvManager = new RDV();
    	        rdvManager.initialiserListe(liste_rendez_vous_annee);

    	        Scanner scanner = new Scanner(System.in);
    	        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
                rdvManager.afficherListe(liste_rendez_vous_annee);
    	        
    	        boolean continuer = true;
    	        while (continuer) {    	          
    	            System.out.println("Que souhaitez-vous faire ?");
    	            System.out.println("1. Ajouter un rendez-vous");
    	            System.out.println("2. Supprimer un rendez-vous");
    	            System.out.println("3. Quitter");
    	            System.out.print("Votre choix : ");
    	            int choix = scanner.nextInt();
    	            scanner.nextLine(); 

    	            switch (choix) {
    	                case 1:
    	                    System.out.println("Entrez la date du rendez-vous (AAAA-MM-JJ) : ");
    	                    String dateEntree = scanner.nextLine();
    	                    LocalDate date = LocalDate.parse(dateEntree, formatter);

    	                    System.out.println("Entrez l'heure du rendez-vous (entre 8 et 16) : ");
    	                    int heureEntree = scanner.nextInt();

    	                    System.out.println("Entrez le numéro du fichier du patient : ");
    	                    int numeroPatient = scanner.nextInt();
    	                    scanner.nextLine(); 

    	                   
    	                    if (rdvManager.estCaseVide(liste_rendez_vous_annee, date.getDayOfYear() - LocalDate.now().getDayOfYear(), heureEntree - 8)) {
    	                        RDV nouveauRDV = new RDV("N", new Date());
    	                        nouveauRDV.setHeure_rdv(heureEntree);
    	                        rdvManager.ajouter(liste_rendez_vous_annee, nouveauRDV, numeroPatient);
    	                    } else {
    	                        System.out.println("La case n'est pas vide. Le rendez-vous ne peut pas être ajouté.");
    	                    }
    	                    break;

    	                case 2:
    	                    System.out.println("Entrez la date du rendez-vous à supprimer (AAAA-MM-JJ) : ");
    	                    String dateSupprimer = scanner.nextLine();
    	                    @SuppressWarnings("unused") LocalDate dateSupp = LocalDate.parse(dateSupprimer, formatter);

    	                    System.out.println("Entrez l'heure du rendez-vous à supprimer (entre 8 et 16) : ");
    	                    int heureSupprimer = scanner.nextInt();
    	                    scanner.nextLine(); 

    	                   
    	                    rdvManager.supprimerRendezVous(liste_rendez_vous_annee, dateSupprimer, heureSupprimer);
    	                    break;

    	                case 3:
    	                    continuer = false; 
    	                    break;

    	                default:
    	                    System.out.println("Choix invalide. Veuillez choisir une option valide.");
    	            }
    	        }

    	        
    	        scanner.close();
    	    }
    	}
    

