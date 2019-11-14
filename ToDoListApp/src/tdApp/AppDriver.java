package tdApp;

public class AppDriver 
{
	public static void main(String[] args) 
	{
		AppController app = new ToDoListAppController();
		app.setView("console");
		app.run();
	}
}
