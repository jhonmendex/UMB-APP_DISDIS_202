package co.edu.umb.ds.review;

import co.edu.umb.ds.review.persistence.entities.Product;
import co.edu.umb.ds.review.persistence.repositories.ProductRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class ReviewApplication {

  public static void main(String[] args) {
    SpringApplication.run(ReviewApplication.class, args);
  }
}
