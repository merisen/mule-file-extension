package com.softserveinc.mule.fce;

import org.mule.runtime.extension.api.annotation.Operations;
import org.mule.runtime.extension.api.annotation.param.Optional;
import org.mule.runtime.extension.api.annotation.param.Parameter;
import org.mule.runtime.extension.api.annotation.param.display.DisplayName;
import org.mule.runtime.extension.api.annotation.param.display.Example;

/**
 * This class represents an extension configuration, values set in this class
 * are commonly used across multiple operations since they represent something
 * core from the extension.
 */
@Operations(FCEOperations.class)
public class FCEConfiguration {
	@DisplayName("Config ID")
	@Parameter
	@Optional()
	public int configId;
	
	@DisplayName("FTP Host Name")
	@Parameter
	@Optional()
	public String ftpName;
	
	@DisplayName("FTP Host Port")
	@Parameter
	@Optional(defaultValue = "21")
	public int ftpPort;
	
	@DisplayName("FTP User")
	@Parameter
	@Optional()
	public String ftpUser;
	
	@DisplayName("FTP Password")
	@Parameter
	@Optional()
	public String ftpPassword;
	
	@DisplayName("FTP Working Directory")
	@Parameter
	@Optional()
	@Example("/home/")
	public String ftpWorkingDir;
	
	@DisplayName("Local Validate Working Directory")
	@Parameter
	@Optional()
	@Example("C:\\Users\\user\\Directory")
	public String localWorkingDir;
}
