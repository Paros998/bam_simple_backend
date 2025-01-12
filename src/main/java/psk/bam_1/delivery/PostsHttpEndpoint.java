package psk.bam_1.delivery;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import psk.bam_1.api.PostModel;
import psk.bam_1.entity.PostEntity;
import psk.bam_1.entity.PostRepository;

@RequestMapping("api/v1/posts")
@RequiredArgsConstructor
@RestController
public class PostsHttpEndpoint {
    private final PostRepository postRepository;

    @GetMapping
    public List<PostModel> getPosts() {
        return postRepository.findAll().stream()
                .map(this::toPostModel)
                .toList();
    }

    private PostModel toPostModel(final @NonNull PostEntity post) {
        return PostModel.builder()
                .title(post.getTitle())
                .content(post.getContent())
                .build();
    }
}
