1. Należy zmienić lokalizacje katalogu baz Derby, katalog instalacyjny Derby oraz lokalizajce jdk javy w plikach z lokalizacji DB\pliki: 
createdb.bat, startServer.bat, stopServer.bat

a. Katalog baz Derby
set DERBY_SYSTEM_HOME=D:\DB\DerbyDbs

b. Katalog instalacyjny Derby
set DERBY_HOME=D:\DB\db-derby-10.13.1.1-bin

c. Lokalizacja jdk javy
set JAVA_HOME=C:\Program Files\Java\jdk1.8.0_211

d. W plikach startServer.bat, stopServer.bat dodatkowo musimy zmienić w ostatniej linijce katalog baz Derby
-Dderby.system.home=D:\DB\DerbyDbs

2. My mamy dostęp bazy danych Derby za pomoca protokolu sieciowego Derby (po starcie serwera),
w tym celu przed uruchomieniem naszej aplikacji WEB musimy odpalić plik startServer.bat,
a po zakończeniu działania aplikacji odpalamy stopServer.bat by zakończyć działanie działanie bazy.

3. Musimy skopiować do kalatogu lib w programie Tomcat (u mnie lokalizacja C:\Program Files\Apache Software Foundation\Tomcat 9.0\lib)
wszystkie bibiloteki z Derby DB\db-derby-10.13.1.1-bin\lib.

4. W pliku context (u mnie lokalizacja C:\Program Files\Apache Software Foundation\Tomcat 9.0\conf) dodać następujący fragmnet:

<Resource name="jdbc/ksidb" auth="Container" 
            type="javax.sql.DataSource"
            description="Baza danych ksiazek" 
            driverClassName="org.apache.derby.jdbc.ClientDriver"
            url="jdbc:derby://localhost/ksidb"
            username="APP"
            password="APP"
            maxActive="20" /> 

wszystko należy dodać na końcu sekcji <Context>.



Pozdrawiam Jan Kwasowski