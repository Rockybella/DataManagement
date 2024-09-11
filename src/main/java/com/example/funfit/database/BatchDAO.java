package com.example.funfit.database;

import com.example.funfit.model.Batch;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class BatchDAO implements DAO {

    @Override
    public Connection getConnection() {
        return Database.getInstance().getConnection();
    }

    @Override
    public void closeConnection() {
        Database.getInstance().closeConnection();
    }

    @Override
    public int executeUpdate(PreparedStatement preparedStatement) {
        return Database.getInstance().executeUpdate(preparedStatement);
    }

    @Override
    public ResultSet executeQuery(PreparedStatement preparedStatement) {
        return Database.getInstance().executeQuery(preparedStatement);
    }

    public void addBatch(Batch batch) {
        String sql = "INSERT INTO batch (batchName, instructor) VALUES (?, ?)";
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setString(1, batch.getBatchName());
            preparedStatement.setString(2, batch.getInstructor());
            executeUpdate(preparedStatement);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeConnection();
        }
    }

    public List<Batch> getAllBatches() {
        List<Batch> batches = new ArrayList<>();
        String sql = "SELECT * FROM batch";
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql);
             ResultSet resultSet = executeQuery(preparedStatement)) {
            while (resultSet.next()) {
                Batch batch = new Batch();
                batch.setBid(resultSet.getInt("bid"));
                batch.setBatchName(resultSet.getString("batchName"));
                batch.setInstructor(resultSet.getString("instructor"));
                batches.add(batch);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeConnection();
        }
        return batches;
    }
}
