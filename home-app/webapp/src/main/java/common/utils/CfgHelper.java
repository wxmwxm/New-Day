package common.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.net.URI;
import java.util.Properties;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class CfgHelper {

	private static Logger log = LoggerFactory.getLogger(CfgHelper.class);

	private static final String CONF_FILE_NAME = "config.properties";

	private static final int REFRESH_TIME = 10 * 60 * 1000;

	private static URI confFileFullName = null;

	private static Properties props = null;
	private static CfgHelper me = null;
	private static long readFileTime = 0L;
	private static long lastModefyTime = 0L;

	/**
	 * 获取CfgHelper实例
	 */
	public synchronized static CfgHelper getInstance() {
		if (me == null) {
			me = new CfgHelper();
		} else if (me != null
				&& System.currentTimeMillis() - readFileTime > REFRESH_TIME) {
			me.refreshConfigure();
		}
		return me;

	}

	private CfgHelper() {
		refreshConfigure();
	}

	/**
	 * 重新装载配置
	 */
	public void refreshConfigure() {
		try {
			getConfFile();
			File f = new File(confFileFullName);
			if (props == null
					|| (f.exists() && f.lastModified() != lastModefyTime)) {
				reloadFile(f);
			}
		} catch (Exception e) {
			log.error("", e);
			// e.printStackTrace();
		}

		readFileTime = System.currentTimeMillis();
	}

	/**
	 * 重新加载文件
	 */
	private void reloadFile(File f) throws FileNotFoundException, IOException {
		InputStream is = new FileInputStream(f);
		props = new Properties();
		props.load(is);
		lastModefyTime = f.lastModified();
	}

	/**
	 * 获取配置文件的路径
	 */
	private void getConfFile() {
		try {
			confFileFullName = this.getClass().getClassLoader()
					.getResource(CONF_FILE_NAME).toURI();
		} catch (Exception e) {
			log.error("", e);
			// e.printStackTrace();
		}
	}

	/*
	 * 如配置文件中无对应键值, 则返回空串
	 */
	public String getCfg(String key) {

		String prop = props.getProperty(key);
		if (prop == null) {
			log.error("No property with key=[" + key + "] in config file="
					+ CONF_FILE_NAME);
			return "";
		}

		return prop;
	}

}
