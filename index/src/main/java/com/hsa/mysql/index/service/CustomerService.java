package com.hsa.mysql.index.service;

import com.hsa.mysql.index.model.CustomerDto;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.Instant;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CustomerService {

  private static final String SQL_INSERT = "INSERT INTO customer (ID, NAME, BIRTHDAY) VALUES (?,?,?)";
  private static final String SQL_SELECT = "SELECT id, name, birthday FROM customer WHERE birthday = ?";

  public List<CustomerDto> getCustomerByBirthday(String birthday) {
    List<CustomerDto> customers = new LinkedList<>();
    try (Connection conn = DriverManager.getConnection(
        "jdbc:mysql://localhost:3306/index_performance", "root", "password");
        PreparedStatement psSelect = conn.prepareStatement(SQL_SELECT)) {

      psSelect.setString(1, birthday);

      long beforeExecution = Instant.now().getEpochSecond();
      System.out.println(beforeExecution);
      ResultSet rs = psSelect.executeQuery();

      long afterExecution = Instant.now().getEpochSecond();

      System.out.println(afterExecution - beforeExecution);

      while (rs.next()) {
        CustomerDto customerDto = new CustomerDto();
        customerDto.setId(rs.getInt("id"));
        customerDto.setName(rs.getString("name"));
        customerDto.setBirthday(rs.getString("birthday"));
        customers.add(customerDto);
      }
      rs.close();
    } catch (SQLException ex) {
      System.err.format("SQL State: %s\n%s", ex.getSQLState(), ex.getMessage());
    } catch (Exception e) {
      e.printStackTrace();
    }
    return customers;
  }

  public void postThousandRecords() {

    try (Connection conn = DriverManager.getConnection(
        "jdbc:mysql://localhost:3306/index_performance", "root", "password");
        PreparedStatement psInsert = conn.prepareStatement(SQL_INSERT)) {

      // commit all or rollback all, if any errors
      conn.setAutoCommit(false); // default true
      for (long i = 40_520_001; i <= 40_530_000; i++) {
        psInsert.setLong(1, i);
        psInsert.setString(2, "Mark");
        psInsert.setString(3, DateTimeFormatter.ofPattern("MM/dd/yyyy")
            .withZone(ZoneId.systemDefault())
            .format(Instant.ofEpochSecond(ThreadLocalRandom.current().nextInt())));
        psInsert.addBatch();
      }

      int[] rows = psInsert.executeBatch();
      conn.commit();
      psInsert.clearBatch();


    } catch (
        SQLException e) {
      System.err.format("SQL State: %s\n%s", e.getSQLState(), e.getMessage());
    } catch (
        Exception e) {
      e.printStackTrace();
    }
  }

  public void init() {

    try (Connection conn = DriverManager.getConnection(
        "jdbc:mysql://localhost:3306/index_performance", "root", "password");
        PreparedStatement psInsert = conn.prepareStatement(SQL_INSERT)) {

      // commit all or rollback all, if any errors
      conn.setAutoCommit(false); // default true
      for (long i = 1; i <= 8_000_000; i++) {
        psInsert.setLong(1, i);
        psInsert.setString(2, "Lesli");
        psInsert.setString(3, DateTimeFormatter.ofPattern("MM/dd/yyyy")
            .withZone(ZoneId.systemDefault())
            .format(Instant.ofEpochSecond(ThreadLocalRandom.current().nextInt())));
        psInsert.addBatch();
      }

      int[] rows = psInsert.executeBatch();
      conn.commit();
      psInsert.clearBatch();


    } catch (
        SQLException e) {
      System.err.format("SQL State: %s\n%s", e.getSQLState(), e.getMessage());
    } catch (
        Exception e) {
      e.printStackTrace();
    }
  }


  public void init2() {

    try (Connection conn = DriverManager.getConnection(
        "jdbc:mysql://localhost:3306/index_performance", "root", "password");
        PreparedStatement psInsert = conn.prepareStatement(SQL_INSERT)) {

      // commit all or rollback all, if any errors
      conn.setAutoCommit(false); // default true
      for (long i = 8_000_001; i <= 16_000_000; i++) {
        psInsert.setLong(1, i);
        psInsert.setString(2, "Mike");
        psInsert.setString(3, DateTimeFormatter.ofPattern("MM/dd/yyyy")
            .withZone(ZoneId.systemDefault())
            .format(Instant.ofEpochSecond(ThreadLocalRandom.current().nextInt())));
        psInsert.addBatch();

        if (i % 1000 == 0) {
          int[] rows = psInsert.executeBatch();
          conn.commit();
          psInsert.clearBatch();
        }

      }
    } catch (
        SQLException e) {
      System.err.format("SQL State: %s\n%s", e.getSQLState(), e.getMessage());
    } catch (
        Exception e) {
      e.printStackTrace();
    }
  }

  public void init3() {

    try (Connection conn = DriverManager.getConnection(
        "jdbc:mysql://localhost:3306/index_performance", "root", "password");
        PreparedStatement psInsert = conn.prepareStatement(SQL_INSERT)) {

      // commit all or rollback all, if any errors
      conn.setAutoCommit(false); // default true
      for (long i = 16_000_001; i <= 24_000_000; i++) {
        psInsert.setLong(1, i);
        psInsert.setString(2, "Mike");
        psInsert.setString(3, DateTimeFormatter.ofPattern("MM/dd/yyyy")
            .withZone(ZoneId.systemDefault())
            .format(Instant.ofEpochSecond(ThreadLocalRandom.current().nextInt())));
        psInsert.addBatch();

        if (i % 1000 == 0) {
          int[] rows = psInsert.executeBatch();
          conn.commit();
          psInsert.clearBatch();
        }

      }
    } catch (
        SQLException e) {
      System.err.format("SQL State: %s\n%s", e.getSQLState(), e.getMessage());
    } catch (
        Exception e) {
      e.printStackTrace();
    }
  }

  public void init4() {

    try (Connection conn = DriverManager.getConnection(
        "jdbc:mysql://localhost:3306/index_performance", "root", "password");
        PreparedStatement psInsert = conn.prepareStatement(SQL_INSERT)) {

      // commit all or rollback all, if any errors
      conn.setAutoCommit(false); // default true
      for (long i = 24_000_001; i <= 32_000_000; i++) {
        psInsert.setLong(1, i);
        psInsert.setString(2, "Mike");
        psInsert.setString(3, DateTimeFormatter.ofPattern("MM/dd/yyyy")
            .withZone(ZoneId.systemDefault())
            .format(Instant.ofEpochSecond(ThreadLocalRandom.current().nextInt())));
        psInsert.addBatch();

        if (i % 1000 == 0) {
          int[] rows = psInsert.executeBatch();
          conn.commit();
          psInsert.clearBatch();
        }

      }
    } catch (
        SQLException e) {
      System.err.format("SQL State: %s\n%s", e.getSQLState(), e.getMessage());
    } catch (
        Exception e) {
      e.printStackTrace();
    }
  }

  public void init5() {

    try (Connection conn = DriverManager.getConnection(
        "jdbc:mysql://localhost:3306/index_performance", "root", "password");
        PreparedStatement psInsert = conn.prepareStatement(SQL_INSERT)) {

      // commit all or rollback all, if any errors
      conn.setAutoCommit(false); // default true
      for (long i = 32_000_001; i <= 40_000_000; i++) {
        psInsert.setLong(1, i);
        psInsert.setString(2, "Mike");
        psInsert.setString(3, DateTimeFormatter.ofPattern("MM/dd/yyyy")
            .withZone(ZoneId.systemDefault())
            .format(Instant.ofEpochSecond(ThreadLocalRandom.current().nextInt())));
        psInsert.addBatch();

        if (i % 1000 == 0) {
          int[] rows = psInsert.executeBatch();
          conn.commit();
          psInsert.clearBatch();
        }

      }
    } catch (SQLException e) {
      System.err.format("SQL State: %s\n%s", e.getSQLState(), e.getMessage());
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

}
