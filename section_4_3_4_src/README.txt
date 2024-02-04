                                                                                                             
      ABOOK       KCODAB    ODABOOK           ABO       OOKCODABOO      OOKCOD       DABOOK    BOOKCO   OOK    
    CODABOOKCO   OOKCODAB   CODABOOKC        ODABO      BOOKCODABOO    ABOOKCOD     CODABOOK   ABOOK    BOO    
   OKC   BOOKC  ABOO  ODAB  KCODABOOKC       CODAB      ABOOK   ABO   ODAB  KCOD   OKCO  BOOK   ABO    DA      
  BOO     BOOK  DAB    ODA  OKCO   OOKC     OKCODA        BOO   DAB   COD    KCO   OOK    BOO   DAB   CO       
  ABO          CODA    CODA  OKC   BOOK     OOK ODA       ABOOKCODA  OKCO    OKCO ABOO    ABOO  ODABOOK        
  DA           KCOD    KCOD  OOK    BOO    ABOOKCODA      DABOOKCODA OOKC    OOKC DABO    DABO  CODABOO        
  OD            KCO    OKC   BOO   DABO    DABOOKCOD      ODABOOKCODA OOK    BOO   DAB    ODA   KCODABO        
  CO       OD   OKC    OOK  DABO  CODAB   CODA   KCOD     COD    KCOD BOO    ABO   ODA    COD   OKC  ABO       
  KCO     KCO   OOKC  ABOO CODABOOKCODA   KCO     KCO     KCODABOOKCO ABOO  ODAB   CODA  OKCO   OOK  DAB       
   KCODABOOKC    OOKCODAB  KCODABOOKCO  BOOKCO   OOKCOD BOOKCODABOOK   ABOOKCOD     CODABOOK   ABOOK ODABOOK   
    KCODABO       OOKCOD   OKCODABOO    ABOOKC   BOOKCO ABOOKCODABO     ABOOKC       CODABO   ODABOO CODABOO   




*********************************************************************************************
* COMPANION CODE FOR THE BOOK “Component Oriented Development & Assembly – CODA Using Java” *
* AUTHORS – Piram Manickam, Sangeetha S, Subrahmanya S V                                    *
* REFERENCE – http://www.codabook.com                                                       *
* CODE CONTRIBUTORS – Vishal Verma, Shikhar Johari, Soumya Bardhan, Rohit Jain,		    *
*                     Karthika Nair, Vibhuti Pithwa, Vaasavi Lakshmi                        *
********************************************************************************************* 


1. The zip file you downloaded contains this README file and the source code for the example in Section 4.3.4. of the book (in Eclipse project format).

2. You can import and execute the projects from Eclipse IDE using steps given below. Alternatively, you can inspect the source code by exploring *.java files inside the zip file. 


Importing Eclipse Project
-------------------------

1. Choose 'File->Import' menu from Eclipse. 

2. From the 'Import' pop-up dialog window, select 'Existing Projects into Workspace' under 'General'.Click on 'Next' button.

3. In the next screen, choose the option 'Select archive file', and select the downloaded zip file. 

4. After scanning the archive, Eclipse lists the following projects under ‘Projects’ selection box:
	- CODAPOS5AdminUI
	- CODAPOS5App
	- CODAPOS5Bill2
	- CODAPOS5BillUI2
	- CODAPOS5Food
	- CODAPOS5GuestUI
	- CODAPOS5Model
	- CODAPOS5Order
	- CODAPOS5OrderUI
	- CODAPOS5Table	
	- ComponentModel
	- ComponentRunner
	
5. Select all of them and click on the 'Finish' button.

6. Selected projects get added to your Eclipse workspace.


Setting up third party libraries
--------------------------------

The following libraries are required for building and executing the code

1. db4objects Database : Please download db4objects database from http://www.db4o.com/DownloadNow.aspx

2. Extract the content of the downloaded zip to a folder ,let us say 'db4o'.

3. For this,choose 'Window->Preferences' menu from Eclipse.

4. From 'Preferences' pop-up dialog window, select 'User Libraries' under 'Java > Build Path'.Click on 'New' button.

5. Type 'db4o' in the 'User library name' field. Click on 'OK' button.

6. Select the newly created 'db4o' library, click on 'Add Jars'.

7. Browse to the lib folder inside the 'db4o' folder created earlier.Typically it would be something like db4o\db4o-8.0-java\db4o-8.0\lib and select a file similar to 'db4o-8.0.249.16098-all-java5.jar'.

8. Click on 'Ok' button.


Building Components
-------------------
1. The component 'ComponentRunner' is used to run the applcation.

2. It is required that you create jar file for the following projects and keep it inside project folder of 'ComponentRunner' :
	- CODAPOS5AdminUI
	- CODAPOS5Bill2
	- CODAPOS5BillUI2
	- CODAPOS5Food
	- CODAPOS5GuestUI
	- CODAPOS5Order
	- CODAPOS5OrderUI
	- CODAPOS5Table

3. Right click on the project 'CODAPOS5AdminUI' under 'Project Explorer' window in Eclipse.

4. From the context pop-up menu, select 'Export' option.

5. From the 'Export' pop-up dialog window, select 'Jar File' under 'Java'.Click on 'Next' button.

6. In the next screen, you will find the project you selected marked in the 'Resources to export' list.

7. In the same screen go to 'Select export destination' and 'Browse' to the 'ComponentRunner' project of your workspace. For example, if your workspace folder is “C:\workspace”, choose “C:\workspace\ComponentRunner” as the destination folder. Click on 'Finish' to export the bundle. 

8. Repeat steps 3 to 7 for all the other projects listed in step 2.


Executing the Application
-------------------------

1. Right click on the project 'ComponentRunner' under 'Project Explorer' window in Eclipse.

2. From the context pop-up menu, select 'Run as -> Run Configurations' option.

3. In the pop-up dialog titled 'Run Configurations' go to 'Arguments' tab.

4. There in the 'Program Arguments' text box ,write 'posapp.app.POSAPP'.This is the name of the main file of the application you want to execute.

5. Now navigate to the 'Classpath' tab in the same dialog and select 'User Entries' from the classpath list box.

6. Click on 'add external jar' which will provide you with a jar selection dialog.Select the following jar files present in the 'ComponentRunner' project :
	- CODAPOS5AdminUI
	- CODAPOS5Bill2
	- CODAPOS5BillUI2
	- CODAPOS5Food
	- CODAPOS5GuestUI
	- CODAPOS5Order
	- CODAPOS5OrderUI
	- CODAPOS5Table

7. Click on 'add project' and add 'CODAPOS5App' to user entries.

8. Click on 'Advanced' -> 'Add user library' and add the 'db4o' library created eariler.

9. Click on 'Run' after completing the above steps.

10. Use the 'Point-Of-Sale' program as guided by the text based menu titled 'Welcome to eStore'
