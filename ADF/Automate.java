package ADF;
import java.util.*;

public class Automate {

    private String nombre;
    private int numEtats;
    private int etatInitial;
    private int etatActuel;
    private TreeSet<Character> alphabet;
    private TreeSet<Integer> etatsFinaux;
    private TreeSet<Integer>[][] tableTransition;

    public Automate() {
        super();
        alphabet = new TreeSet<Character>();
        etatsFinaux = new TreeSet<Integer>();


    }

    public Automate(String nombre, int nEtats, TreeSet<Character> alphabet, int q0,
            TreeSet<Integer> qFinal, TreeSet<Integer>[][] tableTransition) {
        super();
        this.nombre = nombre;
        this.numEtats = nEtats;
        this.alphabet = alphabet;
        this.etatInitial = q0;
        etatsFinaux = qFinal;
        this.tableTransition = tableTransition;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getnumEtats() {
        return numEtats;
    }

    public void setnumEtats(int nEtats) {
        this.numEtats = nEtats;
    }

    public TreeSet<Character> getAlphabet() {
        return alphabet;
    }

    public void setAlphabet(TreeSet<Character> alphabet) {
        this.alphabet=alphabet;
    }

    public int getEtatInitial() {
        return etatInitial;
    }

    public void setEtatInitial(int q0) {
        this.etatInitial = q0;
    }

    public TreeSet<Integer> getEtatsFinaux() {
        return etatsFinaux;
    }

    public void setEtatsFinaux(TreeSet<Integer> qFinal) {
        etatsFinaux = qFinal;
    }

    public TreeSet<Integer>[][] getTableTransition() {
        return tableTransition;
    }

    public void setTableTransition(TreeSet<Integer>[][] tableTransition) {
        this.tableTransition = tableTransition;
    }

    public void ajouterEtatFinal(int q) {
        etatsFinaux.add(q);
    }

    public int getEtatActuel() {
        return etatActuel;
    }

    public void ajouterLettreAlphabet(char lettre) {
        alphabet.add(lettre);
        tableTransition = new TreeSet[numEtats][alphabet.size()];
        initialiserTableTransition();
    }

    private void initialiserTableTransition() {
        for (int x = 0; x < numEtats; x++) {
            for (int y = 0; y < alphabet.size(); y++) {
                tableTransition[x][y] = new TreeSet<Integer>();
            }
        }
    }

    public void ajouterTransition(int q0, Character e, int q1) {
        Vector<Character> v = new Vector<Character>();
        v.addAll(alphabet);
        tableTransition[q0][v.indexOf(e)].add(q1);
    }

    public boolean analyserMot(String mot) {

        etatActuel = etatInitial;
        String[] lettres = mot.split("");

        for (String l : lettres) {
            if (!l.equals("")) {
                etatActuel = fonction(etatActuel, l);
                if (etatActuel == -1) {
                    return false;
                }
            }
        }
        if (etatsFinaux.contains(etatActuel)) {
            return true;
        }

        return false;
    }

    private int fonction(int etatActuel, String e) {
        Vector<Character> v = new Vector<Character>();
        v.addAll(alphabet);
        if (tableTransition[etatActuel][v.indexOf(e)].isEmpty()) {
            return -1;
        } else {
            return tableTransition[etatActuel][v.indexOf(e)].first();
        }

    }
}

