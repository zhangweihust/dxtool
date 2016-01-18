package com.android.dx.command;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.commons.io.FileUtils;

import com.android.dx.command.dexer.Main.Arguments;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class LogHelper {
    public static void dumpArgs(String tag, String[] args) throws IOException{
		File file = new File("D:\\android\\android-sdk-windows\\build-tools\\21.1.1\\lib\\dx_run.log");
		Date d = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("YYYY-mm-dd HH:MM:SS");
		
		System.err.println("Path:" + file.getAbsolutePath());
		
		FileUtils.writeStringToFile(file, "\n --- call at:" + sdf.format(d) + "----tag:" + tag + "----\n", true);
		
		if(args.length>0){
			List<String> argsList = new ArrayList<String>();
			StringBuilder sb = new StringBuilder();
			for(String arg : args){
				argsList.add(arg);
				sb.append("args:" + arg + ", ");
			}
//			System.err.println("args:" + sb.toString());
	        DxConsole.out.println(tag + ", args:" + sb.toString());
			FileUtils.writeLines(file, argsList, true);
		}else{
			
	        DxConsole.out.println(tag + ", args: null" );
			FileUtils.writeStringToFile(file, "call at:" + sdf.format(d) + "\n", true);
			FileUtils.writeStringToFile(file, "args is null\n", true);
		}
    }

	public static void dumpArguments(String tag, Arguments arguments) {
		// TODO Auto-generated method stub
//		GsonBuilder sb = new GsonBuilder();
//		Gson gson = sb.setPrettyPrinting().create();
		String dataStr = "dumpArguments - " + tag + 
				", arguments.debug:"  + arguments.debug + 
				", arguments.verbose:" + arguments.verbose + 
				", arguments.verboseDump:" + arguments.verboseDump + 
				", arguments.coreLibrary:" + arguments.coreLibrary + 
				", arguments.methodToDump:" + arguments.methodToDump + 
				", arguments.dumpWidth:" + arguments.dumpWidth + 
				", arguments.outName:" + arguments.outName + 
				", arguments.humanOutName:" + arguments.humanOutName + 
				", arguments.strictNameCheck:" + arguments.strictNameCheck + 
				", arguments.emptyOk:" + arguments.emptyOk + 
				", arguments.jarOutput:" + arguments.jarOutput + 
				", arguments.keepClassesInJar:" + arguments.keepClassesInJar + 
				", arguments.targetApiLevel:" + arguments.targetApiLevel + 
				", arguments.positionInfo:" + arguments.positionInfo + 
				", arguments.localInfo:" + arguments.localInfo + 
				", arguments.incremental:" + arguments.incremental + 
				", arguments.forceJumbo:" + arguments.forceJumbo + 
				", arguments.fileNames:" + arguments.fileNames + 
				", arguments.optimize:" + arguments.optimize + 
				", arguments.optimizeListFile:" + arguments.optimizeListFile + 
				", arguments.dontOptimizeListFile:" + arguments.dontOptimizeListFile + 
				", arguments.cfOptions:" + arguments.cfOptions + //==null?"null":arguments.cfOptions.toString() + 
				", arguments.dexOptions:" + arguments.dexOptions;//==null?"null":arguments.dexOptions.toString()
				
		DxConsole.out.println(dataStr);
		System.out.println(dataStr);
		
		
	}
}
