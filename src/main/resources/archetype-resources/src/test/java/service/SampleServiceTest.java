package ${package}.service;

import com.github.fakemongo.Fongo;
import com.mongodb.DB;
import ${package}.Application;
import ${package}.dto.IdentityDTO;
import org.jongo.Jongo;
import org.jongo.MongoCollection;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.boot.test.WebIntegrationTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Date;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

@RunWith(SpringJUnit4ClassRunner.class)
@WebIntegrationTest(value = {"spring.profiles.active=DEV"})
@SpringApplicationConfiguration(Application.class)
public class UIDAllocatorServiceTest {

    private MongoCollection collection;

    @Autowired
    private SampleService service;

    @Before
    public void before() throws Exception {
        DB db = new Fongo("UnitTest").getDB("${databaseName}");
        Jongo jongo = new Jongo(db);

        this.collection = jongo.getCollection("${collectionName}");
        this.service.setTestMongoCollection(collection);
    }

    @Test
    public void check() {
        IdentityDTO identity = IdentityDTO.builder()
                .uid("12345")
                .build();

        this.collection.save(identity);

        IdentityDTO actual = this.service.check();
        assertThat(actual.getUid(), is("12345"));
    }
}
