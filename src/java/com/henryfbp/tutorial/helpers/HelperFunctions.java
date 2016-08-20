package com.henryfbp.tutorial.helpers;

import java.util.ArrayList;
import java.util.Random;
import java.util.concurrent.Callable;

import scala.Function;

public class HelperFunctions
{
	public static double distance(int p1x, int p1y, int p1z, int p2x, int p2y,int p2z)
	{
		return Math.sqrt(
				Math.pow((p2x-p1x),2) + Math.pow((p2y-p1y),2) + Math.pow((p2z-p1z),2)
				);
	}
	
	public static ArrayList<Integer[]> generateOffsetSphere(int radius, double allowance)
	{
		ArrayList<Integer[]> ret = new ArrayList<>();
		
		Integer[] coord = new Integer[3];
		
		for(int x = -(radius + (int) allowance); x < (radius + (int) allowance); x++)
		{
			for(int z = -(radius + (int) allowance); z < (radius + (int) allowance); z++)
			{
				for(int y = -(radius + (int) allowance); y < (radius + (int) allowance); y++)
				{
					if((distance(0, 0, 0, x, y, z) < (radius + allowance)) 
					&& (distance(0, 0, 0, x, y, z) > (radius - allowance)))
					{
						coord[0] = x;
						coord[1] = y;
						coord[2] = z;
						ret.add(coord);
						coord = new Integer[3];
					}
				}
			}
		}
		return ret;
	}
	
	public static ArrayList<Integer[]> generateOffsetSphereEigth(int radius, double allowance)
	//generates one quadrant. x,y,z start points are (0 - allowance) 'stead of negative radius.
	{
		ArrayList<Integer[]> ret = new ArrayList<>();
		
		Integer[] coord = new Integer[3];
		
		for(int x = -((int)allowance); x <  (radius + (int) allowance); x++)
		{
			for(int z = -((int)allowance); z < (radius + (int) allowance); z++)
			{
				for(int y = -((int)allowance); y < (radius + (int) allowance); y++)
				{
					if((distance(0, 0, 0, x, y, z) < (radius + allowance)) 
					&& (distance(0, 0, 0, x, y, z) > (radius - allowance)))
					{
						coord[0] = x;
						coord[1] = y;
						coord[2] = z;
						ret.add(coord);
						coord = new Integer[3];
					}
				}
			}
		}
		return ret;
	}
	
}
