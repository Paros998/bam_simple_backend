package psk.bam_1.initializers;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.transaction.annotation.Transactional;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import psk.bam_1.entity.PostRepository;

@Log4j2
@RequiredArgsConstructor
public class PostsInitializer implements ApplicationRunner {
    private final PostRepository postRepository;
    private final PostsToAddConfig config;

    @Override
    @Transactional
    public void run(final ApplicationArguments args) {
        log.info("{} running", this.getClass().getSimpleName());

        postRepository.saveAll(config.getPosts());

        log.info("Initialized posts: {}", config.getPosts());
    }
}
