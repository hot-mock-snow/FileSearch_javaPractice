import java.io.IOException;
import java.io.File;


public class FileCreate extends FileOperationApp{
	String fileTitle;

	//ファイル新規作成メソッド
	public void newCreate(String fileTitle) {
		this.fileTitle = fileTitle;
		
        
        // ファイルオブジェクトを作成します
        File file = new File(fileTitle);
        
        try {
            // ファイルを作成します
            if (file.createNewFile()) {
                System.out.println("ファイルが作成されました: " + file.getName());
            } else {
                System.out.println("ファイルは既に存在します。");
            }
        } catch (IOException e) {
            System.out.println("エラーが発生しました。");
            e.printStackTrace();
        }

        //scTitle.close();
	}

}
