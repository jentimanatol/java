# Java FX Scene Project

## Introduction
This project demonstrates a simple JavaFX application with a label, button, and circle displayed on the scene.

## Prerequisites
- Java Development Kit (JDK) 17
- JavaFX SDK 17

## Setting Up the Project

1. **Download and Install JDK 17:**
    - Download from [Oracle](https://www.oracle.com/java/technologies/javase-jdk17-downloads.html) or [OpenJDK](https://jdk.java.net/17/).

2. **Download and Extract JavaFX SDK:**
    - Get the JavaFX SDK from [Gluon](https://gluonhq.com/products/javafx/).
    - Extract the SDK to a directory, for example, `C:\javafx-sdk-17`.

3. **Configure the Project Libraries:**
    - Ensure your project references the necessary JavaFX JAR files.
    ```bash
    "java.project.referencedLibraries": [
        "lib/**/*.jar",
        "c:\\javafx-sdk-17\\lib\\javafx.base.jar",
        "c:\\javafx-sdk-17\\lib\\javafx.controls.jar",
        "c:\\javafx-sdk-17\\lib\\javafx.fxml.jar",
        "c:\\javafx-sdk-17\\lib\\javafx.graphics.jar",
        "c:\\javafx-sdk-17\\lib\\javafx.media.jar",
        "c:\\javafx-sdk-17\\lib\\javafx.swing.jar",
        "c:\\javafx-sdk-17\\lib\\javafx.web.jar",
        "c:\\javafx-sdk-17\\lib\\javafx-swt.jar",
        "c:\\javafx-sdk-17\\lib\\jrt-fs.jar"
    ]
    ```

## Running the Application
To run the application, use the following command in PowerShell:

```bash
Start-Process -FilePath "C:\Program Files\Java\jdk-17\bin\java.exe" -ArgumentList "--module-path", "C:\javafx-sdk-17\lib", "--add-modules", "javafx.controls,javafx.fxml", "-cp", ".", "Java_fx_Scene"
