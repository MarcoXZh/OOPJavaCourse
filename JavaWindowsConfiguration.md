## What kind of Java do you need?

All you need is the standard version of Java -- **Java SE**, but it has two distributions: **JRE** and **JDK**.

  - If all you need is to run pre-compiled Java *bytecodes* ("*.class" files), you'll only need JRE -- it's just a
    runtime environment;
  - If you need to first compile source codes and then run them, you'll need JDK -- it contains both JRE and compiler.
    This is the distribution we need.

So download JDK (Now the latest is Java 8: Java SE 8u102, as of Sept. 22, 2016) and install it --
http://www.oracle.com/technetwork/java/javase/downloads/index.html.

## You need setup environment variables

Finishing the installation wizard is not enough. You need some extra jobs. So navigate to: *Control Panel* -> *System
and Security* -> *System* -> *Advance system settings* -> *Environment Variables...* -> *System variables*.

![Environment Variables](https://raw.githubusercontent.com/MarcoXZh/OOPJavaCourse/master/Fig_EnvironmentVariables.png)

Click *New...* to add the following variables:

  Name        |  Value                                               |  Note
:------------ | :--------------------------------------------------- | :----------------------------------
  `JAVA_HOME` | `C:\Program Files\Java\jdk1.8.0_102`                 | Use your actual installation path
  `CLASSPATH` | `.;%JAVA_HOME%\lib\dt.jar;%JAVA_HOME%\lib\tools.jar` | Don't miss the first character `.`

Next, find `PATH` variable and edit it: append the following to it

`;%JAVA_HOME%\bin;%JAVA_HOME%\jre\bin`

Click *OK* to save the settings. Restart a new Command Prompt / PowerShell, and run the following to verify the
configuration.

![Installation Verification](https://raw.githubusercontent.com/MarcoXZh/OOPJavaCourse/master/Fig_InstallationVerification.png)
