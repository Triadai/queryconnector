# How to Build

The queryconnector project is composed of two parts:

* LODBConnector
* QueryConnector

### LODBConnector

It's the GUI part of the extension. It was developed with NetBeans and you
can easely modify and compile it using this IDE. Simply open the project with 
NetBeans.

### QueryConnector

It's the real extension for OpenOffice/LibreOffice that use LODBConnector to show the wizard.

##### Pre-build configuration:

Before build it, is necessary to install the OpenOffice/LibreOffice sdk.
You can find more information in the following links:

* [LibreOffice SDK](http://api.libreoffice.org/docs/install.html)
* [OpenOffice SDK](http://www.openoffice.org/download/sdk/)

##### Build instruction:

* Open the prompt command windows/bash shell to the **QueryConnector** directory
* Execute the **setsdkenv_windows.bat** or **setsdkenv_unix.sh** that is located inside the LibreOffice/OpenOffice sdk directory
* run **make** (ATTENTION: the Makefile was created for windows only. You have to modify it before use it on unix-like system.)
* The output file is located in **out/bin/**

##### for Windows users:

* download **UnixUtils** zip from (http://sourceforge.net/projects/unxutils/), extract the content to any directory and put this directory to the **PATH** enviroment variable.
* download **mingw32-make** archive from (http://sourceforge.net/projects/mingw/files/MinGW/Extension/make/) (example **mingw32-make-3.81-xxxxxxxx.tar.gz**), extract it to any directory and put this directory to the **PATH** enviroment variable.
* Rename the **mingw32-make.exe** to **make.exe**
