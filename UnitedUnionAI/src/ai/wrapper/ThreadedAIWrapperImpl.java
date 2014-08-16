package ai.wrapper;

import java.util.Collections;
import java.util.HashSet;
import java.util.Queue;
import java.util.Set;
import java.util.concurrent.ArrayBlockingQueue;

import ai.BaseAI;

public class ThreadedAIWrapperImpl implements Runnable, AIWrapper{
	private Set<BaseAI> aiLists;
	private Queue<BaseAI> queue;

	public ThreadedAIWrapperImpl(int initCap) {
		aiLists=Collections.synchronizedSet(new HashSet<BaseAI>());
		queue=new ArrayBlockingQueue<>(initCap);
		
	}
	
	@Override
	public void wrap(BaseAI...ais) {
		for(BaseAI a: ais) {
			aiLists.add(a);
			
		}
		
	}
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		
	}

	public void stop() {
		
		
	}
	
}
