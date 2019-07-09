package omikuji;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.sql.Connection;
import java.sql.PreparedStatement;

/**
*おみくじデータをDBに取り込む
*PreparedStatementにバインドをする
*@param preparedStatement
*				ステートメント情報
*
*/
public class OmikujiTable {
	public static void OmikujiRegist() {

		Connection connection = null;
		PreparedStatement preparedStatement = null;
		{

			try {

				connection = DBManager.getconnection();

				//CSVファイルの読み込み
				File f = new File("Omikuji.csv");
				BufferedReader br = new BufferedReader(new FileReader(f));

				//読み込んだファイルを１行ずつ画面出力する
				String line;
				// 1行ずつCSVファイルを読み込む
				while ((line = br.readLine()) != null) {

					// 行をカンマ区切りで配列に変換
					String[] data = line.split(",", 0);
					String unsei = data[0];
					int unsei_id = Integer.parseInt(unsei);
					String negaigoto = data[1];
					String akinai = data[2];
					String gakumon = data[3];

					//SQL文の準備

					String s = "INSERT Omikuji INTO unsei_id = ?, negaigoto = ?, akinai = ?, gakumon = ?";

					//ステートメント作成

					preparedStatement = connection.prepareStatement(s);
					preparedStatement.setInt(0, unsei_id);
					preparedStatement.setString(1, negaigoto);
					preparedStatement.setString(2, akinai);
					preparedStatement.setString(3, gakumon);

					//SQL文の実行
					int cnt = preparedStatement.executeUpdate();
					System.out.println(cnt);
				}
				br.close();
			} catch (Exception e) {
				e.printStackTrace();
			} finally {

				//DBをクローズ
				DBManager.close(connection);
				DBManager.close(preparedStatement);

			}
		}
	}
}
