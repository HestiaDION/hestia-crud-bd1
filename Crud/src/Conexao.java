import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexao {
//    DEFINIÇÃO DOS ATRIBUTOS
    protected Connection conn;
    protected PreparedStatement pstmt;
    protected ResultSet rs;

//    DEFINIÇÃO MÉTODO conectar --> Inicia conexão com o BD
    public boolean conectar() {
        try {
            Class.forName("org.postgresql.Driver"); // Informa qual Driver será utilizado na conexão
            conn = DriverManager.getConnection("jdbc:postgresql://pg-aplicativo-hestia24.k.aivencloud.com:23986/defaultdb?ssl=require&user=avnadmin&password=AVNS_3URGOb6MG5fTz7u4pnP"); // Estabelece a conexão com o BD

            return true; // Retorna verdadeiro ao obter sucesso

        } catch (SQLException | ClassNotFoundException sqle) {
            sqle.printStackTrace();

            return false; // Retorna falso em caso de exceção
        }
    }

//    DEFINIÇÃO DO MÉTODO desconectar --> Finaliza a conexão com o BD
    public boolean desconectar() {
        try {
            // Verifica se a conexão está ativa
            if (conn != null && !conn.isClosed()) {
                conn.close(); // Finaliza a conexão
            }

            return true; // Retorna verdadeiro ao obter sucesso

        } catch (SQLException sqle) {
            sqle.printStackTrace();

            return false; // Retorna falso em caso de exceção
        }
    }

//    //  DEFINIÇÃO DO MÉTODO update
//    public int changeValue(String table, String column, int id, String change){
//        try{
//            connect();
//
//            pstmt = conn.prepareStatement("UPDATE ? SET ? = ? WHERE PESSOAID =?");
//
//            pstmt.setString(1, table);
//            pstmt.setString(2, column);
//            pstmt.setString(3, change);
//            pstmt.setInt(4, id);
//
//            int rows = pstmt.executeUpdate();
//            disconnect();
//
//            if (rows > 0){
//                return 1;
//            }else return 0;
//        }catch (SQLException e){
//            e.printStackTrace();
//            return -1;
//        }
//    }
//    public int changeValue(String table, String column, int id, char change){
//        try{
//            connect();
//
//            pstmt = conn.prepareStatement("UPDATE ? SET ? = ? WHERE PESSOAID =?");
//
//            pstmt.setString(1, table);
//            pstmt.setString(2, column);
//            pstmt.setString(3, String.valueOf(change));
//            pstmt.setInt(4, id);
//
//            int rows = pstmt.executeUpdate();
//            disconnect();
//
//            if (rows > 0){
//                return 1;
//            }else return 0;
//        }catch (SQLException e){
//            e.printStackTrace();
//            return -1;
//        }
//    }
//    public int changeValue(String table, String column, int id, int change){
//        try{
//            connect();
//
//            pstmt = conn.prepareStatement("UPDATE ? SET ? = ? WHERE PESSOAID =?");
//
//            pstmt.setString(1, table);
//            pstmt.setString(2, column);
//            pstmt.setInt(3, change);
//            pstmt.setInt(4, id);
//
//            int rows = pstmt.executeUpdate();
//            disconnect();
//
//            if (rows > 0){
//                return 1;
//            }else return 0;
//        }catch (SQLException e){
//            e.printStackTrace();
//            return -1;
//        }
//    }
//    public int changeValue(String table, String column, int id, float change){
//        try{
//            connect();
//
//            pstmt = conn.prepareStatement("UPDATE ? SET ? = ? WHERE PESSOAID =?");
//
//            pstmt.setString(1, table);
//            pstmt.setString(2, column);
//            pstmt.setFloat(3, change);
//            pstmt.setInt(4, id);
//
//            int rows = pstmt.executeUpdate();
//            disconnect();
//
//            if (rows > 0){
//                return 1;
//            }else return 0;
//        }catch (SQLException e){
//            e.printStackTrace();
//            return -1;
//        }
//    }
//    public int changeValue(String table, String column, int id, double change){
//        try{
//            connect();
//
//            pstmt = conn.prepareStatement("UPDATE ? SET ? = ? WHERE PESSOAID =?");
//
//            pstmt.setString(1, table);
//            pstmt.setString(2, column);
//            pstmt.setDouble(3, change);
//            pstmt.setInt(4, id);
//
//            int rows = pstmt.executeUpdate();
//            disconnect();
//
//            if (rows > 0){
//                return 1;
//            }else return 0;
//        }catch (SQLException e){
//            e.printStackTrace();
//            return -1;
//        }
//    }
//
//    public int changeValue(String table, String column, int id, Date change){
//        try{
//            connect();
//
//            pstmt = conn.prepareStatement("UPDATE ? SET ? = ? WHERE PESSOAID =?");
//
//            pstmt.setString(1, table);
//            pstmt.setString(2, column);
//            pstmt.setDate(3, change);
//            pstmt.setInt(4, id);
//
//            int rows = pstmt.executeUpdate();
//            disconnect();
//
//            if (rows > 0){
//                return 1;
//            }else return 0;
//        }catch (SQLException e){
//            e.printStackTrace();
//            return -1;
//        }
//    }
//    public int changeValue(String table, String column, int id, Time change){
//        try{
//            connect();
//
//            pstmt = conn.prepareStatement("UPDATE ? SET ? = ? WHERE PESSOAID =?");
//
//            pstmt.setString(1, table);
//            pstmt.setString(2, column);
//            pstmt.setTime(3, change);
//            pstmt.setInt(4, id);
//
//            int rows = pstmt.executeUpdate();
//            disconnect();
//
//            if (rows > 0){
//                return 1;
//            }else return 0;
//        }catch (SQLException e){
//            e.printStackTrace();
//            return -1;
//        }
//    }
//
////  DEFINIÇÃO DO MÉTODO remove --> Re'
//    public int remove(String tabela, int id){
//        try{
//            connect();
//
//            pstmt = conn.prepareStatement("DELETE FROM ? WHERE PESSOAID =?");
//            pstmt.setString(1, tabela);
//            pstmt.setInt(2, id);
//
//            int rows = pstmt.executeUpdate();
//            disconnect();
//
//            if (rows > 0){
//                return 1;
//            } else {
//                return 0;
//            }
//
//        }catch (SQLException e){
//            e.printStackTrace();
//            return -1;
//        }
//    }
//
////    DEFINIÇÃO DE MÉTODOS DE ANÁLISE DE DADOS
//    public ResultSet listAll(String tabela){
//        try{
//            connect();
//
//            pstmt = conn.prepareStatement("SELECT * FROM ?");
//            pstmt.setString(1, tabela);
//            ResultSet rset = pstmt.executeQuery();
//
//            disconnect();
//            return rset;
//        } catch (Exception e) {
//            e.printStackTrace();
//            return null;
//        }
//    }
//
//    public ResultSet listWhereEqual(String table, String column, String condition){
//        try{
//            connect();
//
//            pstmt = conn.prepareStatement("SELECT * FROM ? WHERE ? = ?");
//            pstmt.setString(1, table);
//            pstmt.setString(2, column);
//            pstmt.setString(3, condition);
//
//            ResultSet rset = pstmt.executeQuery();
//            disconnect();
//            return rset;
//        } catch (Exception e) {
//            e.printStackTrace();
//            return null;
//        }
//    }
//
//    public ResultSet listWhereEqual(String table, String column, char condition){
//        try{
//            connect();
//
//            pstmt = conn.prepareStatement("SELECT * FROM ? WHERE ? = ?");
//            pstmt.setString(1, table);
//            pstmt.setString(2, column);
//            pstmt.setString(3, String.valueOf(condition));
//
//            ResultSet rset = pstmt.executeQuery();
//            disconnect();
//            return rset;
//        } catch (Exception e) {
//            e.printStackTrace();
//            return null;
//        }
//    }
//
//    public ResultSet listWhereEqual(String table, String column, int condition){
//        try{
//            connect();
//
//            pstmt = conn.prepareStatement("SELECT * FROM ? WHERE ? = ?");
//            pstmt.setString(1, table);
//            pstmt.setString(2, column);
//            pstmt.setInt(3, condition);
//
//            ResultSet rset = pstmt.executeQuery();
//            disconnect();
//            return rset;
//        } catch (Exception e) {
//            e.printStackTrace();
//            return null;
//        }
//    }
//    public ResultSet listWhereEqual(String table, String column, float condition){
//        try{
//            connect();
//
//            pstmt = conn.prepareStatement("SELECT * FROM ? WHERE ? = ?");
//            pstmt.setString(1, table);
//            pstmt.setString(2, column);
//            pstmt.setFloat(3, condition);
//
//            ResultSet rset = pstmt.executeQuery();
//            disconnect();
//            return rset;
//        } catch (Exception e) {
//            e.printStackTrace();
//            return null;
//        }
//    }
//    public ResultSet listWhereEqual(String table, String column, double condition){
//        try{
//            connect();
//
//            pstmt = conn.prepareStatement("SELECT * FROM ? WHERE ? = ?");
//            pstmt.setString(1, table);
//            pstmt.setString(2, column);
//            pstmt.setDouble(3, condition);
//
//            ResultSet rset = pstmt.executeQuery();
//            disconnect();
//            return rset;
//        } catch (Exception e) {
//            e.printStackTrace();
//            return null;
//        }
//    }
//    public ResultSet listWhereEqual(String table, String column, boolean condition){
//        try{
//            connect();
//
//            pstmt = conn.prepareStatement("SELECT * FROM ? WHERE ? = ?");
//            pstmt.setString(1, table);
//            pstmt.setString(2, column);
//            pstmt.setBoolean(3, condition);
//
//            ResultSet rset = pstmt.executeQuery();
//            disconnect();
//            return rset;
//        } catch (Exception e) {
//            e.printStackTrace();
//            return null;
//        }
//    }
//    public ResultSet listWhereEqual(String table, String column, Date condition){
//        try{
//            connect();
//
//            pstmt = conn.prepareStatement("SELECT * FROM ? WHERE ? = ?");
//            pstmt.setString(1, table);
//            pstmt.setString(2, column);
//            pstmt.setDate(3, condition);
//
//            ResultSet rset = pstmt.executeQuery();
//            disconnect();
//            return rset;
//        } catch (Exception e) {
//            e.printStackTrace();
//            return null;
//        }
//    }
//    public ResultSet listWhereEqual(String table, String column, Time condition){
//        try{
//            connect();
//
//            pstmt = conn.prepareStatement("SELECT * FROM ? WHERE ? = ?");
//            pstmt.setString(1, table);
//            pstmt.setString(2, column);
//            pstmt.setTime(3, condition);
//
//            ResultSet rset = pstmt.executeQuery();
//            disconnect();
//            return rset;
//        } catch (Exception e) {
//            e.printStackTrace();
//            return null;
//        }
//    }
    //  SELECTS POR TABELA
    //  TABELA UNIVERSITARIO
}
