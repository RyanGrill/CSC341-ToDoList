package tdApp;
import java.util.*;

class ToDoListAppController implements AppController
{
	AppView view;
	IToDoList lst;
	String input, viewName;
	
	ToDoListAppController()
	{
		appInit();
	}
	
	public void setView(String name) {
		this.viewName = name; 
		if(viewName.equalsIgnoreCase("console"))
			view = new ConsoleAppView(lst);
		else if(viewName.equalsIgnoreCase("darkConsole"))
			view = new DarkConsoleAppView(lst);
		else view = null;
		if(view != null){
			view.display( ((ToDoList) lst).toString().toString() );
		}
		else System.exit(1);
	}
		
	public void appInit()
	{
		lst = new ToDoList();
		lst.add("12/10/18", "Prep for my finals");
		lst.add("12/10/18", "See my advisor");
		lst.add("2/7/19", "Go to class @ 6:00PM");
		lst.add("2/5/19", "Go to work @ 4:00PM");
	}
	
	public void run()
	{
		do
		{
			input = view.getInput("Add(a), search (s) the list for a date, remove an entry(r), or quit (q)?");
			if(input.equalsIgnoreCase("a")){
				String date = view.getInput("Enter date --> ");
				String item = view.getInput("Enter item --> ");
				lst.add(date, item);
			}
			else if(input.equalsIgnoreCase("s"))
			{
				input = view.getInput("Enter date --> ");
				view.display("Entries: " + view.getResult() + "\n-----");
			}
			else if(input.equalsIgnoreCase("r"))
			{
				String removeAll = view.getInput("Remove all entries for the date(Y/N)? ");
				if(removeAll.equalsIgnoreCase("Y"))
				{
					String date = view.getInput("Enter date --> ");
					lst.removeAt(date);
				}
				else
				{
					String date = view.getInput("Enter date --> ");
					String item = view.getInput("Enter item --> ");
					lst.remove(date, item);
				}
			}
			else
			{
				view.display("Current To-Do List: \n");
				view.display(lst.toString());
				break;
			}
		}while(true);
	}
}
	
class ConsoleAppView implements AppView
{
	private Scanner sc;
	String input;
	IToDoList lst;
	
	ConsoleAppView(IToDoList l){
		lst = l;
		sc = new Scanner(System.in);
	}

	public String getInput(String prompt) {
		System.out.println(prompt);
		input = sc.nextLine();
		return input;
	}
	
	public String getResult() {
		String result = lst.getItems(input.trim());
		return result;
	}
	
	public void display(String msg) 
	{
		System.out.println(msg);		
	}
}

class DarkConsoleAppView implements AppView
{
	private Scanner sc;
	String input;
	IToDoList lst;
	
	DarkConsoleAppView(IToDoList l){
		lst = l;
		sc = new Scanner(System.in);
	}

	public String getInput(String prompt) {
		System.out.println(prompt);
		input = sc.nextLine();
		return input;
	}
	
	public String getResult() {
		String result = lst.getItems(input.trim());
		return result;
	}
	
	public void display(String msg) 
	{
		System.out.println(msg);		
	}
}
