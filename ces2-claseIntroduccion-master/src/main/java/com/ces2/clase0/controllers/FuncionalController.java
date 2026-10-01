package com.ces2.clase0.controllers;

import com.ces2.clase0.modelo.IContinente;
import com.ces2.clase0.modelo.Region;
import com.ces2.clase0.repositories.ContinenteRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.stream.Collectors;

@Controller
public class FuncionalController {

    private final ContinenteRepository repository = new ContinenteRepository();

    // PUNTO 1: Petición 1 - Muestra los nombres de las clases en una sola línea separados por coma
    @GetMapping("/peticion1")
    public String peticion1(Model model) {
        String nombres = repository.obtenerTodos().stream()
                .map(IContinente::getNombre)
                .collect(Collectors.joining(", "));

        model.addAttribute("titulo", "Punto 1 - Nombres concatenados");
        model.addAttribute("resultado", "Nombres de los 12 objetos: " + nombres);
        return "vistaFuncional";
    }

    // PUNTO 2: Petición 2 - Datos estadísticos (conteo, suma, promedio, min, max) de las regiones
    @GetMapping("/peticion2")
    public String peticion2(Model model) {
        IntSummaryStatistics estadisticas = repository.obtenerTodos().stream()
                .flatMap(c -> c.getRegiones().stream())
                .mapToInt(Region::getPoblacion)
                .summaryStatistics();

        String statsInfo = String.format("Conteo: %d | Suma total: %d | Promedio: %.2f | Mínimo: %d | Máximo: %d",
                estadisticas.getCount(),
                estadisticas.getSum(),
                estadisticas.getAverage(),
                estadisticas.getMin(),
                estadisticas.getMax());

        model.addAttribute("titulo", "Punto 2 - Datos Estadísticos");
        model.addAttribute("resultado", statsInfo);
        return "vistaFuncional";
    }

    // PUNTO 3: Petición 3 - Lista de un atributo String (nombres de todas las regiones)
    @GetMapping("/peticion3")
    public String peticion3(Model model) {
        List<String> nombresRegiones = repository.obtenerTodos().stream()
                .flatMap(c -> c.getRegiones().stream())
                .map(Region::getNombre)
                .collect(Collectors.toList());

        model.addAttribute("titulo", "Punto 3 - Lista de nombres de regiones");
        model.addAttribute("resultado", nombresRegiones.toString());
        return "vistaFuncional";
    }

    // PUNTO 4: Petición 4 - Uso de anyMatch() y noneMatch()
    @GetMapping("/peticion4")
    public String peticion4(Model model) {
        List<Region> todasLasRegiones = repository.obtenerTodos().stream()
                .flatMap(c -> c.getRegiones().stream())
                .collect(Collectors.toList());

        boolean matchPoblacion = todasLasRegiones.stream().anyMatch(r -> r.getPoblacion() > 300);
        boolean matchClima = todasLasRegiones.stream().anyMatch(r -> r.getClima().equals("Tropical"));
        boolean noneNegative = todasLasRegiones.stream().noneMatch(r -> r.getPoblacion() < 0);

        String analisis = "¿Alguna región tiene más de 300 de población? " + matchPoblacion +
                " | ¿Alguna región tiene clima Tropical? " + matchClima +
                " | ¿Ninguna región tiene población negativa? " + noneNegative;

        model.addAttribute("titulo", "Punto 4 - Consultas anyMatch y noneMatch");
        model.addAttribute("resultado", analisis);
        return "vistaFuncional";
    }

    // PUNTO 5: Petición 5 - Objeto con el valor máximo del atributo Integer (población)
    @GetMapping("/peticion5")
    public String peticion5(Model model) {
        Region regionMax = repository.obtenerTodos().stream()
                .flatMap(c -> c.getRegiones().stream())
                .max((r1, r2) -> Integer.compare(r1.getPoblacion(), r2.getPoblacion()))
                .orElse(null);

        String resultadoText = (regionMax != null)
                ? "Región con mayor población: " + regionMax.getNombre() + " (" + regionMax.getPoblacion() + " habitantes)"
                : "No se encontraron regiones.";

        model.addAttribute("titulo", "Punto 5 - Región con mayor valor Integer");
        model.addAttribute("resultado", resultadoText);
        return "vistaFuncional";
    }
}