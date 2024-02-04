                                                                                                             
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
* CODE CONTRIBUTORS – Vishal Verma, Shikhar Johari, Soumya Bardhan, Rohit jain,		    *
*                     Karthika Nair, Vibhuti Pithwa, Vaasavi Lakshmi                        *
*********************************************************************************************  


1. The zip file you downloaded contains this README file and the source code for the example in Section 4.3.1. of the book (in Eclipse project format).

2. You can import and execute the projects from Eclipse IDE using steps given below. Alternatively, you can inspect the source code by exploring *.java files inside the zip file. 


Importing Eclipse Project
-------------------------

1. Choose 'File->Import' menu from Eclipse. 

2. From the 'Import' pop-up dialog window, select 'Existing Projects into Workspace' under 'General'.  Click on 'Next' button.

3. In the next screen, choose the option 'Select archive file', and select the downloaded zip file. 

4. Eclipse scans the zip file and displays 'CODAPOS5' as a project available for import.

5. Select 'CODAPOS5' project and click on the 'Finish' button.

6. 'CODAPOS5' project gets added to your Eclipse workspace.


Setting up third party libraries
--------------------------------

The following libraries are required for building and executing the code

1. db4objects Database : Please download db4objects database from http://www.db4o.com/DownloadNow.aspx

2. Extract the content of the downloaded zip to a folder ,let us say 'db4o'.

3. For this,choose 'Window->Preferences' menu from Eclipse.

4. From 'Preferences' pop-up dialog window, select 'User Libraries' under 'Java > Build Path'.Click on 'New' button.

5. Type 'db4o' in the 'User library name' field. Click on 'OK' button.

6. Select the newly created 'db40' library, click on 'Add Jars'.

7. Browse to the lib folder inside the 'db4o' folder created earlier.Typically it would be something like db4o\db4o-8.0-java\db4o-8.0\lib and select a file similar to 'db4o-8.0.249.16098-all-java5.jar'.

8. Click on 'Ok' button.



Executing the Application
-------------------------

1. Right click on the project 'CODAPOS5' under 'Project Explorer' window in Eclipse.

2. From the context pop-up menu, select 'Run as -> Java Application' option.

3. Use the POS program as guided by the text based menu titled 'Welcome to Restaurant'.




