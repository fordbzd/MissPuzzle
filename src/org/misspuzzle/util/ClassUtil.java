package org.misspuzzle.util;

import java.io.File;
import java.io.FileFilter;
import java.io.IOException;
import java.net.URL;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;

/**
 * Util class for Class and Package.
 * 
 */
public class ClassUtil {

    /**
     * Get all classes that implement the give interface.
     */
    public static List<Class<?>> getAllClassesByInterface(Class<?> c, String[] excludes) {
        List<Class<?>> returnClassList = null;

        if (c.isInterface()) {
            // Get current package name.
            String packageName = c.getPackage().getName();

            // Get all classes from the package and its child packages.
            List<Class<?>> allClasses = getClassesByPackage(packageName, excludes);

            if (allClasses != null) {
                returnClassList = new ArrayList<Class<?>>();

                for (Class<?> cls : allClasses) {
                    if (c.isAssignableFrom(cls)) {
                        // Add if not itself.
                        if (!c.equals(cls)) {
                            returnClassList.add(cls);
                        }
                    }
                }
            }
        }

        return returnClassList;
    }

    /**
     * Get all classes in a package.
     * 
     */
    public static List<Class<?>> getClassesByPackage(String packageName, String[] excludes) {

        List<Class<?>> classes = new ArrayList<Class<?>>();
        String packageDirName = packageName.replace('.', '/');

        if (isExcluded(packageName, excludes)) {
            return classes;
        }

        try {
            Enumeration<URL> dirs = Thread.currentThread().getContextClassLoader().getResources(packageDirName);

            while (dirs.hasMoreElements()) {

                URL url = dirs.nextElement();

                if ("file".equals(url.getProtocol())) {

                    String filePath = URLDecoder.decode(url.getFile(), "UTF-8");
                    List<Class<?>> classNames = findClassesByFile(packageName, filePath, excludes);

                    classes.addAll(classNames);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return classes;
    }

    /**
     * Find all .java files by scaning files.
     * 
     */
    public static List<Class<?>> findClassesByFile(String packageName, String packagePath, String[] excludes) {

        File dir = new File(packagePath);
        List<Class<?>> classNames = new ArrayList<Class<?>>();

        if (!dir.exists() || !dir.isDirectory()) {
            return classNames;
        }

        File[] dirfiles = dir.listFiles(new FileFilter() {
            public boolean accept(File file) {
                // Custom filter: only scan directory, *.java and .folderignore.
                return file.isDirectory() || file.getName().endsWith(".class");
            }
        });

        for (File file : dirfiles) {

            if (file.isDirectory()) {
                String subPackageName = packageName + "." + file.getName();

                if (isExcluded(subPackageName, excludes)) {
                    continue;
                }

                // For directory, recursively add class names.
                List<Class<?>> classNamesSub = findClassesByFile(subPackageName, file.getAbsolutePath(), excludes);
                classNames.addAll(classNamesSub);
            } else {
                // Remove file extension ".java" and add the name to result.
                String className = file.getName().substring(0, file.getName().length() - 6);
                String fullClassName = packageName + "." + className;

                if (isExcluded(fullClassName, excludes)) {
                    continue;
                }

                try {
                    classNames.add(Class.forName(fullClassName));
                } catch (ClassNotFoundException e) {
                    e.printStackTrace();
                }
            }
        }

        return classNames;
    }

    private static boolean isExcluded(String name, String[] excludes) {
        for (String exclude : excludes) {
            if (name.contains(exclude)) {
                return true;
            }
        }

        return false;
    }
}