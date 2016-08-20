package com.henryfbp.hfbpOrbMod.world;

import java.util.ArrayList;
import java.util.Random;

import com.henryfbp.hfbpOrbMod.blocks.ModBlockMultiOre;
import com.henryfbp.hfbpOrbMod.blocks.ModBlocks;
import com.henryfbp.hfbpOrbMod.lib.HelperFunctions;

import cpw.mods.fml.common.IWorldGenerator;
import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.world.World;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraft.world.gen.feature.WorldGenMinable;
import net.minecraft.world.gen.feature.WorldGenerator;

public class ModWorldGen implements IWorldGenerator
{
	private WorldGenerator gen_tutorial_ore; //Generates tut ore, in overworld.
	private WorldGenerator gen_multi_ore;		//generates multi ore
	private WorldGenerator gen_cobblestone; //test
	
	public ModWorldGen()
	{
		this.gen_tutorial_ore = new WorldGenMinable(ModBlocks.tutorial_ore, 8);
		this.gen_multi_ore = new WorldGenMinable(ModBlocks.tutorial_multi_ore, 4);
		this.gen_cobblestone = new WorldGenMinable(Blocks.cobblestone, 16, Blocks.end_stone);
	}
	
	private void runGenerator(WorldGenerator generator, World world, Random random, int chunkX, int chunkZ, int chancesToSpawn, int minHeight, int maxHeight)
	{
		if (minHeight < 0 || maxHeight > 256 || minHeight > maxHeight)
			throw new IllegalArgumentException("Illegal height args for WorldGenerator");
		
		int heightDiff = maxHeight - minHeight + 1;
		
		for(int i = 0; i < chancesToSpawn; i++)
		{
			int x = chunkX * 16 + random.nextInt(16);
			int y = minHeight + random.nextInt(heightDiff);
			int z = chunkZ * 16 + random.nextInt(16);
			generator.generate(world, random, x, y, z);
		}
	}
	
	private void runSphereGenerator(Block block, World world, Random random, int radius, double radiusAllowance, int chunkX, int chunkZ, int chancesToSpawn, int minHeight, int maxHeight)
	{
		if(minHeight < 0 || maxHeight > 256 || minHeight > maxHeight)
			throw new IllegalArgumentException("Illegal height args for SphereGenerator");
		
		int heightDiff = maxHeight - minHeight + 1;
		
		for(int i=0; i < chancesToSpawn; i++)
		{
			
			int x = chunkX * 16 + random.nextInt(16);
			int y = minHeight + random.nextInt(heightDiff);
			int z = chunkZ * 16 + random.nextInt(16);
			
			ArrayList<Integer[]> sphereOffsets = HelperFunctions.generateOffsetSphere(radius, radiusAllowance);
			
			world.setBlock(x, y, z, Blocks.obsidian); //for testing purposes
			
			for(int j = 0; j < sphereOffsets.size(); j++)
			{
				world.setBlock(sphereOffsets.get(j)[0]+x, sphereOffsets.get(j)[1]+y, sphereOffsets.get(j)[2]+z, block); //sets blocks into offsets from an (	x,y,z)
			}
			
		}
		
	}
	
	@Override
	public void generate(Random random, int chunkX, int chunkZ, World world, IChunkProvider chunkGenerator, IChunkProvider chunkProvider)
	{
		switch (world.provider.dimensionId)
		{
		case 0: //Overworld
			this.runGenerator(this.gen_tutorial_ore, world, random, chunkX, chunkZ, 20, 0, 64);
			this.runGenerator(this.gen_multi_ore, world, random, chunkX, chunkZ, 10, 0, 32);
			
			if(random.nextInt(100) <= 10)
			{
				this.runSphereGenerator(ModBlocks.tutorialBlock, world, random, 5, 1.2, chunkX, chunkZ, 1, 100, 100);
			}
			
			break;
		
		case -1: //Nether
			
			break;
			
		case 1: //End
			
			break;
		}
	}
}
