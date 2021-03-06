package thaumicdyes.common;

import java.util.ArrayList;
import java.util.HashMap;

import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagByte;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagInt;
import net.minecraft.util.ResourceLocation;
import thaumcraft.api.ItemApi;
import thaumcraft.api.ThaumcraftApi;
import thaumcraft.api.aspects.Aspect;
import thaumcraft.api.aspects.AspectList;
import thaumcraft.api.crafting.CrucibleRecipe;
import thaumcraft.api.crafting.InfusionRecipe;
import thaumcraft.api.crafting.ShapedArcaneRecipe;
import thaumcraft.api.research.ResearchCategories;
import thaumcraft.api.research.ResearchItem;
import thaumcraft.api.research.ResearchPage;
import thaumcraft.common.config.ConfigBlocks;
import thaumcraft.common.config.ConfigItems;
import thaumicdyes.common.items.ItemHandler;

public class ConfigResearch {
   //public static HashMap recipes = new HashMap();
   public static HashMap<String, Object> recipes = new HashMap();

   
   public static void addResearch() {
      ResearchCategories.registerCategory(
    		  "DYES", 
    		  new ResourceLocation("thaumicdyes:textures/gui/r_td2.png"), 
    		  new ResourceLocation("thaumicdyes:textures/gui/r_tdbg.png")
      );
      
      //Copy research nodes
      copy(ResearchCategories.getResearchList("ARTIFICE").research.get("ARMORFORTRESS"),"TD.ARMORFORTRESS","DYES",7,-2	).setConcealed().setHidden().registerResearchItem();
      //copy(ResearchCategories.getResearchList("ELDRITCH").research.get("VOIDMETAL"),"TD.VOIDMETAL","DYES",0,-1).setConcealed().setHidden().registerResearchItem();
      
      researchCrimson();
      researchCrimsonDyed();
      researchEldritch();
      researchIron();
      researchThaumium();
      researchVoid();
      researchBoots();
      researchRunic();
      
   }
      
      
   //TODO Crimson expansion
   public static void researchCrimson() {
	   
	/////////////
	 //BOOK
	 
	 ShapedArcaneRecipe recipeFabricResource = ThaumcraftApi.addArcaneCraftingRecipe("TD.CRIMSON",
			   new ItemStack(ItemHandler.itemFabricResource), 
			   (new AspectList()).add(Aspect.ENTROPY, 2).add(Aspect.ORDER, 5), 
			   new Object[]{
					"R",
					"F",
					"V",
					'R',new ItemStack(Items.dye, 1, 1),
					'F',new ItemStack(ConfigItems.itemResource, 1, 7),
					'V',new ItemStack(ConfigItems.itemResource, 1, 17)
					});
	
	ShapedArcaneRecipe recipeCrimsonBoots = ThaumcraftApi.addArcaneCraftingRecipe("TD.CRIMSON",
			   new ItemStack(ConfigItems.itemBootsCultist), 
			   (new AspectList()).add(Aspect.EARTH, 10).add(Aspect.ENTROPY, 10).add(Aspect.ORDER, 20), 
			   new Object[]{
					"R R",
					"R R",
					'R',new ItemStack(ItemHandler.itemFabricResource)
					});
	 
	 new ResearchItem("TD.CRIMSON", "DYES", 
			  (new AspectList()).add(Aspect.ELDRITCH, 4).add(Aspect.ARMOR, 4).add(Aspect.MAGIC, 4),
			  -2, -1, 2, 
			  new ItemStack(ConfigItems.itemEldritchObject, 1, 1))
			  .setPages(new ResearchPage[]{
					  new ResearchPage("tc.research_page.TD.crimson.1"),
					  new ResearchPage("tc.research_page.TD.crimson.2"),
					  new ResearchPage("tc.research_page.TD.crimson.3"),
					  new ResearchPage(recipeFabricResource),
					  new ResearchPage(recipeCrimsonBoots)
					  })
			  .setParents("CRIMSON", "ENCHFABRIC")
			  .setLost()
			  .setSpecial()
			  .setRound()
			  .setItemTriggers(new ItemStack(ConfigItems.itemEldritchObject, 1, 1))
			  //.setEntityTriggers("Thaumcraft.CultistLeader")
			  .registerResearchItem();
	 ThaumcraftApi.addWarpToResearch("TD.CRIMSON", 1);
	 
	 
	 /////////////
	 //BANNER
	 
	 ItemStack banner = new ItemStack(ConfigBlocks.blockWoodenDevice,1,8);
	 		//banner.stackTagCompound = new NBTTagCompound();
	 		//banner.stackTagCompound.setByte("color", (byte) -1);
		
	 ItemStack bannerR = new ItemStack(ConfigBlocks.blockWoodenDevice,1,8);
			bannerR.stackTagCompound = new NBTTagCompound();
			bannerR.stackTagCompound.setByte("color", (byte) 14);
	
	 ShapedArcaneRecipe recipeCrimsonBanner = ThaumcraftApi.addArcaneCraftingRecipe("TD.CRIMSONBANNER",
			  banner, 
			  (new AspectList()).add(Aspect.ORDER, 5), 
			  new Object[]{
				"g g",
				"gBg",
				"g g",
				'B',bannerR,
				'g',new ItemStack(Items.gold_nugget)
				});
	
	 new ResearchItem("TD.CRIMSONBANNER", "DYES", 
			  (new AspectList()).add(Aspect.CLOTH, 2).add(Aspect.SENSES, 1),
			  -1, -1, 2, 
			  new ItemStack(ConfigBlocks.blockWoodenDevice, 1, 8))
			  .setPages(new ResearchPage[]{
					  new ResearchPage("tc.research_page.TD.crimsonBanner.1"),
					  new ResearchPage(recipeCrimsonBanner)
					  })
			  .setParents("TD.CRIMSON", "BANNERS")
			  .setConcealed()
			  .setSecondary()
			  //.setEntityTriggers("Thaumcraft.CultistLeader")
			  .registerResearchItem();
		
	 
	 
	 /////////////
	 //CLERIC
	 
	 ShapedArcaneRecipe recipeClericHood = ThaumcraftApi.addArcaneCraftingRecipe("TD.CRIMSONCLERIC",
			   new ItemStack(ConfigItems.itemHelmetCultistRobe), 
			   (new AspectList()).add(Aspect.WATER, 10).add(Aspect.ENTROPY, 10).add(Aspect.ORDER, 20), 
			   new Object[]{
					"RRR",
					"R R",
					"   ",
					'R',new ItemStack(ItemHandler.itemFabricResource)
					});
	 
	 ShapedArcaneRecipe recipeClericChest = ThaumcraftApi.addArcaneCraftingRecipe("TD.CRIMSONCLERIC",
			   new ItemStack(ConfigItems.itemChestCultistRobe), 
			   (new AspectList()).add(Aspect.WATER, 10).add(Aspect.ENTROPY, 10).add(Aspect.ORDER, 20), 
			   new Object[]{
					"R R",
					"RRR",
					"RGR",
					'R',new ItemStack(ItemHandler.itemFabricResource),
					'G',new ItemStack(Items.gold_ingot)
					});
	 
	 ShapedArcaneRecipe recipeClericLegs = ThaumcraftApi.addArcaneCraftingRecipe("TD.CRIMSONCLERIC",
			   new ItemStack(ConfigItems.itemLegsCultistRobe), 
			   (new AspectList()).add(Aspect.WATER, 10).add(Aspect.ENTROPY, 10).add(Aspect.ORDER, 20), 
			   new Object[]{
					"RGR",
					"RIR",
					"R R",
					'R',new ItemStack(ItemHandler.itemFabricResource),
					'I',new ItemStack(Items.iron_ingot),
					'G',new ItemStack(Items.gold_ingot)
					});
	
	
	new ResearchItem("TD.CRIMSONCLERIC", "DYES", 
			  (new AspectList()).add(Aspect.ELDRITCH, 4).add(Aspect.ARMOR, 4).add(Aspect.CLOTH, 4),
			  -5, -2, 1, 
			  new ItemStack(ConfigItems.itemHelmetCultistRobe))
			  .setPages(new ResearchPage[]{
					  new ResearchPage("tc.research_page.TD.crimsonCleric.1"),
					  new ResearchPage(recipeClericHood),
					  new ResearchPage(recipeClericChest),
					  new ResearchPage(recipeClericLegs)
					  })
			  .setParents("TD.CRIMSON")
			  .setSecondary()
			  .setConcealed()
			  .setLost()
			  .setEntityTriggers("Thaumcraft.CultistCleric")
			  .registerResearchItem();

	/////////////
	//KNIGHT
	     
	ShapedArcaneRecipe recipeKnightHelm = ThaumcraftApi.addArcaneCraftingRecipe("TD.CRIMSONKNIGHT",
			   new ItemStack(ConfigItems.itemHelmetCultistPlate), 
			   (new AspectList()).add(Aspect.FIRE, 10).add(Aspect.ENTROPY, 10).add(Aspect.ORDER, 20), 
			   new Object[]{
					"III",
					"IGI",
					" R ",
					'R',new ItemStack(ItemHandler.itemFabricResource),
					'I',new ItemStack(Items.iron_ingot),
					'G',new ItemStack(Items.gold_ingot)
					});
	
	ShapedArcaneRecipe recipeKnightChest = ThaumcraftApi.addArcaneCraftingRecipe("TD.CRIMSONKNIGHT",
			   new ItemStack(ConfigItems.itemChestCultistPlate), 
			   (new AspectList()).add(Aspect.FIRE, 10).add(Aspect.ENTROPY, 10).add(Aspect.ORDER, 20), 
			   new Object[]{
					"I I",
					"IRI",
					"IRI",
					'R',new ItemStack(ItemHandler.itemFabricResource),
					'I',new ItemStack(Items.iron_ingot)
					});
	
	ShapedArcaneRecipe recipeKnightLegs = ThaumcraftApi.addArcaneCraftingRecipe("TD.CRIMSONKNIGHT",
			   new ItemStack(ConfigItems.itemLegsCultistPlate), 
			   (new AspectList()).add(Aspect.FIRE, 10).add(Aspect.ENTROPY, 10).add(Aspect.ORDER, 20), 
			   new Object[]{
					"IGI",
					"IRI",
					"I I",
					'R',new ItemStack(ItemHandler.itemFabricResource),
					'I',new ItemStack(Items.iron_ingot),
					'G',new ItemStack(Items.gold_ingot)
					});
	
	
	new ResearchItem("TD.CRIMSONKNIGHT", "DYES", 
		  (new AspectList()).add(Aspect.ELDRITCH, 4).add(Aspect.ARMOR, 4).add(Aspect.METAL, 4),
		  -5, -1, 1, 
		  new ItemStack(ConfigItems.itemHelmetCultistPlate))
		  .setPages(new ResearchPage[]{
				  new ResearchPage("tc.research_page.TD.crimsonKnight.1"),
				  new ResearchPage(recipeKnightHelm),
				  new ResearchPage(recipeKnightChest),
				  new ResearchPage(recipeKnightLegs)
				  })
		  .setParents("TD.CRIMSON")
		  .setSecondary()
		  .setConcealed()
		  .setLost()
		  .setEntityTriggers("Thaumcraft.CultistKnight")
		  .registerResearchItem();
	
	
	/////////////
	//PRAETOR
	
	InfusionRecipe recipeLeaderHelm = ThaumcraftApi.addInfusionCraftingRecipe("TD.CRIMSONLEADER",
			   new ItemStack(ConfigItems.itemHelmetCultistLeaderPlate), 3, 
			   (new AspectList()).add(Aspect.ARMOR, 8).add(Aspect.ELDRITCH, 8).add(Aspect.METAL, 8), 
			   new ItemStack(ConfigItems.itemHelmetCultistPlate), 
			   new ItemStack[]{
		   			new ItemStack(Items.gold_ingot),
		   			new ItemStack(Items.iron_ingot),
		   			new ItemStack(Items.iron_ingot),
		   			new ItemStack(ItemHandler.itemFabricResource),
		   			new ItemStack(Items.iron_ingot),
		   			new ItemStack(Items.iron_ingot)
		   			});
	   
	   InfusionRecipe recipeLeaderChest = ThaumcraftApi.addInfusionCraftingRecipe("TD.CRIMSONLEADER", 
			   new ItemStack(ConfigItems.itemChestCultistLeaderPlate), 3, 
			   (new AspectList()).add(Aspect.ARMOR, 12).add(Aspect.ELDRITCH, 12).add(Aspect.METAL, 8),  
			   new ItemStack(ConfigItems.itemChestCultistPlate), 
			   new ItemStack[]{
				    new ItemStack(Items.gold_ingot),
		   			new ItemStack(Items.iron_ingot),
		   			new ItemStack(ItemHandler.itemFabricResource),
		   			new ItemStack(Items.iron_ingot),
		   			new ItemStack(ItemHandler.itemFabricResource),
		   			new ItemStack(Items.iron_ingot)
				   });
			   
	   InfusionRecipe recipeLeaderLegs = ThaumcraftApi.addInfusionCraftingRecipe("TD.CRIMSONLEADER",
			   new ItemStack(ConfigItems.itemLegsCultistLeaderPlate), 3, 
			   (new AspectList()).add(Aspect.ARMOR, 10).add(Aspect.ELDRITCH, 10).add(Aspect.METAL, 8),  
			   new ItemStack(ConfigItems.itemLegsCultistPlate), 
			   new ItemStack[]{
				    new ItemStack(Items.gold_ingot),
		   			new ItemStack(Items.iron_ingot),
		   			new ItemStack(ItemHandler.itemFabricResource),
		   			new ItemStack(Items.iron_ingot),
		   			new ItemStack(ItemHandler.itemFabricResource),
		   			new ItemStack(Items.iron_ingot)
				   });
	
	new ResearchItem("TD.CRIMSONLEADER", "DYES", 
	   		  (new AspectList()).add(Aspect.ELDRITCH, 4).add(Aspect.ARMOR, 4).add(Aspect.METAL, 4).add(Aspect.MAGIC, 4),
	   		  -3, 2, 1, 
	   		  new ItemStack(ConfigItems.itemHelmetCultistLeaderPlate))
	   		  .setPages(new ResearchPage[]{
	   				  new ResearchPage("tc.research_page.TD.crimsonLeader.1"),
	   				  new ResearchPage(recipeLeaderHelm),
	   				  new ResearchPage(recipeLeaderChest),
	   				  new ResearchPage(recipeLeaderLegs)
	   				  })
	   		  .setParents("TD.CRIMSON", "PRIMPEARL")
	   		  .setParentsHidden("TD.CRIMSONCLERIC", "TD.CRIMSONKNIGHT", "TD.CRIMSONRANGER", "TD.CRIMSONARCHER")
	   		  .setConcealed()
	   		  //.setLost()
	   		  //.setEntityTriggers("Thaumcraft.CultistCleric")
	   		  .registerResearchItem();
	
	/////////////
	//PALADIN
	
	ShapedArcaneRecipe recipePaladinHelm = ThaumcraftApi.addArcaneCraftingRecipe("TD.PALADIN",
			   new ItemStack(ItemHandler.itemHelmetCultistPaladin), 
			   (new AspectList()).add(Aspect.FIRE, 20).add(Aspect.ENTROPY, 10).add(Aspect.ORDER, 25), 
			   new Object[]{
					" g ",
					"GHG",
					" g ",
					'H',new ItemStack(ConfigItems.itemHelmetCultistLeaderPlate),
					'g',new ItemStack(Items.gold_nugget),
					'G',new ItemStack(Items.gold_ingot)
					});
	
	new ResearchItem("TD.PALADIN", "DYES", 
	   		  (new AspectList()).add(Aspect.ELDRITCH, 4).add(Aspect.ARMOR, 4).add(Aspect.METAL, 4),
	   		  -3, 4, 1, 
	   		  new ItemStack(ItemHandler.itemHelmetCultistPaladin))
	   		  .setPages(new ResearchPage[]{
	   				  new ResearchPage("tc.research_page.TD.paladin.1"),
	   				  new ResearchPage(recipePaladinHelm)
	   				  })
	   		  .setParents("TD.CRIMSONLEADER")
	   		  .setSecondary()
	   		  .setConcealed()
	   		  .setHidden()
	   		  //.setLost()
	   		  //.setEntityTriggers("Thaumcraft.CultistCleric")
	   		  .registerResearchItem();
	
	
	
	/////////////
	//RANGER
	ShapedArcaneRecipe recipeRangerHelm = ThaumcraftApi.addArcaneCraftingRecipe("TD.CRIMSONRANGER",
			   new ItemStack(ItemHandler.itemHelmetCultistRanger), 
			   (new AspectList()).add(Aspect.EARTH, 10).add(Aspect.ENTROPY, 10).add(Aspect.ORDER, 20), 
			   new Object[]{
					" I ",
					"IHI",
					" R ",
					'R',new ItemStack(ItemHandler.itemFabricResource),
					'H',new ItemStack(Items.iron_helmet),
					'I',new ItemStack(Items.iron_ingot)
					});
     
     ShapedArcaneRecipe recipeRangerChest = ThaumcraftApi.addArcaneCraftingRecipe("TD.CRIMSONRANGER",
			   new ItemStack(ItemHandler.itemChestCultistRanger), 
			   (new AspectList()).add(Aspect.EARTH, 10).add(Aspect.ENTROPY, 10).add(Aspect.ORDER, 20), 
			   new Object[]{
					"c",
					"C",
					"R",
					'C',new ItemStack(ConfigItems.itemChestCultistRobe),
					'c',new ItemStack(Blocks.chest),
					'R',new ItemStack(ItemHandler.itemFabricResource)
					});
     
     ShapedArcaneRecipe recipeRangerLegs = ThaumcraftApi.addArcaneCraftingRecipe("TD.CRIMSONRANGER",
			   new ItemStack(ItemHandler.itemLegsCultistRanger), 
			   (new AspectList()).add(Aspect.EARTH, 10).add(Aspect.ENTROPY, 10).add(Aspect.ORDER, 20), 
			   new Object[]{
					"sLs",
					"bBb",
					'B',new ItemStack(Items.blaze_powder),
					'L',new ItemStack(ConfigItems.itemLegsCultistRobe),
					's',new ItemStack(Items.string),
					'b',new ItemStack(Items.glass_bottle)
					});
    

    new ResearchItem("TD.CRIMSONRANGER", "DYES", 
  		  (new AspectList()).add(Aspect.ELDRITCH, 4).add(Aspect.ARMOR, 4).add(Aspect.CLOTH, 4),
  		  -4, -3, 1, 
  		  new ItemStack(ItemHandler.itemChestCultistRanger))
  		  .setPages(new ResearchPage[]{
  				  new ResearchPage("tc.research_page.TD.crimsonRanger.1"),
  				  new ResearchPage(recipeRangerHelm),
  				  new ResearchPage(recipeRangerChest),
  				  new ResearchPage(recipeRangerLegs)
  				  })
  		  .setParents("TD.CRIMSON")
  		  .setParentsHidden("TD.CRIMSONCLERIC")
  		  .setSecondary()
  		  .setConcealed()
  		  //.setLost()
  		  //.setEntityTriggers("Thaumcraft.CultistCleric")
  		  .registerResearchItem();
	
	
	/////////////
	//ARCHER
    ShapedArcaneRecipe recipeArcherHelm = ThaumcraftApi.addArcaneCraftingRecipe("TD.CRIMSONARCHER",
			   new ItemStack(ItemHandler.itemHelmetCultistArcher), 
			   (new AspectList()).add(Aspect.AIR, 10).add(Aspect.ENTROPY, 10).add(Aspect.ORDER, 20), 
			   new Object[]{
					"IHI",
					" g ",
					'g',new ItemStack(Items.gold_ingot),
					'H',new ItemStack(Items.iron_helmet),
					'I',new ItemStack(Items.iron_ingot)
					});
     
     ShapedArcaneRecipe recipeArcherChest = ThaumcraftApi.addArcaneCraftingRecipe("TD.CRIMSONARCHER",
			   new ItemStack(ItemHandler.itemChestCultistArcher), 
			   (new AspectList()).add(Aspect.AIR, 10).add(Aspect.ENTROPY, 10).add(Aspect.ORDER, 20), 
			   new Object[]{
					"I I",
					"RIR",
					"IlI",
					'R',new ItemStack(ItemHandler.itemFabricResource),
					'C',new ItemStack(ConfigItems.itemChestCultistRobe),
					'I',new ItemStack(Items.iron_ingot),
					'l',new ItemStack(Items.leather)
					});
     
     ShapedArcaneRecipe recipeArcherLegs = ThaumcraftApi.addArcaneCraftingRecipe("TD.CRIMSONARCHER",
			   new ItemStack(ItemHandler.itemLegsCultistArcher), 
			   (new AspectList()).add(Aspect.AIR, 10).add(Aspect.ENTROPY, 10).add(Aspect.ORDER, 20), 
			   new Object[]{
					"ILI",
					" R ",
					'R',new ItemStack(ItemHandler.itemFabricResource),
					'L',new ItemStack(ConfigItems.itemLegsCultistPlate),
					'I',new ItemStack(Items.iron_ingot)
					});
    

    new ResearchItem("TD.CRIMSONARCHER", "DYES", 
  		  (new AspectList()).add(Aspect.ELDRITCH, 4).add(Aspect.ARMOR, 4).add(Aspect.CLOTH, 4),
  		  -5, 0, 1, 
  		  new ItemStack(ItemHandler.itemHelmetCultistArcher))
  		  .setPages(new ResearchPage[]{
  				  new ResearchPage("tc.research_page.TD.crimsonArcher.1"),
  				  new ResearchPage(recipeArcherHelm),
  				  new ResearchPage(recipeArcherChest),
  				  new ResearchPage(recipeArcherLegs)
  				  })
  		  .setParents("TD.CRIMSON")
  		  .setParentsHidden("TD.CRIMSONKNIGHT")
  		  .setSecondary()
  		  .setConcealed()
  		  //.setLost()
  		  //.setEntityTriggers("Thaumcraft.CultistCleric")
  		  .registerResearchItem();
	   
   }
	   
   //TODO Dyed crimson	
   public static void researchCrimsonDyed() {
	   
			/////////////
			//Cleric
		  InfusionRecipe recipeRobeHelm = ThaumcraftApi.addInfusionCraftingRecipe("TD.DYEDROBE",
				   new ItemStack(ItemHandler.itemHelmetCultistRobeDyed), 3, 
				   (new AspectList()).add(Aspect.ARMOR, 8).add(Aspect.MAGIC, 16).add(Aspect.CLOTH, 16).add(Aspect.METAL, 8), 
				   ItemApi.getItem("itemHelmetCultistRobe", 0), 
				   new ItemStack[]{
			   			ItemApi.getItem("itemResource", 14),
			   			ItemApi.getItem("itemResource", 7), 
			   			ItemApi.getItem("itemResource", 2), 
			   			ItemApi.getItem("itemResource", 7)});
		  
		  InfusionRecipe recipeRobeChest = ThaumcraftApi.addInfusionCraftingRecipe("TD.DYEDROBE", 
				   new ItemStack(ItemHandler.itemChestCultistRobeDyed), 3, 
				   (new AspectList()).add(Aspect.ARMOR, 12).add(Aspect.MAGIC, 24).add(Aspect.CLOTH, 24).add(Aspect.METAL, 8),  
				   ItemApi.getItem("itemChestCultistRobe", 0), 
				   new ItemStack[]{
					   ItemApi.getItem("itemResource", 14),
					   ItemApi.getItem("itemResource", 7),
					   ItemApi.getItem("itemResource", 2),
					   ItemApi.getItem("itemResource", 7)});
				   
		  InfusionRecipe recipeRobeLegs = ThaumcraftApi.addInfusionCraftingRecipe("TD.DYEDROBE",
				   new ItemStack(ItemHandler.itemLegsCultistRobeDyed), 3, 
				   (new AspectList()).add(Aspect.ARMOR, 10).add(Aspect.MAGIC, 20).add(Aspect.CLOTH, 20).add(Aspect.METAL, 8),  
				   ItemApi.getItem("itemLegsCultistRobe", 0), 
				   new ItemStack[]{
					   ItemApi.getItem("itemResource", 14), 
					   ItemApi.getItem("itemResource", 7), 
					   ItemApi.getItem("itemResource", 2), 
					   ItemApi.getItem("itemResource", 7)});
		
		 new ResearchItem("TD.DYEDROBE", "DYES", 
				  (new AspectList()).add(Aspect.CLOTH, 4).add(Aspect.ARMOR, 4).add(Aspect.MAGIC, 4),
				  -7, -3, 2, 
				  new ItemStack(ItemHandler.itemHelmetCultistRobeDyed, 0))
				  .setPages(new ResearchPage[]{
						  new ResearchPage("tc.research_page.TD.robe.1"), 
						  new ResearchPage("tc.research_page.TD.robe.2"), 
						  new ResearchPage(recipeRobeHelm), 
						  new ResearchPage(recipeRobeChest), 
						  new ResearchPage(recipeRobeLegs)})
				  //.setParents("TD.THAUMIUM", "ENCHFABRIC") //WIP
				  .setParents("TD.CRIMSONCLERIC")
				  .setConcealed()
				  .registerResearchItem();
		 
		 
			/////////////
			//KNGIHT
		 InfusionRecipe recipeKniHelm = ThaumcraftApi.addInfusionCraftingRecipe("TD.DYEDKNIGHT",
				   new ItemStack(ItemHandler.itemHelmetCultistKnightDyed), 3, 
				   (new AspectList()).add(Aspect.ARMOR, 16).add(Aspect.MAGIC, 16).add(Aspect.CLOTH, 8).add(Aspect.METAL, 16),
				   ItemApi.getItem("itemHelmetCultistPlate", 0), 
				   new ItemStack[]{
			   			ItemApi.getItem("itemResource", 7), 
			   			ItemApi.getItem("itemResource", 2), 
			   			ItemApi.getItem("itemResource", 7), 
			   			ItemApi.getItem("itemResource", 2)});
		 	
		 InfusionRecipe recipeKniChest = ThaumcraftApi.addInfusionCraftingRecipe("TD.DYEDKNIGHT",
				   new ItemStack(ItemHandler.itemChestCultistKnightDyed), 3, 
				   (new AspectList()).add(Aspect.ARMOR, 24).add(Aspect.MAGIC, 24).add(Aspect.CLOTH, 8).add(Aspect.METAL, 16),
				   ItemApi.getItem("itemChestCultistPlate", 0), 
				   new ItemStack[]{
			   			ItemApi.getItem("itemResource", 7), 
			   			ItemApi.getItem("itemResource", 2), 
			   			ItemApi.getItem("itemResource", 7), 
			   			ItemApi.getItem("itemResource", 2)});
		   
		 InfusionRecipe recipeKniLegs = ThaumcraftApi.addInfusionCraftingRecipe("TD.DYEDKNIGHT",
				   new ItemStack(ItemHandler.itemLegsCultistKnightDyed), 3, 
				   (new AspectList()).add(Aspect.ARMOR, 20).add(Aspect.MAGIC, 20).add(Aspect.CLOTH, 8).add(Aspect.METAL, 16),
				   ItemApi.getItem("itemLegsCultistPlate", 0), 
				   new ItemStack[]{
			   			ItemApi.getItem("itemResource", 7), 
			   			ItemApi.getItem("itemResource", 2), 
			   			ItemApi.getItem("itemResource", 7), 
			   			ItemApi.getItem("itemResource", 2)});
		 
		 new ResearchItem("TD.DYEDKNIGHT", "DYES", 
				  (new AspectList()).add(Aspect.CLOTH, 4).add(Aspect.ARMOR, 4).add(Aspect.MAGIC, 4),
				  -7, -1, 2, 
				  ItemApi.getItem("itemHelmetCultistPlate", 0))
				  .setPages(new ResearchPage[]{
						  new ResearchPage("tc.research_page.TD.knight.1"), 
						  new ResearchPage(recipeKniHelm), 
						  new ResearchPage(recipeKniChest), 
						  new ResearchPage(recipeKniLegs)})
				  //.setParents("TD.THAUMIUM", "ENCHFABRIC") //WIP
				  .setParents("TD.CRIMSONKNIGHT")
				  .setConcealed()
				  .registerResearchItem();
		 
		 
			/////////////
			//PRAETOR
		 InfusionRecipe recipePraeHelm = ThaumcraftApi.addInfusionCraftingRecipe("TD.DYEDPRAETOR", 
				   new ItemStack(ItemHandler.itemHelmetCultistLeaderDyed), 5, 
				   (new AspectList()).add(Aspect.ARMOR, 16).add(Aspect.MAGIC, 16).add(Aspect.CLOTH, 8).add(Aspect.METAL, 16),
				   ItemApi.getItem("itemHelmetCultistLeaderPlate", 0), 
				   new ItemStack[]{
			  			ItemApi.getItem("itemResource", 7), 
			  			ItemApi.getItem("itemResource", 2), 
			  			ItemApi.getItem("itemResource", 7), 
			  			ItemApi.getItem("itemResource", 2)});
		 
		 InfusionRecipe recipePraeChest = ThaumcraftApi.addInfusionCraftingRecipe("TD.DYEDPRAETOR", 
				   new ItemStack(ItemHandler.itemChestCultistLeaderDyed), 5, 
				   (new AspectList()).add(Aspect.ARMOR, 24).add(Aspect.MAGIC, 24).add(Aspect.CLOTH, 8).add(Aspect.METAL, 16), 
				   ItemApi.getItem("itemChestCultistLeaderPlate", 0), 
				   new ItemStack[]{
			  			ItemApi.getItem("itemResource", 7), 
			  			ItemApi.getItem("itemResource", 2), 
			  			ItemApi.getItem("itemResource", 7), 
			  			ItemApi.getItem("itemResource", 2)});
		 
		 InfusionRecipe recipePraeLegs = ThaumcraftApi.addInfusionCraftingRecipe("TD.DYEDPRAETOR", 
				   new ItemStack(ItemHandler.itemLegsCultistLeaderDyed), 5, 
				   (new AspectList()).add(Aspect.ARMOR, 20).add(Aspect.MAGIC, 20).add(Aspect.CLOTH, 8).add(Aspect.METAL, 16), 
				   ItemApi.getItem("itemLegsCultistLeaderPlate", 0), 
				   new ItemStack[]{
			  			ItemApi.getItem("itemResource", 7), 
			  			ItemApi.getItem("itemResource", 2), 
			  			ItemApi.getItem("itemResource", 7), 
			  			ItemApi.getItem("itemResource", 2)});
		
		 
		 new ResearchItem("TD.DYEDPRAETOR", "DYES", 
				  (new AspectList()).add(Aspect.CLOTH, 5).add(Aspect.ARMOR, 5).add(Aspect.MAGIC, 5).add(Aspect.DARKNESS, 5),
				  -5, 3, 3, 
				  ItemApi.getItem("itemHelmetCultistLeaderPlate", 0))
				  .setPages(new ResearchPage[]{
						  new ResearchPage("tc.research_page.TD.praetor.1"), 
						  new ResearchPage(recipePraeHelm), 
						  new ResearchPage(recipePraeChest), 
						  new ResearchPage(recipePraeLegs)})
				  .setParents("TD.CRIMSONLEADER") //change to "DYEDKNIGHT" once implemented
				  .setConcealed()
				  .registerResearchItem();
		 
		 
			/////////////
			//Ranger
		 InfusionRecipe recipeRangerHelmDyed = ThaumcraftApi.addInfusionCraftingRecipe("TD.DYEDRANGER",
				   new ItemStack(ItemHandler.itemHelmetCultistRangerDyed), 3, 
				   (new AspectList()).add(Aspect.ARMOR, 16).add(Aspect.MAGIC, 16).add(Aspect.CLOTH, 8).add(Aspect.METAL, 16),
				   new ItemStack(ItemHandler.itemHelmetCultistRanger),  
				   new ItemStack[]{
			   			ItemApi.getItem("itemResource", 7), 
			   			ItemApi.getItem("itemResource", 2), 
			   			ItemApi.getItem("itemResource", 7), 
			   			ItemApi.getItem("itemResource", 2)});
			
		InfusionRecipe recipeRangerChestDyed = ThaumcraftApi.addInfusionCraftingRecipe("TD.DYEDRANGER",
				   new ItemStack(ItemHandler.itemChestCultistRangerDyed), 3, 
				   (new AspectList()).add(Aspect.ARMOR, 24).add(Aspect.MAGIC, 24).add(Aspect.CLOTH, 8).add(Aspect.METAL, 16),
				   new ItemStack(ItemHandler.itemChestCultistRanger), 
				   new ItemStack[]{
			   			ItemApi.getItem("itemResource", 14), 
			   			ItemApi.getItem("itemResource", 2), 
			   			ItemApi.getItem("itemResource", 7), 
			   			ItemApi.getItem("itemResource", 2)});
		  
		InfusionRecipe recipeRangerLegsDyed = ThaumcraftApi.addInfusionCraftingRecipe("TD.DYEDRANGER",
				   new ItemStack(ItemHandler.itemLegsCultistRangerDyed), 3, 
				   (new AspectList()).add(Aspect.ARMOR, 20).add(Aspect.MAGIC, 20).add(Aspect.CLOTH, 8).add(Aspect.METAL, 16),
				   new ItemStack(ItemHandler.itemLegsCultistRanger),  
				   new ItemStack[]{
			   			ItemApi.getItem("itemResource", 14), 
			   			ItemApi.getItem("itemResource", 2), 
			   			ItemApi.getItem("itemResource", 7), 
			   			ItemApi.getItem("itemResource", 2)});
		  
			InfusionRecipe recipeRangerHelmGoggles = ThaumcraftApi.addInfusionCraftingRecipe("TD.DYEDRANGER", new Object[] { "mask", new NBTTagInt(0) }, 3, 
					  new AspectList().add(Aspect.SENSES, 16).add(Aspect.AURA, 8).add(Aspect.ARMOR, 8), 
					  new ItemStack(ItemHandler.itemHelmetCultistRangerDyed, 1, 32767), 
				      new ItemStack[] { 
						  new ItemStack(Items.slime_ball), 
				    	  new ItemStack(ConfigItems.itemGoggles, 1, 32767) });
			  
			InfusionRecipe recipeRangerHelmPlate = ThaumcraftApi.addInfusionCraftingRecipe("TD.DYEDRANGER", new Object[] { "mask", new NBTTagInt(1) }, 2, 
					  new AspectList().add(Aspect.CRAFT, 8).add(Aspect.ARMOR, 8), 
					  new ItemStack(ItemHandler.itemHelmetCultistRangerDyed, 1, 32767), 
				      new ItemStack[] { 
				    	  new ItemStack(Items.slime_ball), 
				    	  ItemApi.getItem("itemResource", 2) });
		 
		 new ResearchItem("TD.DYEDRANGER", "DYES", 
				  (new AspectList()).add(Aspect.CLOTH, 4).add(Aspect.ARMOR, 4).add(Aspect.MAGIC, 4).add(Aspect.TRAVEL, 4),
				  -5, -5, 2, 
				  new ItemStack(ItemHandler.itemChestCultistRangerDyed))
				  .setPages(new ResearchPage[]{
						  new ResearchPage("tc.research_page.TD.ranger.1"),
						  new ResearchPage(recipeRangerHelmDyed),
						  new ResearchPage(recipeRangerChestDyed),
						  new ResearchPage(recipeRangerLegsDyed),
						  new ResearchPage("tc.research_page.TD.ranger.2"),
						  new ResearchPage(recipeRangerHelmGoggles),
						  new ResearchPage(recipeRangerHelmPlate)
				  			})
				  .setParents("TD.CRIMSONRANGER")
				  .setConcealed()
				  .registerResearchItem();
		 
		 
			/////////////
			//ARCHER
		 
		 InfusionRecipe recipeArcherHelmDyed = ThaumcraftApi.addInfusionCraftingRecipe("TD.DYEDARCHER", 
				   new ItemStack(ItemHandler.itemHelmetCultistArcherDyed), 5, 
				   (new AspectList()).add(Aspect.ARMOR, 16).add(Aspect.MAGIC, 16).add(Aspect.CLOTH, 8).add(Aspect.METAL, 16),
				   new ItemStack(ItemHandler.itemHelmetCultistArcher), 
				   new ItemStack[]{
			  			ItemApi.getItem("itemResource", 7), 
			  			ItemApi.getItem("itemResource", 2), 
			  			ItemApi.getItem("itemResource", 7), 
			  			ItemApi.getItem("itemResource", 2)});
		 
		InfusionRecipe recipeArcherChestDyed = ThaumcraftApi.addInfusionCraftingRecipe("TD.DYEDARCHER", 
				   new ItemStack(ItemHandler.itemChestCultistArcherDyed), 5, 
				   (new AspectList()).add(Aspect.ARMOR, 24).add(Aspect.MAGIC, 24).add(Aspect.CLOTH, 8).add(Aspect.METAL, 16), 
				   new ItemStack(ItemHandler.itemChestCultistArcher), 
				   new ItemStack[]{
			  			ItemApi.getItem("itemResource", 7), 
			  			ItemApi.getItem("itemResource", 2), 
			  			ItemApi.getItem("itemResource", 7), 
			  			ItemApi.getItem("itemResource", 2)});
		 
		InfusionRecipe recipeArcherLegsDyed = ThaumcraftApi.addInfusionCraftingRecipe("TD.DYEDARCHER", 
				   new ItemStack(ItemHandler.itemLegsCultistArcherDyed), 5, 
				   (new AspectList()).add(Aspect.ARMOR, 20).add(Aspect.MAGIC, 20).add(Aspect.CLOTH, 8).add(Aspect.METAL, 16), 
				   new ItemStack(ItemHandler.itemLegsCultistArcher), 
				   new ItemStack[]{
			  			ItemApi.getItem("itemResource", 7), 
			  			ItemApi.getItem("itemResource", 2), 
			  			ItemApi.getItem("itemResource", 7), 
			  			ItemApi.getItem("itemResource", 2)});
		 
		 new ResearchItem("TD.DYEDARCHER", "DYES", 
				  (new AspectList()).add(Aspect.CLOTH, 5).add(Aspect.ARMOR, 5).add(Aspect.MAGIC, 5).add(Aspect.WEAPON, 5),
				  -7, 1, 2, 
				  new ItemStack(ItemHandler.itemHelmetCultistArcherDyed))
				  .setPages(new ResearchPage[]{
						  new ResearchPage("tc.research_page.TD.archer.1"), 
						  new ResearchPage(recipeArcherHelmDyed), 
						  new ResearchPage(recipeArcherChestDyed), 
						  new ResearchPage(recipeArcherLegsDyed)
						  })
				  .setParents("TD.CRIMSONARCHER") //change to "DYEDKNIGHT" once implemented
				  .setConcealed()
				  .registerResearchItem();
		 
		 
		 
		 //Shitposting
		 
			/////////////
			//SUNKNIGHT
		 
		 ShapedArcaneRecipe recipeSunKniHelm = ThaumcraftApi.addArcaneCraftingRecipe("TD.SUNNYD",
				   new ItemStack(ItemHandler.itemHelmetSunKnight), 
				   (new AspectList()).add(Aspect.FIRE, 20).add(Aspect.AIR, 20), 
				   new Object[]{
						" g ",
						" H ",
						" g ",
						'H',new ItemStack(ItemHandler.itemHelmetCultistKnightDyed),
						'g',new ItemStack(Items.dye, 1, 8)
						});
		
		ShapedArcaneRecipe recipeSunKniChest = ThaumcraftApi.addArcaneCraftingRecipe("TD.SUNNYD",
				   new ItemStack(ItemHandler.itemChestSunKnight), 
				   (new AspectList()).add(Aspect.FIRE, 20).add(Aspect.AIR, 20),
				   new Object[]{
						" r ",
						"rCr",
						" y ",
						'C',new ItemStack(ItemHandler.itemChestCultistKnightDyed),
						'r',new ItemStack(Items.dye, 1, 1),
						'y',new ItemStack(Items.dye, 1, 11)
						});
		 
		 new ResearchItem("TD.SUNNYD", "DYES", 
				  (new AspectList()).add(Aspect.FIRE, 4).add(Aspect.ARMOR, 4).add(Aspect.AURA, 4),
				  0, -3, 1, 
				  new ItemStack(ItemHandler.itemChestSunKnight))
				  .setPages(new ResearchPage[]{
						  new ResearchPage("tc.research_page.TD.sunnyD.1"), 
						  new ResearchPage(recipeSunKniHelm), 
						  new ResearchPage(recipeSunKniChest)
						  })
				  //.setParents("TD.THAUMIUM", "ENCHFABRIC") //WIP
				  .setParentsHidden("TD.DYEDKNIGHT")
				  .setConcealed()
				  .setHidden()
				  .registerResearchItem();
	   
   }
      
   //TODO Eldritch
   public static void researchEldritch() {
    	  
    	  copy(ResearchCategories.getResearchList("ELDRITCH").research.get("ENTEROUTER"),"TD.OUTERARRIVAL","DYES",-2,6).setConcealed().setHidden().registerResearchItem();
          
          //Husk Armour
          InfusionRecipe recipeHuskHelm = ThaumcraftApi.addInfusionCraftingRecipe("TD.INHABITEDPLATE",
    			   new ItemStack(ItemHandler.itemHelmetInhabitedPlate), 3, 
    			   (new AspectList()).add(Aspect.ENTROPY, 16).add(Aspect.ELDRITCH, 16).add(Aspect.METAL, 16).add(Aspect.ARMOR, 16), 
    			   ItemApi.getItem("itemHelmetCultistPlate", 0), 
    			   new ItemStack[]{
    		   			ItemApi.getItem("itemShard", 5), 
    		   			new ItemStack(Items.iron_ingot), 
    		   			ItemApi.getItem("itemResource", 17)});
         	
          InfusionRecipe recipeHuskChest = ThaumcraftApi.addInfusionCraftingRecipe("TD.INHABITEDPLATE",
    			   new ItemStack(ItemHandler.itemChestInhabitedPlate), 3, 
    			   (new AspectList()).add(Aspect.ENTROPY, 16).add(Aspect.ELDRITCH, 24).add(Aspect.METAL, 24).add(Aspect.ARMOR, 24), 
    			   ItemApi.getItem("itemChestCultistPlate", 0), 
    			   new ItemStack[]{
        	 			ItemApi.getItem("itemShard", 5), 
        	 			new ItemStack(Items.iron_ingot), 
        	 			new ItemStack(Items.iron_ingot),
        	 			ItemApi.getItem("itemResource", 17),
        	 			ItemApi.getItem("itemResource", 17)});
    	   
          InfusionRecipe recipeHuskLegs = ThaumcraftApi.addInfusionCraftingRecipe("TD.INHABITEDPLATE",
    			   new ItemStack(ItemHandler.itemLegsInhabitedPlate), 3, 
    			   (new AspectList()).add(Aspect.ENTROPY, 16).add(Aspect.ELDRITCH, 20).add(Aspect.METAL, 20).add(Aspect.ARMOR, 20), 
    			   ItemApi.getItem("itemLegsCultistPlate", 0), 
    			   new ItemStack[]{
        	 			ItemApi.getItem("itemShard", 5), 
        	 			new ItemStack(Items.iron_ingot), 
        	 			new ItemStack(Items.iron_ingot),
        	 			ItemApi.getItem("itemResource", 17)});
          
          new ResearchItem("TD.INHABITEDPLATE", "DYES", 
    		  (new AspectList()).add(Aspect.ENTROPY, 4).add(Aspect.EXCHANGE, 4).add(Aspect.ELDRITCH, 4),
              -4, 6, 1, 
    		  new ItemStack(ItemHandler.itemHelmetInhabitedPlate, 0))
    		  .setPages(new ResearchPage[]{
    				  new ResearchPage("tc.research_page.TD.husk.1"), 
    				  new ResearchPage("tc.research_page.TD.husk.2"),
    				  new ResearchPage(recipeHuskHelm), 
    				  new ResearchPage(recipeHuskChest), 
    				  new ResearchPage(recipeHuskLegs)})
    		  .setParents(/*"DYEDKNIGHT",*/ "TD.OUTERARRIVAL")
    		  //.setConcealed()
    		  .registerResearchItem();
          ThaumcraftApi.addWarpToResearch("TD.INHABITEDPLATE", 2);
      }
      
   //TODO IRON TIER
   public static void researchIron () {
	   
		/////////////
		//Iron Fortress
	    InfusionRecipe recipeIronFortHelm = ThaumcraftApi.addInfusionCraftingRecipe("TD.IRONFORTRESS", 
				new ItemStack(ItemHandler.itemHelmetIronFortress), 1, 
				(new AspectList()).add(Aspect.ARMOR, 8).add(Aspect.METAL, 8).add(Aspect.CRAFT, 8), 
				   new ItemStack(Items.iron_helmet, 0), 
				   new ItemStack[]{
					   new ItemStack(Items.iron_ingot, 0),
					   new ItemStack(Items.iron_ingot, 0),
					   new ItemStack(Items.iron_ingot, 0),
					   new ItemStack(Items.gold_ingot, 0),
					   new ItemStack(Items.diamond, 0),
					   });
				   
	    InfusionRecipe recipeIronFortChest = ThaumcraftApi.addInfusionCraftingRecipe("TD.IRONFORTRESS", 
				new ItemStack(ItemHandler.itemChestIronFortress), 1, 
				(new AspectList()).add(Aspect.ARMOR, 8).add(Aspect.METAL, 8).add(Aspect.CRAFT, 8), 
				   new ItemStack(Items.iron_chestplate, 0), 
				   new ItemStack[]{
			    	   new ItemStack(Items.iron_ingot, 0),
					   new ItemStack(Items.iron_ingot, 0),
					   new ItemStack(Items.iron_ingot, 0),
					   new ItemStack(Items.iron_ingot, 0),
					   new ItemStack(Items.gold_ingot, 0),
					   new ItemStack(Items.leather, 0)
			   			});
		   
	    InfusionRecipe recipeIronFortLegs = ThaumcraftApi.addInfusionCraftingRecipe("TD.IRONFORTRESS", 
				new ItemStack(ItemHandler.itemLegsIronFortress), 1, 
				(new AspectList()).add(Aspect.ARMOR, 8).add(Aspect.METAL, 8).add(Aspect.CRAFT, 8), 
				   new ItemStack(Items.iron_leggings, 0), 
				   new ItemStack[]{
					   new ItemStack(Items.iron_ingot, 0),
					   new ItemStack(Items.iron_ingot, 0),
					   new ItemStack(Items.iron_ingot, 0),
					   new ItemStack(Items.gold_ingot, 0),
					   new ItemStack(Items.leather, 0)
			   			});
	          
	    new ResearchItem("TD.IRONFORTRESS", "DYES", 
	  		  (new AspectList()).add(Aspect.ARMOR, 5).add(Aspect.METAL, 5).add(Aspect.CRAFT, 5),
	  		  9, -1, 1, 
	  		  new ItemStack(ItemHandler.itemHelmetIronFortress, 0))
	    		  .setPages(new ResearchPage[]{
	  				  new ResearchPage("tc.research_page.TD.ironFortress.1"),
	  				  new ResearchPage("tc.research_page.TD.ironFortress.2"), 
	  				  new ResearchPage(recipeIronFortHelm), 
	  				  new ResearchPage(recipeIronFortChest), 
	  				  new ResearchPage(recipeIronFortLegs)
	  				  })
				  .setParents("TD.ARMORFORTRESS")
				  .setSecondary()
				  //.setConcealed()
				  .registerResearchItem();
			
			
		/////////////
		//Faceplates
		InfusionRecipe recipeIronFortHelmGoggles = ThaumcraftApi.addInfusionCraftingRecipe("TD.IRONHELMGOGGLES", new Object[] { "goggles", new NBTTagByte((byte) 1) }, 5, 
				  new AspectList().add(Aspect.SENSES, 32).add(Aspect.AURA, 16).add(Aspect.ARMOR, 16), 
				  new ItemStack(ItemHandler.itemHelmetIronFortress, 1, 32767), 
			      new ItemStack[] { 
			    	  new ItemStack(Items.slime_ball), 
			    	  new ItemStack(ConfigItems.itemGoggles, 1, 32767) });
		  
		InfusionRecipe recipeIronFortHelmKnight = ThaumcraftApi.addInfusionCraftingRecipe("TD.IRONHELMAESTHETICS", new Object[] { "mask", new NBTTagInt(0) }, 2, 
				  new AspectList().add(Aspect.CRAFT, 8).add(Aspect.ARMOR, 8), 
				  new ItemStack(ItemHandler.itemHelmetIronFortress, 1, 32767), 
			      new ItemStack[] { 
			    	  new ItemStack(Items.slime_ball), 
			    	  ItemApi.getItem("itemHelmetCultistPlate", 32767) });
		  
		InfusionRecipe recipeIronFortHelmPraetor = ThaumcraftApi.addInfusionCraftingRecipe("TD.IRONHELMAESTHETICS", new Object[] { "mask", new NBTTagInt(1) }, 2, 
				  new AspectList().add(Aspect.CRAFT, 8).add(Aspect.ARMOR, 8), 
				  new ItemStack(ItemHandler.itemHelmetIronFortress, 1, 32767), 
			      new ItemStack[] { 
			    	  new ItemStack(Items.slime_ball), 
			    	  ItemApi.getItem("itemHelmetCultistLeaderPlate", 32767) });
			
		new ResearchItem("TD.IRONHELMGOGGLES", "DYES", 
				new AspectList().add(Aspect.SENSES, 5).add(Aspect.AURA, 3).add(Aspect.ARMOR, 3), 
				11, -1, 2, 
				ItemApi.getItem("itemGoggles", 0))
	    		  .setPages(new ResearchPage[]{
	  				  new ResearchPage("tc.research_page.TD.ironHelmGoggles.1"),
	  				  new ResearchPage(recipeIronFortHelmGoggles)})
				  .setParents("TD.IRONFORTRESS", "GOGGLES")
				  .setSecondary()
				  .setConcealed()
				  .registerResearchItem();	
		
		new ResearchItem("TD.IRONHELMAESTHETICS", "DYES", 
				new AspectList().add(Aspect.CRAFT, 5).add(Aspect.ARMOR, 3), 
				11, 0, 2, 
				ItemApi.getItem("itemHelmetCultistPlate", 0))
	    		  .setPages(new ResearchPage[]{
	  				  new ResearchPage("tc.research_page.TD.ironHelmFace.1"),
	  				  new ResearchPage(recipeIronFortHelmKnight),
	  				  new ResearchPage(recipeIronFortHelmPraetor)
	  				  })
				  .setParents("TD.IRONFORTRESS")
				  .setSecondary()
				  .setConcealed()
				  .registerResearchItem();
		
		InfusionRecipe recipeIronFortHelmHusk = ThaumcraftApi.addInfusionCraftingRecipe("TD.IRONHELMHUSK", 
				new Object[] { "mask", new NBTTagInt(2) }, 2, 
				  new AspectList().add(Aspect.CRAFT, 8).add(Aspect.ARMOR, 8).add(Aspect.ELDRITCH, 4).add(Aspect.EXCHANGE, 4), 
				  new ItemStack(ItemHandler.itemHelmetIronFortress, 1, 32767), 
			      new ItemStack[] { 
			    	  new ItemStack(Items.slime_ball), 
			    	  new ItemStack(ItemHandler.itemHelmetInhabitedPlate, 0),
			    	  });
		
		new ResearchItem("TD.IRONHELMHUSK", "DYES", 
				new AspectList().add(Aspect.CRAFT, 5).add(Aspect.ARMOR, 3).add(Aspect.ELDRITCH, 2), 
				10, 1, 2, 
				new ResourceLocation("thaumicdyes:textures/items/icon/husk_plate_helm.png"))
	    		  .setPages(new ResearchPage[]{
	  				  new ResearchPage("tc.research_page.TD.ironHelmFace.2"),
	   				  new ResearchPage(recipeIronFortHelmHusk)})
				  .setParents("TD.IRONFORTRESS")
				  .setParentsHidden("TD.INHABITEDPLATE", "TD.IRONHELMAESTHETICS")
				  .setSecondary()
				  .setConcealed()
				  .registerResearchItem();   
	   
   }   
      	  
   //TODO THAUMIUM TIER
   public static void researchThaumium() {
	   
		copy(ResearchCategories.getResearchList("ALCHEMY").research.get("THAUMIUM"),"TD.THAUMIUM","DYES",2,-1).setConcealed().setHidden().registerResearchItem();
	      
		/////////////
		//Thaumium Fortress
     InfusionRecipe recipeFortHelm = ThaumcraftApi.addInfusionCraftingRecipe("TD.DYEDFORTRESS", 
			   new ItemStack(ItemHandler.itemHelmetFortressDyed), 5, 
			   (new AspectList()).add(Aspect.ARMOR, 16).add(Aspect.MAGIC, 16).add(Aspect.CLOTH, 8).add(Aspect.METAL, 16), 
			   ItemApi.getItem("itemHelmetFortress", 0), 
			   new ItemStack[]{
				   ItemApi.getItem("itemResource", 2), 
				   ItemApi.getItem("itemResource", 2), 
				   ItemApi.getItem("itemResource", 7), 
				   ItemApi.getItem("itemResource", 2)});
			   
     InfusionRecipe recipeFortChest = ThaumcraftApi.addInfusionCraftingRecipe("TD.DYEDFORTRESS", 
			   new ItemStack(ItemHandler.itemChestFortressDyed), 5, 
			   (new AspectList()).add(Aspect.ARMOR, 24).add(Aspect.MAGIC, 24).add(Aspect.CLOTH, 8).add(Aspect.METAL, 16), 
			   ItemApi.getItem("itemChestFortress", 0), 
			   new ItemStack[]{
		   			ItemApi.getItem("itemResource", 2), 
		   			ItemApi.getItem("itemResource", 2), 
		   			ItemApi.getItem("itemResource", 7), 
		   			ItemApi.getItem("itemResource", 2)});
	   
     InfusionRecipe recipeFortLegs = ThaumcraftApi.addInfusionCraftingRecipe("TD.DYEDFORTRESS", 
			   new ItemStack(ItemHandler.itemLegsFortressDyed), 5, 
			   (new AspectList()).add(Aspect.ARMOR, 20).add(Aspect.MAGIC, 20).add(Aspect.CLOTH, 8).add(Aspect.METAL, 16),
			   ItemApi.getItem("itemLegsFortress", 0), 
			   new ItemStack[]{
		   			ItemApi.getItem("itemResource", 2), 
		   			ItemApi.getItem("itemResource", 2), 
		   			ItemApi.getItem("itemResource", 7), 
		   			ItemApi.getItem("itemResource", 2)});

     
     new ResearchItem("TD.DYEDFORTRESS", "DYES", 
   		  (new AspectList()).add(Aspect.CLOTH, 5).add(Aspect.ARMOR, 5).add(Aspect.MAGIC, 5),
   		  5, -2, 5, 
   		  new ItemStack(ItemHandler.itemHelmetFortressDyed, 0))
   		  .setPages(new ResearchPage[]{
   				  new ResearchPage("tc.research_page.TD.fortress.1"), 
   				  new ResearchPage(recipeFortHelm), 
   				  new ResearchPage(recipeFortChest), 
   				  new ResearchPage(recipeFortLegs)})
			  .setParents("TD.THAUMIUM","TD.ARMORFORTRESS")
			  .setConcealed()
			  .registerResearchItem();
     
     
		  /////////////
		  //Thaumium Robes				   
	    InfusionRecipe recipeThaumRobeHelm = ThaumcraftApi.addInfusionCraftingRecipe("TD.THAUMIUMROBE", 
				new ItemStack(ItemHandler.itemHelmetThaumiumRobeDyed), 4, 
				new AspectList().add(Aspect.METAL, 16).add(Aspect.SENSES, 16).add(Aspect.ARMOR, 16).add(Aspect.CLOTH, 16).add(Aspect.MAGIC, 16), 
				ItemApi.getItem("itemHelmetThaumium", 0), 
				new ItemStack[] { 
	    			new ItemStack(ConfigItems.itemGoggles), 
	    			new ItemStack(ConfigItems.itemResource, 1, 7), 
	    			new ItemStack(ConfigItems.itemResource, 1, 7), 
	    			new ItemStack(ConfigItems.itemResource, 1, 14), 
	    			new ItemStack(ConfigItems.itemResource, 1, 7), 
	    			new ItemStack(ConfigItems.itemResource, 1, 7) });
			    
	    InfusionRecipe recipeThaumRobeChest = ThaumcraftApi.addInfusionCraftingRecipe("TD.THAUMIUMROBE", 
				new ItemStack(ItemHandler.itemChestThaumiumRobeDyed), 4, 
				new AspectList().add(Aspect.METAL, 24).add(Aspect.ARMOR, 24).add(Aspect.CLOTH, 24).add(Aspect.MAGIC, 16), 
				ItemApi.getItem("itemChestThaumium", 0), 
				new ItemStack[] { 
	    			new ItemStack(ConfigItems.itemChestRobe), 
	    			new ItemStack(ConfigItems.itemResource, 1, 2), 
	    			new ItemStack(ConfigItems.itemResource, 1, 2), 
	    			new ItemStack(ConfigItems.itemResource, 1, 14), 
	    			new ItemStack(ConfigItems.itemResource, 1, 7), 
	    			new ItemStack(Items.leather) });
			    
	    InfusionRecipe recipeThaumRobeLegs = ThaumcraftApi.addInfusionCraftingRecipe("TD.THAUMIUMROBE", 
				new ItemStack(ItemHandler.itemLegsThaumiumRobeDyed), 4, 
				new AspectList().add(Aspect.METAL, 20).add(Aspect.ARMOR, 20).add(Aspect.CLOTH, 20).add(Aspect.MAGIC, 16), 
				ItemApi.getItem("itemLegsThaumium", 0), 
				new ItemStack[] { 
	    			ItemApi.getItem("itemLegsRobe", 0), 
	    			ItemApi.getItem("itemResource", 2), 
	    			ItemApi.getItem("itemResource", 2), 
	    			ItemApi.getItem("itemResource", 14), 
	    			ItemApi.getItem("itemResource", 7), 
	    			new ItemStack(Items.leather) });
				            
	      new ResearchItem("TD.THAUMIUMROBE", "DYES", 
	    		  (new AspectList()).add(Aspect.ARMOR, 5).add(Aspect.CLOTH, 5).add(Aspect.CRAFT, 5),
	    		  3, -4, 2, 
	    		  new ItemStack(ItemHandler.itemChestThaumiumRobeDyed, 0))
	      		  .setPages(new ResearchPage[]{
	    				  new ResearchPage("tc.research_page.TD.thaumrobe.1"),
	    				  new ResearchPage(recipeThaumRobeHelm), 
	    				  new ResearchPage(recipeThaumRobeChest), 
	    				  new ResearchPage(recipeThaumRobeLegs)})
				  .setParents("TD.THAUMIUM", "GOGGLES", "ENCHFABRIC")
				  .registerResearchItem(); 
	   
   }   
	     
   //TODO VOID TIER
   public static void researchVoid() {
	   
	      copy(ResearchCategories.getResearchList("ELDRITCH").research.get("ARMORVOIDFORTRESS"),"TD.VOIDFORTRESS","DYES",2,6).setConcealed().setHidden().registerResearchItem();
	      
		  /////////////
		  //Void Robes
		CrucibleRecipe recipeVoidRobeHelm = ThaumcraftApi.addCrucibleRecipe("TD.VOIDROBE", 
				new ItemStack(ItemHandler.itemHelmetVoidRobeDyed), 
				ItemApi.getItem("itemHelmetVoidRobe", 0), 
				(new AspectList()).add(Aspect.CLOTH, 8).add(Aspect.ENTROPY, 4).add(Aspect.EXCHANGE, 8));
				   
		CrucibleRecipe recipeVoidRobeChest = ThaumcraftApi.addCrucibleRecipe("TD.VOIDROBE", 
				new ItemStack(ItemHandler.itemChestVoidRobeDyed), 
				ItemApi.getItem("itemChestVoidRobe", 0), 
				(new AspectList()).add(Aspect.CLOTH, 8).add(Aspect.ENTROPY, 4).add(Aspect.EXCHANGE, 8));
		
		CrucibleRecipe recipeVoidRobeLegs = ThaumcraftApi.addCrucibleRecipe("TD.VOIDROBE", 
				new ItemStack(ItemHandler.itemLegsVoidRobeDyed), 
				ItemApi.getItem("itemLegsVoidRobe", 0), 
				(new AspectList()).add(Aspect.CLOTH, 8).add(Aspect.ENTROPY, 4).add(Aspect.EXCHANGE, 8));
	          
	   new ResearchItem("TD.VOIDROBE", "DYES", 
	  		  (new AspectList()).add(Aspect.ARMOR, 5).add(Aspect.METAL, 5).add(Aspect.CRAFT, 5),
	  		  4, 6, 2, 
	  		  new ItemStack(ItemHandler.itemChestVoidRobeDyed, 0))
	    		  .setPages(new ResearchPage[]{
	  				  new ResearchPage("tc.research_page.TD.voidrobe.1"),
	  				  new ResearchPage(recipeVoidRobeHelm),
	  				  new ResearchPage(recipeVoidRobeChest),
	  				  new ResearchPage(recipeVoidRobeLegs),
	    		  			})
				  .setParents("TD.VOIDFORTRESS")
				  .setSecondary()
				  .setConcealed()
				  .registerResearchItem();
	   
   }
	      
   //TODO boots
   public static void researchBoots() {
	   
	      copy(ResearchCategories.getResearchList("ARTIFICE").research.get("BOOTSTRAVELLER"),"TD.BOOTSTRAVELLER","DYES",4,2).setConcealed().setHidden().registerResearchItem();
	      
		  /////////////
		  //Thaumium boots
	      InfusionRecipe recipeThaumBoots = ThaumcraftApi.addInfusionCraftingRecipe("TD.THAUMIUMBOOTS", 
					new ItemStack(ItemHandler.itemBootsThaumiumTraveller), 4, 
					new AspectList().add(Aspect.METAL, 16).add(Aspect.ARMOR, 16).add(Aspect.CLOTH, 16).add(Aspect.MAGIC, 16).add(Aspect.TRAVEL, 8), 
					ItemApi.getItem("itemBootsTraveller", 0), 
					new ItemStack[] { 
	    	  			new ItemStack(Items.leather), 
		    			new ItemStack(ConfigItems.itemResource, 1, 2), 
		    			new ItemStack(ConfigItems.itemResource, 1, 2), 
		    			new ItemStack(ConfigItems.itemResource, 1, 14), 
		    			new ItemStack(ConfigItems.itemResource, 1, 7), 
		    			new ItemStack(ConfigItems.itemResource, 1, 7)});
	      
	      new ResearchItem("TD.THAUMIUMBOOTS", "DYES", 
	    		  (new AspectList()).add(Aspect.ARMOR, 5).add(Aspect.CLOTH, 5).add(Aspect.TRAVEL, 5),
	    		  2, 1, 2, 
	    		  new ItemStack(ItemHandler.itemBootsThaumiumTraveller, 0))
	      		  .setPages(new ResearchPage[]{
	    				  new ResearchPage("tc.research_page.TD.thaumboots.1"),
	    				  new ResearchPage(recipeThaumBoots)})
				  .setParents("TD.THAUMIUM", "TD.BOOTSTRAVELLER")
				  .setConcealed()
				  .registerResearchItem();
	      
		  /////////////
		  //Void boots
	      InfusionRecipe recipeVoidBoots = ThaumcraftApi.addInfusionCraftingRecipe("TD.VOIDBOOTS", 
					new ItemStack(ItemHandler.itemBootsVoidTraveller), 4, 
					new AspectList().add(Aspect.METAL, 16).add(Aspect.ARMOR, 16).add(Aspect.CLOTH, 16).add(Aspect.MAGIC, 16).add(Aspect.TRAVEL, 8).add(Aspect.ELDRITCH, 16).add(Aspect.VOID, 8), 
					ItemApi.getItem("itemBootsTraveller", 0), 
					new ItemStack[] { 
	    	  			new ItemStack(Items.leather), 
		    			new ItemStack(ConfigItems.itemResource, 1, 16), 
		    			new ItemStack(ConfigItems.itemResource, 1, 2), 
		    			new ItemStack(ConfigItems.itemResource, 1, 14), 
		    			new ItemStack(ConfigItems.itemResource, 1, 7), 
		    			new ItemStack(ConfigItems.itemResource, 1, 7)});
	      
	      new ResearchItem("TD.VOIDBOOTS", "DYES", 
	    		  (new AspectList()).add(Aspect.ARMOR, 5).add(Aspect.CLOTH, 5).add(Aspect.TRAVEL, 5).add(Aspect.ELDRITCH, 5),
	    		  2, 4, 2, 
	    		  new ItemStack(ItemHandler.itemBootsVoidTraveller, 0))
	      		  .setPages(new ResearchPage[]{
	    				  new ResearchPage("tc.research_page.TD.voidboots.1"),
	    				  new ResearchPage(recipeVoidBoots)})
				  .setParents("TD.VOIDFORTRESS", "TD.BOOTSTRAVELLER")
				  .setConcealed()
				  .registerResearchItem();  
	   
   }
	      
   //TODO Runic armour
   public static void researchRunic() {
	      
      /////////////
      //base
      new ResearchItem("TD.RUNICARMOR", "DYES", 
    		  new AspectList().add(Aspect.ARMOR, 8).add(Aspect.AIR, 5).add(Aspect.MAGIC, 5).add(Aspect.ENERGY, 5).add(Aspect.MIND, 3),
    		  8, 3, 3, 
    		  new ItemStack(ItemHandler.itemChestRunicLegacy))
      		  .setPages(new ResearchPage[] { 
      				  new ResearchPage("tc.research_page.TD.RUNICARMOR.1"), 
      				  new ResearchPage("tc.research_page.TD.RUNICARMOR.2"), 
      				  new ResearchPage((InfusionRecipe)recipes.get("RunicArmorHelm")), 
      				  new ResearchPage((InfusionRecipe)recipes.get("RunicArmorChest")), 
      				  new ResearchPage((InfusionRecipe)recipes.get("RunicArmorLegs")), 
      				  new ResearchPage((InfusionRecipe)recipes.get("RunicArmorBoots")) 
      				  })
			  .setParents("INFUSION", "RUNICARMOR")
			  .setConcealed()
			  .setSpecial()
			  .registerResearchItem();
      
      /////////////
      //goggles+boots
      new ResearchItem("TD.RUNICGOGGLES", "DYES", 
    		  new AspectList().add(Aspect.SENSES, 8).add(Aspect.MAGIC, 5).add(Aspect.ARMOR, 5).add(Aspect.AURA, 3),
    		  7, 1, 2, 
    		  new ItemStack(ItemHandler.itemGogglesRunicLegacy))
      		  .setPages(new ResearchPage[] { 
      				  new ResearchPage("tc.research_page.TD.RUNICGOGGLES.1"), 
      				  new ResearchPage((InfusionRecipe)recipes.get("RunicGoggles")) 
      				  })
			  .setParents("GOGGLES", "TD.RUNICARMOR")
			  .setSecondary()
			  .setConcealed()
			  .registerResearchItem();
      
      new ResearchItem("TD.RUNICBOOTSTRAVELLER", "DYES",
    		  new AspectList().add(Aspect.TRAVEL, 8).add(Aspect.WATER, 5).add(Aspect.ARMOR, 5).add(Aspect.FLIGHT, 5),
    		  5, 2, 2, 
    		  new ItemStack(ItemHandler.itemBootsTravellerRunicLegacy))
      		  .setPages(new ResearchPage[] { 
      				  new ResearchPage("tc.research_page.TD.RUNICBOOTSTRAVELLER.1"), 
      				  new ResearchPage((InfusionRecipe)recipes.get("RunicBootsTraveller")) 
      				  })
			  .setParents("TD.BOOTSTRAVELLER", "TD.RUNICARMOR")
			  .setSecondary()
			  .setConcealed()
			  .registerResearchItem();
      
      /////////////
      //augments
      ArrayList<InfusionRecipe> rc1 = new ArrayList();
      ArrayList<InfusionRecipe> rc2 = new ArrayList();
      ArrayList<InfusionRecipe> rc3 = new ArrayList();
      ArrayList<InfusionRecipe> rc4 = new ArrayList();
      ArrayList<InfusionRecipe> rc5 = new ArrayList();
      ArrayList<InfusionRecipe> rc6 = new ArrayList();
      for (int a = 0; a <= 3; a++)
      {
        rc1.add((InfusionRecipe)recipes.get("RAU1_" + a));
        rc2.add((InfusionRecipe)recipes.get("RAU2_" + a));
        rc3.add((InfusionRecipe)recipes.get("RAU3_" + a));
        rc4.add((InfusionRecipe)recipes.get("RAU4_" + a));
        rc5.add((InfusionRecipe)recipes.get("RAU5_" + a));
        rc6.add((InfusionRecipe)recipes.get("RAU6_" + a));
      }
      
      new ResearchItem("TD.RUNICARMORUPGRADES", "DYES", 
    		  new AspectList().add(Aspect.MAGIC, 8).add(Aspect.ARMOR, 5).add(Aspect.ORDER, 5).add(Aspect.MIND, 3),
    		  7, 4, 3, 
    		  new ResourceLocation("thaumcraft", "textures/misc/r_runicupg.png"))
		      .setPages(new ResearchPage[] { 
		    		  new ResearchPage("tc.research_page.TD.RUNICARMORUPGRADES.1"), 
		    		  new ResearchPage("tc.research_page.TD.RUNICARMORUPGRADES.2"), 
		    		  new ResearchPage("tc.research_page.TD.RUNICARMORUPGRADES.3"),
		    		  new ResearchPage("tc.research_page.TD.RUNICARMORUPGRADES.4"),
		    		  new ResearchPage("TD.ENHANCEDRUNICARMOR", "tc.research_page.TD.RUNICARMORUPGRADES.5"),
		    		  new ResearchPage((InfusionRecipe[])rc1.toArray(new InfusionRecipe[0])), 
		    		  new ResearchPage((InfusionRecipe[])rc2.toArray(new InfusionRecipe[0])), 
		    		  new ResearchPage((InfusionRecipe[])rc3.toArray(new InfusionRecipe[0])), 
		    		  new ResearchPage((InfusionRecipe[])rc4.toArray(new InfusionRecipe[0])), 
		    		  new ResearchPage((InfusionRecipe[])rc5.toArray(new InfusionRecipe[0])), 
		    		  new ResearchPage((InfusionRecipe[])rc6.toArray(new InfusionRecipe[0]))
		      })
		      .setParents("TD.RUNICARMOR")
		      .setParentsHidden("RUNICHEALING", "RUNICKINETIC", "RUNICEMERGENCY")
		      .setSecondary()
		      .setConcealed()
		      .registerResearchItem();
      
      
      //TODO Enhanced runic
      
      //base
      ArrayList<InfusionRecipe> enhR = new ArrayList();
      for (int a = 0; a <= 3; a++)
      {
        enhR.add((InfusionRecipe)recipes.get("EnhRunicArmor" + a));
      }
      
      new ResearchItem("TD.ENHANCEDRUNICARMOR", "DYES", 
    		  new AspectList().add(Aspect.ARMOR, 8).add(Aspect.AIR, 5).add(Aspect.MAGIC, 5).add(Aspect.ENERGY, 5).add(Aspect.MIND, 3),
    		  10, 3, 3, 
    		  new ItemStack(ItemHandler.itemChestRunicTX))
      		  .setPages(new ResearchPage[] { 
      				  new ResearchPage("tc.research_page.TD.ENHANCEDRUNICARMOR.1"), 
      				  new ResearchPage("tc.research_page.TD.ENHANCEDRUNICARMOR.2"), 
      				  new ResearchPage((InfusionRecipe[])enhR.toArray(new InfusionRecipe[0])) 
      				 
      				  })
			  //.setParentsHidden("")
			  .setParents("TD.RUNICARMOR")
			  //.setParentsHidden("PRIMPEARL")
			  .setConcealed()
			  .registerResearchItem();
       
      
			      
   }
	      
	      
   

   
   //For some things
   //Borrowed from Thaumic Bases. Allows creating copies of research over to a tab
   public static ResearchItem copy(ResearchItem res, String newKey, String newCat, int dC, int dR)
	{
		ResearchItem rItem;
		
		if(res.icon_resource != null)
			rItem = new ResearchItem(newKey,newCat,res.tags,dC,dR,res.getComplexity(),res.icon_resource);
		else
			rItem = new ResearchItem(newKey,newCat,res.tags,dC,dR,res.getComplexity(),res.icon_item);
		
		rItem.parents = res.parents;
		rItem.parentsHidden = res.parentsHidden;
		rItem.siblings = res.siblings;
		rItem.setPages(res.getPages());
		rItem.setAspectTriggers(new Aspect[0]);
		rItem.setEntityTriggers(new String[0]);
		rItem.setItemTriggers(new ItemStack[0]);
		
		if(res.isAutoUnlock())
			rItem.setAutoUnlock();
		
		if(res.isConcealed())
			rItem.setConcealed();
		
		if(res.isHidden())
			rItem.setHidden();
		
		if(res.isLost())
			rItem.setLost();
		
		if(res.isRound())
			rItem.setRound();
		
		if(res.isSecondary())
			rItem.setSecondary();
		
		if(res.isSpecial())
			rItem.setSpecial();
		
		if(res.isStub())
			rItem.setStub();
		
		if(res.siblings != null && res.siblings.length > 0)
		{
			String[] sibStr = new String[res.siblings.length+1];
			for(int i = 0; i < res.siblings.length; ++i)
				sibStr[i] = res.siblings[i];
			
			sibStr[sibStr.length - 1] = newKey;
			
			res.setSiblings(sibStr);
		}else
		{
			res.setSiblings(newKey);
		}
		
		return rItem;
	}
   
  
}
