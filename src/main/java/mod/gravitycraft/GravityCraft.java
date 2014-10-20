package mod.gravitycraft;

import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import org.apache.logging.log4j.Logger;

/**
 * Created by lukas on 20.10.14.
 */
@Mod(modid = GravityCraft.MODID, version = GravityCraft.VERSION, name = GravityCraft.NAME)
public class GravityCraft
{
    public static final String MODID = "gravitycraft";
    public static final String NAME = "GravityCraft";
    public static final String VERSION = "0.1-pre-alpha";

    @Mod.Instance(value = "gravitycraft")
    public static GravityCraft instance;

    @SidedProxy(clientSide = "mod.gravitycraft.client.GCClientProxy", serverSide = "mod.gravitycraft.server.GCServerProxy")
    public static GCProxy proxy;

    public static Logger logger;

    @Mod.EventHandler
    public void preInit(FMLPreInitializationEvent event)
    {
        logger = event.getModLog();

        GCRegistryHandler.preInit();
    }
}
