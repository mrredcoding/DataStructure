package TP5.queue;

/**
 * La classe Queue représente une file générique implémentée à l'aide d'un tableau circulaire.
 * Elle permet d'ajouter des éléments à la fin de la file (push) et de retirer des éléments du début de la file (pop).
 * @param <T> Le type des éléments dans la file.
 *
 * @version 1.0
 * @author Cédric Alonso
 * @author Jade Hatoum
 */
public class Queue<T> {

    private final T[] tab; // Tableau contenant les éléments de la file.
    private int start;      // Indice de début de la file.
    private int end;        // Indice de fin de la file.
    private final int NBMAXELEMENTS; // Capacité maximale de la file.
    private int nbElements; // Nombre d'éléments actuellement dans la file.

    /**
     * Constructeur de la classe Queue.
     *
     * @param nbMaxElements La capacité maximale de la file.
     */
    public Queue(int nbMaxElements) {
        this.NBMAXELEMENTS = nbMaxElements;
        this.tab = (T[]) new Object[NBMAXELEMENTS];
        this.start = 0;
        this.end = 0;
        this.nbElements = 0;
    }

    /**
     * Ajoute un élément à la fin de la file.
     *
     * @param value L'élément à ajouter.
     * @throws QueueException Si la file est pleine.
     */
    public void push(T value) throws QueueException {
        if (this.isFull())
            throw new QueueException("Vous ne pouvez pas ajouter un élément (" + value + ") : La file est pleine !");
        this.tab[this.end] = value;
        this.end = (this.end + 1) % this.NBMAXELEMENTS;
        this.nbElements++;
    }

    /**
     * Retire et retourne l'élément du début de la file.
     *
     * @return L'élément retiré de la file.
     * @throws QueueException Si la file est vide.
     */
    public T pop() throws QueueException {
        if (this.isEmpty())
            throw new QueueException("Vous ne pouvez pas retirer un élément : La file est vide !");
        T value = this.tab[this.start];
        this.start = (this.start + 1) % NBMAXELEMENTS;
        this.nbElements--;
        return value;
    }

    /**
     * Retourne l'élément du début de la file sans le retirer.
     *
     * @return L'élément du début de la file.
     * @throws QueueException Si la file est vide.
     */
    public T top() throws QueueException {
        if (this.isEmpty())
            throw new QueueException("Vous ne pouvez pas lire d'élément : La file est vide !");
        return this.tab[this.start];
    }

    /**
     * Retourne une représentation sous forme de chaîne de caractères de la file.
     *
     * @return Une chaîne de caractères représentant la file.
     */
    @Override
    public String toString() {
        if (this.isEmpty())
            return "Il n'y a aucun élément dans la file." + System.lineSeparator();

        StringBuilder sb = new StringBuilder("Il y a ")
                .append(this.nbElements)
                .append(this.nbElements > 1 ? " éléments " : " élément ")
                .append("dans la file :")
                .append(System.lineSeparator());

        int cpt = this.nbElements;
        for (int i = this.start; cpt != 0; i = (i + 1) % NBMAXELEMENTS, cpt--)
            sb.append(this.tab[i]).append(System.lineSeparator());

        return sb.toString();
    }

    /**
     * Vérifie si la file est pleine.
     *
     * @return true si la file est pleine, false sinon.
     */
    public boolean isFull() {
        return this.nbElements == NBMAXELEMENTS;
    }

    /**
     * Vérifie si la file est vide.
     *
     * @return true si la file est vide, false sinon.
     */
    public boolean isEmpty() {
        return this.nbElements == 0;
    }

    /**
     * Retourne le nombre d'élément dans la file
     *
     * @return nbElements le nombre d'élément dans la file
     */
    public int getNbElements(){
        return this.nbElements;
    }
}




