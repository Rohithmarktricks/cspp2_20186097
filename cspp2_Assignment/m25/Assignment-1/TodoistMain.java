import java.util.Scanner;
import java.util.Arrays;

/**
 * Class for task.
 */
class Task {
    /**
     * Title.
     */
    private String title;
    /**
     * Name of the person.
     */
    private String assignedTo;
    /**
     * Time to Complete.
     */
    private int timeToComplete;
    /**
     * Important.
     */
    private Boolean important;
    /**
     * Urgent.
     */
    private Boolean urgent;
    /**
     * Status.
     */
    private String status;
    /**
     * Constructs the object.
     *
     * @param      title1           The title 1
     * @param      assignedTo1      The assigned to 1
     * @param      timeToComplete1  The time to complete 1
     * @param      important1       The important 1
     * @param      urgent1          The urgent 1
     * @param      status1          The status 1
     * @throws     Exception.
     */
    Task(final String title1, final String assignedTo1,
         final int timeToComplete1,
         final Boolean important1, final Boolean urgent1,
         final String status1)
    throws Exception {

        if (title1.equals("")) {
            throw new Exception("Title not provided");
        }
        if (timeToComplete1 < 0) {
            throw new Exception("Invalid timeToComplete " + timeToComplete1);
        }
        if (!(status1.equals("todo") || status1.equals("done"))) {
            throw new Exception("Invalid status " + status1);
        }

        this.title = title1;
        this.assignedTo = assignedTo1;
        this.timeToComplete = timeToComplete1;
        this.important = important1;
        this.urgent = urgent1;
        this.status = status1;

    }

    /**
     * Gets the title.
     *
     * @return     The title.
     */
    public String getTitle() {
        return title;
    }
    /**
     * Sets the title.
     *
     * @param      title1  The title
     */
    public void setTitle(final String title1) {
        this.title = title1;
    }

    /**
     * Gets the assigned to.
     *
     * @return     The assigned to.
     */
    public String getAssignedTo() {
        return assignedTo;
    }
    /**
     * Sets the assigned to.
     *
     * @param      assignedTo1  The assigned to
     */
    public void setAssignedTo(final String assignedTo1) {
        this.assignedTo = assignedTo1;
    }
    /**
     * Gets the time to complete.
     *
     * @return     The time to complete.
     */
    public int getTimeToComplete() {
        return timeToComplete;
    }
    /**
     * Sets the time to complete.
     *
     * @param      timeToComplete1  The time to complete
     */
    public void setTimeToComplete(final int timeToComplete1) {
        this.timeToComplete = timeToComplete1;
    }
    /**
     * Gets the important.
     *
     * @return     The important.
     */
    public String getImportant() {
        if (important) {
            return "Important";
        }
        return "Not Important";
    }
    /**
     * Sets the important.
     *
     * @param      important1  The important
     */
    public void setImportant(final Boolean important1) {
        this.important = important1;
    }
    /**
     * Gets the urgent.
     *
     * @return     The urgent.
     */
    public String getUrgent() {
        if (urgent) {
            return "Urgent";
        }
        return "Not Urgent";
    }
    /**
     * Sets the urgent.
     *
     * @param      urgent1  The urgent
     */
    public void setUrgent(final Boolean urgent1) {
        this.urgent = urgent1;
    }
    /**
     * Gets the status.
     *
     * @return     The status.
     */
    public String getStatus() {
        return status;
    }
    /**
     * Sets the status.
     *
     * @param      status1  The status
     */
    public void setStatus(String status1) {
        this.status = status1;
    }
    /**
     * Returns a string representation of the object.
     *
     * @return     String representation of the object.
     */
    public String toString() {
        return this.getTitle() + ", " + this.getAssignedTo() + ", " + this.getTimeToComplete() + ", " + this.getImportant() + ", " + this.getUrgent() + ", " + this.getStatus();
    }

}


/**
 * Class for todoist.
 */
class Todoist {
    /**
     * taskobj Task Array.
     */
    private Task[] taskobj;
    /**
     * size of the Task array.
     */
    private int size;
    /**
     * Gets the size.
     *
     * @return     The size.
     */
    public int getSize() {
        return size;
    }
    /**
     * Sets the size.
     *
     * @param      size1  The size 1
     */
    public void setSize(final int size1) {
        this.size = size1;
    }
    /**
     * Gets the taskobj.
     *
     * @return     The taskobj.
     */
    public Task[] getTaskobj() {
        return taskobj;
    }
    /**
     * Sets the taskobj.
     *
     * @param      taskobj1  The taskobj
     */
    public void setTaskobj(Task[] taskobj1) {
        this.taskobj = taskobj1;
    }
    /**
     * Constructs the object.
     */
    Todoist() {
        final int hundred = 100;
        taskobj = new Task[hundred];
        size = 0;
    }
    /**
     * Adds a task.
     *
     * @param      task  The task
     */
    public void addTask(final Task task) {
        if (taskobj.length == size) {
            taskobj = resize();
        }
        taskobj[size++] = task;
    }
    /**
     * To create a new Task array.
     *
     * @return     a Task array.
     */
    public Task[] resize() {
        Task[] newList = new Task[taskobj.length * 2];
        for (int i = 0; i < size; i++) {
            newList[i] = taskobj[i];
        }
        return newList;
    }
    /**
     * Returns a string representation of the object.
     *
     * @return     String representation of the object.
     */
    public String toString() {
        String s = "";
        for (int i = 0; i < size; i++) {
            s += taskobj[i].getTitle() + ", "
                 + taskobj[i].getAssignedTo() + ", "
                 + taskobj[i].getTimeToComplete() + ", "
                 + taskobj[i].getImportant() + ", "
                 + taskobj[i].getUrgent() + ", "
                 + taskobj[i].getStatus() + "\n";
        }
        return s.substring(0, s.length() - 1);
    }
    /**
     * Gets the next task.
     *
     * @param      parameter  The parameter
     *
     * @return     The next task.
     */
    public Task getNextTask(final String parameter) {
        for (int i = 0; i < size; i++) {
            if (taskobj[i].getAssignedTo().equals(parameter)
                    && taskobj[i].getStatus().equals("todo")) {
                if (taskobj[i].getImportant().equals("Important")
                        && taskobj[i].getUrgent().equals("Not Urgent")) {
                    return taskobj[i];
                }
            }
        }
        return null;

    }
    /**
     * Gets the next task.
     *
     * @param      parameter  The parameter
     * @param      param2     The parameter 2
     *
     * @return     The next task.
     */
    public Task[] getNextTask(final String parameter, final int param2) {
        Task[] getTasks = new Task[param2];
        int index = 0;
        for (int i = 0; i < size; i++) {
            if (taskobj[i].getAssignedTo().equals(parameter)
                    && taskobj[i].getStatus().equals("todo")) {
                if (taskobj[i].getImportant().equals("Important")
                        && taskobj[i].getUrgent().equals("Not Urgent")) {
                    getTasks[index] = taskobj[i];
                    index++;
                    if (index == param2) {
                        break;
                    }
                }
            }
        }
        return getTasks;
    }
    /**
     * Total time taken.
     *
     * @return     time taken(int).
     */
    public int totalTime4Completion() {
        int count = 0;
        for (int i = 0; i < size; i++) {
            if (taskobj[i].getStatus().equals("todo")) {
                count += taskobj[i].getTimeToComplete();
            }
        }
        return count;
    }
}


/**
 * Class for todoist main.
 */
public class TodoistMain {
    /**
     * Constructs the object.
     */
    protected TodoistMain() {
        //unused.
    }

    /**
     * Starts a test.
     */
    public static void startTest() {
        Todoist todo = new Todoist();
        Scanner s = new Scanner(System.in);
        while (s.hasNext()) {
            String[] tokens = s.nextLine().split(",");
            switch (tokens[0]) {
            case "task":
                testTask(tokens);
                break;
            case "add-task":
                testAddTask(todo, tokens);
                break;
            case "print-todoist":
                System.out.println(todo);
                break;
            case "get-next":
                System.out.println(todo.getNextTask(tokens[1]));
                break;
            case "get-next-n":
                int n = Integer.parseInt(tokens[2]);
                Task[] tasks = todo.getNextTask(tokens[1], n);
                System.out.println(Arrays.deepToString(tasks));
                break;
            case "total-time":
                System.out.println(todo.totalTime4Completion());
                break;
            default:
                break;
            }
        }
    }

    /**
     * method to test add task.
     *
     * @param      todo    The todo
     * @param      tokens  The tokens
     */
    public static void testAddTask(final Todoist todo,
                                   final String[] tokens) {
        try {
            todo.addTask(createTask(tokens));
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    /**
     * method to test the creation of task object.
     *
     * @param      tokens  The tokens
     */
    public static void testTask(final String[] tokens) {
        try {
            System.out.println(createTask(tokens));
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    /**
     * Creates a task object.
     *
     * @param      tokens     The tokens
     *
     * @return     Task object
     *
     * @throws     Exception  if task inputs are invalid
     */
    public static Task createTask(final String[] tokens) throws Exception {
        final int three = 3;
        final int four = 4;
        final int five = 5;
        final int six = 6;
        String title = tokens[1];
        String assignedTo = tokens[2];
        int timeToComplete = Integer.parseInt(tokens[three]);
        boolean important = tokens[four].equals("y");
        boolean urgent = tokens[five].equals("y");
        String status = tokens[six];

        return new Task(
                   title, assignedTo, timeToComplete,
                   important, urgent, status);

    }

    /**
     * main method.
     *
     * @param      args  The command line arguments
     */
    public static void main(final String[] args) {
        startTest();
    }
}
