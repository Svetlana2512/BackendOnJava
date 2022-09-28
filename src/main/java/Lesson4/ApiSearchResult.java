package Lesson4;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ApiSearchResult {
    private List<ApiSearchResultItem> results;
    private Integer offset;
    private Integer number;
    private Integer totalResults;
}