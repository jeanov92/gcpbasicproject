import com.google.api.gax.rpc.ApiException;
import com.google.cloud.ServiceOptions;
import com.google.cloud.pubsub.v1.TopicAdminClient;
import com.google.pubsub.v1.ProjectTopicName;

import java.io.IOException;

public class DeleteTopicExample {

    public static void main(String[] args) throws IOException {
        // Your Google Cloud Platform project ID
        String projectId = ServiceOptions.getDefaultProjectId();
        String topicName = "topic-from-java";
        String projectTopicName = ProjectTopicName.of(projectId, topicName).toString();

        try (TopicAdminClient topicAdminClient = TopicAdminClient.create()) {
            System.out.println(projectTopicName + " will be deleted!");
            topicAdminClient.deleteTopic(projectTopicName);
            System.out.println(projectTopicName + " deleted successfully");
        } catch (ApiException e) {
            System.out.print(e.getStatusCode().getCode());
            System.out.print(e.isRetryable());
        }

    }
}
