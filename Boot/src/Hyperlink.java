import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;


public class Hyperlink 
{
	private String _name;
	public String GetName() { return _name; }
	
	private String _url;
	public String GetUrl() { return _url; }
	
	private List<Metatag> _metatags;
	public List<Metatag> GetMetatags() { return _metatags; }
	
	private String _comments;
	public String GetComments() { return _comments; }
	
	private String _searchTags;
	public String GetSearchTags() { return _searchTags; }
	
	private String _lastEdited;
	public String GetLastEdited() { return _lastEdited; }
	
	
	public Hyperlink(String name, String url, List<Metatag> metatags, String comments)
	{
		_name = name;
		_url = url;
		_metatags = metatags;
		_comments = comments;
		
		DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
		Date date = new Date();
		
		_lastEdited = dateFormat.format(date);
		
		_searchTags = " ";
		_searchTags += name + " ";
		_searchTags += url + " ";
		
		for(Metatag m : metatags)
		{
			_searchTags += m.GetName() + " ";
			_searchTags += m.GetDescription() + " ";
		}
	}
	
	public Hyperlink(String name, String url, List<Metatag> metatags, String comments, String lastEdited)
	{
		_name = name;
		_url = url;
		_metatags = metatags;
		_comments = comments;
		_lastEdited = lastEdited;
		
		_searchTags = " ";
		_searchTags += name + " ";
		_searchTags += url + " ";
		
		for(Metatag m : metatags)
		{
			_searchTags += m.GetName() + " ";
			_searchTags += m.GetDescription() + " ";
		}
	}
	
	public void Log()
	{
		System.out.println("Name = " + _name);
		System.out.println("Url = " + _url);
		System.out.println("Metatags = ");
		
		for(Metatag m : _metatags)
		{
			m.Log();
		}
		
		System.out.print("Comments = ");
		
		System.out.print(_comments + " ");
		
		System.out.println();		
	}	
}
