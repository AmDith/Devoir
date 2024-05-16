package services;

import java.util.ArrayList;
import java.util.List;

import core.Service;
import entities.Cours;
import entities.Professeur;

public class ServiceProf implements Service<Professeur> {
    private List<Professeur> profs = new ArrayList<>();

    @Override
    public boolean save(Professeur objet) {
        if (objet != null) {
            profs.add(objet);
            return true;
        }
        return false;
    }

    @Override
    public List<Professeur> show() {
        return profs;
    }

    @Override
    public void liste(List<Professeur> profs) {
        for(Professeur tab : profs){
            if(tab!=null){
                System.out.println(tab.toString());
            } 
        } 
    }

    @Override
    public void liste(Professeur objeTs) {
        for(Cours  tab : objeTs.getCourList()){
            if(tab!=null){
                System.out.println(tab.toString());
            }  
        }
    }

    @Override
    public Professeur verfId(List<Professeur> objeTs, int id) {
        for (Professeur obejeT : objeTs) {
            if (obejeT.getId() == id) {
                return obejeT;
            }
        }
        return null;
    }
    
}
