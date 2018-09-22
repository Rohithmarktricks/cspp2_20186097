import java.util.Scanner;
import java.util.Arrays;

/*class TitleNotProvidedException extends Exception {
	public String toString() {
		return "Title not provided";
	}
}

class InvalidTimeToCompleteException extends Exception {
	public String toString() {
		return "Invalid time ToComplete" + "<" + ">";
	}
}

class InvalidStatusException extends Exception {
	public String toString() {
		return "Invalid status" + "<" + ">";
	}
}*/

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
	Task(String title1, String assignedTo1, int timeToComplete1, Boolean important1, Boolean urgent1, String status1) {
		/*this.title = title1;
		this.assignedTo = assignedTo1;
		this.timeToComplete = timeToComplete1;
		this.important = important1;
		this.urgent = urgent1;
		this.status = status1;*/

		setTitle(title1);
		setAssignedTo(assignedTo1);
		setTimeToComplete(timeToComplete1);
		setImportant(important1);
		setUrgent(urgent1);
		setStatus(status1);
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
	public String getNextTask(String parameter) {
		for (int j = 0; j < taskobj.length; j++) {
			if (taskobj[j].getAssignedTo() == parameter) {
				if (taskobj[j].getStatus() == "todo" && taskobj[j].getImportant() == "Important"  && taskobj[j].getUrgent() == "Urgent") {
					return taskobj[j].getTitle();
				}
			}
		}

		for (int j = 0; j < taskobj.length; j++) {
			if (taskobj[j].getAssignedTo() == parameter) {
				if (taskobj[j].getStatus() == "todo" && taskobj[j].getImportant() == "Important" && taskobj[j].getUrgent() == "Urgent") {
					return taskobj[j].getTitle();
				}
			}
		}
		return "null";
	}

	public Task[] getNextTask(String parameter, int param2) {
		Task[] ta = new Task[2];
		return ta;
	}

	public int totalTime4Completion() {
		int i = 0;
		/*for (Task task : taskobj) {
			if (task.getStatus() == "done") {
				i += task.getTimeToComplete();
			}
		}*/
		return i;
	}
}


/**
 * Class for todoist main.
 */
public class TodoistMain {

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
	public static void testAddTask(final Todoist todo, final String[] tokens) {
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
		String title = tokens[1];
		String assignedTo = tokens[2];
		int timeToComplete = Integer.parseInt(tokens[3]);
		boolean important = tokens[4].equals("y");
		boolean urgent = tokens[5].equals("y");
		String status = tokens[6];

		return new Task(
		           title, assignedTo, timeToComplete, important, urgent, status);
		/* catch (TitleNotProvidedException e) {
			System.out.println("Title not provided");
		} catch (InvalidStatusException e) {
			System.out.println("Invalid status" + "<" + this.getStatus() + ">");
		} catch (InvalidTimeToCompleteException e) {
			System.out.println("Invalid time ToComplete" + "<" + this.getTimeToComplete() + ">");
		}*/
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
