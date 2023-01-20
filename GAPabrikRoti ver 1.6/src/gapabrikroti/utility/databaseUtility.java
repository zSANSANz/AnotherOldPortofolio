/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gapabrikroti.utility;

import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;
import gapabrikroti.dao.CrossOverDAO;
import gapabrikroti.dao.CrossOverGenerationDAO;
import gapabrikroti.dao.DaftarIndexDAO;
import gapabrikroti.dao.EvaluasiDAO;
import gapabrikroti.dao.EvaluasiGenerationDAO;
import gapabrikroti.dao.KoordinatDAO;
import gapabrikroti.dao.MutasiDAO;
import gapabrikroti.dao.MutasiGenerationDAO;
import gapabrikroti.dao.ParameterDAO;
import gapabrikroti.dao.PopulasiDAO;
import gapabrikroti.dao.RataRataDAO;
import gapabrikroti.dao.RouleteWheelDAO;
import gapabrikroti.dao.RouleteWheelGenerationDAO;
import gapabrikroti.dao.UserDAO;
import gapabrikroti.dao.impl.jdbc.CrossOverDAOImpl;
import gapabrikroti.dao.impl.jdbc.CrossOverGenerationDAOImpl;
import gapabrikroti.dao.impl.jdbc.DaftarIndexDAOImpl;
import gapabrikroti.dao.impl.jdbc.EvaluasiDAOImpl;
import gapabrikroti.dao.impl.jdbc.EvaluasiGenerationDAOImpl;
import gapabrikroti.dao.impl.jdbc.KoordinatDAOImpl;
import gapabrikroti.dao.impl.jdbc.MutasiDAOImpl;
import gapabrikroti.dao.impl.jdbc.MutasiGenerationDAOImpl;
import gapabrikroti.dao.impl.jdbc.ParameterDAOImpl;
import gapabrikroti.dao.impl.jdbc.PopulasiDAOImpl;
import gapabrikroti.dao.impl.jdbc.RataRataDAOImpl;
import gapabrikroti.dao.impl.jdbc.RouleteWheelDAOImpl;
import gapabrikroti.dao.impl.jdbc.RouleteWheelGenerationDAOImpl;
import gapabrikroti.dao.impl.jdbc.UserDAOImpl;
import java.sql.Connection;
import java.sql.SQLException;



/**
 *
 * @author cvgs
 */
public class databaseUtility {
    private static Connection connection;
    private static UserDAO userDAO;
    private static DaftarIndexDAO daftarIndexDAO;
    private static KoordinatDAO koordinatDAO;
    private static ParameterDAO parameterDAO;
    private static PopulasiDAO populasiDAO;
    private static EvaluasiDAO evaluasiDAO;
    private static RataRataDAO rataRataDAO;
    private static RouleteWheelDAO rouleteWheelDAO;
    private static CrossOverDAO crossOverDAO;
    private static MutasiDAO mutasiDAO;
    private static EvaluasiGenerationDAO evaluasiGenerationDAO;
    private static RouleteWheelGenerationDAO rouleteWheelGenerationDAO;
    private static CrossOverGenerationDAO crossOverGenerationDAO;
    private static MutasiGenerationDAO mutasiGenerationDAO;
    
    public static Connection getConnection() throws SQLException {
        if (connection == null) {
            MysqlDataSource dataSource = new MysqlDataSource();
            dataSource.setUrl("jdbc:mysql://localhost/pabrik_roti");
            dataSource.setUser("root");
            dataSource.setPassword("");

            connection = dataSource.getConnection();
        }
        return connection;
    }
    
    public static UserDAO getUserDAO() throws SQLException {
        if (userDAO == null) {
           userDAO = new UserDAOImpl(getConnection());
        }
        return userDAO;
    }
    
    public static DaftarIndexDAO getDaftarIndexDAO() throws SQLException {
        if (daftarIndexDAO == null) {
           daftarIndexDAO = new DaftarIndexDAOImpl(getConnection());
        }
        return daftarIndexDAO;
    }
    
    public static KoordinatDAO getKoordinatDAO() throws SQLException {
        if (koordinatDAO == null) {
           koordinatDAO = new KoordinatDAOImpl(getConnection());
        }
        return koordinatDAO;
    }
    
    public static ParameterDAO getParameterDAO() throws SQLException {
        if (parameterDAO == null) {
            parameterDAO = new ParameterDAOImpl(getConnection());
        }
        return parameterDAO;
    }
    
    public static PopulasiDAO getPopulasiDAO() throws SQLException {
        if (populasiDAO == null) {
            populasiDAO = new PopulasiDAOImpl(getConnection());
        }
        return populasiDAO;
    }
    
    public static EvaluasiDAO getEvaluasiDAO() throws SQLException {
        if (evaluasiDAO == null) {
            evaluasiDAO = new EvaluasiDAOImpl(getConnection());
        }
        return evaluasiDAO;
    }
    
    public static RataRataDAO getRataRataDAO() throws SQLException {
        if (rataRataDAO == null) {
            rataRataDAO = new RataRataDAOImpl(getConnection());
        }
        return rataRataDAO;
    }
    
    public static RouleteWheelDAO getRouleteWheelDAO() throws SQLException {
        if (rouleteWheelDAO == null) {
            rouleteWheelDAO = new RouleteWheelDAOImpl(getConnection());
        }
        return rouleteWheelDAO;
    }
    
    public static CrossOverDAO getCrossOverDAO() throws SQLException {
        if (crossOverDAO == null) {
            crossOverDAO = new CrossOverDAOImpl(getConnection());
        }
        return crossOverDAO;
    }
    
    public static MutasiDAO getMutasiDAO() throws SQLException {
        if (mutasiDAO == null) {
            mutasiDAO = new MutasiDAOImpl(getConnection());
        }
        return mutasiDAO;
    }
    
    public static EvaluasiGenerationDAO getEvaluasiGenerationDAO() throws SQLException {
        if (evaluasiGenerationDAO == null) {
            evaluasiGenerationDAO = new EvaluasiGenerationDAOImpl(getConnection());
        }
        return evaluasiGenerationDAO;
    }
    
    public static RouleteWheelGenerationDAO getRouleteWheelGenerationDAO() throws SQLException {
        if (rouleteWheelGenerationDAO == null) {
            rouleteWheelGenerationDAO = new RouleteWheelGenerationDAOImpl(getConnection());
        }
        return rouleteWheelGenerationDAO;
    }
    
    public static CrossOverGenerationDAO getCrossOverGenerationDAO() throws SQLException {
        if (crossOverGenerationDAO == null) {
            crossOverGenerationDAO = new CrossOverGenerationDAOImpl(getConnection());
        }
        return crossOverGenerationDAO;
    }
    
    public static MutasiGenerationDAO getMutasiGenerationDAO() throws SQLException {
        if (mutasiGenerationDAO == null) {
            mutasiGenerationDAO = new MutasiGenerationDAOImpl(getConnection());
        }
        return mutasiGenerationDAO;
    }
}
