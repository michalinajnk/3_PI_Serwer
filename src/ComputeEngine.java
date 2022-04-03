import compute.Compute;

import java.math.BigDecimal;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;



//Server side
public class ComputeEngine implements Compute {

    public ComputeEngine() {
        super();
    }

    public <T> T executeTask(compute.Task<T> t) {
        return t.execute();
    }

    public BigDecimal testPI(){
        return new BigDecimal("3.14");
    }

    public static void main(String[] args) throws MalformedURLException, RemoteException {

        try {

            Registry var1 = LocateRegistry.createRegistry(1099);
            System.out.println("ComputeEngine bound");

        } catch (Exception var4) {
            System.err.println("ComputeEngine exception:");
            var4.printStackTrace();
        }



        try {
            String name = "Compute";
           Compute engine = new ComputeEngine();
            Compute stub =
                    (Compute) UnicastRemoteObject.exportObject(engine, 0);
            Naming.rebind(name, stub);
        }
        catch(Exception var3){
            System.out.println("SERVER CAN'T BE REGISTERED!");
            var3.printStackTrace();
        }

    }

}