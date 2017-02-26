package com.henryfbp.hfbpOrbMod.lib;

import java.util.ArrayList;
import java.util.Random;
import java.util.concurrent.Callable;
import java.util.stream.Collectors;

public class HelperFunctions
{
	
	
	public static double distance(int p1x, int p1y, int p1z, int p2x, int p2y,int p2z)
	{
		return Math.sqrt(
				Math.pow((p2x-p1x),2) + Math.pow((p2y-p1y),2) + Math.pow((p2z-p1z),2)
				);
	}
	
	public static ArrayList<Integer[]> generateOffsetSphereEigth(int radius, double allowance)
	//generates one octant. x,y,z start points are (0 - allowance) 'stead of negative radius.
	{
		ArrayList<Integer[]> ret = new ArrayList<>();
		
		Integer[] coord = new Integer[3];
		
		for(int x = -((int)allowance); x <  (radius + (int) allowance); x++)
		{
			for(int z = -((int)allowance); z < (radius + (int) allowance); z++)
			{
				for(int y = -((int)allowance); y < (radius + (int) allowance); y++)
				{
					if((distance(0, 0, 0, x, y, z) < (radius + allowance)) //if before outer shell
					&& (distance(0, 0, 0, x, y, z) > (radius - allowance)))//if before inner shell
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
	
	public static ArrayList<Integer[]> generateOffsetSphere(int radius, double allowance)
	{
		ArrayList<Integer[]> quad = generateOffsetSphereEigth(radius, allowance);//+++ octant, make 7 others pls.
		
		ArrayList<Integer[]> ret = new ArrayList<>();
		
		Integer[] tempAdd = new Integer[3];
		
		for(int xM=-1; xM<3; xM+=2)
		{//xM is -1, 1, STOP
			for(int yM=-1; yM<3; yM+=2)
			{//yM is -1, 1, STOP
				for(int zM=-1; zM<3; zM+=2)
				{//zM is -1, 1, STOP
					for(int i=0; i<quad.size(); i++)
					{
						tempAdd[0] = quad.get(i)[0]*xM; //set x, apply modifier
						tempAdd[1] = quad.get(i)[1]*yM; //set y, apply modifier
						tempAdd[2] = quad.get(i)[2]*zM; //set z, apply modifier
						
						ret.add(tempAdd);
						
						tempAdd = new Integer[3];
					}
				}
			}
		}
		
		ret = (ArrayList<Integer[]>) ret.stream().distinct().collect(Collectors.toList()); //tl;dr make dupes go bye bye
		
		return ret;
	}
	
}
