package Views;

import java.util.List;

import core.Views;
import entities.Cours;
import entities.Professeur;
import services.ServiceCours;
import services.ServiceProf;

public class ViewsProfesseur extends ViewsO implements Views<Professeur> {
    private ServiceCours sCours;
    private ViewsCours vCours;
    private ServiceProf sProf;

    public ViewsProfesseur(ServiceCours sCours,ServiceProf sProf) {
        this.sCours = sCours;
        this.sProf = sProf;
    }

    public ViewsProfesseur() {
    }

    public ViewsProfesseur(ServiceCours sCours,ViewsCours vCours) {
        this.sCours = sCours;
        this.vCours = vCours;
    }

    @Override
    public Professeur created() {
        Professeur prof = new Professeur();
        Cours cours;
        int choix;
       System.out.println("Entrer votre nom");
       sc.nextLine();
       prof.setNom(sc.nextLine());
       System.out.println("Entrer votre numero de telephone ");
       sc.nextLine();
       prof.setTel(sc.nextLine());
       System.out.println("Entrer le module enseigne ");
       sc.nextLine();
       prof.setModule(sc.nextLine());
       System.out.println("Entrer votre grade ");
       sc.nextLine();
       prof.setGrade(sc.nextLine());
       do{
        System.out.println("Voulez-vous ajouter un ou des cours(s) a ce prof[O/N]");
        choix  = sc.next().charAt(0);
        if(choix == 'O') {
            sc.nextLine();
            if(sCours.show() != null) {
                cours = vCours.demande(sCours.show());
                prof.addData(cours);
                cours.setProfesseur(prof);
            
           }
           else {
            System.out.println("Le tableau est vide");
           }
       }
       }while(choix == 'O');
       return prof;  
    }

    @Override
    public Professeur demande(List<Professeur> objeTs) {
        int choix2;
        do{
            System.out.println("Entrer l'id du prof");
            choix2 = sc.nextInt();   
        }while(sProf.verfId(sProf.show(), choix2) == null);
        return sProf.verfId(sProf.show(), choix2);
    }
    
    
}
