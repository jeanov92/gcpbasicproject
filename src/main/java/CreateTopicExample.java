// [START pubsub_quickstart_create_topic]
// Imports the Google Cloud client library

import com.google.api.gax.rpc.ApiException;
import com.google.cloud.ServiceOptions;
import com.google.cloud.pubsub.v1.TopicAdminClient;
import com.google.pubsub.v1.ProjectTopicName;

public class CreateTopicExample {

    /**
     * Create a topic.
     *
     * @param args topicId
     * @throws Exception exception thrown if operation is unsuccessful
     */
    public static void main(String... args) throws Exception {

        // Your Google Cloud Platform project ID
        String projectId = ServiceOptions.getDefaultProjectId();

        String topicId = "topic-from-java";

        // Create a new topic
        ProjectTopicName topic = ProjectTopicName.of(projectId, topicId);
        try (TopicAdminClient topicAdminClient = TopicAdminClient.create()) {
            topicAdminClient.createTopic(topic);
            System.out.printf("Topic %s:%s created.\n", topic.getProject(), topic.getTopic());
        } catch (ApiException e) {
            // example : code = ALREADY_EXISTS(409) implies topic already exists
            System.out.print(e.getStatusCode().getCode());
            System.out.print(e.isRetryable());
        }
    }
}
// [END pubsub_quickstart_create_topic]
