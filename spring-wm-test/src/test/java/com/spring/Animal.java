package com.spring;

public abstract class Animal {
	//这个方法，子类不能去改变
	public final void takeShower(){
		//按照固定顺序执行
		showerStart();
		process();
	}
	abstract public void showerStart();
	abstract public void process();
}

class Cat extends Animal{
	@Override
	public void showerStart() {
		System.out.println("小猫——开始洗澡了");
	}

	@Override
	public void process() {

		System.out.println("小猫——洗澡中");
	}
}

class Dog extends Animal{
	@Override
	public void showerStart() {
		System.out.println("小狗——开始洗澡了");
	}

	@Override
	public void process() {

		System.out.println("小狗——洗澡中");
	}
}
class TestZoo{
	public static void main(String[] args) {
		Animal  c =new Cat();
		Animal  d =new Dog();
		c.takeShower();
		d.takeShower();
	}
}