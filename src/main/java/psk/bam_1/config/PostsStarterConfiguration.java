package psk.bam_1.config;

import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;

import psk.bam_1.entity.PostRepository;
import psk.bam_1.initializers.PostsInitializer;
import psk.bam_1.initializers.PostsToAddConfig;

@Configuration
@ConditionalOnProperty(prefix = "posts.starter", value = "enabled", havingValue = "true")
public class PostsStarterConfiguration {

    @Bean
    @ConfigurationProperties(prefix = "posts.starter.data")
    public PostsToAddConfig postsToAddConfig() {
        return new PostsToAddConfig();
    }

    @Bean
    public PostsInitializer postsInitializer(
            final @Lazy PostRepository postRepository) {
        return new PostsInitializer(postRepository, postsToAddConfig());
    }
}
