package classes;

import interfaces.WorkerInterface;

public class WorkerClass {
	
	//PROCEDURE
	public void execute(WorkerInterface workerInterface) {
		workerInterface.doSomeWork();
	}
}
