package concurrency.cp7;

import concurrency.common.Constant;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.attribute.PosixFilePermission;
import java.nio.file.attribute.PosixFilePermissions;
import java.util.Set;
import java.util.concurrent.TimeUnit;

/**
 * @author yanyuchi
 * @date 2020-03-07 21:19
 */
public class PreventDuplicated {

    public static void main(String[] args) throws IOException {
        Runtime.getRuntime().addShutdownHook(new Thread(() -> {
            System.out.println("The program received kill SIGNAL.");
            getLockFile().toFile().delete();

        }));

        checkRunning();
        for(;;){
            try{
                TimeUnit.MILLISECONDS.sleep(1);
            }catch (InterruptedException e){
                e.printStackTrace();
            }
        }

    }


    private static void checkRunning() throws IOException{
        Path path =getLockFile();
        if(path.toFile().exists()){
            throw  new RuntimeException("The program already running.");
        }
        Set<PosixFilePermission> perms = PosixFilePermissions.fromString(Constant.HOOK.PERMISSIONS);
        Files.createFile(path,PosixFilePermissions.asFileAttribute(perms));
    }

    private static Path getLockFile(){
        return Paths.get(Constant.HOOK.LOCK_PATH,Constant.HOOK.LOCK_FILE);
    }
}
