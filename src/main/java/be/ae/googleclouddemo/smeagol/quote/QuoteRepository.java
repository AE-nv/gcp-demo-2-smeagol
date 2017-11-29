package be.ae.googleclouddemo.smeagol.quote;

import org.springframework.data.repository.CrudRepository;

interface QuoteRepository extends CrudRepository<Quote, Integer> {

}