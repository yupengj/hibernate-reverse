package com.gantang.generatecode.config;

/**
 * DataSource 配置
 * 
 * @author jyp10@foxmail.com
 *
 */
public final class DataSourceConfig {

	private static String DEIVATE_KEY = "datasource.driverClassName";
	private static String URL_KEY = "datasource.url";
	private static String USER_NAME_KEY = "datasource.username";
	private static String PASSWORD_KEY = "datasource.password";

	private static DataSourceConfig DATA_SOURCE_COFIG = new DataSourceConfig();

	private String driver;
	private String url;
	private String userName;
	private String password;

	private DataSourceConfig() {
		this.driver = Config.getValue(DEIVATE_KEY);
		if (this.driver == null) {
			throw new RuntimeException(getMsg(DEIVATE_KEY));
		}
		this.url = Config.getValue(URL_KEY);
		if (this.url == null) {
			throw new RuntimeException(getMsg(URL_KEY));
		}
		this.userName = Config.getValue(USER_NAME_KEY);
		if (this.userName == null) {
			throw new RuntimeException(getMsg(USER_NAME_KEY));
		}
		this.password = Config.getValue(PASSWORD_KEY);
		if (this.password == null) {
			throw new RuntimeException(getMsg(PASSWORD_KEY));
		}
	}

	/**
	 * 创建 DataSourceConfig
	 * 
	 * @return DataSourceConfig
	 */
	public static DataSourceConfig newInstance() {
		return DATA_SOURCE_COFIG;
	}

	/**
	 * 异常提示信息
	 * 
	 * @param key key
	 * @return mess
	 */
	private String getMsg(String key) {
		return "参数 " + key + " 缺少值";
	}

	public String getDriver() {
		return driver;
	}

	public void setDriver(String driver) {
		this.driver = driver;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "DataSource [driver=" + driver + ", url=" + url + ", userName=" + userName + ", password=" + password + "]";
	}

}
