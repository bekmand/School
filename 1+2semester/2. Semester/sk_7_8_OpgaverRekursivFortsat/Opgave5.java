package sk_7_8_OpgaverRekursivFortsat;

import java.io.File;

public class Opgave5 {
	
	public static void ScanDir(String path) {
		System.out.println("[DIR] "+path);
		// skab et File-objekt svarende til mappen path
		File file=new File(path);
		// få listen over alle filer og undermapper
		String[] names=file.list();
		for (String name: names) {
		File file2=new File(path+"/"+name);
		if (file2.isDirectory())
		ScanDir(path+"/"+name);
		}
	}
	
	public static int ScanDirCount(String path){
		int count = 0;
		File file=new File(path);
		// få listen over alle filer og undermapper
		String[] names=file.list();
		
		for (String name: names) {
					File file2=new File(path+"/"+name);
						if (file2.isDirectory()){
							count += ScanDirCount(path+"/"+name);
							count++;
						}
				}
		return count;
	}
	
	public static void ScanDirNiveau(String path, int niveau) {
		System.out.println(niveau + "[DIR] "+path);
		// skab et File-objekt svarende til mappen path
		File file=new File(path);
		// få listen over alle filer og undermapper
		String[] names=file.list();
		for (String name: names) {
		File file2=new File(path+"/"+name);
		
			if (file2.isDirectory()){
					ScanDirNiveau(path+"/"+name, niveau+1);
			}
		}
	}
	
	public static void main(String[] args) {
		//Opgave 5.a
//		ScanDir("C:/Users/casper.bekmand/Music");
		//Opgave 5.b
//		System.out.println(ScanDirCount("C:/Users/casper.bekmand/Music"));
		//Opgave 5.c
		ScanDirNiveau("C:/Users/casper.bekmand/Music", 1);
	}

}
