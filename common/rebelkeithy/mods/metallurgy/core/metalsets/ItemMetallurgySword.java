package rebelkeithy.mods.metallurgy.core.metalsets;

import java.util.ArrayList;
import java.util.List;

import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.EnumToolMaterial;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemSword;

public class ItemMetallurgySword extends ItemSword 
{
    private List<ISwordHitListener> hlList = new ArrayList<ISwordHitListener>();
    String subText;
	
	public ItemMetallurgySword(int par1, EnumToolMaterial par2EnumToolMaterial) 
	{
		super(par1, par2EnumToolMaterial);
	}
	
    public ItemMetallurgySword setTextureName(String par1Str)
    {
        super.func_111206_d(par1Str);
        return this;
    }

    public void addHitListener(ISwordHitListener hl)
    {
    	hlList.add(hl);
    }
    
    @Override
    public boolean hitEntity(ItemStack par1ItemStack, EntityLivingBase par2EntityLivingBase, EntityLivingBase par3EntityLivingBase)
    {
    	for(ISwordHitListener hl : hlList)
    		hl.hitEntity(par1ItemStack, par2EntityLivingBase, par3EntityLivingBase);
    	
        
        return super.hitEntity(par1ItemStack, par2EntityLivingBase, par3EntityLivingBase);
    }
    
    public void setSubText(String text)
    {
    	subText = text;
    }

    @Override
    public void addInformation(ItemStack par1ItemStack, EntityPlayer par2EntityPlayer, List par3List, boolean par4)
    {
    	if(subText != null)
    	{
    		for(String string : subText.split("-"))
    			par3List.add("\u00A7" + string);
    	}
    }
}
