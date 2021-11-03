

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum TokenType {
    ACCESS("access_token", 12), REFRESH("refresh_token", 24 * 14);

    private String name;
    private int maxHour;
}
