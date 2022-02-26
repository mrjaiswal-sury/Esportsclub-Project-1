import com.google.auth.oauth2.GoogleCredentials;
import com.google.common.collect.Lists;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Random;

public class AddFile {
    public static void main(String[] args) throws Exception {
    GoogleCredentials credentials=authExplicit("E:\\Users\\Suryaansh Jaiswal\\Desktop\\key\\mercurial-shape-342406-57be7ff47199.json");
    File file=new File("E:\\Users\\Suryaansh Jaiswal\\Desktop\\explicit pics");
    while(true) {
        String[] files= file.list();
        int length = files.length;
        Random random = new Random();
        if(length>0){
            int x=random.nextInt(length);
            Path name=Path.of("E:\\Users\\Suryaansh Jaiswal\\Desktop\\explicit pics\\"+files[x]);
            System.out.println(name+"   "+x);
            UploadObject.uploadObject(files[x],String.valueOf(name),credentials,"jpg");
            Send.send(files[x]);
            Files.delete(name);
        }else{
            break;
        }

        }
    }

    static GoogleCredentials authExplicit(String jsonPath)throws IOException{
        GoogleCredentials credentials=GoogleCredentials.fromStream(new FileInputStream(jsonPath)).createScoped(Lists.newArrayList("https://www.googleapis.com/auth/cloud-platform"));
        return credentials;
    }
}
