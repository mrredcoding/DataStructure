package TP5;

public class Main {

    private static final Queue<Integer> queue = new Queue<>(3);
    public static void main(String[] args) {
        push(new Integer[]{5, 7, 9, 10});

        pop();

        pop();

        pop();

        pop();

        pop();

        push(new Integer[]{55, 77, 99});
    }

    private static void push(Integer[] values){
        for (Integer value : values){
            try{
                queue.push(value);
                System.out.println("Properly pushed value : " + value + " in the queue");
            } catch (EmptyQueueException e){
                System.out.println(e.getMessage());
            }
        }
        System.out.println(System.lineSeparator() + queue);
    }

    private static void pop(){
        try{
            Integer popValue = queue.pop();
            System.out.println("The pop element value is : " + popValue);
        } catch (EmptyQueueException e){
            System.out.println(e.getMessage());
        }
        System.out.println(queue);
    }
}
