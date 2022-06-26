package ru.netology.manager;

import ru.netology.domain.Ticket;
import ru.netology.repository.Repository;

import java.security.PublicKey;
import java.util.Arrays;
import java.util.Comparator;

public class Manager {
  private Repository repo;
  
  public Manager(Repository repo) {
    this.repo = repo;
  }
  
  public void save(Ticket newTicket) {
    repo.add(newTicket);
  }
  public void removeById(int id) {
    repo.remove(id);
  }
  
  public Ticket[] findAll(String from, String to, Comparator<Ticket> comparator) {
    Ticket[] result = new Ticket[0];
    for (Ticket ticket : repo.findAll()) {
      if ((ticket.getFromAirport().equals(from)) && (ticket.getToAirport().equals(to))) {
        Ticket[] tmp = new Ticket[result.length + 1];
        for (int i = 0; i < result.length; i++) {
          tmp[i] = result[i];
        }
        tmp[tmp.length - 1] = ticket;
        result = tmp;
      }
    }
    Arrays.sort(result, comparator);
    return result;
  }
  
  public Ticket[] getTickets(){
    return repo.findAll();
  }
  
}
