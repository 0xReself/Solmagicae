package io.github.reself.solmagicae.util;

import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;

public class Reference {
	public static final String MODID = "solmagicae";
	public static final String NAME = "SolMagicae";
	public static final String VERSION = "0.1";
	public static final String ACCEPTED_VERSIONS = "[1.12.2]";
	public static final String CLIENT_PROXY_CLASS = "io.github.reself.solmagicae.proxy.ClientProxy";
	public static final String COMMON_PROXY_CLASS = "io.github.reself.solmagicae.proxy.CommonProxy";
	
	public static final Logger LOGGER = LogManager.getLogger(Reference.MODID);
}
