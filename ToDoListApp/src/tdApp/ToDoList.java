package tdApp;
import java.util.*;

public class ToDoList implements IToDoList 
{
	private HashMap<String, LinkedList<String>> list;
	
	public ToDoList()
	{
		list = new HashMap<String, LinkedList<String>>();
	}
	
	public void add(String date, String item)
	{
		if(!contains(date))
		{
			list.put(date, new LinkedList<String>());
			list.get(date).add(item);
		}
		else
			list.get(date).add(item);
	}
	
	public void removeAt(String date)
	{
		list.remove(date);
	}
	
	public void remove(String date, String item)
	{
		list.get(date).remove(item);
	}
	
	public Set<String> getKeyset()
	{
		return list.keySet();
	}
	
	public boolean contains(String date)
	{
		Set<String> dates = getKeyset();
		return dates.contains(date);
	}
	
	public String getItems(String date)
	{
		String toReturn = "";
		if(contains(date))
		{
			toReturn += list.get(date).toString();
		}
		return toReturn;
	}
	
	public String toString()
	{
		String toReturn = "";
		for(Map.Entry<String, LinkedList<String>> entry : list.entrySet()) 
		{
			toReturn += entry.getKey() + "\t";
			toReturn += list.get(entry.getKey()).toString() + "\n";
		}
		return toReturn;
	}
}
