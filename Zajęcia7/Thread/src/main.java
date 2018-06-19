public class main {
    public static void main(String args[])
    {
        Worker first = new Worker("First");
        first.enqueueTask("Zadanie 1", new Task(1));
        first.enqueueTask("Zadanie 2", new Task(2));
        first.enqueueTask("Zadanie 3", new Task(3));
        first.enqueueTask("Zadanie 4", new Task(4));
        first.enqueueTask("Zadanie 5", new Task(5));
        first.enqueueTask("Zadanie 6", new Task(6));
        first.enqueueTask("Zadanie 7", new Task(7));
        first.enqueueTask("Zadanie 8", new Task(8));
        first.enqueueTask("Zadanie 9", new Task(9));
        first.enqueueTask("Zadanie 10", new Task(10));
        first.start();
        first.stop();
        first.start();

    }
}
