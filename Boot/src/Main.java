

import java.io.*;
import java.util.ArrayList;
import java.util.List;


public class Main 
{	
	public static void main(String[] args) throws IOException 
	{
		List<Metatag> metatags = new ArrayList();
		metatags.add(new Metatag("Name1", "Value1"));
		metatags.add(new Metatag("Name2", "Ilharco"));
		List<String> comments = new ArrayList();
		comments.add("Such a nice comment");	
		
		Hyperlink a = new Hyperlink("Aco", "www.Ilharco.com", metatags, comments);
		
		XmlManager.GetInstance().Add(a);
		
		for(Hyperlink h : XmlManager.GetInstance().Search("Lucas Muller"))
		{
			h.Log();
			System.out.println();
		}
		
		
		
		XmlManager.GetInstance().Save();
	}
}
