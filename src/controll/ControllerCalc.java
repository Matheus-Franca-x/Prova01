package controll;

import java.util.concurrent.Semaphore;

public class ControllerCalc extends Thread
{
	
	private int idThread;
	private Semaphore pausa;
	private double valor;
	
	public ControllerCalc(int i, Semaphore perm)
	{
		this.idThread = i;
		this.pausa = perm;
		
	}
	
	@Override
	public void run()
	{
		try {
			pausa.acquire();
			calculo();
		} catch (InterruptedException e) {
			e.printStackTrace();
		} finally {
			pausa.release();
		}
	}
	
	private void calculo()
	{
		valor = 1 / (double) idThread;
		while (valor < 1)
		{
			System.out.println(valor);
			valor = 1 / idThread;
		}
	}
	
}
