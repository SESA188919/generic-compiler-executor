package org.ow2.mind.ctools.ccs_v5;

import java.util.ArrayList;
import java.util.List;

import org.ow2.mind.cli.CommandLine;
import org.ow2.mind.ctools.CompilerExecutor;
import org.ow2.mind.ctools.CompilerExecutorLauncher;

public class Ccsv5CompilerExecutor extends org.ow2.mind.ctools.AbstractExecutor implements CompilerExecutor {
	public void preprocess(CommandLine cmdLine) {
		if (CompilerExecutorLauncher.dependencyFileOpt.getValue(cmdLine)!=null) {
			List<String> cmdDependency = new ArrayList<String>();
			// YTE todo : use the variable in order to get the compiler name
			if (CompilerExecutorLauncher.executableOpt.getValue(cmdLine)==null) {
				cmdDependency.add("cl2000");
			} else {
				cmdDependency.add(CompilerExecutorLauncher.executableOpt.getValue(cmdLine));
			}
			cmdDependency.add(CompilerExecutorLauncher.inputFileOpt.getValue(cmdLine));
			if (CompilerExecutorLauncher.flagsOpt.getValue(cmdLine)!=null) {
				for (String f : CompilerExecutorLauncher.flagsOpt.getValue(cmdLine).split(" ")){
					cmdDependency.add(f);
				}
			}
			if (CompilerExecutorLauncher.defineOpt.getValue(cmdLine)!=null) {
				for (String def : CompilerExecutorLauncher.defineOpt.getValue(cmdLine).split(" ")) {
					cmdDependency.add( "-D" + def );
				}
			}
			if (CompilerExecutorLauncher.includeDirOpt.getValue(cmdLine)!=null) {
				for (String dir : CompilerExecutorLauncher.includeDirOpt.getValue(cmdLine).split(" ") ){
					cmdDependency.add( "-I" + dir );
				}
			}
			cmdDependency.add("-I.");
			if (CompilerExecutorLauncher.preIncludeFileOpt.getValue(cmdLine)!=null) {
				for (String inc : CompilerExecutorLauncher.preIncludeFileOpt.getValue(cmdLine).split(" ") ){
					cmdDependency.add("--preinclude");
					cmdDependency.add( inc );
				}
			}
			cmdDependency.add("-ppd="+CompilerExecutorLauncher.dependencyFileOpt.getValue(cmdLine));
			cmdDependency.add("-eo=.o");
			String[] strs = (String[]) cmdDependency.toArray(new String[cmdDependency.size()]);
			int ret = exec(strs);
			if (ret < 0) System.exit(ret);
		}
		
		List<String> cmdPreprocess = new ArrayList<String>();
		if (CompilerExecutorLauncher.executableOpt.getValue(cmdLine)==null) {
			cmdPreprocess.add("cl2000");
		} else {
			cmdPreprocess.add(CompilerExecutorLauncher.executableOpt.getValue(cmdLine));
		}
		cmdPreprocess.add(CompilerExecutorLauncher.inputFileOpt.getValue(cmdLine));
		if (CompilerExecutorLauncher.flagsOpt.getValue(cmdLine)!=null) {
			for (String f : CompilerExecutorLauncher.flagsOpt.getValue(cmdLine).split(" ")){
				cmdPreprocess.add(f);
			}
		}
		if (CompilerExecutorLauncher.defineOpt.getValue(cmdLine)!=null) {
			for (String def : CompilerExecutorLauncher.defineOpt.getValue(cmdLine).split(" ")) {
				cmdPreprocess.add( "-D" + def );
			}
		}
		if (CompilerExecutorLauncher.includeDirOpt.getValue(cmdLine)!=null) {
			for (String dir : CompilerExecutorLauncher.includeDirOpt.getValue(cmdLine).split(" ") ){
				cmdPreprocess.add( "-I" + dir );
			}
		}
		cmdPreprocess.add("-I.");
		if (CompilerExecutorLauncher.preIncludeFileOpt.getValue(cmdLine)!=null) {
			for (String inc : CompilerExecutorLauncher.preIncludeFileOpt.getValue(cmdLine).split(" ") ){
				cmdPreprocess.add("--preinclude");
				cmdPreprocess.add( inc );
			}
		}
		cmdPreprocess.add("-ppl");
		cmdPreprocess.add("--output_file="+CompilerExecutorLauncher.outputFileOpt.getValue(cmdLine));
		String[] strs = (String[]) cmdPreprocess.toArray(new String[cmdPreprocess.size()]);
		System.exit(exec(strs));
	}

	public void compile(CommandLine cmdLine) {
		List<String> cmd = new ArrayList<String>();
		if (CompilerExecutorLauncher.executableOpt.getValue(cmdLine)==null) {
			cmd.add("cl2000");
		} else {
			cmd.add(CompilerExecutorLauncher.executableOpt.getValue(cmdLine));
		}
		cmd.add("-c");
		cmd.add(CompilerExecutorLauncher.inputFileOpt.getValue(cmdLine));
		if (CompilerExecutorLauncher.flagsOpt.getValue(cmdLine)!=null) {
			for (String f : CompilerExecutorLauncher.flagsOpt.getValue(cmdLine).split(" ")){
				cmd.add(f);
			}
		}
		if (CompilerExecutorLauncher.defineOpt.getValue(cmdLine)!=null) {
			for (String def : CompilerExecutorLauncher.defineOpt.getValue(cmdLine).split(" ")) {
				cmd.add( "-D" + def );
			}
		}
		if (CompilerExecutorLauncher.includeDirOpt.getValue(cmdLine)!=null) {
			for (String dir : CompilerExecutorLauncher.includeDirOpt.getValue(cmdLine).split(" ") ){
				cmd.add( "-I" + dir );
			}
		}
		cmd.add("-I.");
		if (CompilerExecutorLauncher.preIncludeFileOpt.getValue(cmdLine)!=null) {
			for (String inc : CompilerExecutorLauncher.preIncludeFileOpt.getValue(cmdLine).split(" ") ){
				cmd.add("--preinclude");
				cmd.add( inc );
			}
		}
		if (CompilerExecutorLauncher.dependencyFileOpt.getValue(cmdLine)!=null) {
			cmd.add("-ppd="+CompilerExecutorLauncher.dependencyFileOpt.getValue(cmdLine));
		}
		cmd.add("--output_file="+CompilerExecutorLauncher.outputFileOpt.getValue(cmdLine));
		String[] strs = (String[]) cmd.toArray(new String[cmd.size()]);
		System.exit(exec(strs));	
	}
}
