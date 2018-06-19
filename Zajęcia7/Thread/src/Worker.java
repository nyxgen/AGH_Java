import javafx.util.Pair;

import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.PriorityQueue;
import java.util.Queue;

public class Worker implements WorkerListener{

    boolean working = false;
    boolean started = false;
    String name;
    ArrayDeque<Pair<String,Task>> taskQueue = new ArrayDeque<>();
    Thread workThread;
    Thread queueThread;
    WorkerListener listener;
    void enqueueTask( String taskName, Task task )
    {
        taskQueue.add(new Pair(taskName, task));
    }
    void start()
    {
        onWorkerStarted();
        queueThread = new WorkingThread(name);
        queueThread.run();
    }

    void stop()
    {
        onWorkerStoped();
    }
    void setListener(WorkerListener newListener )
    {
        listener = newListener;
    }
    boolean isStarted()
    {
        return started;
    }
    boolean isWorking()
    {
        return working;
    }

    public Worker(String newName )
    {
        name = newName;
    }
    @Override
   public void onWorkerStarted()
    {
        System.out.println("Worker Started");
        started = true;
    }
    @Override
   public void onWorkerStoped()
    {
        System.out.println("Worker Stoped");
        started = false;
    }
    @Override
    public void onTaskStarted( int taskNumber, String taskName )
    {
        System.out.println();
        System.out.print("Task Stared, Task Name: " + taskName);
        System.out.print(" Task number: ");
        System.out.println(taskNumber);
        working = true;
    }
    @Override
    public void onTaskCompleted( int taskNumber, String taskName )
    {
        System.out.print("Task Completed, Task Name: " + taskName);
        System.out.print(" Task number: ");
        System.out.println(taskNumber);
        System.out.println();
        working = false;
    }
    public class WorkingThread extends Thread
    {
        String name;
       public WorkingThread(String newName)
       {
           name = newName;
       }
        @Override
       public void run()
        {
            while(started)
            {
                    if(!taskQueue.isEmpty()) {

                        Pair<String, Task> toDoNext = taskQueue.poll();
                        workThread = new Thread(toDoNext.getValue());
                        onTaskStarted(toDoNext.getValue().taskNumber, toDoNext.getKey());
                        workThread.start();
                        try {
                            workThread.join();
                            onTaskCompleted(toDoNext.getValue().taskNumber, toDoNext.getKey());
                        } catch (InterruptedException e) {

                        }
                }
            }
        }
    }
}
