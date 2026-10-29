package com.ces2.clase0.controladores;

import com.ces2.clase0.modelos.*;
import com.ces2.clase0.repositories.RepositorioTerritorio;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.*;
import java.util.function.Function;

@Controller
public class ControladorTrabajo3 {

    private final RepositorioTerritorio repo = new RepositorioTerritorio();

    @GetMapping("/")
    public String verTrabajoCompleto(Model model) {
        Stack<Region> stackRegiones = repo.getStackRegiones();
        Deque<Region> dequeRegiones = repo.getTerritorioGlobal().getRegiones();

        // --- DATOS DEL PUNTO 2 ---
        List<String> listaStackOutput = new ArrayList<>();
        List<String> listaDequeOutput = new ArrayList<>();

        ListIterator<Region> listIterator = stackRegiones.listIterator();
        while (listIterator.hasNext()) {
            Region r = listIterator.next();
            listaStackOutput.add("Región: " + r.getNombre() + 
                    " | EnumRegion: " + r.getEnumRegion() + 
                    " | Categoría: " + r.getCategoria() + 
                    " | Países: " + r.getNumeroPaises());
        }

        Iterator<Region> iterator = dequeRegiones.iterator();
        while (iterator.hasNext()) {
            Region r = iterator.next();
            listaDequeOutput.add("Región: " + r.getNombre() + 
                    " | EnumRegion: " + r.getEnumRegion() + 
                    " | Categoría: " + r.getCategoria() + 
                    " | Población: " + r.getPoblacionMillones() + "M");
        }

        // --- DATOS DEL PUNTO 3 ---
        Deque<Region> dequeCopia = new ArrayDeque<>(dequeRegiones);
        List<String> resultadoFiltrado = new ArrayList<>();
        dequeCopia.stream()
                .filter(r -> r.getEnumRegion() == EnumRegion.ASIA)
                .forEach(r -> resultadoFiltrado.add("Objeto filtrado: " + r.getNombre() + 
                        " | Enum: " + r.getEnumRegion() + 
                        " | Categoría: " + r.getCategoria()));

        // --- DATOS DE LOS PUNTOS 4 Y 5 ---
        Function<Region, Integer> funcionSumaConteo = region -> {
            return region.getConteo().stream().mapToInt(Integer::intValue).sum();
        };

        Region regionPrueba = repo.getStackRegiones().peek();
        int sumaDirecta = funcionSumaConteo.apply(regionPrueba);
        int totalVerTotales = regionPrueba.verTotales(funcionSumaConteo);

        // --- ENVIAR TODO AL MODELO ---
        model.addAttribute("listaStackOutput", listaStackOutput);
        model.addAttribute("listaDequeOutput", listaDequeOutput);
        model.addAttribute("resultadoFiltrado", resultadoFiltrado);
        model.addAttribute("nombreRegion", regionPrueba.getNombre());
        model.addAttribute("elementosConteo", regionPrueba.getConteo().toString());
        model.addAttribute("sumaDirecta", sumaDirecta);
        model.addAttribute("totalVerTotales", totalVerTotales);

        return "vistaTrabajo3";
    }
}