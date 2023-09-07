import javax.swing.JOptionPane;
import java.util.Stack;

public class Principal {
    public static void main(String[] args) {
        String expresionInfija = JOptionPane.showInputDialog("Ingrese una expresión infija:");
        String expresionSufijaFinal = InfijaSufija.convertir(expresionInfija);

        JOptionPane.showMessageDialog(null, "Expresión infija: " + expresionInfija + "\nExpresión sufija: " + expresionSufijaFinal);
    }

    public static boolean esOperando(String estring) {
        return estring.matches("[a-zA-Z0-9]+");
    }

    public static boolean esOperador(String estringg) {
        return estringg.matches("[+\\-*/]");
    }

    public static int precedencia(String operador) {
        switch (operador) {case "+": case "-":
                return 1; case "*": case "/":
                return 2;
        }
        return 0;
    }
}