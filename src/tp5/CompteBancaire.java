package tp5;

public class CompteBancaire {
    protected String numero;
    protected double solde;
    protected String titulaire;

    public CompteBancaire(String numero, String titulaire, double soldeInitial) {
        this.numero = numero;
        this.titulaire = titulaire;
        this.solde = soldeInitial;
    }

    public void deposer(double montant) {
        solde += montant;
    }

    public void retirer(double montant) throws FondsInsuffisantsException {
        if (montant > solde) {
            throw new FondsInsuffisantsException("Fonds insuffisants pour retirer " + montant);
        }
        solde -= montant;
    }

    public double getSolde() {
        return solde;
    }

    public String getNumero() {
        return numero;
    }

    public void transferer(CompteBancaire destinataire, double montant)
            throws FondsInsuffisantsException, CompteInexistantException {
        if (destinataire == null) {
            throw new CompteInexistantException("Compte destinataire inexistant");
        }
        this.retirer(montant);
        destinataire.deposer(montant);
    }

    @Override
    public String toString() {
        return "Compte [" + numero + "] - Titulaire: " + titulaire + " - Solde: " + solde;
    }
}
