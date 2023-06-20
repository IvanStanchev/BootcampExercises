package org.example;

import java.io.File;

public class TreeCommand {
    public static void main(String[] args) {
        String directoryPath = ".";
        File directory = new File(directoryPath);

        if (directory.exists() && directory.isDirectory()) {
            printDirectoryTree(directory, "", true);
        } else {
            System.out.println("Invalid directory path.");
        }
    }

    private static void printDirectoryTree(File directory, String indent, boolean isLast) {
        System.out.print(indent);

        if (isLast) {
            System.out.print("└── ");
            indent += "    ";
        } else {
            System.out.print("├── ");
            indent += "│   ";
        }

        System.out.println(directory.getName());

        if (!directory.isDirectory()) {
            return;
        }
        File[] children = directory.listFiles();

        if (children == null) {
            return;
        }

        for (int i = 0; i < children.length; i++) {
            boolean isLastChild = (i == children.length - 1);
            printDirectoryTree(children[i], indent, isLastChild);
        }
    }
}
