package core;

import java.util.List;

public interface Classeimp<T> {
    void save (T objet);
    List<T> show();
    T verfId(List<T> objeTs, int id); 
}
