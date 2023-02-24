package stepDefs;

import io.cucumber.java.en.Given;
import org.junit.Assert;
import utilities.DBUtils;

import java.util.List;
import java.util.Map;

public class Question4StepDef {

    private static int count = 0;

    @Given("the title {string} and count {long} should match the DB record")
    public void the_title_and_count_should_match_the_db_record(String title, long copy_count) {
        String query = "SELECT title,COUNT(*) \n" +
                "FROM store s\n" +
                "JOIN inventory i ON i.store_id = s.store_id\n" +
                "JOIN film f ON f.film_id = i.film_id\n" +
                "WHERE s.store_id = 1\n" +
                "GROUP BY title,f.film_id\n" +
                "HAVING \n" +
                "(COUNT(*) = (SELECT MAX(count) FROM store1_movieCounts))\n" +
                "ORDER BY f.film_id\n" +
                "LIMIT 5\n";

        List<Map<String,Object>> resultMapList = DBUtils.getQueryResultMap(query);
        Map<String,Object> resultMap = resultMapList.get(count++);
        Assert.assertEquals(title,resultMap.get("title"));
        Assert.assertEquals(copy_count, resultMap.get("count"));
    }
}
