package com.ces2.clase0.repositories;

import com.ces2.clase0.modelo.*;
import org.springframework.stereotype.Repository;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Repository
public class ContinenteRepository {

    public List<IContinente> obtenerTodos() {
        List<IContinente> lista12Objetos = new ArrayList<>();

        // Listas con diferentes cantidades de objetos (0, 1, 2, 3, 4 y 5 elementos) para la programación funcional
        List<Region> lista0 = new ArrayList<>();
        List<Region> lista1 = Arrays.asList(
                new Region("Norteamérica", "Templado", 350)
        );
        List<Region> lista2 = Arrays.asList(
                new Region("Sudamérica", "Tropical", 400),
                new Region("Centroamérica", "Cálido", 150)
        );
        List<Region> lista3 = Arrays.asList(
                new Region("Andina", "Frío", 100),
                new Region("Caribe", "Cálido", 200),
                new Region("Pacífico", "Húmedo", 300)
        );
        List<Region> lista4 = Arrays.asList(
                new Region("Asia Oriental", "Templado", 500),
                new Region("Sudeste Asiático", "Tropical", 250),
                new Region("Asia del Sur", "Monzónico", 600),
                new Region("Asia Central", "Seco", 80)
        );
        List<Region> lista5 = Arrays.asList(
                new Region("Polinesia", "Tropical", 20),
                new Region("Micronesia", "Cálido", 15),
                new Region("Melanesia", "Húmedo", 30),
                new Region("Australasia", "Desértico", 45),
                new Region("Insular", "Ecuatorial", 10)
        );

        // 12 Objetos instanciados de las 3 clases concretas asignadas (America, Asia, Oceania)
        lista12Objetos.add(new America("America del Norte", lista0));
        lista12Objetos.add(new America("America del Sur", lista1));
        lista12Objetos.add(new America("America Central", lista2));
        lista12Objetos.add(new America("America Insular", lista3));

        lista12Objetos.add(new Asia("Asia Oriental", lista4));
        lista12Objetos.add(new Asia("Asia del Sur", lista5));
        lista12Objetos.add(new Asia("Asia Occidental", lista0));
        lista12Objetos.add(new Asia("Asia Central", lista1));

        lista12Objetos.add(new Oceania("Polinesia", lista2));
        lista12Objetos.add(new Oceania("Micronesia", lista3));
        lista12Objetos.add(new Oceania("Melanesia", lista4));
        lista12Objetos.add(new Oceania("Australasia", lista5));

        return lista12Objetos;
    }
}