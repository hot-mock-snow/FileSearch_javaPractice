import java.io.File;
import java.util.ArrayList;


public class FileDelete {
	String directoryPath;
	String fileTitle;
	
		
		/*拡張子まで完全一致の通常のファイル検索メソッド　ここから*/

//        // ファイルオブジェクトを作成
//        File fileOb = new File(fileTitle);
//        File directory = new File(directoryPath);
//        //File file = new File(directory);
//        
//        // ファイルが存在するかどうかを確認します
//        if (fileOb.exists()) {
//            // ファイルを削除します
//            if (fileOb.delete()) {
//                System.out.println("ファイルが正常に削除されました。");
//            } else {
//                System.out.println("ファイルの削除中にエラーが発生しました。");
//            }
//        } else {
//            System.out.println("指定されたファイルが見つかりません。");
//        }
//	}
//	
//	
//	
//	public void delFileTitle(String directoryPath, String fileTitle) {
//		this.directoryPath = directoryPath;
//		this.fileTitle = fileTitle;
//	     
//      // ファイルオブジェクトを作成
//      File fileOb = new File(fileTitle);
//      //File directory = new File(directoryPath);
//      //File file = new File(directory);
//		
//        // ファイルが存在するかどうかを確認します
//        if (fileOb.exists()) {
//            // ファイルを削除します
//            if (fileOb.delete()) {
//                System.out.println("ファイルが正常に削除されました。");
//            } else {
//                System.out.println("ファイルの削除中にエラーが発生しました。");
//            }
//        } else {
//            System.out.println("指定されたファイルが見つかりません。");
//        }
//	}

	/*通常のファイル検索メソッド　ここまで　*/
	
        //sc.close();
		
		
	/*　■2024/4/29　
	拡張子を無視してファイル名の一致する場合に該当するファイルを全て削除するプログラム	
	*/

	/*検索部分*/
	//メンバ変数
	int searchHit = 0; 	//検索がヒットしたかの判定に使う
	
	//検索結果を格納する配列
	ArrayList<String> searchResult = new ArrayList<String>();
		
	
	public void delFile(String directoryPath, String fileTitle) {
		this.directoryPath = directoryPath;
		this.fileTitle = fileTitle;
	
	
	// 指定されたディレクトリからファイル名を検索
	searchFiles(directoryPath, fileTitle);
	
	//検索結果がない
	if(searchHit == 0) {
		System.out.println("指定のキーワード『" + fileTitle + "』に該当するファイルは見つかりませんでした");
	} else {	//検索結果がある
		//件数表示
		System.out.println("該当ファイル　全" + searchHit + "件を削除しました");
		//配列を回して検索結果を表示
		for(int i = 0; i <searchResult.size(); i++) {
			//System.out.println("以下のファイルを削除しました");
			System.out.println("削除結果 " + (i + 1) + "：" + searchResult.get(i));
			File deleteFile = new File(searchResult.get(i));
			deleteFile.delete();
		}
	}
	}
	
	
	//ファイル検索メソッド
	 public void searchFiles(String directoryPath, String fileTitle) {
		this.directoryPath = directoryPath;
		this.fileTitle = fileTitle;
	
	     File directory = new File(directoryPath);
	     
	     if (!directory.isDirectory()) {
	    	 System.out.println("指定されたパスはディレクトリではありません。");
	   }
   
       
	   // ディレクトリ内のすべてのファイルとサブディレクトリを取得
	   File[] files = directory.listFiles();
	   if (files != null) {
	       for (File file : files) {
	           if (file.isDirectory()) {
	               // サブディレクトリの場合、再帰的にファイルを検索
	               searchFiles(file.getAbsolutePath(), fileTitle);
	           } else if (file.getName().contains(fileTitle)) {
	        	   
	        	   // 検索キーワードがファイル名に含まれる場合、配列に格納
	        	   searchResult.add(file.getAbsolutePath());
	        	   searchHit ++;
	        	   
	           }
	        }
	   }
	 }
}

