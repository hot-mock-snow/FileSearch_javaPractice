import java.io.File;
import java.util.ArrayList;
//ファイル検索

public class FileSearch extends FileOperationApp{
	
	//メンバ変数
	int searchHit = 0; 	//検索がヒットしたかの判定に使う
	String directoryPath; //ファイルパス

	String searchKeyword = ""; //検索キーワード
	
	//検索結果を格納する配列
	ArrayList<String> searchResult = new ArrayList<String>();
		
	
	//ディレクトリのチェックと検索結果の表示メソッド
	public void checkDirectory(String directoryPath, String searchKeyword) {
		this.directoryPath = directoryPath;
		this.searchKeyword = searchKeyword;

    // 指定されたディレクトリからファイル名を検索
    searchFiles(directoryPath, searchKeyword);
    
    //検索結果がない
    if(searchHit == 0) {
    	System.out.println("指定の検索キーワード『" + searchKeyword + "』に該当するファイルは見つかりませんでした");
    } else {	//検索結果がある
    	//件数表示
    	System.out.println("該当ファイル　全" + searchHit + "件");
    	//配列を回して検索結果を表示
    	for(int i = 0; i <searchResult.size(); i++) {
    		System.out.println("検索結果 " + (i + 1) + "：" + searchResult.get(i));
    	}
    }
	}

	
	//ファイル検索メソッド
	 public void searchFiles(String directoryPath, String searchKeyword) {
		this.directoryPath = directoryPath;
		this.searchKeyword = searchKeyword;

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
                   searchFiles(file.getAbsolutePath(), searchKeyword);
               } else if (file.getName().contains(searchKeyword)) {
            	   
            	   // 検索キーワードがファイル名に含まれる場合、配列に格納
            	   searchResult.add(file.getAbsolutePath());
            	   searchHit ++;
            	   
               }
	        }
         }
	 }



}
