import ru.stc.worker.Worker;
import ru.stc.worker.WorkerInvHandler;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.lang.reflect.Proxy;

public class Main {
    public static void main(String[] args) throws Exception {
        Worker worker =
                (Worker) Proxy.newProxyInstance(
                        Worker.class.getClassLoader(),
                        new Class[]{Worker.class},
                        new WorkerInvHandler()
                );
        while (true) {
            new BufferedReader(new InputStreamReader(System.in)).readLine();
            worker.init();
            worker.doWork();

        }
    }
}
