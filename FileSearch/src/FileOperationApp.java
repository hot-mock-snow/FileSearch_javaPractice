//メインオペレーション
                   
//■■■　やりたいこと　■■■
//手入力したファイル名を削除
//該当する複数のファイル名の削除
//拡張子を無視して同名ファイルであれば削除できるようにする


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class FileOperationApp {
    public static void main(String[] args) throws IOException {
    	//メンバ変数
    	
    	// ファイルを検索するディレクトリを指定　↓元の表記
    	//String directoryPath = "/path/to/search/directory";
    	String directoryPath = "/C:/Users/UserName/Documents/folderName";
    	String searchKeyword = " ";
    	String fileTitle = " ";
    	
    	//手入力操作のために必要、繰り返し操作にも使用
    	int operationNum = 0;
    	
    	while(operationNum == 0) {//再操作実行可能にするためのwhile文
    	
    	//実行したい操作を数字入力で選択
    	System.out.println("操作が実行されるファイルパスは『/C:/Users/美稀/Documents/shita』です。");
    	System.out.println("実行したい操作の数字を入力してください");
    	System.out.println("1.ファイルの検索");
    	System.out.println("2.ファイルの新規作成");
    	System.out.println("3.ファイル名の修正");
    	System.out.println("4.ファイルの削除");
    	System.out.println("警告！：ファイルの削除を実行したい場合、予期しないファイル削除を防ぐために、");
    	System.out.println("まずはファイル検索を実行して該当ファイルの確認を行ってください！");
    	try {
    	//数字入力の受付
    	Scanner scNum = new Scanner(System.in);
    	operationNum = scNum.nextInt();
    	//scNum.close();
    	} catch(Exception e) { //数字以外が入力されたときのエラーの記載
    		e.printStackTrace();
    	}   	
    	
	    	switch(operationNum) {
	    	case 1:
	    		// 検索条件 
	    		// 追記　キーボード入力で受付
	    		System.out.print("検索キーワード：");
	    		BufferedReader brKeyword = new BufferedReader(new InputStreamReader(System.in));
	    		try {
	    			searchKeyword = brKeyword.readLine();
	    		} catch(Exception e) {
	    			e.printStackTrace();
	    		}
	    		
	            //ファイル検索オブジェクト生成
	            FileSearch fs = new FileSearch();
	            fs.checkDirectory(directoryPath, searchKeyword);
	            fs.searchFiles(directoryPath, searchKeyword);
	            
	            //再操作を問う
	            operationAgain(operationNum);
	            
	    		break;
	    		
	    		
	    	case 2:
	    		//手入力の名前のファイルを追加する　同階層に
	    		System.out.println("新規作成するファイルの名前を入力してください");
	    		Scanner scCreTitle = new Scanner(System.in);
	    		fileTitle = scCreTitle.next();
	    		
	    		//ファイル作成オブジェクト生成
	    		FileCreate fc = new FileCreate();
	    		fc.newCreate(fileTitle);
	    		
	    		//再操作を問う
	    		operationAgain(operationNum);
	    		
	    		break;
	    		
	    		
	    	case 3:
	    		//ファイル名の修正をする
	    		String currentFileName = "";
	    		String newFileName = "";
	    		
	    		//修正前ファイル名の手入力
	    		System.out.println("修正前のファイル名を入力してください");
	    		Scanner scBeforeName = new Scanner(System.in);
	    		currentFileName = scBeforeName.next();
	    		//修正後ファイル名の手入力
	    		System.out.println("修正後のファイル名を入力してください");
	    		Scanner scAfterName = new Scanner(System.in);
	    		newFileName = scAfterName.next();
	    		
	    		//ファイル名修正オブジェクト生成
	    		FileRename fr = new FileRename();
	    		fr.FileRenameExe(currentFileName, newFileName);
	    		
	    		//再操作を問う
	    		operationAgain(operationNum);
	    		
	    		break;
	    		
	    		
	    	case 4:
	    		//手入力の名前のファイルを削除する
	    		System.out.println("削除するファイルの名前を入力してください");
	    		Scanner scDelTitle = new Scanner(System.in);
	    		fileTitle = scDelTitle.next();
	    		
	    		//ファイル削除オブジェクト生成
	    		FileDelete fd = new FileDelete();
	    		fd.delFile(directoryPath, fileTitle);
	    		
	    		//再操作を問う
	    		operationAgain(operationNum);
	    		
	    		break;
	    		
	    		
	    	default:
	    	    // 式の値がどのcaseの値とも一致しなかったときの処理
	    		System.out.println("入力値エラ－　有効な値は1～3です");
	    		System.out.println("プログラムを終了します");
	    		operationNum = 0;
	
	    	}
    	}
    }
    
    //繰り返し操作を問うメソッド
    public static void operationAgain(int operationNum) {
    	int againNum = 0;
    	
    	while(againNum == 0) {
	    	System.out.println("操作を続けますか？");
	    	System.out.println("1.はい");
	    	System.out.println("2.いいえ");
	    	Scanner scAgainNum = new Scanner(System.in);
	    	againNum = scAgainNum.nextInt();
	    	if(againNum == 1) {
	    		operationNum = 0;
	    	} else if(againNum == 2) {
	    		System.out.println("終了します。");
	    	} else {
	    		System.out.println("有効な入力値は1,2です。");
	    		againNum = 0;
	    	}
    	}
    }
    

    //Scanner閉じる
    //scAgainNum.close();
}



