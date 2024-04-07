package it.edu.marconiverona.listhashmapinstances;

/**
 * Rappresenta una lista di istanze di {@link ClasseSC} e {@link StudenteSC}.
 * Questa classe fornisce una dimostrazione della gestione delle istanze di
 * {@link StudenteSC} all'interno delle istanze di {@link ClasseSC}.
 *
 * @author <a href="mailto:marco.aprea@marconiverona.edu.it">Marco Aprea</a>
 * @version 1.0 20240407
 * @see <a href="https://it.wikipedia.org/wiki/Class_diagram#Relazione"> WIKI
 * UML Relazione</a>
 */
public class ListHashMapInstances {

    /**
     * Metodo principale che mostra l'utilizzo delle istanze di {@link ClasseSC}
     * e {@link StudenteSC}. Crea diverse istanze di entrambe le classi,
     * aggiunge studenti alle classi e visualizza informazioni sulle classi e
     * sugli studenti.
     *
     * @param args Gli argomenti da riga di comando passati al programma.
     */
    public static void main(String[] args) {

        StudenteSC st01 = new StudenteSC(10, "20010");
        StudenteSC st02 = new StudenteSC(11, "20011");
        StudenteSC st03 = new StudenteSC(12, "20012");
        StudenteSC st04 = new StudenteSC(13, "20013");
        StudenteSC st05 = new StudenteSC(14, "20014");

        ClasseSC cl01 = new ClasseSC(200, "3ei");
        ClasseSC cl02 = new ClasseSC(200, "3ei");

        cl01.addStudenteSCId(st01.getId());
        cl01.addStudenteSCId(st02.getId());

        cl02.addStudenteSCId(st03.getId());

        System.out.println("--- Studenti della classe cl01 ---");
        System.out.println(cl01.toString());

        System.out.println("--- Studenti della classe cl02 ---");
        System.out.println(cl02.toString());

        System.out.println("--- Studenti della classe con id 200 ---");
        ClasseSC clId200 = ClasseSC.getClasseSCbyId(200);
        System.out.println(clId200.toString());
    }
}
