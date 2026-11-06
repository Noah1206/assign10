package com.example.demo.service;

import com.example.demo.dto.ProductRequest;
import com.example.demo.dto.ProductResponse;
import com.example.demo.entity.Product;
import com.example.demo.repository.ProductRepository;
import jakarta.transaction.Transactional;
import jakarta.websocket.server.ServerEndpoint;
import org.apache.coyote.Request;
import org.apache.coyote.Response;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {
    private final ProductRepository productRepository;
    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public ProductResponse create(ProductRequest request) {
        Product saved = productRepository.save(new Product(request)); // INSERT // save() : 받아온 객체를 db에 저장한다.
        // save()를 호출하면, 먼저 객체가 entity로서 추가되고, jpa가 db에 추가된 객체를 db에 맵핑하여 추가한다. 또한 기존 데이터 수정은 Jpa가 관리하는 persistence context에 들어가있기 때문에, entity 객체를 불러와서 수정해도 dirty checking으로 update가 반영된다.
        return ProductResponse.from(saved);
    }

    public List<ProductResponse> findAll() {
        return productRepository.findAll().stream().map(this::toResponse).toList(); // findAll() : 해당 테이블에 있는 모든 데이터들을 db에서 가지고온다

    }

    public ProductResponse findById(Long id) {
        return toResponse(checkProduct(id));
    }

    @Transactional
    public void update(Long id, ProductRequest request) {
        Product updateProduct = productRepository.findById(id).orElseThrow();
        updateProduct.update(request);

    }

    public void delete(Long id) {
        if (!productRepository.existsById(id)) { // existsById() : 해당 데이터가 실제로 존재하는지 안하는지 확인한다.
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Book not found: " + id); // deleteById() : id에 해당하는 객체를 db에서 삭제한다
        }
        productRepository.deleteById(id);
    }

    private Product checkProduct(Long id) { // 만약 id에 해당하는 데이터가 존재하지않는 null일 수도 있기 때문에, 만약 null일때 중단되지않고 null인 상태인 것을 클라이언트에게 알려줘야하기 때문에 Optional을 사용한다.
        return productRepository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Product is not found " + id)); // findById() : id에 해당하는 객체를 db에서 찾는다.
    }

    public List<Product> getProduct(String name) {
        return productRepository.findByName(name);
    }

    public List<Product> getPriceGreaterThan(Integer price) {
        return productRepository.findByPriceGreaterThan(price);
    }

    public List<Product> getPriceAsc() {
        return productRepository.findAllByOrderByPriceAsc();
    }

    private ProductResponse toResponse(Product request) {
        return new ProductResponse(request.getId(), request.getName(), request.getDescription(), request.getCategory(), request.getDate(), request.getPrice());
    }
}
