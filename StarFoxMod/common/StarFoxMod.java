package alphacentauri17.StarFoxMod.common;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.Init;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.Mod.PreInit;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.network.NetworkMod;
import cpw.mods.fml.common.network.NetworkRegistry;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;
import cpw.mods.fml.common.network.NetworkMod.SidedPacketHandler;
import cpw.mods.fml.common.SidedProxy;
import alphacentauri17.FrozenMod.common.items.ItemDisk;
import alphacentauri17.StarFoxMod.common.StarFoxModCommonProxy;
import alphacentauri17.StarFoxMod.common.handlers.StarFoxModClientPacketHandler;
import alphacentauri17.StarFoxMod.common.handlers.StarFoxModServerPacketHandler;
import alphacentauri17.StarFoxMod.common.items.ItemBlaster;

@NetworkMod(clientSideRequired=true,serverSideRequired=true, //Whether client side and server side are needed
clientPacketHandlerSpec = @SidedPacketHandler(channels = {"StarFoxMod"}, packetHandler = StarFoxModClientPacketHandler.class), //For clientside packet handling
serverPacketHandlerSpec = @SidedPacketHandler(channels = {"StarFoxMod"}, packetHandler = StarFoxModServerPacketHandler.class)) //For serverside packet handling

//MOD BASICS
@Mod(modid="StarFoxMod",name="StarFox Mod",version="Release")

public class StarFoxMod {

@Instance("StarFoxMod") //The instance, this is very important later on
public static StarFoxMod instance = new StarFoxMod();

@SidedProxy(clientSide = "alphacentauri17.StarFoxMod.client.StarFoxModClientProxy", serverSide = "alphacentauri17.StarFoxMod.common.StarFoxModCommonProxy") //Tells Forge the location of your proxies
public static StarFoxModCommonProxy proxy;

//ITEMS
public static Item Blaster;

@PreInit
public void PreInit(FMLPreInitializationEvent e){
	
//ITEMS
Blaster = new ItemBlaster(6900).setUnlocalizedName("Blaster").setCreativeTab(CreativeTabs.tabCombat);
}

@Init
public void InitTutorialMod(FMLInitializationEvent event){ //Your main initialization method

//ITEMS (Method)
proxy.registerItems();	
	
//MULTIPLAYER ABILITY
NetworkRegistry.instance().registerGuiHandler(this, proxy); //Registers the class that deals with GUI data

}
}
