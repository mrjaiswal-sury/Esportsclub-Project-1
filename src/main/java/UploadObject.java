import com.google.auth.oauth2.GoogleCredentials;
import com.google.cloud.storage.BlobId;
import com.google.cloud.storage.BlobInfo;
import com.google.cloud.storage.Storage;
import com.google.cloud.storage.StorageOptions;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class UploadObject {
    public static void uploadObject( String objectName, String filePath, GoogleCredentials credential, String type) throws IOException{
        String projectId="mercurial-shape-342406";
        String bucketName="project-gv-folder";

        Storage storage=StorageOptions.newBuilder().setCredentials(credential).setProjectId(projectId).build().getService();
        BlobId blobId=BlobId.of(bucketName,objectName);

        BlobInfo blobInfo=BlobInfo.newBuilder(blobId).setContentType("image/"+type).build();
        storage.create(blobInfo,Files.readAllBytes(Paths.get(filePath)));
        System.out.println("File " + filePath + " uploaded to bucket " + bucketName + " as " + objectName);
    }
}
