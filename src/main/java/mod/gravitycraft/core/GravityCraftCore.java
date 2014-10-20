package mod.gravitycraft.core;

import com.google.common.collect.ImmutableList;
import com.google.common.eventbus.EventBus;
import cpw.mods.fml.common.DummyModContainer;
import cpw.mods.fml.common.LoadController;
import cpw.mods.fml.common.ModMetadata;

/**
 * @author diesieben07
 */
public class GravityCraftCore extends DummyModContainer {

	public static final String CLASS_NAME = "mod.gravitycraft.core.GravityCraftCore";

	public GravityCraftCore() {
		super(new ModMetadata());
		ModMetadata md = getMetadata();
		md.modId = GravityCraftCoreLoader.MODID;
		md.name = GravityCraftCoreLoader.NAME;
		md.version = "0.1-pre-alpha";
		md.authorList = ImmutableList.of("Ivorius", "Ieuan", "diesieben07", "???");
		md.autogenerated = false;
	}

	@Override
	public boolean registerBus(EventBus bus, LoadController controller) {
		return true;
	}
}