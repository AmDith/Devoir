package entities;

import java.util.List;

public class Professeur {
    private int id ;
    private String nom;
    private String tel;
    private String module;
    private String grade;
    private List<Cours> courList;
    private static int nbre;
    
    public Professeur(int id, String nom, String tel, String module, String grade, List<Cours> courList) {
        this.id = id;
        this.nom = nom;
        this.tel = tel;
        this.module = module;
        this.grade = grade;
        this.courList = courList;
    }
    public Professeur() {
        id = ++ nbre;
    }
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getNom() {
        return nom;
    }
    public void setNom(String nom) {
        this.nom = nom;
    }
    public String getTel() {
        return tel;
    }
    public void setTel(String tel) {
        this.tel = tel;
    }
    public String getModule() {
        return module;
    }
    public void setModule(String module) {
        this.module = module;
    }
    public String getGrade() {
        return grade;
    }
    public void setGrade(String grade) {
        this.grade = grade;
    }
    public List<Cours> getCourList() {
        return courList;
    }
    public void addData(Cours cours) {
        courList.add(cours);
        
    }
    @Override
    public String toString() {
        return "Professeur [id=" + id + ", nom=" + nom + ", tel=" + tel + ", module=" + module + ", grade=" + grade
                + "]";
    }
    
}
