package tdApp;

interface AppView
{
	String getInput(String prompt);
	String getResult();
	void display(String msg);
}

interface AppController
{
	void appInit();
	void setView(String viewName);
	void run();
}

interface IToDoList
{
	void add(String date, String item);
	void remove(String date, String item);
	void removeAt(String date);
	boolean contains(String date);
	String getItems(String date);
}