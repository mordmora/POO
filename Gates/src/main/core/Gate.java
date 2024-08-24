/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package main.core;

import java.util.HashSet;
import java.util.Set;

/**
 *
 * @author Mord Mora
 */
public class Gate {

    private final String name;
    private boolean input_pinA;
    private boolean input_pinB;
    private boolean output_pin;

    private static final Set<String> VALID_GATE_NAMES = new HashSet<>();

    static {
        VALID_GATE_NAMES.add("AND");
        VALID_GATE_NAMES.add("OR");
        VALID_GATE_NAMES.add("NOT");
        VALID_GATE_NAMES.add("NAND");
        VALID_GATE_NAMES.add("NOR");
        VALID_GATE_NAMES.add("XOR");
        VALID_GATE_NAMES.add("XNOR");
    }

    public Gate(String name){

        if(!VALID_GATE_NAMES.contains(name.toUpperCase())){
            throw new IllegalArgumentException("La compuerta que se está intentando crear no existe.");
        }

        this.input_pinA = false;
        this.input_pinB = false;
        this.output_pin = false;
        this.name = name;
    }

    public boolean getInputPinA(){
        return input_pinA;
    }

    public boolean getInputPinB(){
        return input_pinB;
    }

    public boolean getOutpuPin(){
        return output_pin;
    }

    public String getName(){
        return name;
    }

    public void setInputPinA(boolean A){
        this.input_pinA = A;
    }

    public void setInputPinB(boolean B){
        this.input_pinB = B;
    }

    private void initPins(boolean A, boolean B){
        this.input_pinA = A;
        this.input_pinB = B;
    }

    public boolean operate(boolean A, boolean B) {
        initPins(A, B);
        switch (this.name.toUpperCase()) {
            case "OR" -> {
                this.output_pin = this.input_pinA || this.input_pinB;
                return this.output_pin;
            }
            case "AND" -> {
                this.output_pin = this.input_pinA && this.input_pinB;
                return this.output_pin;
            }
            case "NOT" -> {
                // NOT opera solo en el primer pin de entrada
                this.output_pin = !this.input_pinA;
                return this.output_pin;
            }
            case "NAND" -> {
                this.output_pin = !(this.input_pinA && this.input_pinB);
                return this.output_pin;
            }
            case "NOR" -> {
                this.output_pin = !(this.input_pinA || this.input_pinB);
                return this.output_pin;
            }
            case "XOR" -> {
                this.output_pin = this.input_pinA != this.input_pinB;
                return this.output_pin;
            }
            case "XNOR" -> {
                this.output_pin = this.input_pinA == this.input_pinB;
                return this.output_pin;
            }
            default -> throw new UnsupportedOperationException("Compuerta no soportada: " + this.name);
        }
    }
}
