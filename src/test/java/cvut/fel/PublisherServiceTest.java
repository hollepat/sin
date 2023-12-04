package cvut.fel;

import cvut.fel.service.PublisherServiceImp;
import org.junit.jupiter.api.Test;

public class PublisherServiceTest {

    private PublisherServiceImp publisherServiceImp;

    @Test
    public void createContract() {

        assert publisherServiceImp.createContract(1L, 1L);

    }


}
