package mod.gravitycraft.core;

import cpw.mods.fml.relauncher.IFMLLoadingPlugin;

import java.util.Map;

/**
 * @author diesieben07
 */
@IFMLLoadingPlugin.Name(value = GravityCraftCoreLoader.NAME)
@IFMLLoadingPlugin.MCVersion(value = "1.7.10")
@IFMLLoadingPlugin.TransformerExclusions(value = {"ivorius.gravitycraft.core.", "ivorius.ivtoolkit.asm."})
@IFMLLoadingPlugin.SortingIndex(value = 0)
public final class GravityCraftCoreLoader implements IFMLLoadingPlugin
{
    public static final String MODID = "gravitycraftcore";
    public static final String NAME = "GravityCraft Core";

	@Override
	public String[] getASMTransformerClass() {
		return null;
	}

	@Override
	public String getModContainerClass() {
		return GravityCraftCore.CLASS_NAME;
	}

	@Override
	public String getSetupClass() {
		return null;
	}

	@Override
	public void injectData(Map<String, Object> data) { }

	@Override
	public String getAccessTransformerClass() {
		return null;
	}
}
