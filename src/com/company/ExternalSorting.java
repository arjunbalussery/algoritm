package com.company;

import java.io.*;
import java.util.*;

public class ExternalSorting {
    //will return bloack size in bit
    private static long getblockSize(File file) {
        int MAXBLOCKSIZE=20;
        long fileSize=file.length();
        long blockSize = fileSize/MAXBLOCKSIZE;
        long freeMemory = Runtime.getRuntime().freeMemory();
        /*if(blockSize < freeMemory/2)
            blockSize=freeMemory/2;
        else {
            if(blockSize >= freeMemory)
                System.err.println("We expect to run out of memory. ");
        }*/
        return blockSize;

    }

    public static  List<File>  createCunks(File file, Comparator<String> cmp) {
        long blockSize = getblockSize(file);
        List<File> tempFiles = new ArrayList<>();
        String line="";
        BufferedReader bf=null;
        try {
            bf = new BufferedReader(new FileReader(file));
            while(line != null) {
                List<String> templist = new ArrayList<>();
                long currentblocksize = 0;// in bytes
                while((currentblocksize < blockSize)
                        &&(   (line = bf.readLine()) != null) ){ // as long as you have 2MB
                    templist.add(line);
                    currentblocksize += line.length()*2;// 2 + 40; // java uses 16 bits per character + 40 bytes of overhead (estimated)
                }
                tempFiles.add(sortAndSave(templist,cmp));
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            if(Objects.nonNull(bf)) {
                try {
                    bf.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

        }
        return tempFiles;
    }

    private static File sortAndSave(List<String> templist, Comparator<String> cmp) throws IOException {
        Collections.sort(templist,cmp);  //
        File newtmpfile = File.createTempFile("sortInBatch", "flatfile");
        newtmpfile.deleteOnExit();
        BufferedWriter fbw = new BufferedWriter(new FileWriter(newtmpfile));
        try {
            for(String r : templist) {
                fbw.write(r);
                fbw.newLine();
            }
        } finally {
            fbw.close();
        }
        return newtmpfile;
    }
}
