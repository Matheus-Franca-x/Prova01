package view;

import java.util.concurrent.Semaphore;

import controll.ControllerCalc;

public class Main {

	public static void main(String[] args) 
	{
		Semaphore perm = new Semaphore(1);
		
		for (int i = 0; i <= 10; i++)
		{
			Thread calc = new ControllerCalc(i, perm);
			calc.start();
		}

	}
	// deixarei privado depois das 10h da noite
}
