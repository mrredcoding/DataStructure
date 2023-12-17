package TP5.queue;

/**
 * La classe Main est une classe de démonstration illustrant l'utilisation de la classe Queue.
 * Elle crée une instance de la classe Queue, effectue des opérations de push et pop, et affiche les résultats.
 *
 * @version 1.0
 * @author Cédric Alonso
 * @author Jade Hatoum
 */
public class Main {

    /** File utilisée pour les démonstrations, avec une capacité maximale de 3 éléments. */
    private static final Queue<Integer> queue = new Queue<>(3);

    /**
     * La méthode principale de la classe Main.
     *
     * @param args Les arguments de la ligne de commande.
     */
    public static void main(String[] args) {
        push(new Integer[]{5, 7, 9, 10});

        pop();

        pop();

        pop();

        pop();

        pop();

        push(new Integer[]{55, 77, 99});
    }

    /**
     * Ajoute des valeurs à la file à l'aide de la méthode push et affiche le résultat.
     *
     * @param values Les valeurs à ajouter à la file.
     */
    private static void push(Integer[] values) {
        for (Integer value : values) {
            try {
                queue.push(value);
                System.out.println("Valeur correctement ajoutée : " + value + " dans la file");
            } catch (QueueException e) {
                System.out.println(e.getMessage());
            }
        }
        System.out.println(System.lineSeparator() + queue);
    }

    /**
     * Retire un élément de la file à l'aide de la méthode pop et affiche le résultat.
     */
    private static void pop() {
        try {
            Integer popValue = queue.pop();
            System.out.println("La valeur de l'élément retiré est : " + popValue);
        } catch (QueueException e) {
            System.out.println(e.getMessage());
        }
        System.out.println(queue);
    }
}

