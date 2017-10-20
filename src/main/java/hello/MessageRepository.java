package hello;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(collectionResourceRel = "message",path="messages")
public interface MessageRepository extends PagingAndSortingRepository<Message,Integer> {

}
