mvn clean package

mkdir target/package-input

jlink `
  --module-path "$env:JAVA_HOME\jmods;C:\JavaFX\javafx-jmods-25.0.2" `
  --add-modules java.se,java.net.http,jdk.crypto.ec,jdk.unsupported,javafx.controls `
  --bind-services `
  --strip-debug `
  --no-man-pages `
  --no-header-files `
  --output target/runtime

Copy-Item "target/attendance-1.0-SNAPSHOT.jar" "target/package-input/" -Force

jpackage --type app-image --name att --input target/package-input --main-jar attendance-1.0-SNAPSHOT.jar --main-class Launcher --runtime-image target/runtime --icon src/main/resources/favicon.ico --java-options "--add-modules=javafx.controls,java.logging,java.net.http" --dest target/dist --verbose

attrib -R "target\dist\att\att.exe"