package ge;

import java.util.ArrayList;
import java.util.List;

public class Debug 
{
	private static List<String> _messages = new ArrayList<String>();
	private static String _fullMessage = "";
	
	static StringBuilder stringBuilder = new StringBuilder();
	
	public static int callsPerUpdate = 0;
	public static void Write(String message)
	{
		if(!thisThread.isAlive()) thisThread.start();		
		
		if(!beingCalled) 
		{
			_messages.add(message);
			callsPerUpdate++;
		}	
	}
	
	private static boolean beingCalled = false;
	
	public static void Call()
	{		
		if(!thisThread.isAlive()) thisThread.start();
		beingCalled = true;	
	}
	
	public static void Clear()
	{
		if(!beingCalled) 
		{			
			_messages.clear();
			callsPerUpdate = 0;
		}
	}
	
	static Thread thisThread = new Thread(){
		public void run ()
		{
			beingCalled = false;
			while(true)
			{				
				//WTF
				try {
					Thread.sleep((long)GameEngine.MS_PER_UPDATE());
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				//?				
				
				if(beingCalled)
				{	
					
					for (int i = 0; i < callsPerUpdate; i++) 
					{
						if(i < _messages.size())
							stringBuilder.append("\n" + _messages.get(i));
					}
					
					_fullMessage = stringBuilder.toString();
					
					if(!_fullMessage.equals(""))
					{
						System.out.print(_fullMessage);
						System.out.println("\n--------------------------------------------------------");
					}
					
					_fullMessage = "";
					stringBuilder = new StringBuilder();
					_messages.clear();
					beingCalled = false;
				}
			}
		}
	};	
}
