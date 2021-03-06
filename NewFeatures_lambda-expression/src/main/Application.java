package main;

import interfaces.WorkerInterface;

import java.util.ArrayList;
import java.util.List;

import classes.WorkerClass;

public class Application {
	
	//MAIN
	public static void main(String[] args) {
		
		// ################################
		//LOCAL VARIABLES *****************
		List<Integer> list = new ArrayList<Integer>();
		
		//ADD *****************************
		list.add(5);
		list.add(10);
		list.add(15);
		
		//LOOP ****************************
		//FOREACH_01 old syntax
		for (int i : list) {
			System.out.println(i);
		}
		//FOREACH_02 new syntax
		list.forEach(n -> {System.err.println(n);});
		list.forEach(System.out::println);
		
		// #################################
		WorkerClass worker = new WorkerClass();
		//ANNONYMOUS CLASS
		worker.execute(new WorkerInterface() {
			
			@Override
			public void doSomeWork() {
				System.err.println("do some work using anonymous class");
			}
		});
		
		//LAMBDA ***************************
		worker.execute(() -> { 
			System.out.println("do some work using lambda");
		});
	}
}
