/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.riflemansd.businessprofit.utils.autoupv;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *
 * @author RiflemanSD
 */
public class UpdateFileHeader {

    //private String filename;
    private FileManager fileManager;
    private String projectInformationFile;
    private String projectLicenseFile;
    private String projectClassLicenseFile;

    private String className;
    private String last_update;
    private String author;
    private String author_name;
    private String version;
    private final List<String> lines;
    private final List<String> lines2;
    private final List<String> lines3;

    public UpdateFileHeader(String className, String last_update, String author, String author_name, String version) {
        this.className = className;
        this.last_update = last_update;
        this.author = author;
        this.author_name = author_name;
        this.version = version;

        projectInformationFile = "nbproject\\myheader\\Information.txt";
        projectLicenseFile = "nbproject\\myheader\\License.txt";
        projectClassLicenseFile = "nbproject\\myheader\\ClassLicense.txt";

        fileManager = new FileManager(projectLicenseFile);
        lines = fileManager.readAllLines();
        fileManager.close();
        fileManager = new FileManager(projectInformationFile);
        lines2 = fileManager.readAllLines();
        fileManager.close();
        fileManager = new FileManager(projectClassLicenseFile);
        lines3 = fileManager.readAllLines();
        fileManager.close();
    }

    public static void main(String[] args) {
        //File file = new File("src\\org\\riflemansd\\businessprofit\\utils\\autoupv\\FileManager2.java");

        //UpdateFileHeader up = new UpdateFileHeader(file.getName(), getDate(file.lastModified()), "https://github.com/RiflemanSD", "RiflemanSD", "1.0.6");
        //up.updateFileHeader(new FileManager(file));
        //new UpdateFileHeader("src\\org\\riflemansd\\businessprofit\\utils\\autoupv\\FileManager2.java");
        //new UpdateFileHeader("nbproject\\myheader\\Information.txt");
        File mainFile = new File("src");

        ArrayList<File> fileToCheck = new ArrayList<>();
        ArrayList<File> javaFiles = new ArrayList<>();

        fileToCheck.add(mainFile);

        while (!fileToCheck.isEmpty()) {
            File currFile = fileToCheck.get(0);

            if (currFile.isDirectory()) {
                for (File f : currFile.listFiles()) {
                    fileToCheck.add(f);
                }
            } else {
                if (currFile.getName().endsWith(".java")) {
                    javaFiles.add(currFile);
                }
            }
            System.out.println(currFile.getAbsolutePath() + " " + new Date(currFile.lastModified()));
            fileToCheck.remove(0);
        }

        for (File jFile : javaFiles) {
            //UpdateFileHeader up = new UpdateFileHeader(jFile.getName(), getDate(jFile.lastModified()), "https://github.com/RiflemanSD", "RiflemanSD", "1.0.6");

            //up.updateFileHeader2Way(new FileManager(jFile));
        }

        File file = new File("src\\org\\riflemansd\\businessprofit\\utils\\autoupv\\NewClass.java");
        File file1 = new File("src\\org\\riflemansd\\businessprofit\\utils\\autoupv\\NewClass2.java");
        File file2 = new File("src\\org\\riflemansd\\businessprofit\\utils\\autoupv\\NewInterface.java");
        File file3 = new File("src\\org\\riflemansd\\businessprofit\\utils\\autoupv\\NewInterface2.java");

        javaFiles.clear();
        javaFiles.add(file);
        javaFiles.add(file1);
        javaFiles.add(file2);
        javaFiles.add(file3);

        for (File jFile : javaFiles) {
            UpdateFileHeader up = new UpdateFileHeader(jFile.getName(), getDate(jFile.lastModified()), "https://github.com/RiflemanSD", "RiflemanSD", "1.0.7");

            up.updateFileHeader2Way(new FileManager(jFile));
        }
    }

    /**
     * public class {className} class {className}
     *
     * public interface {interfaceName} interface {interfaceName}
     *
     *
     * To change this license header, choose License Headers in Project
     * Properties. To change this template file, choose Tools | Templates and
     * open the template in the editor.
     *
     *
     *
     * @author RiflemanSD
     */
    private boolean updateFileHeader2Way(FileManager file) {
        String defaultFileHeader = "/*\n"
                + " * To change this license header, choose License Headers in Project Properties.\n"
                + " * To change this template file, choose Tools | Templates\n"
                + " * and open the template in the editor.\n"
                + " */";
        String defaultClassHeader = "/**\n"
                + " *\n"
                + " * @author RiflemanSD\n"
                + " */";

        String stringToWrite = "";
        String fileString = file.readFileAsString();

        int indexOfPackage = fileString.indexOf("package");
        if (indexOfPackage == -1) {
            return false;
        }

        int indexOfPublicClass = fileString.indexOf("public class");
        if (indexOfPublicClass == -1) {
            int indexOfClass = fileString.indexOf("class");
            if (indexOfClass == -1) {
                int indexOfPublicInterface = fileString.indexOf("public interface");
                if (indexOfPublicInterface == -1) {
                    int indexOfInterface = fileString.indexOf("interface");
                    if (indexOfInterface == -1) {
                        return false;
                    } else {
                        indexOfPublicClass = indexOfInterface;
                    }
                } else {
                    indexOfPublicClass = indexOfPublicInterface;
                }
            } else {
                indexOfPublicClass = indexOfClass;
            }
        }
        boolean noChange = false;
        String imports = "";
        String header = "";
        if (indexOfPackage == 0) header = "";
        else header = fileString.substring(0, indexOfPackage - 1);
        
        System.out.println("Header: " + header);
        if (header.equals(defaultFileHeader) || header.isEmpty()) {
            stringToWrite += "/* ~~ " + lines.get(0).replace("{class}", this.className.replace(".java", "")) + " ~~\n";
            for (int i = 1; i < lines.size(); i++) {
                stringToWrite += " * " + lines.get(i) + "\n";
            }
            stringToWrite += " * \n";

            stringToWrite += " * ~~ " + lines2.get(0) + " ~~\n";
            for (int i = 1; i < lines2.size(); i++) {
                stringToWrite += " * " + lines2.get(i) + "\n";
            }
            stringToWrite += " */\n";

            imports = fileString.substring(indexOfPackage, indexOfPublicClass - 1);
            stringToWrite += imports.substring(0, imports.indexOf("\n") + 1);
            imports = imports.substring(imports.indexOf("\n") + 1);
            stringToWrite += imports;
        } else {
            imports = fileString.substring(indexOfPackage, indexOfPublicClass - 1);
            stringToWrite += header + "\n" + imports.substring(0, imports.indexOf("\n") + 1);
            imports = imports.substring(imports.indexOf("\n") + 1);
            noChange = true;
        }
        System.out.println("imports: " + imports);
        int indexOfStartJD = imports.indexOf("/**");
        boolean checkVersion = false;
        if (indexOfStartJD != -1 && !imports.endsWith(defaultClassHeader)) {
            checkVersion = true;
            stringToWrite += imports + "\n" + fileString.substring(indexOfPublicClass);
        }
        else if (indexOfStartJD == -1 || imports.endsWith(defaultClassHeader)) {
            stringToWrite += imports.replace(defaultClassHeader, "");

            stringToWrite += "\n/** <h1>" + lines3.get(0).replace("{class}", this.className.replace(".java", "")) + "</h1>\n";
            for (int i = 1; i < lines3.size(); i++) {
                String line = lines3.get(i);

                if (!line.isEmpty() && !line.startsWith("@")) {
                    if (line.contains("{author}")) {
                        line = line.replace("{author}", "<a href=" + this.author + ">" + this.author_name + "</a>");
                    }
                    if (line.contains("{class_info}")) {
                        line = line.replace("{class_info}", "");
                    }
                    if (line.contains("{last_update}")) {
                        line = line.replace("{last_update}", this.last_update);
                    }

                    line = "<p>" + line + "</p>";
                }
                if (line.startsWith("@")) {
                    if (line.contains("{author_name}")) {
                        line = line.replace("{author_name}", this.author_name);
                    }
                    if (line.contains("{version}")) {
                        line = line.replace("{version}", this.version);
                    }
                }
                stringToWrite += " * " + line + "\n";
            }
            stringToWrite += " */\n";

            stringToWrite += fileString.substring(indexOfPublicClass);
            noChange = false;
        }

        if (checkVersion) {
            String sversion = "@version ";
            int versionIndex = stringToWrite.indexOf(sversion + version);
            
            if (versionIndex == -1) {
                versionIndex = stringToWrite.indexOf(sversion);
                if (versionIndex != -1) {
                    String verSubString = stringToWrite.substring(versionIndex);
                    verSubString = verSubString.substring(verSubString.indexOf("\n"));
                    verSubString = " " + sversion + version + verSubString;
                    
                    stringToWrite = stringToWrite.substring(0, versionIndex-1) + verSubString;
                    
                    noChange = false;
                }
            }
        }
        
        if (noChange) {
            return false;
        }

        //System.out.println("Write: " + stringToWrite + "End Of Write");
        file.delete();
        file.save();
        
        String[] newLines = stringToWrite.split("\n");
        
        System.out.println("Write...");
        for (String line : newLines) {
            file.writeLine(line);
            System.out.println(line);
        }
        System.out.println("...End");
        file.save();
        file.close();
        
        return true;
    }

    private void updateFileHeader(FileManager file1) {
        List<String> linesLicense = lines;
        List<String> linesInformation = lines2;
        List<String> linesClassLicense = lines3;

        List<String> linesFile = file1.readAllLines();
        file1.delete();
        file1.save();

        boolean lic = false;
        boolean info = false;
        boolean clh = false;
        boolean stop = false;
        boolean stop2 = false;
        boolean lic2 = false;
        for (String line1 : linesFile) {
            if (line1.contains("~~")) {
                lic = true;
                stop = true;
            }
            if (line1.contains("package")) {
                stop = true;
                if (!lic) {
                    file1.writeLine("/* ~~ " + linesLicense.get(0).replace("{class}", this.className.replace(".java", "")) + " ~~");
                    for (int i = 1; i < linesLicense.size(); i++) {
                        System.out.println(linesLicense.get(i));
                        file1.writeLine(" * " + linesLicense.get(i));
                    }
                    file1.writeLine(" * ");

                    file1.writeLine(" * ~~ " + linesInformation.get(0) + " ~~");
                    for (int i = 1; i < linesInformation.size(); i++) {
                        System.out.println(linesInformation.get(i));
                        file1.writeLine(" * " + linesInformation.get(i));
                    }
                    file1.writeLine(" */");
                }
                file1.writeLine(line1);
            }
            if (!lic2 && lic && line1.contains("*") && !stop2) {
                file1.writeLine(line1);
                if (line1.contains("*/")) {
                    lic2 = true;
                }
            }
            if (line1.contains("import")) {
                file1.writeLine(line1);
            } else {
                if (stop) {
                    if (line1.contains("<h1>")) {
                        clh = true;
                        stop2 = true;
                        file1.writeLine(" ");
                    }
                    if (!info && line1.contains("public")) {
                        info = true;
                        stop2 = true;
                        if (!clh) {
                            file1.writeLine("\n/** <h1>" + linesClassLicense.get(0).replace("{class}", this.className.replace(".java", "")) + "</h1>");
                            for (int i = 1; i < linesClassLicense.size(); i++) {
                                String line = linesClassLicense.get(i);

                                if (!line.isEmpty() && !line.startsWith("@")) {
                                    if (line.contains("{author}")) {
                                        line = line.replace("{author}", "<a href=" + this.author + ">" + this.author_name + "</a>");
                                    }
                                    if (line.contains("{class_info}")) {
                                        line = line.replace("{class_info}", "");
                                    }
                                    if (line.contains("{last_update}")) {
                                        line = line.replace("{last_update}", this.last_update);
                                    }

                                    line = "<p>" + line + "</p>";
                                }
                                if (line.startsWith("@")) {
                                    if (line.contains("{author_name}")) {
                                        line = line.replace("{author_name}", this.author_name);
                                    }
                                    if (line.contains("{version}")) {
                                        line = line.replace("{version}", this.version);
                                    }
                                }

                                System.out.println(line);
                                file1.writeLine(" * " + line);
                            }
                            file1.writeLine(" */");
                        }
                    }
                    if (stop2) {
                        if (line1.startsWith(" * @version")) {
                            line1 = " * " + line1.split(" ")[2] + " " + this.version;
                        }

                        file1.writeLine(line1);
                    }
                }
            }
        }
        file1.save();

        file1.close();
    }

    public static String getDate(Long time) {
        SimpleDateFormat date_format = new SimpleDateFormat("dd/MM/yyyy");

        return date_format.format(new Date(time));
    }
}
