package psk.bam_1.initializers;

import java.util.ArrayList;
import java.util.List;

import lombok.Data;
import lombok.NoArgsConstructor;
import psk.bam_1.entity.PostEntity;

@Data
@NoArgsConstructor
public class PostsToAddConfig {
    private List<PostEntity> posts = new ArrayList<>();
}
