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
        for (String line : lines) {
            System.out.println(line);
        }
        fileManager.close();
        fileManager = new FileManager(projectInformationFile);
        lines2 = fileManager.readAllLines();
        for (String line : lines) {
            System.out.println(line);
        }
        fileManager.close();
        fileManager = new FileManager(projectClassLicenseFile);
        lines3 = fileManager.readAllLines();
        for (String line : lines) {
            System.out.println(line);
        }
        fileManager.close();
    }

    public static void main(String[] args) {
        File file = new File("src\\org\\riflemansd\\businessprofit\\utils\\autoupv\\FileManager2.java");

        UpdateFileHeader up = new UpdateFileHeader(file.getName(), getDate(file.lastModified()), "RiflemanSD", "RiflemanSD", "1.0.0");

        up.updateFileHeader(new FileManager(file));

        if (up != null) {
            return;
        }
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
                javaFiles.add(currFile);
            }
            System.out.println(currFile.getAbsolutePath() + " " + new Date(currFile.lastModified()));
            fileToCheck.remove(0);
        }

        for (File jFile : javaFiles) {

        }

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
        for (String line1 : linesFile) {
            if (line1.contains("~~")) {
                lic = true;
                stop = true;
            }
            if (line1.contains("package")) {
                stop = true;
                if (!lic) {
                    file1.writeLine("/* ~~ " + linesLicense.get(0) + " ~~");
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
            if (line1.contains("import")) {
                file1.writeLine(line1);
            } else {
                if (stop) {
                    if (line1.contains("<h1>")) {
                        clh = true;
                        stop2 = true;
                    }
                    if (!info && line1.contains("public")) {
                        file1.writeLine(" ");
                        info = true;
                        stop2 = true;
                        if (!clh) {
                            file1.writeLine("/** " + linesClassLicense.get(0));
                            for (int i = 1; i < linesClassLicense.size(); i++) {
                                System.out.println(linesClassLicense.get(i));
                                file1.writeLine(" * " + linesClassLicense.get(i));
                            }
                            file1.writeLine(" */");
                        }
                    }
                    if (stop2) {
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
