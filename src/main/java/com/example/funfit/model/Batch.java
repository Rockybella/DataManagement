package com.example.funfit.model;

import com.google.gson.annotations.SerializedName;

public class Batch {
	
	@SerializedName("bid")
    private int bid; // Matches the 'bid' column in the database
	
	@SerializedName("batchName")
    private String batchName; // Matches the 'batch_name' column in the database
	
	@SerializedName("instructor")
    private String instructor;

    // Default constructor
    public Batch() {
    }

    // Parameterized constructor
    public Batch(int bid, String batchName, String instructor) {
        this.bid = bid;
        this.batchName = batchName;
        this.instructor = instructor;
    }

    // Getter and setter for bid
    public int getBid() {
        return bid;
    }

    public void setBid(int bid) {
        this.bid = bid;
    }

    // Getter and setter for batchName
    public String getBatchName() {
        return batchName;
    }

    public void setBatchName(String batchName) {
        this.batchName = batchName;
    }

    // Getter and setter for instructor
    public String getInstructor() {
        return instructor;
    }

    public void setInstructor(String instructor) {
        this.instructor = instructor;
    }

    // toString method
    @Override
    public String toString() {
        return "Batch [bid=" + bid + ", batchName=" + batchName + ", instructor=" + instructor + "]";
    }
}
