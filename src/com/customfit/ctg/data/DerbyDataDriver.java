/**
 * 
 */
package com.customfit.ctg.data;

import com.customfit.ctg.*;
import com.customfit.ctg.model.*;
import java.util.*;
import java.io.*;
import java.sql.*;

/**
 * WORKINPROGRESS:
 * The DerbyDataDriver class represents one of the DataDriverInterfaces
 * aimed at providing embedded data operations for the application.
 * 
 * @author David
 */
public class DerbyDataDriver implements DataDriverInterface {

	private final String JDBC_DRIVER = "org.apache.derby.jdbc.EmbeddedDriver";
	private String dbName = "." + File.separator + "app_data" + File.separator + "derby.db";
	private String connectionString = "jdbc:derby:" + dbName + ";create=true";
	private Connection connection = null;
	
	@Override
	public boolean connect(String connectionString) {
		this.connectionString = connectionString;
		
		//load driver
		try {
			Class.forName(connectionString);
		} catch (ClassNotFoundException e) {
			Controller.dumpException("The JDBC Embedded Derby driver not found. (" + this.JDBC_DRIVER + ")", e);
			return false;
		}

		//boot database
		try {
			connection = DriverManager.getConnection(connectionString);
		} catch (SQLException e) {
			Controller.dumpException("SQLException has occurred while connecting to Derby database.", e);
			return false;
		}

		//return connection state
		return this.isConnected();
	}
	
	@Override
	public void close() {
		if (this.connection != null){
			try {
				this.connection.close();
			} catch (SQLException e) {
				Controller.dumpException("SQLException has occurred while closing connection to Derby database.", e);
			}
		}
	}

	@Override
	public boolean isConnected() {
		if (this.connection != null){
			try {
				return !(this.connection.isClosed());
			} catch (SQLException e) {
				Controller.dumpException("SQLException has occurred while checking connection state to Derby database in isConnected().", e);
				return false;
			}
		}
		else
			return false;
	}

	@Override
	public List<Recipe> selectAllRecipes() {
		ArrayList<Recipe> recipes = new ArrayList<Recipe>();
		Statement statement; 
		// TODO Auto-generated method stub
		try {
			statement = this.connection.createStatement();
			if (statement.execute("SELECT Name, Description, Instructions, ServingSizeQuantity, ServingSizeUnit, Servings, Rating FROM Recipe"))
			{
				ResultSet response = statement.getResultSet();
//				do
//				{
//					Recipe recipe = new Recipe(
//							response.getString(0),
//							response.getString(1),
//							response.getString(2),
//							response.getDouble(3),
//							new MeasurableUnit(response.getDouble(4), response.getString(5)),
//							response.getDouble(6),
//							response.getDouble(7));
//					recipes.add(recipe);
//				}
//				while (response.next());
			}
		} catch (SQLException e) {
			Controller.dumpException("SQLException occurred while performing select all recipes operation.", e);
		}
		return null;
	}

	@Override
	public List<Recipe> selectRecipesByName(String recipeName) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean insertRecipe(Recipe newRecipe) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean updateRecipeByName(String currentRecipeName,
			Recipe updatedRecipe) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean deleteRecipeByName(String recipeName) {
		// TODO Auto-generated method stub
		return false;
	}

}
