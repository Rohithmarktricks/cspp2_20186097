import java.util.Scanner;
import java.util.Arrays;

/**
 * Class for task.
 */
class Task {
	private String title;
	private String assignedTo;
	private int timeToComplete;
	private Boolean important;
	private Boolean urgent;
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
	 */
	Task(String title1, String assignedTo1, int timeToComplete1, Boolean important1, Boolean urgent1, String status1) throws Exception {

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


	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}


	public String getAssignedTo() {
		return assignedTo;
	}

	public void setAssignedTo(String assignedTo) {
		this.assignedTo = assignedTo;
	}

	public int getTimeToComplete() {
		return timeToComplete;
	}

	public void setTimeToComplete(int timeToComplete) {
		this.timeToComplete = timeToComplete;
	}

	public String getImportant() {
		if (important) {
			return "Important";
		}
		return "Not Important";
	}

	public void setImportant(Boolean important) {
		this.important = important;
	}
	public String getUrgent() {
		if (urgent) {
			return "Urgent";
		}
		return "Not Urgent";
	}

	public void setUrgent(Boolean urgent) {
		this.urgent = urgent;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String toString() {
		return this.getTitle() + ", " + this.getAssignedTo() + ", " + this.getTimeToComplete() + ", " + this.getImportant() + ", " + this.getUrgent() + ", " + this.getStatus();
	}

}


/**
 * Class for todoist.
 */
class Todoist {
	Task[] taskobj;
	int size;

	Todoist() {
		taskobj = new Task[100];
		size = 0;
	}

	public void addTask(Task task) {
		if (taskobj.length == size) {
			taskobj = resize();
		}
		taskobj[size++] = task;
	}

	public Task[] resize() {
		Task[] newList = new Task[taskobj.length * 2];
		for (int i = 0; i < size; i++) {
			newList[i] = taskobj[i];
		}
		return newList;
	}

	public String toString() {
		String s = "";
		for (int i = 0; i < size; i++) {
			s += taskobj[i].getTitle() + ", " + taskobj[i].getAssignedTo() + ", " + taskobj[i].getTimeToComplete() + ", " + taskobj[i].getImportant() + ", " + taskobj[i].getUrgent() + ", " + taskobj[i].getStatus() + "\n";
		}
		return s.substring(0, s.length() - 1);
	}
	public Task getNextTask(String parameter) {
		for (int i = 0; i < size; i++) {
			if (taskobj[i].getAssignedTo().equals(parameter) && taskobj[i].getStatus().equals("todo")) {
				if (taskobj[i].getImportant().equals("Important") && taskobj[i].getUrgent().equals("Not Urgent")) {
					return taskobj[i];
				}
			}
		}
		return null;

	}

	public Task[] getNextTask(String parameter, int param2) {
		Task[] getTasks = new Task[param2];
		int index = 0;
		for (int i = 0; i < size; i++) {
			if (taskobj[i].getAssignedTo().equals(parameter) && taskobj[i].getStatus().equals("todo")) {
				if (taskobj[i].getImportant().equals("Important") && taskobj[i].getUrgent().equals("Not Urgent")) {
					getTasks[index] = taskobj[i];
					index++;
					if (index == param2) break;
				}
			}
		}
		return getTasks;
	}

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
	protected TodoistMain(){
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
