package entities;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

public class Cours {
   
    private int id;
    private String module;
    private Professeur professeur;
    private LocalTime heureDebut;
    private LocalTime heureFin;
    private LocalDate date;
    private static int nbre;
    private List<Classe> classes = new ArrayList<>();

    public Cours() {
        id = ++ nbre;
    }
    public Cours(int id, String module, Professeur professeur, LocalTime heureDebut, LocalTime heureFin, LocalDate date,
            List<Classe> classes) {        
        this.id = id;
        this.module = module;
        this.professeur = professeur;
        this.heureDebut = heureDebut;
        this.heureFin = heureFin;
        this.date = date;
        this.classes = classes;
    }
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getModule() {
        return module;
    }
    public void setModule(String module) {
        this.module = module;
    }
    public Professeur getProfesseur() {
        return professeur;
    }
    public void setProfesseur(Professeur professeur) {
        this.professeur = professeur;
    }
    public LocalTime getHeureDebut() {
        return heureDebut;
    }
    public void setHeureDebut(LocalTime heureDebut) {
        this.heureDebut = heureDebut;
    }
    public LocalTime getHeureFin() {
        return heureFin;
    }
    public void setHeureFin(LocalTime heureFin) {
        this.heureFin = heureFin;
    }
    public LocalDate getDate() {
        return date;
    }
    public void setDate(LocalDate date) {
        this.date = date;
    }
    public List<Classe> getClasses() {
        return classes;
    }
    public void setClasses(Classe classe) {
        classes.add(classe);
    }
    @Override
    public String toString() {
        return "Cours [id=" + id + ", module=" + module + ", professeur=" + professeur + ", heureDebut=" + heureDebut
                + ", heureFin=" + heureFin + ", date=" + date + "]";
    }
    
}
