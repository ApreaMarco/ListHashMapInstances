package it.edu.marconiverona.listhashmapinstances;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

// Simula una tabella MASTER
// Bisognerebbe prevedere anche il comportamento del COMMIT, del ROLLBACK e dell' ONCASCADE
/**
 * Rappresenta un'entità di classe nel sistema. Ogni istanza di questa classe
 * corrisponde a una classe nel sistema. Mantiene una lista di ID studente
 * associati ad essa.
 *
 * @author <a href="mailto:marco.aprea@marconiverona.edu.it">Marco Aprea</a>
 * @version 1.0 20240407
 */
public class ClasseSC {

    // Chiave univoca -> PRIMARY KEY
    private int id;
    private String name;
    // Map che contiene tutte le istanze di ClasseSC
    private static Map<Integer, ClasseSC> mappaClasseSC = new HashMap<>(100);// 100 capability
    // Lista che contiene tutti gli id delle instanze StudenteSC appartenenti all'instanza di ClasseSC
    private List<Integer> listaIdStudenteSC = new ArrayList<>();

    /**
     * Costruisce una nuova istanza di {@link ClasseSC} con l'ID e il nome
     * specificati. Se non esiste un'istanza con lo stesso ID, aggiunge questa
     * istanza alla mappa delle classi.
     *
     * @param id L'identificatore univoco per la classe.
     * @param name Il nome della classe.
     */
    public ClasseSC(int id, String name) {
        this.id = id;
        this.name = name;
        // Inserisce l'istanza rappresentata da this nella mappa, controllando che non sia presente l'id -> INSERT
        // Sarebbe più saggio prevedere un metodo apposito
        if (!mappaClasseSC.containsKey(id)) {
            // Se uso esclusivamente il metodo put dell'hashmap, cambia il riferimento dell'istanza -> UPDATE
            mappaClasseSC.put(this.id, this);
        }
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    /**
     * Restituisce una rappresentazione in stringa dell'oggetto
     * {@link ClasseSC}. Questo include l'ID della classe, il nome e una lista
     * di ID studente associati ad essa.
     *
     * @return Una rappresentazione in stringa dell'oggetto classe.
     */
    @Override
    public String toString() {
        // Recupero le istanze di ScuolaSC collegate a ClasseSC, usando le chiavi primarie -> JOIN
        // Sarebbe più elegante ed efficiente usare uno StringBuilder
        String toStringStudentSC = "[\n";
        for (Integer studentId : listaIdStudenteSC) {
            StudenteSC IstanzaStudenteSC = StudenteSC.getStudenteSCbyID(studentId);
            toStringStudentSC += IstanzaStudenteSC.toString() + '\n';
        }
        toStringStudentSC += "]";
        return "ClasseSC{" + "id=" + id + ", name=" + name + ", listaStudID=" + toStringStudentSC + '}';
    }

    // Metodo che restituisce un instanza di ClasseSC che ha quell'id -> SELECT
    /**
     * Recupera un'istanza di {@link ClasseSC} dal suo ID dalla mappa delle
     * classi.
     *
     * @param id L'ID della classe da recuperare.
     * @return Un'istanza di {@link ClasseSC} se trovata, altrimenti null.
     */
    public static ClasseSC getClasseSCbyId(int id) {
        return mappaClasseSC.get(id);
    }

    // Metodo che elimina un instanza di ClasseSC che ha quell'id -> DELETE
    /**
     * Rimuove un'istanza di {@link ClasseSC} dalla mappa delle classi dal suo
     * ID.
     *
     * @param id L'ID della classe da rimuovere.
     */
    public static void removeClasseSCById(int id) {
        mappaClasseSC.remove(id);
    }

    /**
     * Aggiunge un ID studente alla lista di ID studente associati a questa
     * istanza di classe. Aggiorna anche l'ID di classe corrispondente
     * nell'istanza studente associata.
     *
     * @param idStudenteSC L'ID dello studente da aggiungere.
     */
    public void addStudenteSCId(int idStudenteSC) {
        listaIdStudenteSC.add(idStudenteSC);
        // Vincolo di integrità referenziale
        StudenteSC updateStudenteSC = StudenteSC.getStudenteSCbyID(idStudenteSC);
        updateStudenteSC.setIdClasseSC(id);
    }
}
