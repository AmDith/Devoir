package services;


import entities.Filiere;
import entities.Niveau;

public class ServiceClasse { 


    public String generateName(Niveau niveau,Filiere filiere) {
        return String.valueOf(niveau) + String.valueOf(filiere);
    }

   
    
}
