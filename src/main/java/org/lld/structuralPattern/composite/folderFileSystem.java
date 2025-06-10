package org.lld.structuralPattern.composite;

import java.util.ArrayList;
import java.util.List;

interface FileSystemComponent{
    void showDetails();
}
class File implements FileSystemComponent{
    private String name;
    public File(String name){
        this.name = name;
    }
    @Override
    public void showDetails(){
        System.out.println("File: " + name);
    }
}

class Folder implements FileSystemComponent{
    private String name;
    List<FileSystemComponent> children = new ArrayList<>();

    public Folder(String name){
        this.name = name;
    }
    public void add(FileSystemComponent component){
        children.add(component);
    }
    public void remove(FileSystemComponent component){
        children.remove(component);
    }
    @Override
    public void showDetails(){
        System.out.println("Folder: " + name);
        for(FileSystemComponent child : children){
            child.showDetails();
        }
    }
}

public class folderFileSystem {
    public static void main(String[] args) {
        File file1 = new File("Resume.pdf");
        File file2 = new File("CoverLetter.pdf");
        Folder jobFolder = new Folder("JobFolder");
        jobFolder.add(file1);
        jobFolder.add(file2);
        Folder root = new Folder("Root");
        root.add(jobFolder);
        root.showDetails();
    }
}
