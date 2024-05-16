package Views;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

import core.Views;
import entities.Cours;
import entities.Professeur;
import services.ServiceCours;
import services.ServiceProf;

public class ViewsCours extends ViewsO implements Views<Cours> {
    private ServiceCours serviceCours;
    private ViewsClasse vClasse;
    private ViewsProfesseur vp;
    private ServiceProf sp;

    public ViewsCours() {
    }


    public ViewsCours(ServiceCours serviceCours,ViewsClasse vClasse,ViewsProfesseur vp,ServiceProf sp) {
        this.serviceCours = serviceCours;
        this.vClasse = vClasse;
        this.vp = vp;
        this.sp = sp;
    }
    

    @Override
    public Cours created() {
       char choix;
       Cours cours = new Cours();
       Professeur prof;
       System.out.println("Entrer le nom du module");
       sc.nextLine();
       cours.setModule(sc.nextLine());
       System.out.println("Entrer une date");
       cours.setDate(saisirDate());
       System.out.println("Entrer l'heure de debut du cours");
       cours.setHeureDebut(saisirHeure());
       System.out.println("Entrer l'heure de fin de cours");
       cours.setHeureFin(saisirHeure());
       do{
        System.out.println("Voulez-vous ajouter une ou des classe(s) au cours[O/N]");
        choix  = sc.next().charAt(0);
        if(choix == 'O') {
            sc.nextLine();
            cours.setClasses(vClasse.created());   
        }
       }while(choix == 'O');
       prof = vp.demande(sp.show());
       prof.addData(cours);
       cours.setProfesseur(prof);    
       return cours;
    }

    @Override
    public Cours demande(List<Cours> objeTs) {
        int choix2;
        do{
            System.out.println("Entrer l'id du cours");
            choix2 = sc.nextInt();   
        }while(serviceCours.verfId(serviceCours.show(), choix2) == null);
        return serviceCours.verfId(serviceCours.show(), choix2);
      }

      public static LocalDate saisirDate() {
        int year, month, day;

        System.out.println("Saisissez l'année (YYYY) : ");
        year = sc.nextInt();
        System.out.println("Saisissez le mois (MM) : ");
        month = sc.nextInt();
        System.out.println("Saisissez le jour (DD) : ");
        day = sc.nextInt();

        return LocalDate.of(year, month, day);
    }

    public static LocalTime saisirHeure() {
        int hour, minute;

        System.out.println("Saisissez l'heure (HH) : ");
        hour = sc.nextInt();
        System.out.println("Saisissez les minutes (MM) : ");
        minute = sc.nextInt();

        return LocalTime.of(hour, minute);
    }  
    
    
}
