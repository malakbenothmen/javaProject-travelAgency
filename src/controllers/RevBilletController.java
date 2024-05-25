package controllers;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import connexion.Connexion;
import models.Billflight;
import models.Flight;

public class RevBilletController {

    

    public void createBillflight(Billflight billflight) {
        String sql = "INSERT INTO Billflight(flight_id, user_id, fullName, passport, pricefrais, category, SeatType, numSeat) VALUES(?,?,?,?,?,?,?,?)";

        try (Connection con = Connexion.obtenirConnexion();
             PreparedStatement pstmt = con.prepareStatement(sql)) {
            pstmt.setInt(1, billflight.getFlight_id());
            pstmt.setInt(2, billflight.getUser_id());
            pstmt.setString(3, billflight.getFullName());
            pstmt.setInt(4, billflight.getPassport());
            pstmt.setDouble(5, billflight.getPricefrais());
            pstmt.setString(6, billflight.getCategory());
            pstmt.setString(7, billflight.getSeatType());
            pstmt.setInt(8, billflight.getNumSeat());

            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
    
    public int getSeatsRevByClass(int flightId ,String classe) {
        String sql = "SELECT count(*) FROM Billflight WHERE flight_id = ? and seatType = ?";
        try (Connection conn = Connexion.obtenirConnexion();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setInt(1, flightId);
            pstmt.setString(2, classe);
            ResultSet rs = pstmt.executeQuery();
            int i =0;

            while (rs.next()) {
            	i++;
           
                return i ;
            }
 
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }

    public Billflight findBillflightById(int id) {
        String sql = "SELECT * FROM Billflight WHERE billflight_id = ?";
        Billflight billflight = null;

        try (Connection conn = Connexion.obtenirConnexion();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, id);
            ResultSet rs = pstmt.executeQuery();

            if (rs.next()) {
                billflight = new Billflight();
                billflight.setBillflight_id(rs.getInt("billflight_id"));
                billflight.setFlight_id(rs.getInt("flight_id"));
                billflight.setUser_id(rs.getInt("user_id"));
                billflight.setFullName(rs.getString("fullName"));
                billflight.setPassport(rs.getInt("passport"));
                billflight.setPricefrais(rs.getDouble("pricefrais"));
                billflight.setCategory(rs.getString("category"));
                billflight.setSeatType(rs.getString("SeatType"));
                billflight.setNumSeat(rs.getInt("numSeat"));
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        return billflight;
    }
    public List<Billflight> findAllReservation() {
        String sql = "SELECT * FROM Billflight";
        List<Billflight> reservations = new ArrayList<>();

        try (Connection conn = Connexion.obtenirConnexion();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                Billflight billflight = new Billflight();
                billflight.setBillflight_id(rs.getInt("billflight_id"));
                billflight.setFlight_id(rs.getInt("flight_id"));
                billflight.setUser_id(rs.getInt("user_id"));
                billflight.setFullName(rs.getString("fullName"));
                billflight.setPassport(rs.getInt("passport"));
                billflight.setPricefrais(rs.getDouble("pricefrais"));
                billflight.setCategory(rs.getString("category"));
                billflight.setSeatType(rs.getString("SeatType"));
                billflight.setNumSeat(rs.getInt("numSeat"));
                
                reservations.add(billflight);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        return reservations;
    }
    
    
    public List<Billflight> findByAirlineName(String airlineName) {
        String sql = "SELECT * FROM Billflight bf JOIN Flight f ON bf.flight_id = f.flight_id JOIN Airline a ON f.airline_id = a.airline_id WHERE a.name = ?";
        List<Billflight> reservations = new ArrayList<>();

        try (Connection conn = Connexion.obtenirConnexion();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, airlineName);
            ResultSet rs = pstmt.executeQuery();

            while (rs.next()) {
                Billflight billflight = new Billflight();
                billflight.setBillflight_id(rs.getInt("billflight_id"));
                billflight.setFlight_id(rs.getInt("flight_id"));
                billflight.setUser_id(rs.getInt("user_id"));
                billflight.setFullName(rs.getString("fullName"));
                billflight.setPassport(rs.getInt("passport"));
                billflight.setPricefrais(rs.getDouble("pricefrais"));
                billflight.setCategory(rs.getString("category"));
                billflight.setSeatType(rs.getString("SeatType"));
                billflight.setNumSeat(rs.getInt("numSeat"));

                reservations.add(billflight);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        return reservations;
    }
    
    public List<Billflight> findByDepartureDate(LocalDate departureDate) {
        String sql = "SELECT * FROM Billflight bf JOIN Flight f ON bf.flight_id = f.flight_id WHERE f.d_depart = ?";
        List<Billflight> reservations = new ArrayList<>();

        try (Connection conn = Connexion.obtenirConnexion();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setDate(1, java.sql.Date.valueOf(departureDate));
            ResultSet rs = pstmt.executeQuery();

            while (rs.next()) {
                Billflight billflight = new Billflight();
                billflight.setBillflight_id(rs.getInt("billflight_id"));
                billflight.setFlight_id(rs.getInt("flight_id"));
                billflight.setUser_id(rs.getInt("user_id"));
                billflight.setFullName(rs.getString("fullName"));
                billflight.setPassport(rs.getInt("passport"));
                billflight.setPricefrais(rs.getDouble("pricefrais"));
                billflight.setCategory(rs.getString("category"));
                billflight.setSeatType(rs.getString("SeatType"));
                billflight.setNumSeat(rs.getInt("numSeat"));

                reservations.add(billflight);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        return reservations;
    }

    
   
}
