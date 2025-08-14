package tp5;

import java.util.ArrayList;

public class MainCompte {
    public static void main(String[] args) {
        ArrayList<CompteBancaire> comptes = new ArrayList<>();

        // Ajouter des comptes
        CompteCourant cc = new CompteCourant("CC001", "Alice", 500, 200);
        CompteEpargne ce = new CompteEpargne("CE001", "Bob", 1000, 0.05);

        comptes.add(cc);
        comptes.add(ce);

        // Opérations
        try {
            cc.deposer(200);
            cc.retirer(800); // Utilise découvert

            ce.genererInterets();
            System.out.println(ce);

            // Transfert
            cc.transferer(ce, 50);

        } catch (FondsInsuffisantsException | CompteInexistantException e) {
            System.err.println(e.getMessage());
        }

        // Afficher tous les comptes
        for (CompteBancaire c : comptes) {
            System.out.println(c);
        }

        // Suppression de compte
        comptes.remove(cc);
        System.out.println("Compte CC001 supprimé.");

        // Tentative de transfert après suppression
        try {
            cc.transferer(ce, 50);
        } catch (FondsInsuffisantsException | CompteInexistantException e) {
            System.err.println(e.getMessage());
        }
    }
}