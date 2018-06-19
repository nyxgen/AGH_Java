public class Task implements Runnable {
    public int taskNumber;
    public Task(int newTaskNumber)
    {taskNumber = newTaskNumber;

    }
    public void run()
    {
        System.out.print("Wątek o numerze ");
        System.out.println(taskNumber);
    }
}
