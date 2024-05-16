import java.util.Scanner;

import Views.ViewsCours;
import Views.ViewsProfesseur;
import services.ServiceClasse;
import services.ServiceCours;
import services.ServiceProf;
import Views.ViewsClasse;

public class App {
    private static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) throws Exception {
        ServiceClasse sClasse = new ServiceClasse();
        ServiceCours sCours = new ServiceCours();
        ServiceProf sProf = new ServiceProf();
        ViewsClasse.setSc(sc);
        ViewsCours.setSc(sc);
        ViewsProfesseur.setSc(sc);
        ViewsClasse vClasse = new ViewsClasse(sClasse);
        ViewsProfesseur vp = new ViewsProfesseur(sCours,sProf);
        ViewsCours vc = new ViewsCours(sCours, vClasse, vp, sProf);
        
        int choix;
        do{
            choix = affichageMenu();
            switch (choix) {
                case 1 :
                    if(sProf.save(vp.created())) {
                        System.out.println("La classe est cree");
                    }
                    else {
                        System.out.println("La classe n'est pas cree"); 
                    }
                    break;
                case 2 :
                    if(sProf.show() != null){
                        sProf.liste(sProf.show());
                    }
                    break;
                case 3 : 
                    if(sCours.save(vc.created())) {
                        System.out.println("Le cours est cree");
                    }
                    else {
                        System.out.println("Le cours n'est pas cree"); 
                    }
                    break; 
                case 4 :
                    if(sCours.show() != null){
                        sCours.liste(sCours.show());
                    }
                    break;
                case 5 :
                    sProf.liste(vp.demande(sProf.show())); 
                    break;  
                default:               
                }
    
            }while(choix != 6);     

    }
    public static int affichageMenu(){
        int choix;
        do{
            System.out.println("Menu");
            System.out.println("1.Ajouter un Professeur");
            System.out.println("2. Lister les Professeurs");
            System.out.println("3. Créer un cours");
            System.out.println("4. Lister les tous les cours");
            System.out.println(" 5. Lister les les cours d'un professeur");
            System.out.println("6. Quitter");
            
            choix = sc.nextInt();
        }while(choix<0 || choix>6);
        return choix;
    }
}
