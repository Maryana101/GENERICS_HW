package ru.netology.domain;

import java.util.Objects;

public class Ticket implements Comparable<Ticket> {
  private int id;
  private int price;
  private String fromAirport;
  private String toAirport;
  private int flightDuration;
  
  public Ticket(int id, int price, String fromAirport, String toAirport, int flightDuration) {
    this.id = id;
    this.price = price;
    this.fromAirport = fromAirport;
    this.toAirport = toAirport;
    this.flightDuration = flightDuration;
  }
  
  @Override
  public int compareTo(Ticket o) {
    if (price > o.price) {
      return 1;
    }
    if (price < o.price) {
      return -1;
    }
    return 0;
  }
  
  public int getId() {
    return id;
  }
  
  public String getFromAirport() {
    return fromAirport;
  }
  
  public String getToAirport() {
    return toAirport;
  }
  
  public int getFlightDuration() {
    return flightDuration;
  }
  
  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    Ticket ticket = (Ticket) o;
    return id == ticket.id && price == ticket.price && flightDuration == ticket.flightDuration && Objects.equals(fromAirport, ticket.fromAirport) && Objects.equals(toAirport, ticket.toAirport);
  }
  
  @Override
  public int hashCode() {
    return Objects.hash(id, price, fromAirport, toAirport, flightDuration);
  }
  
  public void setId(int id) {
    this.id = id;
  }
  
  public int getPrice() {
    return price;
  }
  
  public void setPrice(int price) {
    this.price = price;
  }
  
  public void setFromAirport(String fromAirport) {
    this.fromAirport = fromAirport;
  }
  
  public void setToAirport(String toAirport) {
    this.toAirport = toAirport;
  }
  
  public void setFlightDuration(int flightDuration) {
    this.flightDuration = flightDuration;
  }
}
