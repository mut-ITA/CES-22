import java.util.List;


public class Hyperlink 
{
	private String _name;
	public String GetName() { return _name; }
	
	private String _url;
	public String GetUrl() { return _url; }
	
	private List<Metatag> _metatags;
	public List<Metatag> GetMetatags() { return _metatags; }
	
	private List<String> _comments;
	public List<String> GetComments() { return _comments; }
	
	private String _searchTags;
	public String GetSearchTags() { return _searchTags; }
	
	
	public Hyperlink(String name, String url, List<Metatag> metatags, List<String> comments)
	{
		_name = name;
		_url = url;
		_metatags = metatags;
		_comments = comments;
		
		_searchTags = "";
		_searchTags += name + " ";
		
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
		
		for ( String c : _comments)
		{
			System.out.print(c + " ");
		}
		
		System.out.println();		
	}	
}
