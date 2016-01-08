package com.ela.pojotoxml;

public class Employee {

    private String name;
    private int age;
    private double salary;
    private Address address;
    
    public String getName() {
            return name;
    }
    public void setName(String name) {
            this.name = name;
    }
    public int getAge() {
            return age;
    }
    public void setAge(int age) {
            this.age = age;
    }
    public double getSalary() {
            return salary;
    }
    public void setSalary(double salary) {
            this.salary = salary;
    }
    public void setAddress(Address address) {
            this.address = address;
    }
    public Address getAddress() {
            return address;
    }
    
	@Override
	public String toString() {
		return "Employee [name=" + name + ", age=" + age + ", salary=" + salary + ", address=" + address + "]";
	}
    
    
}