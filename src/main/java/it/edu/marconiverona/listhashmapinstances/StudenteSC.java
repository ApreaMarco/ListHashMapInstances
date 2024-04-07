package it.edu.marconiverona.listhashmapinstances;

import java.util.HashMap;
import java.util.Map;

// Simula una tabella SLAVE
// Bisognerebbe prevedere anche il comportamento del COMMIT, del ROLLBACK e dell' ONCASCADE
/**
 * Rappresenta un'entità studente nel sistema. Ogni istanza di questa classe
 * corrisponde a uno studente nel sistema. Mantiene un mapping degli ID studente
 * alle istanze studente.
 *
 * @author <a href="mailto:marco.aprea@marconiverona.edu.it">Marco Aprea</a>
 * @version 1.0 20240407
 */
public class StudenteSC {

    // Chiave univoca -> PRIMARY KEY
    private int id;
    private String matricola;
    // Map che contiene tutte le istanze di StudenteSC
    private static Map<Integer, StudenteSC> mappaStudenteSC = new HashMap<>(100);// 100 capability
    // Collegamento con l'istanza di ClasseSC -> FOREIGN KEY
    private int idClasseSC;

    /**
     * Costruisce una nuova istanza di {@link StudenteSC} con l'ID e la
     * matricola specificati. Se non esiste un'istanza con lo stesso ID,
     * aggiunge questa istanza alla mappa degli studenti.
     *
     * @param id L'identificatore univoco per lo studente.
     * @param matricola La matricola dello studente.
     */
    public StudenteSC(int id, String matricola) {
        this.id = id;
        this.matricola = matricola;
        // Inserisce l'istanza rappresentata da this nella mappa, controllando che non sia presente l'id -> INSERT
        // Sarebbe più saggio prevedere un metodo apposito
        if (!mappaStudenteSC.containsKey(id)) {
            // Se uso esclusivamente il metodo put dell'hashmap, cambia il riferimento dell'istanza -> UPDATE
            mappaStudenteSC.put(this.id, this);
        }
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMatricola() {
        return matricola;
    }

    public void setMatricola(String matricola) {
        this.matricola = matricola;
    }

    /**
     * Restituisce una rappresentazione in stringa dell'oggetto
     * {@link StudenteSC}. Questo include l'ID dello studente, la matricola e
     * l'ID di classe associato.
     *
     * @return Una rappresentazione in stringa dell'oggetto studente.
     */
    @Override
    public String toString() {
        return "StudenteSC{" + "id=" + id + ", matricola=" + matricola + ", idClasseSC=" + idClasseSC + '}';
    }

    // Collegamento con la ClasseSC
    public int getIdClasseSC() {
        return idClasseSC;
    }

    public void setIdClasseSC(int idClasseSC) {
        this.idClasseSC = idClasseSC;
    }

    // Metodo che restituisce un instanza di StudenteSC che ha quell'id -> SELECT
    /**
     * Restituisce l'istanza di {@link StudenteSC} corrispondente all'ID
     * specificato.
     *
     * @param id L'ID dello studente da cercare.
     * @return L'istanza di {@link StudenteSC} se trovata, altrimenti null.
     */
    public static StudenteSC getStudenteSCbyID(int id) {
        return mappaStudenteSC.get(id);
    }

    // Metodo che elimina un instanza di ClasseSC che ha quell'id -> DELETE
    /**
     * Rimuove l'istanza di {@link StudenteSC} corrispondente all'ID
     * specificato.
     *
     * @param id L'ID dello studente da rimuovere.
     */
    public static void removeStudenteSCById(int id) {
        mappaStudenteSC.remove(id);
    }
}
