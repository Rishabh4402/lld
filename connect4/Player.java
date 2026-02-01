package connect4;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Player {
    private String name;
    private Color color;
}
