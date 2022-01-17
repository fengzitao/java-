package com.fzt.day14.java;

public class Person {
	String name;
	int age;

	public Person(String name, int age) {
		super();
		this.name = name;
		this.age = age;
	}

	public void eat() {
		System.out.println("人：吃饭");
	}

	public void walk() {
		System.out.println("人：走路");
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (getClass() != obj.getClass()) {
			return false;
		}
		Person other = (Person) obj;
		if (age != other.age) {
			return false;
		}
		if (name == null) {
			return other.name == null;
		} else {
			return name.equals(other.name);
		}
	}

//	public boolean equals(Object obj) {
//		if (obj == this) {
//			return true;
//		}
//
//		if (obj instanceof Person) {
//			Person p = (Person) obj;
//			return this.age == p.age && this.name.equals(p.name);
//		}
//
//		return false;
//	}

}
