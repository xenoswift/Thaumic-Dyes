package thaumic.dyes.client.models;

import net.minecraft.client.model.ModelBiped;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.entity.monster.EntitySkeleton;
import net.minecraft.entity.monster.EntityZombie;
import net.minecraft.util.MathHelper;
import org.lwjgl.opengl.GL11;

public class ModelRobes extends ModelBiped {
   ModelRenderer Hood1;
   ModelRenderer Hood2;
   ModelRenderer Hood3;
   ModelRenderer Hood4;
   ModelRenderer Chestthing;
   ModelRenderer Mbelt;
   ModelRenderer ClothchestL;
   ModelRenderer ClothchestR;
   ModelRenderer Book;
   ModelRenderer Scroll;
   ModelRenderer BeltR;
   ModelRenderer Backplate;
   ModelRenderer MbeltL;
   ModelRenderer MbeltR;
   ModelRenderer BeltL;
   ModelRenderer Chestplate;
   ModelRenderer ShoulderplateR1;
   ModelRenderer ShoulderplateR2;
   ModelRenderer ShoulderplateR3;
   ModelRenderer ShoulderplateTopR;
   ModelRenderer RArm1;
   ModelRenderer RArm2;
   ModelRenderer RArm3;
   ModelRenderer LArm1;
   ModelRenderer LArm2;
   ModelRenderer LArm3;
   ModelRenderer ShoulderplateL1;
   ModelRenderer ShoulderplateL2;
   ModelRenderer ShoulderplateL3;
   ModelRenderer ShoulderplateTopL;
   ModelRenderer ShoulderL;
   ModelRenderer ShoulderR;
   ModelRenderer ClothBackR3;
   ModelRenderer FrontclothR2;
   ModelRenderer FrontclothR1;
   ModelRenderer SideclothR2;
   ModelRenderer SideclothR1;
   ModelRenderer SideclothR3;
   ModelRenderer ClothBackR1;
   ModelRenderer ClothBackR2;
   ModelRenderer SidepanelR1;
   ModelRenderer LegpanelR6;
   ModelRenderer LegpanelR5;
   ModelRenderer LegpanelR4;
   ModelRenderer FrontclothL2;
   ModelRenderer ClothBackL3;
   ModelRenderer ClothBackL1;
   ModelRenderer FrontclothL1;
   ModelRenderer SideclothL2;
   ModelRenderer SideclothL3;
   ModelRenderer Focipouch;
   ModelRenderer SideclothL1;
   ModelRenderer ClothBackL2;
   ModelRenderer LegpanelL4;
   ModelRenderer LegpanelL5;
   ModelRenderer LegpanelL6;
   ModelRenderer SidepanelL1;

   public ModelRobes(float f) {
      super(f, 0.0F, 128, 64);
      super.textureWidth = 128;
      super.textureHeight = 64;
      this.Hood1 = new ModelRenderer(this, 16, 7);
      this.Hood1.addBox(-4.5F, -9.0F, -4.6F, 9, 9, 9);
      this.Hood1.setTextureSize(128, 64);
      this.setRotation(this.Hood1, 0.0F, 0.0F, 0.0F);
      this.Hood2 = new ModelRenderer(this, 52, 13);
      this.Hood2.addBox(-4.0F, -9.7F, 2.0F, 8, 9, 3);
      this.Hood2.setTextureSize(128, 64);
      this.setRotation(this.Hood2, -0.226893F, 0.0F, 0.0F);
      this.Hood3 = new ModelRenderer(this, 52, 14);
      this.Hood3.addBox(-3.5F, -10.0F, 3.5F, 7, 8, 3);
      this.Hood3.setTextureSize(128, 64);
      this.setRotation(this.Hood3, -0.349066F, 0.0F, 0.0F);
      this.Hood4 = new ModelRenderer(this, 53, 15);
      this.Hood4.addBox(-3.0F, -10.7F, 3.5F, 6, 7, 3);
      this.Hood4.setTextureSize(128, 64);
      this.setRotation(this.Hood4, -0.5759587F, 0.0F, 0.0F);
      this.Chestthing = new ModelRenderer(this, 56, 50);
      this.Chestthing.addBox(-2.5F, 1.0F, -4.0F, 5, 7, 1);
      this.Chestthing.setTextureSize(128, 64);
      this.setRotation(this.Chestthing, 0.0F, 0.0F, 0.0F);
      this.Mbelt = new ModelRenderer(this, 16, 55);
      this.Mbelt.addBox(-4.0F, 7.0F, -3.0F, 8, 5, 1);
      this.Mbelt.setTextureSize(128, 64);
      this.setRotation(this.Mbelt, 0.0F, 0.0F, 0.0F);
      this.ClothchestL = new ModelRenderer(this, 108, 38);
      this.ClothchestL.mirror = true;
      this.ClothchestL.addBox(2.1F, 0.5F, -3.5F, 2, 8, 1);
      this.ClothchestL.setTextureSize(128, 64);
      this.setRotation(this.ClothchestL, 0.0F, 0.0F, 0.0F);
      this.ClothchestR = new ModelRenderer(this, 108, 38);
      this.ClothchestR.addBox(-4.1F, 0.5F, -3.5F, 2, 8, 1);
      this.ClothchestR.setTextureSize(128, 64);
      this.setRotation(this.ClothchestR, 0.0F, 0.0F, 0.0F);
      this.Book = new ModelRenderer(this, 81, 16);
      this.Book.addBox(1.0F, 0.0F, 4.0F, 5, 7, 2);
      this.Book.setTextureSize(128, 64);
      this.setRotation(this.Book, 0.0F, 0.0F, 0.7679449F);
      this.Scroll = new ModelRenderer(this, 78, 25);
      this.Scroll.addBox(-2.0F, 9.5F, 4.0F, 8, 3, 3);
      this.Scroll.setTextureSize(128, 64);
      this.setRotation(this.Scroll, 0.0F, 0.0F, 0.191986F);
      this.BeltR = new ModelRenderer(this, 16, 36);
      this.BeltR.addBox(-5.0F, 4.0F, -3.0F, 1, 3, 6);
      this.BeltR.setTextureSize(128, 64);
      this.setRotation(this.BeltR, 0.0F, 0.0F, 0.0F);
      this.Backplate = new ModelRenderer(this, 36, 45);
      this.Backplate.addBox(-4.0F, 1.0F, 2.0F, 8, 11, 2);
      this.Backplate.setTextureSize(128, 64);
      this.setRotation(this.Backplate, 0.0F, 0.0F, 0.0F);
      this.MbeltL = new ModelRenderer(this, 16, 36);
      this.MbeltL.addBox(4.0F, 8.0F, -3.0F, 1, 3, 6);
      this.MbeltL.setTextureSize(128, 64);
      this.setRotation(this.MbeltL, 0.0F, 0.0F, 0.0F);
      this.MbeltR = new ModelRenderer(this, 16, 36);
      this.MbeltR.addBox(-5.0F, 8.0F, -3.0F, 1, 3, 6);
      this.MbeltR.setTextureSize(128, 64);
      this.setRotation(this.MbeltR, 0.0F, 0.0F, 0.0F);
      this.BeltL = new ModelRenderer(this, 16, 36);
      this.BeltL.addBox(4.0F, 4.0F, -3.0F, 1, 3, 6);
      this.BeltL.setTextureSize(128, 64);
      this.setRotation(this.BeltL, 0.0F, 0.0F, 0.0F);
      this.Chestplate = new ModelRenderer(this, 16, 25);
      this.Chestplate.addBox(-4.0F, 1.0F, -3.0F, 8, 6, 1);
      this.Chestplate.setTextureSize(128, 64);
      this.setRotation(this.Chestplate, 0.0F, 0.0F, 0.0F);
      this.ShoulderplateR1 = new ModelRenderer(this, 56, 33);
      this.ShoulderplateR1.addBox(-4.5F, -1.5F, -3.5F, 1, 4, 7);
      this.ShoulderplateR1.setTextureSize(128, 64);
      this.setRotation(this.ShoulderplateR1, 0.0F, 0.0F, 0.4363323F);
      this.ShoulderplateR2 = new ModelRenderer(this, 40, 33);
      this.ShoulderplateR2.addBox(-3.5F, 1.5F, -3.5F, 1, 3, 7);
      this.ShoulderplateR2.setTextureSize(128, 64);
      this.setRotation(this.ShoulderplateR2, 0.0F, 0.0F, 0.4363323F);
      this.ShoulderplateR3 = new ModelRenderer(this, 40, 33);
      this.ShoulderplateR3.addBox(-2.5F, 3.5F, -3.5F, 1, 3, 7);
      this.ShoulderplateR3.setTextureSize(128, 64);
      this.setRotation(this.ShoulderplateR3, 0.0F, 0.0F, 0.4363323F);
      this.ShoulderplateTopR = new ModelRenderer(this, 56, 25);
      this.ShoulderplateTopR.addBox(-5.5F, -2.5F, -3.5F, 2, 1, 7);
      this.ShoulderplateTopR.setTextureSize(128, 64);
      this.setRotation(this.ShoulderplateTopR, 0.0F, 0.0F, 0.4363323F);
      this.RArm1 = new ModelRenderer(this, 88, 39);
      this.RArm1.addBox(-3.5F, 2.5F, -2.5F, 5, 7, 5);
      this.RArm1.setTextureSize(128, 64);
      this.setRotation(this.RArm1, 0.0F, 0.0F, 0.0F);
      this.RArm2 = new ModelRenderer(this, 76, 32);
      this.RArm2.addBox(-3.0F, 5.5F, 2.5F, 4, 4, 2);
      this.RArm2.setTextureSize(128, 64);
      this.setRotation(this.RArm2, 0.0F, 0.0F, 0.0F);
      this.RArm3 = new ModelRenderer(this, 88, 32);
      this.RArm3.addBox(-2.5F, 3.5F, 2.5F, 3, 2, 1);
      this.RArm3.setTextureSize(128, 64);
      this.setRotation(this.RArm3, 0.0F, 0.0F, 0.0F);
      this.ShoulderplateL1 = new ModelRenderer(this, 56, 33);
      this.ShoulderplateL1.addBox(3.5F, -1.5F, -3.5F, 1, 4, 7);
      this.ShoulderplateL1.setTextureSize(128, 64);
      this.setRotation(this.ShoulderplateL1, 0.0F, 0.0F, -0.4363323F);
      this.ShoulderplateL2 = new ModelRenderer(this, 40, 33);
      this.ShoulderplateL2.addBox(2.5F, 1.5F, -3.5F, 1, 3, 7);
      this.ShoulderplateL2.setTextureSize(128, 64);
      this.setRotation(this.ShoulderplateL2, 0.0F, 0.0F, -0.4363323F);
      this.ShoulderplateL3 = new ModelRenderer(this, 40, 33);
      this.ShoulderplateL3.addBox(1.5F, 3.5F, -3.5F, 1, 3, 7);
      this.ShoulderplateL3.setTextureSize(128, 64);
      this.setRotation(this.ShoulderplateL3, 0.0F, 0.0F, -0.4363323F);
      this.ShoulderplateTopL = new ModelRenderer(this, 56, 25);
      this.ShoulderplateTopL.addBox(3.5F, -2.5F, -3.5F, 2, 1, 7);
      this.ShoulderplateTopL.setTextureSize(128, 64);
      this.setRotation(this.ShoulderplateTopL, 0.0F, 0.0F, -0.4363323F);
      this.ShoulderR = new ModelRenderer(this, 16, 45);
      this.ShoulderR.mirror = true;
      this.ShoulderR.addBox(-3.5F, -2.5F, -2.5F, 5, 5, 5);
      this.ShoulderR.setTextureSize(128, 64);
      this.setRotation(this.ShoulderR, 0.0F, 0.0F, 0.0F);
      this.LArm1 = new ModelRenderer(this, 88, 39);
      this.LArm1.mirror = true;
      this.LArm1.addBox(-1.5F, 2.5F, -2.5F, 5, 7, 5);
      this.LArm1.setTextureSize(128, 64);
      this.setRotation(this.LArm1, 0.0F, 0.0F, 0.0F);
      this.LArm2 = new ModelRenderer(this, 76, 32);
      this.LArm2.addBox(-1.0F, 5.5F, 2.5F, 4, 4, 2);
      this.LArm2.setTextureSize(128, 64);
      this.setRotation(this.LArm2, 0.0F, 0.0F, 0.0F);
      this.LArm3 = new ModelRenderer(this, 88, 32);
      this.LArm3.addBox(-0.5F, 3.5F, 2.5F, 3, 2, 1);
      this.LArm3.setTextureSize(128, 64);
      this.setRotation(this.LArm3, 0.0F, 0.0F, 0.0F);
      this.ShoulderL = new ModelRenderer(this, 16, 45);
      this.ShoulderL.addBox(-1.5F, -2.5F, -2.5F, 5, 5, 5);
      this.ShoulderL.setTextureSize(128, 64);
      this.ShoulderL.mirror = true;
      this.setRotation(this.ShoulderL, 0.0F, 0.0F, 0.0F);
      this.FrontclothR1 = new ModelRenderer(this, 108, 38);
      this.FrontclothR1.addBox(0.0F, 0.0F, 0.0F, 3, 8, 1);
      this.FrontclothR1.setRotationPoint(-3.0F, 11.0F, -3.0F);
      this.FrontclothR1.setTextureSize(128, 64);
      this.setRotation(this.FrontclothR1, -0.10472F, 0.0F, 0.0F);
      this.FrontclothR2 = new ModelRenderer(this, 108, 47);
      this.FrontclothR2.addBox(0.0F, 7.5F, 1.7F, 3, 3, 1);
      this.FrontclothR2.setRotationPoint(-3.0F, 11.0F, -3.0F);
      this.FrontclothR2.setTextureSize(128, 64);
      this.setRotation(this.FrontclothR2, -0.3316126F, 0.0F, 0.0F);
      this.FrontclothL1 = new ModelRenderer(this, 108, 38);
      this.FrontclothL1.mirror = true;
      this.FrontclothL1.addBox(0.0F, 0.0F, 0.0F, 3, 8, 1);
      this.FrontclothL1.setRotationPoint(0.0F, 11.0F, -3.0F);
      this.FrontclothL1.setTextureSize(128, 64);
      this.setRotation(this.FrontclothL1, -0.10472F, 0.0F, 0.0F);
      this.FrontclothL2 = new ModelRenderer(this, 108, 47);
      this.FrontclothL2.mirror = true;
      this.FrontclothL2.addBox(0.0F, 7.5F, 1.7F, 3, 3, 1);
      this.FrontclothL2.setRotationPoint(0.0F, 11.0F, -3.0F);
      this.FrontclothL2.setTextureSize(128, 64);
      this.setRotation(this.FrontclothL2, -0.3316126F, 0.0F, 0.0F);
      this.ClothBackR1 = new ModelRenderer(this, 118, 14);
      this.ClothBackR1.mirror = true;
      this.ClothBackR1.addBox(0.0F, 0.0F, 0.0F, 4, 8, 1);
      this.ClothBackR1.setRotationPoint(-4.0F, 11.5F, 3.0F);
      this.ClothBackR1.setTextureSize(128, 64);
      this.setRotation(this.ClothBackR1, 0.10472F, 0.0F, 0.0F);
      this.ClothBackR2 = new ModelRenderer(this, 123, 9);
      this.ClothBackR2.addBox(0.0F, 7.8F, -0.9F, 1, 2, 1);
      this.ClothBackR2.setRotationPoint(-4.0F, 11.5F, 3.0F);
      this.ClothBackR2.setTextureSize(128, 64);
      this.setRotation(this.ClothBackR2, 0.226893F, 0.0F, 0.0F);
      this.ClothBackR3 = new ModelRenderer(this, 120, 12);
      this.ClothBackR3.mirror = true;
      this.ClothBackR3.addBox(1.0F, 7.8F, -0.9F, 3, 3, 1);
      this.ClothBackR3.setRotationPoint(-4.0F, 11.5F, 3.0F);
      this.ClothBackR3.setTextureSize(128, 64);
      this.setRotation(this.ClothBackR3, 0.226893F, 0.0F, 0.0F);
      this.ClothBackL1 = new ModelRenderer(this, 118, 14);
      this.ClothBackL1.addBox(0.0F, 0.0F, 0.0F, 4, 8, 1);
      this.ClothBackL1.setRotationPoint(0.0F, 11.5F, 3.0F);
      this.ClothBackL1.setTextureSize(128, 64);
      this.setRotation(this.ClothBackL1, 0.10472F, 0.0F, 0.0F);
      this.ClothBackL2 = new ModelRenderer(this, 123, 9);
      this.ClothBackL2.mirror = true;
      this.ClothBackL2.addBox(3.0F, 7.8F, -0.9F, 1, 2, 1);
      this.ClothBackL2.setRotationPoint(0.0F, 11.5F, 3.0F);
      this.ClothBackL2.setTextureSize(128, 64);
      this.setRotation(this.ClothBackL2, 0.226893F, 0.0F, 0.0F);
      this.ClothBackL3 = new ModelRenderer(this, 120, 12);
      this.ClothBackL3.addBox(0.0F, 7.8F, -0.9F, 3, 3, 1);
      this.ClothBackL3.setRotationPoint(0.0F, 11.5F, 3.0F);
      this.ClothBackL3.setTextureSize(128, 64);
      this.setRotation(this.ClothBackL3, 0.226893F, 0.0F, 0.0F);
      this.SideclothL2 = new ModelRenderer(this, 116, 34);
      this.SideclothL2.addBox(0.5F, 5.5F, -2.5F, 1, 3, 5);
      this.SideclothL2.setTextureSize(128, 64);
      this.setRotation(this.SideclothL2, 0.0F, 0.0F, -0.296706F);
      this.SideclothR1 = new ModelRenderer(this, 116, 42);
      this.SideclothR1.addBox(-2.5F, 0.5F, -2.5F, 1, 5, 5);
      this.SideclothR1.setTextureSize(128, 64);
      this.setRotation(this.SideclothR1, 0.0F, 0.0F, 0.122173F);
      this.SideclothR2 = new ModelRenderer(this, 116, 34);
      this.SideclothR2.addBox(-1.5F, 5.5F, -2.5F, 1, 3, 5);
      this.SideclothR2.setTextureSize(128, 64);
      this.setRotation(this.SideclothR2, 0.0F, 0.0F, 0.296706F);
      this.SideclothR3 = new ModelRenderer(this, 116, 1);
      this.SideclothR3.addBox(0.4F, 8.4F, -2.5F, 1, 3, 5);
      this.SideclothR3.setTextureSize(128, 64);
      this.setRotation(this.SideclothR3, 0.0F, 0.0F, 0.5235988F);
      this.SidepanelR1 = new ModelRenderer(this, 116, 25);
      this.SidepanelR1.addBox(-2.5F, 0.5F, -2.5F, 1, 4, 5);
      this.SidepanelR1.setTextureSize(128, 64);
      this.SidepanelR1.mirror = true;
      this.setRotation(this.SidepanelR1, 0.0F, 0.0F, 0.4363323F);
      this.LegpanelR6 = new ModelRenderer(this, 82, 38);
      this.LegpanelR6.addBox(-3.0F, 4.5F, -1.5F, 2, 3, 1);
      this.LegpanelR6.setTextureSize(128, 64);
      this.setRotation(this.LegpanelR6, -0.4363323F, 0.0F, 0.0F);
      this.LegpanelR5 = new ModelRenderer(this, 76, 42);
      this.LegpanelR5.addBox(-3.0F, 2.5F, -2.5F, 2, 3, 1);
      this.LegpanelR5.setTextureSize(128, 64);
      this.setRotation(this.LegpanelR5, -0.4363323F, 0.0F, 0.0F);
      this.LegpanelR4 = new ModelRenderer(this, 76, 38);
      this.LegpanelR4.addBox(-3.0F, 0.5F, -3.5F, 2, 3, 1);
      this.LegpanelR4.setTextureSize(128, 64);
      this.setRotation(this.LegpanelR4, -0.4363323F, 0.0F, 0.0F);
      this.SideclothL3 = new ModelRenderer(this, 116, 1);
      this.SideclothL3.addBox(-1.4F, 8.4F, -2.5F, 1, 3, 5);
      this.SideclothL3.setTextureSize(128, 64);
      this.setRotation(this.SideclothL3, 0.0F, 0.0F, -0.5235988F);
      this.Focipouch = new ModelRenderer(this, 100, 20);
      this.Focipouch.addBox(3.5F, 0.5F, -2.5F, 3, 6, 5);
      this.Focipouch.setTextureSize(128, 64);
      this.setRotation(this.Focipouch, 0.0F, 0.0F, -0.122173F);
      this.SideclothL1 = new ModelRenderer(this, 116, 42);
      this.SideclothL1.addBox(1.5F, 0.5F, -2.5F, 1, 5, 5);
      this.SideclothL1.setTextureSize(128, 64);
      this.setRotation(this.SideclothL1, 0.0F, 0.0F, -0.122173F);
      this.LegpanelL4 = new ModelRenderer(this, 76, 38);
      this.LegpanelL4.mirror = true;
      this.LegpanelL4.addBox(1.0F, 0.5F, -3.5F, 2, 3, 1);
      this.LegpanelL4.setTextureSize(128, 64);
      this.setRotation(this.LegpanelL4, -0.4363323F, 0.0F, 0.0F);
      this.LegpanelL5 = new ModelRenderer(this, 76, 42);
      this.LegpanelL5.mirror = true;
      this.LegpanelL5.addBox(1.0F, 2.5F, -2.5F, 2, 3, 1);
      this.LegpanelL5.setTextureSize(128, 64);
      this.setRotation(this.LegpanelL5, -0.4363323F, 0.0F, 0.0F);
      this.LegpanelL6 = new ModelRenderer(this, 82, 38);
      this.LegpanelL6.mirror = true;
      this.LegpanelL6.addBox(1.0F, 4.5F, -1.5F, 2, 3, 1);
      this.LegpanelL6.setTextureSize(128, 64);
      this.setRotation(this.LegpanelL6, -0.4363323F, 0.0F, 0.0F);
      this.SidepanelL1 = new ModelRenderer(this, 116, 25);
      this.SidepanelL1.addBox(1.5F, 0.5F, -2.5F, 1, 4, 5);
      this.SidepanelL1.setTextureSize(128, 64);
      this.setRotation(this.SidepanelL1, 0.0F, 0.0F, -0.4363323F);
      super.bipedHeadwear.cubeList.clear();
      super.bipedHead.cubeList.clear();
      super.bipedHead.addChild(this.Hood1);
      super.bipedHead.addChild(this.Hood2);
      super.bipedHead.addChild(this.Hood3);
      super.bipedHead.addChild(this.Hood4);
      super.bipedBody.cubeList.clear();
      super.bipedRightLeg.cubeList.clear();
      super.bipedLeftLeg.cubeList.clear();
      if(f < 1.0F) {
         super.bipedBody.addChild(this.Mbelt);
         super.bipedBody.addChild(this.MbeltL);
         super.bipedBody.addChild(this.MbeltR);
         super.bipedLeftLeg.addChild(this.Focipouch);
      } else {
         super.bipedBody.addChild(this.BeltR);
         super.bipedBody.addChild(this.BeltL);
         super.bipedBody.addChild(this.Chestplate);
         super.bipedBody.addChild(this.Chestthing);
         super.bipedBody.addChild(this.Scroll);
         super.bipedBody.addChild(this.Backplate);
         super.bipedBody.addChild(this.Book);
         super.bipedBody.addChild(this.ClothchestL);
         super.bipedBody.addChild(this.ClothchestR);
         super.bipedBody.addChild(this.FrontclothR1);
         super.bipedBody.addChild(this.FrontclothR2);
         super.bipedBody.addChild(this.FrontclothL1);
         super.bipedBody.addChild(this.FrontclothL2);
         super.bipedBody.addChild(this.ClothBackR1);
         super.bipedBody.addChild(this.ClothBackR2);
         super.bipedBody.addChild(this.ClothBackR3);
         super.bipedBody.addChild(this.ClothBackL1);
         super.bipedBody.addChild(this.ClothBackL2);
         super.bipedBody.addChild(this.ClothBackL3);
      }

      super.bipedRightArm.cubeList.clear();
      super.bipedRightArm.addChild(this.ShoulderR);
      super.bipedRightArm.addChild(this.RArm1);
      super.bipedRightArm.addChild(this.RArm2);
      super.bipedRightArm.addChild(this.RArm3);
      super.bipedRightArm.addChild(this.ShoulderplateTopR);
      super.bipedRightArm.addChild(this.ShoulderplateR1);
      super.bipedRightArm.addChild(this.ShoulderplateR2);
      super.bipedRightArm.addChild(this.ShoulderplateR3);
      super.bipedLeftArm.cubeList.clear();
      super.bipedLeftArm.addChild(this.ShoulderL);
      super.bipedLeftArm.addChild(this.LArm1);
      super.bipedLeftArm.addChild(this.LArm2);
      super.bipedLeftArm.addChild(this.LArm3);
      super.bipedLeftArm.addChild(this.ShoulderplateTopL);
      super.bipedLeftArm.addChild(this.ShoulderplateL1);
      super.bipedLeftArm.addChild(this.ShoulderplateL2);
      super.bipedLeftArm.addChild(this.ShoulderplateL3);
      super.bipedRightLeg.addChild(this.LegpanelR4);
      super.bipedRightLeg.addChild(this.LegpanelR5);
      super.bipedRightLeg.addChild(this.LegpanelR6);
      super.bipedRightLeg.addChild(this.SidepanelR1);
      super.bipedRightLeg.addChild(this.SideclothR1);
      super.bipedRightLeg.addChild(this.SideclothR2);
      super.bipedRightLeg.addChild(this.SideclothR3);
      super.bipedLeftLeg.addChild(this.LegpanelL4);
      super.bipedLeftLeg.addChild(this.LegpanelL5);
      super.bipedLeftLeg.addChild(this.LegpanelL6);
      super.bipedLeftLeg.addChild(this.SidepanelL1);
      super.bipedLeftLeg.addChild(this.SideclothL1);
      super.bipedLeftLeg.addChild(this.SideclothL2);
      super.bipedLeftLeg.addChild(this.SideclothL3);
   }

   public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
      super.render(entity, f, f1, f2, f3, f4, f5);
      if(!(entity instanceof EntitySkeleton) && !(entity instanceof EntityZombie)) {
         this.setRotationAngles(f, f1, f2, f3, f4, f5, entity);
      } else {
         this.setRotationAnglesZombie(f, f1, f2, f3, f4, f5, entity);
      }

      float a = MathHelper.cos(f * 0.6662F) * 1.4F * f1;
      float b = MathHelper.cos(f * 0.6662F + 3.141593F) * 1.4F * f1;
      float c = Math.min(a, b);
      this.FrontclothR1.rotateAngleX = this.FrontclothL1.rotateAngleX = c - 0.10472F;
      this.FrontclothR2.rotateAngleX = this.FrontclothL2.rotateAngleX = c - 0.3316126F;
      this.ClothBackR1.rotateAngleX = this.ClothBackL1.rotateAngleX = -c + 0.10472F;
      this.ClothBackR2.rotateAngleX = this.ClothBackL2.rotateAngleX = this.ClothBackR3.rotateAngleX = this.ClothBackL3.rotateAngleX = -c + 0.226893F;
      if(super.isChild) {
         float f6 = 2.0F;
         GL11.glPushMatrix();
         GL11.glScalef(1.5F / f6, 1.5F / f6, 1.5F / f6);
         GL11.glTranslatef(0.0F, 16.0F * f5, 0.0F);
         super.bipedHead.render(f5);
         GL11.glPopMatrix();
         GL11.glPushMatrix();
         GL11.glScalef(1.0F / f6, 1.0F / f6, 1.0F / f6);
         GL11.glTranslatef(0.0F, 24.0F * f5, 0.0F);
         super.bipedBody.render(f5);
         super.bipedRightArm.render(f5);
         super.bipedLeftArm.render(f5);
         super.bipedRightLeg.render(f5);
         super.bipedLeftLeg.render(f5);
         super.bipedHeadwear.render(f5);
         GL11.glPopMatrix();
      } else {
         GL11.glPushMatrix();
         GL11.glScalef(1.01F, 1.01F, 1.01F);
         super.bipedHead.render(f5);
         GL11.glPopMatrix();
         super.bipedBody.render(f5);
         super.bipedRightArm.render(f5);
         super.bipedLeftArm.render(f5);
         super.bipedRightLeg.render(f5);
         super.bipedLeftLeg.render(f5);
         super.bipedHeadwear.render(f5);
      }

   }

   private void setRotation(ModelRenderer model, float x, float y, float z) {
      model.rotateAngleX = x;
      model.rotateAngleY = y;
      model.rotateAngleZ = z;
   }

   public void setRotationAnglesZombie(float p_78087_1_, float p_78087_2_, float p_78087_3_, float p_78087_4_, float p_78087_5_, float p_78087_6_, Entity p_78087_7_) {
      super.setRotationAngles(p_78087_1_, p_78087_2_, p_78087_3_, p_78087_4_, p_78087_5_, p_78087_6_, p_78087_7_);
      float f6 = MathHelper.sin(super.onGround * 3.141593F);
      float f7 = MathHelper.sin((1.0F - (1.0F - super.onGround) * (1.0F - super.onGround)) * 3.141593F);
      super.bipedRightArm.rotateAngleZ = 0.0F;
      super.bipedLeftArm.rotateAngleZ = 0.0F;
      super.bipedRightArm.rotateAngleY = -(0.1F - f6 * 0.6F);
      super.bipedLeftArm.rotateAngleY = 0.1F - f6 * 0.6F;
      super.bipedRightArm.rotateAngleX = -1.570796F;
      super.bipedLeftArm.rotateAngleX = -1.570796F;
      super.bipedRightArm.rotateAngleX -= f6 * 1.2F - f7 * 0.4F;
      super.bipedLeftArm.rotateAngleX -= f6 * 1.2F - f7 * 0.4F;
      super.bipedRightArm.rotateAngleZ += MathHelper.cos(p_78087_3_ * 0.09F) * 0.05F + 0.05F;
      super.bipedLeftArm.rotateAngleZ -= MathHelper.cos(p_78087_3_ * 0.09F) * 0.05F + 0.05F;
      super.bipedRightArm.rotateAngleX += MathHelper.sin(p_78087_3_ * 0.067F) * 0.05F;
      super.bipedLeftArm.rotateAngleX -= MathHelper.sin(p_78087_3_ * 0.067F) * 0.05F;
   }
}
