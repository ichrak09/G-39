package secretaire;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Date;

public class RDV {
	
    private int num_rdv;
	private String nom;
	private String prenom;
    private LocalDate dat_saisi_rdv;
    private int heure_rdv;
    private String val_rdv;
    private Date dat_rdv;
    private String cmtr;
   
    private static int nbrPrecedent = 0;
    
    static final int HEURES_PAR_JOUR = 9; // 8h00 à 16h00

    
    public RDV() {
	}

	public String getCmtr() {
        return cmtr;
    }

    public void setCmtr(String cmtr) {
        this.cmtr = cmtr;
    }

    public int getNum_rdv() {
        return num_rdv;
    }

    public void setNum_rdv(int num_rdv) {
        this.num_rdv = num_rdv;
    }

 
    public String getVal_rdv() {
        return val_rdv;
    }

    public void setVal_rdv(String val_rdv) {
        this.val_rdv = val_rdv;
    }

    public Date getDat_rdv() {
        return dat_rdv;
    }

    public void setDat_rdv(Date dat_rdv) {
        this.dat_rdv = dat_rdv;
    }

    public RDV( String val_rdv, Date dat_rdv) {
        this.num_rdv = ++nbrPrecedent;
        LocalDate dateCourante = LocalDate.now();
        this.dat_saisi_rdv = dateCourante;
        this.val_rdv = val_rdv;
        
    }

    public void afficherListe(Object[][] liste_rendez_vous_annee) {
        for (Object[] jour : liste_rendez_vous_annee) {
            for (Object rdv : jour) {
                System.out.print(rdv + " ");
            }
            System.out.println();
        }
    }

    public void initialiserListe(Object[][] liste_rendez_vous_annee) {
        LocalDate dateCourante = LocalDate.now();      
        liste_rendez_vous_annee[0][0]= "RendezVous";
        for (int i = 1; i < liste_rendez_vous_annee.length; i++) {
            liste_rendez_vous_annee[i][0] = dateCourante.plusDays(i);
        }
        for (int j = 0; j < HEURES_PAR_JOUR; j++) {
            liste_rendez_vous_annee[0][j + 1] = LocalTime.of(8 + j,0);
        }
    }
  
    public boolean estCaseVide(Object[][] liste_rendez_vous_annee, int jour, int heure) {
        return liste_rendez_vous_annee[jour][heure + 1] == null;
    }

    public void mettreAJourCase(Object[][] liste_rendez_vous_annee, int jour, int heure, int numeroPatient) {
        liste_rendez_vous_annee[jour][heure + 1] = numeroPatient;
    }

    public void ajouter(Object[][] liste_rendez_vous_annee, RDV rdv, int numeroPatient) {
        int jour = LocalDate.parse((CharSequence) rdv.getDat_rdv()).getDayOfYear() - LocalDate.now().getDayOfYear();
        int heure = rdv.getHeure_rdv() - 8;
        if (jour >= 0 && jour < liste_rendez_vous_annee.length && heure >= 0 && heure < HEURES_PAR_JOUR) {
            if (estCaseVide(liste_rendez_vous_annee, jour, heure)) {
                mettreAJourCase(liste_rendez_vous_annee, jour, heure, numeroPatient);
            } else {
                System.out.println("La case n'est pas vide. Le rendez-vous ne peut pas être ajouté.");
            }
        } else {
            System.out.println("Date ou heure invalide.");
        }
    }

    @SuppressWarnings("unlikely-arg-type")
	public void afficherRendezVous(Object[][] liste_rendez_vous_annee, String date_rdv, int heure_rdv) {
        boolean trouve = false;
        for (int i = 0; i < liste_rendez_vous_annee.length; i++) {
            for (int j = 0; j < liste_rendez_vous_annee[i].length; j++) {
                if (liste_rendez_vous_annee[i][j] != null && liste_rendez_vous_annee[i][j] instanceof RDV) {
                    RDV rdv = (RDV) liste_rendez_vous_annee[i][j];
                    if (rdv.getDat_rdv().equals(date_rdv) && rdv.getHeure_rdv() == heure_rdv ) {
                        System.out.println("Numéro de rendez-vous : " + rdv.getNum_rdv() + ", Date du rendez-vous : " + rdv.getDat_rdv());
                        System.out.println("Heure de rendez-vous : " + rdv.getHeure_rdv() + "h" +  ", Validation : " + rdv.getVal_rdv());
                        System.out.println("Commentaire : " + rdv.getCmtr());
                        if (liste_rendez_vous_annee[i][j + 1] != null && liste_rendez_vous_annee[i][j + 1] instanceof Integer) {
                            System.out.println("Numéro de fichier du patient : " + liste_rendez_vous_annee[i][j + 1]);
                        }
                        trouve = true;
                        return;
                    }
                }
            }
        }
        if (!trouve) {
            System.out.println("Aucun rendez-vous trouvé pour la date " + date_rdv + " à " + heure_rdv + "h" + ".");
        }
    }

    @SuppressWarnings("unlikely-arg-type")
	public void supprimerRendezVous(Object[][] liste_rendez_vous_annee, String date_rdv, int heure_rdv) {
        boolean trouve = false;
        for (int i = 0; i < liste_rendez_vous_annee.length; i++) {
            for (int j = 0; j < liste_rendez_vous_annee[i].length; j++) {
                if (liste_rendez_vous_annee[i][j] != null && liste_rendez_vous_annee[i][j] instanceof RDV) {
                    RDV rdv = (RDV) liste_rendez_vous_annee[i][j];
                    if (rdv.getDat_rdv().equals(date_rdv) && rdv.getHeure_rdv() == heure_rdv ) {
                        liste_rendez_vous_annee[i][j] = null;
                        trouve = true;
                        System.out.println("Le rendez-vous du " + date_rdv + " à " + heure_rdv + "h" +" a été supprimé avec succès.");
                        return;
                    }
                }
            }
        }
        if (!trouve) {
            System.out.println("Aucun rendez-vous trouvé pour la date " + date_rdv + " à " + heure_rdv + "h" +".");
        }
    }
   

	public static int getNbrPrecedent() {
		return nbrPrecedent;
	}

	public static void setNbrPrecedent(int nbrPrecedent) {
		RDV.nbrPrecedent = nbrPrecedent;
	}

	public int getHeure_rdv() {
		return heure_rdv;
	}

	public void setHeure_rdv(int heure_rdv) {
		this.heure_rdv = heure_rdv;
	}


	public LocalDate getDat_saisi_rdv() {
		return dat_saisi_rdv;
	}

	public void setDat_saisi_rdv(LocalDate dat_saisi_rdv) {
		this.dat_saisi_rdv = dat_saisi_rdv;
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


