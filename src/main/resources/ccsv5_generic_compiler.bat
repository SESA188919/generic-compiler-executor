@echo off

@REM CCS V5 compiler invocation.

setlocal
set MIND_LIB=%MIND_ROOT%/lib
set MIND_EXT=%MIND_ROOT%/ext

for /r "%MIND_LIB%\" %%i in (*.jar) do (
    set VarTmp=%%~fnxi;& call :concat
    )
for /r "%MIND_EXT%\" %%i in (*.jar) do (
    set VarTmp=%%~fnxi;& call :concat
    )
goto :runGenericCompiler


	
:concat
set MIND_CLASSPATH=%MIND_CLASSPATH%%VarTmp%
goto :eof

:runGenericCompiler
java -classpath %MIND_CLASSPATH% org.ow2.mind.ctools.ccs_v5.Ccsv5CompilerExecutorLauncher %*