import java.util.Stack;

public class InfijaSufija {
    public static String convertir(String expresionInfija) {
        String[] tokens = expresionInfija.split("\\s+");
        StringBuilder expresionSufija = new StringBuilder();
        Stack<String> pila = new Stack<>();

        for (String tokensito : tokens) {
            switch (tokensito) {
                case "+": case "-": case "*": case "/":
                    while (!pila.isEmpty() && Principal.esOperador(pila.peek()) && Principal.precedencia(pila.peek()) >= Principal.precedencia(tokensito)) {
                        expresionSufija.append(pila.pop()).append(" ");
                    }
                    pila.push(tokensito);
                    break;
                case "(":
                    pila.push(tokensito);
                    break;
                case ")":
                    while (!pila.isEmpty() && !pila.peek().equals("(")) {
                        expresionSufija.append(pila.pop()).append(" ");
                    }
                    if (!pila.isEmpty() && pila.peek().equals("(")) {
                        pila.pop();
                    }
                    break;
                default:
                    if (Principal.esOperando(tokensito)) {
                        expresionSufija.append(tokensito).append(" ");
                    }
                    break;
            }
        }

        while (!pila.isEmpty()) {
            expresionSufija.append(pila.pop()).append(" ");
        }

        return expresionSufija.toString().trim();
    }
}