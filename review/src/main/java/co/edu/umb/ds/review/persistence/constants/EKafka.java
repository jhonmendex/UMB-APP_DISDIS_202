package co.edu.umb.ds.review.persistence.constants;


public enum EKafka {
    BOOTSTRAP_SERVER_KAFKA("localhost:9092"),
    REVIEW_TOPIC("review-by-product-event"),
    GROUP_ID("reviews_group"),
    PRODUCT_INFO_TOPIC("product-info-event");

    private final String message;

    EKafka(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
