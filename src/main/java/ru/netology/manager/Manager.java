package ru.netology.manager;

import ru.netology.domain.Ticket;
import ru.netology.repository.Repository;

import java.util.Arrays;

public class Manager {
  Repository repo = new Repository();
  Ticket[] tickets = new Ticket[0];
  
  public Manager(Repository repo) {
    this.repo = repo;
  }
  
  public void save(Ticket newTicket) {
    repo.add(newTicket);
  }
  
  public void removeById(int id) {
    repo.remove(id);
  }
  
  public Ticket[] findAll(String from, String to) {
    Ticket[] result = new Ticket[0];
    for (Ticket ticket : repo.findAll()) {
      if ((ticket.getFromAirport() == from) && (ticket.getToAirport() == to)) {
        Ticket[] tmp = new Ticket[result.length + 1];
        for (int i = 0; i < result.length; i++) {
          tmp[i] = result[i];
        }
        tmp[tmp.length - 1] = ticket;
        result = tmp;
      }
    }
    Arrays.sort(result);
    return result;
  }
  
}
