package mod.gravitycraft.core;

import com.google.common.collect.Sets;
import cpw.mods.fml.common.FMLLog;
import cpw.mods.fml.common.MissingModsException;
import cpw.mods.fml.common.versioning.ArtifactVersion;
import cpw.mods.fml.common.versioning.DefaultArtifactVersion;
import cpw.mods.fml.relauncher.IFMLLoadingPlugin;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Map;
import java.util.Set;

/**
 * @author diesieben07
 */
@IFMLLoadingPlugin.Name(value = GravityCraftCoreLoader.NAME)
@IFMLLoadingPlugin.MCVersion(value = "1.7.10")
@IFMLLoadingPlugin.TransformerExclusions(value = {"ivorius.gravitycraft.core.", "ivorius.ivtoolkit.asm."})
@IFMLLoadingPlugin.SortingIndex(value = 1001)
public final class GravityCraftCoreLoader implements IFMLLoadingPlugin
{
    public static final String MODID = "gravitycraftcore";
    public static final String NAME = "GravityCraft Core";

    public static Logger logger = LogManager.getLogger(MODID);

	@Override
	public String[] getASMTransformerClass()
    {
        requireClass("ivorius.ivtoolkit.asm.IvClassTransformerManager", new DefaultArtifactVersion("ivtoolkit", true), MODID, NAME);
        return new String[]{GravityCraftClassTransformer.class.getName()};
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

    public static void requireClass(String classname, ArtifactVersion artifactVersion, String modID, String modName)
    {
        try
        {
            Class.forName(classname);
        }
        catch (ClassNotFoundException e)
        {
            FMLLog.severe("The mod %s (%s) requires mods %s to be available", modID, modName, artifactVersion.getLabel());
            Set<ArtifactVersion> versionMissingMods = Sets.newHashSet();
            versionMissingMods.add(artifactVersion);
            throw new MissingModsException(versionMissingMods);
        }
    }
}
