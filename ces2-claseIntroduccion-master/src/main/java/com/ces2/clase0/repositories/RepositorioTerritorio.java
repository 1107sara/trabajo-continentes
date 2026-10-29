package com.ces2.clase0.repositories;

import com.ces2.clase0.modelos.*;
import java.util.Stack;

public class RepositorioTerritorio {

    private Stack<Region> stackRegiones;
    private Territorio territorioGlobal;

    public RepositorioTerritorio() {
        this.stackRegiones = new Stack<>();
        cargarDatos();
    }

    private void cargarDatos() {
        // PUNTO 1: Crear 5 objetos del tipo Region con los dos Enums asignados
        Region r1 = new Region("Región Oriental", 6, 1600.0, EnumRegion.ASIA, Categoria.CONTINENTAL);
        r1.agregarConteo(10);
        r1.agregarConteo(20);
        r1.agregarConteo(30);

        Region r2 = new Region("Región Sur", 12, 430.0, EnumRegion.ASIA, Categoria.CONTINENTAL);
        r2.agregarConteo(5);
        r2.agregarConteo(15);

        Region r3 = new Region("Región Occidental", 9, 190.0, EnumRegion.ASIA, Categoria.CONTINENTAL);
        r3.agregarConteo(100);

        Region r4 = new Region("Región Insular", 11, 675.0, EnumRegion.ASIA, Categoria.CONTINENTAL);
        // Sin elementos en conteo para probar listas/stacks vacíos

        Region r5 = new Region("Región Central", 7, 50.0, EnumRegion.ASIA, Categoria.CONTINENTAL);
        r5.agregarConteo(2);
        r5.agregarConteo(4);
        r5.agregarConteo(6);
        r5.agregarConteo(8);

        // Guardar los 5 objetos en un Stack de tipo Region
        stackRegiones.push(r1);
        stackRegiones.push(r2);
        stackRegiones.push(r3);
        stackRegiones.push(r4);
        stackRegiones.push(r5);

        // Crear el objeto Territorio con los mismos Enums
        territorioGlobal = new Territorio("Territorio Asiático", EnumRegion.ASIA, Categoria.CONTINENTAL);

        // Agregar los 5 objetos de tipo Region al Deque del objeto Territorio
        territorioGlobal.agregarRegion(r1);
        territorioGlobal.agregarRegion(r2);
        territorioGlobal.agregarRegion(r3);
        territorioGlobal.agregarRegion(r4);
        territorioGlobal.agregarRegion(r5);
    }

    public Stack<Region> getStackRegiones() {
        return stackRegiones;
    }

    public Territorio getTerritorioGlobal() {
        return territorioGlobal;
    }
}