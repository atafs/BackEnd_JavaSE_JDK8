package dao;

import interfaces.Female;
import interfaces.Person;

public class AmericoTomas implements Person, Female{

	//insert methods with implementation
	public void speak() {
		//INTERFACE PERSON
		Person.super.speak();
		//INTERFACE FEMALE
		Female.super.speak();
	}
}
