
package ru.netology.repository;

import ru.netology.domain.Ticket;

public class Repository {
  private Ticket[] tickets=new Ticket[0];
  
  public Repository(){
  
  }
  
  public void add(Ticket newTicket){
    Ticket[] tmp=new Ticket[tickets.length+1];
    for (int i = 0; i < tickets.length; i++) {
      tmp[i]=tickets[i];
    }
    tmp[tmp.length-1]=newTicket;
    tickets=tmp;
  }
  
  public void remove(int id){
    Ticket[] tmp= new Ticket[tickets.length-1];
    int index=0;
    for (int i = 0; i < tickets.length; i++) {
      if (tickets[i].getId()!=id){
        tmp[index]=tickets[i];
        index++;
      }
    }
    tickets=tmp;
  }
  
  public Ticket[] findAll(){
    return tickets;
  }
}