import java.io.File;

public class FileRename {
	String currentFileName;
	String newFileName;
	
	//ファイル名修正メソッド
    public void FileRenameExe(String currentFileName, String newFileName) {
    	this.currentFileName = currentFileName;
    	this.newFileName = newFileName;
        // 現在のファイル名と新しいファイル名を指定
//        String currentFileName = "oldfile.txt";
//        String newFileName = "newfile.txt";
        
        // 現在のファイル名と新しいファイル名を使ってファイルオブジェクトを作成
        File currentFile = new File(currentFileName);
        File newFile = new File(newFileName);
        
        // ファイル名の変更
        if(currentFile.exists()) {
            boolean success = currentFile.renameTo(newFile);
            if(success) {
                System.out.println("ファイル名が変更されました。");
            } else {
                System.out.println("ファイル名の変更に失敗しました。");
            }
        } else {
            System.out.println("指定されたファイルは存在しません。");
        }
    }
}

