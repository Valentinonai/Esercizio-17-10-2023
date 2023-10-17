package org.example;

import com.github.javafaker.Faker;
import org.example.entities.Evento;
import org.example.entities.EventoDAO;
import org.example.entities.JpaUtil;

import javax.persistence.EntityManager;
import java.util.Random;

public class Application {

    public static void main(String[] args) {
        EntityManager em = JpaUtil.getEmf().createEntityManager();
        Faker fkr = new Faker();
        EventoDAO evdao = new EventoDAO(em);
        Random rnd = new Random();

        /*for (int i = 0; i < 10; i++) {
            evdao.save(new Evento(fkr.name().title(), LocalDate.of(rnd.nextInt(2023, 2025), rnd.nextInt(1, 13), rnd.nextInt(1, 29)), "Description", rnd.nextInt(1, 3) == 1 ? TipoEvento.PRIVATO : TipoEvento.PUBBLICO, rnd.nextInt(1, 1000)));
        }*/
        Evento found = evdao.getById(5);
        if (found != null)
            System.out.println(found);
        else System.out.println("Elemento non trovato");


        evdao.delete(5);

    }
}
