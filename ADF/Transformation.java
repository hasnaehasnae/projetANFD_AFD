package ADF;
import java.util.Stack;
import java.util.TreeSet;
import java.util.Vector;

import javax.swing.JOptionPane;

public class Transformation {
	
	private String nombre;
    private int numEtats;
    private int etatInitial;
    private TreeSet<Character> alphabet;
    private TreeSet<Integer> etatsFinaux;
    private TreeSet<Integer>[][] tabTrans;
    
    public Automate transformer(Automate automate) {

        nombre = automate.getNombre();
        numEtats = automate.getnumEtats();
        alphabet = automate.getAlphabet();
        etatInitial = automate.getEtatInitial();
        etatsFinaux = automate.getEtatsFinaux();
        tabTrans = automate.getTableTransition();

        if (alphabet.contains('E')) {
            JOptionPane.showMessageDialog(null, "Eliminer les epsilons transitiones");

            eliminerEpsilonTransition();
            JOptionPane.showMessageDialog(null, "Epsilon-Transitions eliminées");

        } else {
            JOptionPane.showMessageDialog(null, "cet automate ne contient pas des Epsilons-Transitions");


        }
        if (nonDeterministe()) {
            JOptionPane.showMessageDialog(null, "cet automate n'est pas deterministe");

            determinisme();
            JOptionPane.showMessageDialog(null, "AFD obtenu");

        } else {
            JOptionPane.showMessageDialog(null, "cet automate est déja deterministe !!!");
          }
        Automate a = new Automate(nombre, numEtats, alphabet, etatInitial, etatsFinaux, tabTrans);
        return a ;
    }
    
    private void eliminerEpsilonTransition() {
        TreeSet<Integer> tran;
        TreeSet<Integer> tr;
        TreeSet<Integer> tr2;

        TreeSet<Character> alphabetTemp = (TreeSet<Character>) alphabet.clone();
        alphabetTemp.remove("E");
        TreeSet<Integer>[][] tableTransitionTemp = new TreeSet[numEtats][alphabetTemp.size()];

        for (int a = 0; a < alphabetTemp.size(); a++) {
            for (int q = 0; q < numEtats; q++) {
                tableTransitionTemp[q][a] = new TreeSet<Integer>();
            }

        }

        for (char c : alphabet) {
            if (c !='E') {
                for (int cont = 0; cont < numEtats; cont++) {
                    tran = new TreeSet<Integer>();
                    tr = epsilonTransition(cont);
                    tr2 = new TreeSet<Integer>();
                    for (Integer i : tr) {
                        tran.addAll(obtenerTransition(i.intValue(), c));
                    }
                    for (Integer i : tran) {
                        tr2.addAll(epsilonTransition(i.intValue()));

                        Vector<Character> v = new Vector<Character>();
                        v.addAll(alphabetTemp);
                        tableTransitionTemp[cont][v.indexOf(c)].addAll(tr2);
                    }
                }
            }
        }

        TreeSet<Integer> f = epsilonTransition(etatInitial);
        boolean cq0F = false;

        for (Integer i : etatsFinaux) {
            if (f.contains(i)) {
                cq0F = true;
            }
        }

        if (cq0F) {
            etatsFinaux.add(etatInitial);
        }
        alphabet = alphabetTemp;
        tabTrans = tableTransitionTemp;

        System.out.println();
    }

    private TreeSet<Integer> epsilonTransition(int q) {
        TreeSet<Integer> tr = new TreeSet<Integer>();
        TreeSet<Integer> tr2 = new TreeSet<Integer>();
        Stack<TreeSet<Integer>> pile = new Stack<TreeSet<Integer>>();
        pile.push(obtenerTransition(q, 'E'));
        tr.add(q);

        while (!pile.isEmpty()) {
            tr2 = pile.pop();

            for (Integer i : tr2) {
                if (!tr.contains(i.intValue())) {
                    pile.push(obtenerTransition(i.intValue(), 'E'));
                }
            }
            tr.addAll(tr2);
        }
        return tr;
    }

    private TreeSet<Integer> obtenerTransition(int q0, char c) {
        Vector<Character> v = new Vector<Character>();
        v.addAll(alphabet);
        return tabTrans[q0][v.indexOf(c)];
    }
    
    private boolean nonDeterministe() {
        boolean b = false;
        TreeSet<Integer> ts = new TreeSet<Integer>();
        for (char c : alphabet) {
            for (int cont = 0; cont < numEtats; cont++) {
                ts = obtenerTransition(cont, c);
                if (ts != null && ts.size() > 1) {
                    b = true;
                }
            }
        }
        return b;
    }
    
    private void determinisme() {

        Vector<TreeSet> nouveauxEtats = new Vector<TreeSet>();
        TreeSet<Integer> ts;
        TreeSet<Integer> ts2;

        TreeSet<Integer> tr = new TreeSet<Integer>();
        tr.add(0);
        nouveauxEtats.add(tr);

        for (char c : alphabet) {
            for (int cont = 0; cont < numEtats; cont++) {
                ts = obtenerTransition(cont, c);
                if (ts.size() != 0 && !nouveauxEtats.contains(ts)) {
                    nouveauxEtats.add(ts);
                }
            }
        }
        Vector<TreeSet> temp = (Vector<TreeSet>) nouveauxEtats.clone();

        for (TreeSet<Integer> t : temp) {
            ts2 = new TreeSet<Integer>();
            for (char c : alphabet) {
                for (Integer i : t) {
                    ts2.addAll(obtenerTransition(i, c));
                }
                if (ts2.size() != 0 && !nouveauxEtats.contains(ts2)) {
                    nouveauxEtats.add(ts2);
                }
            }
        }

        TreeSet<Integer>[][] tableau = new TreeSet[nouveauxEtats.size()][alphabet.size()];


        TreeSet<Integer> tranO, tran;
        for (char c : alphabet) {
            for (TreeSet<Integer> t : nouveauxEtats) {
                tranO = new TreeSet<Integer>();
                tran = new TreeSet<Integer>();
                for (Integer i : t) {
                    tranO.addAll(obtenerTransition(i, c));
                }

                if (nouveauxEtats.indexOf(tranO) != -1) {
                    tran.add(nouveauxEtats.indexOf(tranO));
                }

                Vector<Character> v = new Vector<Character>();
                v.addAll(alphabet);
                tableau[nouveauxEtats.indexOf(t)][v.indexOf(c)] = tran;
            }
        }

        TreeSet<Integer> finaux = new TreeSet<Integer>();

        for (TreeSet<Integer> t : nouveauxEtats) {
            for (Integer i : etatsFinaux) {
                if (t.contains(i)) {
                    finaux.add(nouveauxEtats.indexOf(t));
                }
            }
        }

        numEtats = nouveauxEtats.size();
        etatsFinaux = finaux;
        tabTrans = tableau;
        System.out.println();
    }
    
    

}
