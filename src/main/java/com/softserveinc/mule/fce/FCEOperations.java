package com.softserveinc.mule.fce;

import static org.mule.runtime.extension.api.annotation.param.MediaType.ANY;
import static org.mule.runtime.extension.api.annotation.param.display.Placement.CONNECTION_TAB;

import java.io.IOException;

import org.mule.runtime.extension.api.annotation.Alias;
import org.mule.runtime.extension.api.annotation.param.Config;
import org.mule.runtime.extension.api.annotation.param.MediaType;
import org.mule.runtime.extension.api.annotation.param.Optional;
import org.mule.runtime.extension.api.annotation.param.display.DisplayName;
import org.mule.runtime.extension.api.annotation.param.display.Example;
import org.mule.runtime.extension.api.annotation.param.display.Placement;
import org.mule.runtime.extension.api.annotation.param.display.Summary;

import com.softserveinc.mule.fce.command.LocalFileValidatorCommand;
import com.softserveinc.mule.fce.command.RemoteFileValidatorCommand;

/**
 * This class is a container for operations, every public method in this class
 * will be taken as an extension operation.
 */
public class FCEOperations {
	private static final LocalFileValidatorCommand FLVC = new LocalFileValidatorCommand();
	private static final RemoteFileValidatorCommand RFVC = new RemoteFileValidatorCommand();
	
	@Summary("Check if file exist in selected directory")
	@MediaType(value = ANY, strict = false)
	@Alias("LocalFileValidation")
	public String localFileValidation(
			@Config FCEConfiguration config,
			@Example("C:\\Users\\") 
			@DisplayName("Local Path") 
			@Summary("Local directory path") String localAbsolutePath,
			@Example("file.txt") 
			@DisplayName("File Name") 
			@Summary("File name") String fileName) {
		return FLVC.localFileValidateOperation(localAbsolutePath, fileName);
	}

	@Summary("Check if file exist in selected directory")
	@MediaType(value = ANY, strict = false)
	@Alias("RemoteFileValidation")
	public String remoteFileValidation(
			@Config FCEConfiguration config,
			@DisplayName("Use configuration")
			@Optional(defaultValue = "false")
			@Summary("Configuration") boolean isConfig,
			@Example("org.mule.ftp") 
			@DisplayName("FTP Host")
			@Placement(tab = CONNECTION_TAB)
			@Optional()
			@Summary("FTP Host Name") String host,
			@Example("21") 
			@DisplayName("FTP Port")
			@Placement(tab = CONNECTION_TAB)
			@Optional()
			@Summary("FTP Host Port") int port,
			@Example("mule") 
			@DisplayName("User Name")
			@Placement(tab = CONNECTION_TAB)
			@Optional()
			@Summary("FTP Host User Name") String username,
			@Example("strongpassword") 
			@DisplayName("FTP Password")
			@Placement(tab = CONNECTION_TAB)
			@Optional()
			@Summary("FTP Host Password") String password,
			@Example("/home/") 
			@DisplayName("Remote Path") 
			@Placement(tab = CONNECTION_TAB)
			@Optional()
			@Summary("Remote directory path") String remoteAbsolutePath,
			@Example("file.txt") 
			@DisplayName("File Name") 
			@Summary("File name") String fileName) throws IOException {
		return RFVC.remoteFileValidateOperation(config, isConfig, host, port, username, password, remoteAbsolutePath, fileName);
	}
}
