package com.demo;

import java.text.ParseException;
import java.util.Scanner;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

import interfaces.WashingMachineOperation;


public class sample implements WashingMachineOperation
{
	private static Scanner sc;
	int seconds=72;
	int secondss=74;
	int i=0;
	
	private void showMachines() {
		System.out.println("Choose your machine \n Press 1 for LG(6.5 kg) \n Press 2 for Whirpool(7 kg)");
		sc=getinstance();
		String mID=sc.nextLine();
		System.out.print(""+mID);
		start(mID);
	}
	public static void main(String[] agrs)
	{
		sample sm=new sample();  
		sm.showMachines();		
		
	}
	private static Scanner getinstance()
	{
		return new Scanner(System.in);
	}
	@Override
	public void start(String mID) {
		// TODO Auto-generated method stub
		System.out.print(""+mID);
		if(mID.equals("1"))
		{
			System.out.println("\n\n\n You have selected LG machine \n\n\n Select feature one of the below mentioned\n 1.Cotton and synthetics 2.Wool, Dedicates and Handwash" );
			sc=getinstance();
			System.out.print("You have choosen "+sc.nextLine()+"features");
			startTimer();
		}
		else if(mID.equals("2"))
		{
			System.out.println("\n You have selected Samsung machine");
		}
		else
		{
			System.out.println("\n Invalid machine and Please try again");
			showMachines();
		}
		
	}
	private void startTimer()
	{
		Timer tt=new Timer();
		tt.schedule(new TimerTask() {
			
			@Override
			public void run() {
				// TODO Auto-generated method stub
				i++;
				if(i%seconds==0)
				{
					System.out.print("Your washing machine is off");
					tt.cancel();
					tt.purge();
				}
				else
				{
					//System.out.print("\nTime left :"+(seconds-(i%seconds)));
					//long minutes = TimeUnit.MILLISECONDS.toMinutes((seconds-i)*1000);
			        // long seconds = (milliseconds / 1000);
			        //long second = TimeUnit.MILLISECONDS.toSeconds((seconds-i)*1000);
			        
                    //System.out.println("Remaining time:"+minutes+":"+second);
					/*
					 * System.out.format("%d Milliseconds = %d minutes\n", i*1000, minutes );
					 * System.out.println("Or"); System.out.format("%d Milliseconds = %d seconds",
					 * i*1000, seconds );
					 */
			        try {
						showRemainingTime(((seconds-i)*1000));
					} catch (ParseException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
		}, 0,1000);
		
	}
	public static void showRemainingTime(long millis) throws ParseException {
        //long millis = 3600000;
        String hms = String.format("%02d:%02d:%02d", TimeUnit.MILLISECONDS.toHours(millis),
                TimeUnit.MILLISECONDS.toMinutes(millis) - TimeUnit.HOURS.toMinutes(TimeUnit.MILLISECONDS.toHours(millis)),
                TimeUnit.MILLISECONDS.toSeconds(millis) - TimeUnit.MINUTES.toSeconds(TimeUnit.MILLISECONDS.toMinutes(millis)));
        System.out.println("Remaining Time:"+hms);
    }
	@Override
	public void pause() {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void stop() {
		// TODO Auto-generated method stub
		
	}

}
