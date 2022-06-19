package ru.netology.domain;

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
  
  
  @Override
  public String toString() {
    return Integer.toString(price) + " - " + Integer.toString(id);
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
}
