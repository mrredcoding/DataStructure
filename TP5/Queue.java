package TP5;

public class Queue<T> {
    private T[] tab;
    private int start;

    private int end;

    private final int NBMAXELEMENTS;

    private int nbElements;

    public Queue(int nbMaxElements){
        this.NBMAXELEMENTS = nbMaxElements;
        this.tab = (T[]) new Object[NBMAXELEMENTS];
        this.start = 0;
        this.end = 0;
        this.nbElements = 0;
    }

    public void push(T value) throws EmptyQueueException {
        if (this.isFull())
            throw new EmptyQueueException("You cannot push an element (" + value + ") : " +
                    this.getClass().getSimpleName() + " is full !");

        this.tab[this.end] = value;
        this.end = (this.end + 1) % this.NBMAXELEMENTS;

        this.nbElements++;
    }

    public T pop() throws EmptyQueueException{
        if (this.isEmpty())
            throw new EmptyQueueException("You cannot pop an element : " +
                    this.getClass().getSimpleName() + " is empty ! ");

        T value = this.tab[this.start];
        this.start = (this.start + 1) % NBMAXELEMENTS;

        this.nbElements--;

        return value;
    }

    @Override
    public String toString() {
        if (this.isEmpty())
            return "There is no element in the queue." + System.lineSeparator();

        StringBuilder sb = new StringBuilder("There is ")
                .append(this.nbElements)
                .append(this.nbElements > 1 ? " elements " : " element ")
                .append("in the queue :")
                .append(System.lineSeparator());

        int cpt = this.nbElements;
        for (int i = this.start; cpt != 0; i = (i + 1) % NBMAXELEMENTS, cpt--)
            sb.append(this.tab[i]).append(System.lineSeparator());

        return sb.toString();
    }

    private boolean isFull(){
        return this.nbElements == NBMAXELEMENTS;
    }

    private boolean isEmpty(){
        return this.nbElements == 0;
    }
}
