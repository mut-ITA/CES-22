package ge;

import java.util.ArrayList;
import java.util.List;

public class ColliderThread implements Runnable {

	private List<Collider> Colliders = new ArrayList<Collider>();
	private static ColliderThread _instance;
    public static ColliderThread Instance()
    {
        if(_instance == null)
            _instance = new ColliderThread();
        return _instance;
    }
	public void run (){
		while(true){
			for (int i = 0; i < Colliders.size(); i++) {
				for (int j = i; j < Colliders.size(); j++) {
					if(Colliders.get(i).HasCollided(Colliders.get(j)));
				}
			}
		}
	}
	
	public void AddList(Collider collider){
		Colliders.add(collider);		
	}
	
}
