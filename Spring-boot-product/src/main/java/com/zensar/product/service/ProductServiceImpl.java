package com.zensar.product.service;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import com.zensar.product.controller.entity.Product;
import com.zensar.product.dto.ProductDto;
import com.zensar.product.repository.ProductRepository;

@Service
public class ProductServiceImpl implements ProductService {

	private List<Product> products = new ArrayList<Product>();
	@Autowired
	private ProductRepository productRepository;
	@Autowired
	private ModelMapper modelMapper;

	public ProductServiceImpl() {
		// products.add(new Product(100, "Iphone", 50000, "02-08-2022"));
		// products.add(new Product(101, "Realme", 20000, "02-04-2022"));
		// products.add(new Product(102, "Vivo", 30000, "06-08-2022"));
	}

	@Override
	public ProductDto getProduct(int productId) {
		Product getProduct = productRepository.findById(productId).get();
		return modelMapper.map(getProduct, ProductDto.class);
		// return mapToDto(getCoupon);
	}

	@Override
	// public List<Product> getAllProducts() {
	// public List<ProductDto> getAllProducts(int pageNumber,int pageSize) {

	// List<Product> listOfProductDto = productRepository.findAll();
	// Page<Product> findAll = productRepository.findAll(PageRequest.of(1, 5));
	// Page<Product> findAll =
	// productRepository.findAll(PageRequest.of(pageNumber,pageSize));
	// Page<Product> findAll =
	// productRepository.findAll(PageRequest.of(pageNumber,pageSize,Sort.by(Direction.DESC,"productName")));
	// Page<Product> findAll =
	// productRepository.findAll(PageRequest.of(pageNumber,pageSize,Sort.by(Direction.ASC,"productName")));
	// Page<Product> findAll =
	// productRepository.findAll(PageRequest.of(pageNumber,pageSize,Direction.DESC,"productName"));
	// Page<Product> findAll =
	// productRepository.findAll(PageRequest.of(pageNumber,pageSize,Direction.ASC,"productName"));
	public List<ProductDto> getAllProducts(int pageNumber, int pageSize, String sortBy, Direction dir) {
		Page<Product> findAll = productRepository.findAll(PageRequest.of(pageNumber, pageSize, dir, sortBy));
		List<Product> content = findAll.getContent();
		List<ProductDto> listOfProductDto = new ArrayList<ProductDto>();
		/*
		 * for (Product product : listOfProductDto) {
		 * //listOfProductDto.add(mapToDto(product));
		 * listOfProductDto.add(modelMapper.map(product,ProductDto.class)); }
		 */
		for (Product product : content)
			listOfProductDto.add(modelMapper.map(product, ProductDto.class));
		return listOfProductDto;
	}

	@Override
	// public void insertProduct(Product product) {
	// products.add(product);
	public ProductDto insertProduct(ProductDto productDto) {

		/*
		 * Product product=new Product();
		 * product.setProductId(productDto.getProductId());
		 * product.setProductName(productDto.getProductName());
		 * product.setProductCost(productDto.getProductCost());
		 * product.setProductExp(productDto.getProductExp());
		 */

		// Product product=mapToEntity(productDto);
		Product product = modelMapper.map(productDto, Product.class);
		Product insertedProduct = productRepository.save(product);
		// return modelMapper.map(insertedProduct);
		return modelMapper.map(insertedProduct, ProductDto.class);

	}

	@Override
	// public void updateProduct(int productId, Product product) {

	/*
	 * Product product1 = getProduct(productId);
	 * product1.setProductId(product.getProductId());
	 * product1.setProductName(product.getProductName());
	 * product1.setProductCost(product.getProductCost());
	 * product1.setProductExp(product.getProductExp());
	 * products.add(product1);
	 */

	public void updateProduct(int productId, ProductDto productDto) {
		/*
		 * Product product=new Product();
		 * product.setProductId(productDto.getProductId());
		 * product.setProductName(productDto.getProductName());
		 * product.setProductCost(productDto.getProductCost());
		 * product.setProductExp(productDto.getProductExp());
		 */

		// Product product=mapToEntity(productDto);
		Product product = modelMapper.map(productDto, Product.class);
		productRepository.save(product);

	}

	@Override
	public void deleteProduct(int productId) {

		/*
		 * for (int i = 0; i < products.size(); i++) { Product product =
		 * products.get(i); if (product.getProductId() == productId) {
		 * products.remove(product);
		 * 
		 * } }
		 */productRepository.deleteById(productId);

	}

	@Override
	public List<ProductDto> getByProductName(String productName) {
		// List<Product> findByProductName=productRepository.findByProductName(productName);
		List<Product> findByProductName = productRepository.test(productName);
		List<ProductDto> productDtos = new ArrayList<ProductDto>();
		for (Product product : findByProductName)
			productDtos.add(modelMapper.map(product, ProductDto.class));

		return productDtos;
	}

	@Override
	public List<ProductDto> getByProductNameOrProductCost(String productName, int productCost) {
		List<Product> findByProductName = productRepository.findByProductNameOrProductCost(productName,productCost);
		List<ProductDto> productDtos = new ArrayList<ProductDto>();
		for (Product product : findByProductName)
			productDtos.add(modelMapper.map(product, ProductDto.class));

		return productDtos;
	}

	@Override
	public List<ProductDto> getByProductNameAndProductExp(String productName, String productExp) {
		List<Product> findByProductName = productRepository.test1(productName, productExp);
		List<ProductDto> productDtos = new ArrayList<ProductDto>();
		for (Product product : findByProductName)
			productDtos.add(modelMapper.map(product, ProductDto.class));

		return productDtos;
	}

	@Override
	public List<ProductDto> getByProductNameOrderByProductCost(String productName) {
		List<Product> findByProductName = productRepository.findByProductNameOrderByProductCost(productName);
		List<ProductDto> productDtos = new ArrayList<ProductDto>();
		for (Product product : findByProductName)
			productDtos.add(modelMapper.map(product, ProductDto.class));

		return productDtos;
	}
	/*
	 * public Product mapToEntity(ProductDto productDto) { Product product= new
	 * Product(); product.setProductId(productDto.getProductId());
	 * product.setProductName(productDto.getProductName());
	 * product.setProductCost(productDto.getProductCost());
	 * product.setProductExp(productDto.getProductExp()); return product; }
	 * public ProductDto mapToDto(Product product) { ProductDto dto=new
	 * ProductDto(); dto.setProductId(product.getProductId());
	 * dto.setProductName(product.getProductName());
	 * dto.setProductCost(product.getProductCost());
	 * dto.setProductExp(product.getProductExp()); return dto; }
	 */


}
