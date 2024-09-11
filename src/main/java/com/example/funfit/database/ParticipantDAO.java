package com.example.funfit.database;

import com.example.funfit.model.Participant;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ParticipantDAO implements DAO {

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

    public void addParticipant(Participant participant) {
        String sql = "INSERT INTO participant (name, phone, email, bid) VALUES (?, ?, ?, ?)";
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setString(1, participant.getName());
            preparedStatement.setString(2, participant.getPhone());
            preparedStatement.setString(3, participant.getEmail());
            preparedStatement.setInt(4, participant.getBid());
            executeUpdate(preparedStatement);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeConnection();
        }
    }

    public List<Participant> getAllParticipants() {
        List<Participant> participants = new ArrayList<>();
        String sql = "SELECT * FROM participant";
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql);
             ResultSet resultSet = executeQuery(preparedStatement)) {
            while (resultSet.next()) {
                Participant participant = new Participant();
                participant.setPid(resultSet.getInt("pid"));
                participant.setName(resultSet.getString("name"));
                participant.setPhone(resultSet.getString("phone"));
                participant.setEmail(resultSet.getString("email"));
                participant.setBid(resultSet.getInt("bid"));
                participants.add(participant);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeConnection();
        }
        return participants;
    }
}
