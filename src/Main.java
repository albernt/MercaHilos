import java.util.Random;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Random random = new Random();
        Cliente[] clientes = new Cliente[5];
        for(int i = 0; i < 5; i++) {
            clientes[i] = new Cliente("Cliente " + (i+1), random.nextInt(5) + 1);
        }
        Caja caja1 = new Caja(1);
        Caja caja2 = new Caja(2);


        for (Cliente cliente : clientes) {
            if (random.nextBoolean()) {
                caja1.cobrar(cliente);
            } else {
                caja2.cobrar(cliente);
            }
        }



    }
}