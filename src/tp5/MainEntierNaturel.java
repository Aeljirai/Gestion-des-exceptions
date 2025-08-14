package tp5;

public class MainEntierNaturel {
    public static void main(String[] args) {
        try {
            EntierNaturel entier = new EntierNaturel(5);
            System.out.println("Valeur initiale : " + entier.getVal());

            entier.setVal(3);
            System.out.println("Nouvelle valeur : " + entier.getVal());

            entier.decrementer();
            System.out.println("Après décrémentation : " + entier.getVal());

            entier.setVal(-10); // Provoque une exception

        } catch (NombreNegatifException e) {
            System.err.println("Exception capturée : " + e.getMessage());
            System.err.println("Valeur erronée : " + e.getValeurErronee());
        }

        try {
            EntierNaturel e2 = new EntierNaturel(-1);
        } catch (NombreNegatifException e) {
            System.err.println("Exception lors de la création : " + e.getMessage());
            System.err.println("Valeur erronée : " + e.getValeurErronee());
        }
    }
}
