package controll;

import java.util.concurrent.Semaphore;

public class ControllerCalc extends Thread
{
	
	private int idThread;
	private Semaphore pausa;
	private int valor;
	
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
		valor = valor / idThread;
		while (valor < 1)
		{
			System.out.println(valor);
			valor = valor / idThread;
		}
	}
	
}
