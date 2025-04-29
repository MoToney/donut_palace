package com.example.demo.bootstrap;

import com.example.demo.domain.OutsourcedPart;
import com.example.demo.domain.Part;
import com.example.demo.domain.Product;
import com.example.demo.domain.InhousePart;
import com.example.demo.repositories.OutsourcedPartRepository;
import com.example.demo.repositories.PartRepository;
import com.example.demo.repositories.ProductRepository;
import com.example.demo.service.OutsourcedPartService;
import com.example.demo.service.OutsourcedPartServiceImpl;
import com.example.demo.service.ProductService;
import com.example.demo.service.ProductServiceImpl;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

/**
 *
 *
 *
 *
 */
@Component
public class BootStrapData implements CommandLineRunner {

    private final PartRepository partRepository;
    private final ProductRepository productRepository;

    private final OutsourcedPartRepository outsourcedPartRepository;

    public BootStrapData(PartRepository partRepository, ProductRepository productRepository,
            OutsourcedPartRepository outsourcedPartRepository) {
        this.partRepository = partRepository;
        this.productRepository = productRepository;
        this.outsourcedPartRepository = outsourcedPartRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        if (partRepository.count() == 0) {
            InhousePart glazedDonut = new InhousePart();
            glazedDonut.setName("Glazed Donut");
            glazedDonut.setInv(5);
            glazedDonut.setPrice(0.99);
            glazedDonut.setId(1L);
            partRepository.save(glazedDonut);

            InhousePart chocolateDonut = new InhousePart();
            chocolateDonut.setName("Chocolate Donut");
            chocolateDonut.setInv(10);
            chocolateDonut.setPrice(1.49);
            chocolateDonut.setId(2L);
            partRepository.save(chocolateDonut);

            InhousePart becCroissant = new InhousePart();
            becCroissant.setName("Bacon,Egg,Cheese Croissant");
            becCroissant.setInv(7);
            becCroissant.setPrice(2.99);
            becCroissant.setId(3L);
            partRepository.save(becCroissant);

            InhousePart donutHoles = new InhousePart();
            donutHoles.setName("Donut Holes");
            donutHoles.setInv(12);
            donutHoles.setPrice(0.49);
            donutHoles.setId(4L);
            partRepository.save(donutHoles);

            OutsourcedPart cFrappe = new OutsourcedPart();
            cFrappe.setName("Caramel Frappe");
            cFrappe.setInv(3);
            cFrappe.setPrice(3.99);
            cFrappe.setId(5L);
            cFrappe.setCompanyName("McDonald's");
            outsourcedPartRepository.save(cFrappe);
        }

        if (productRepository.count() == 0) {

            Product dozenGlazed = new Product("Dozen Glazed Donuts", 10.0, 15);
            productRepository.save(dozenGlazed);
            Product dozenChocolate = new Product("Dozen Chocolate Donuts", 10.5, 15);
            productRepository.save(dozenChocolate);
            Product mixedGlazed = new Product("One Glazed Donut and Donut Holes", 11.0, 15);
            productRepository.save(mixedGlazed);
            Product breakfastCombo = new Product("Breakfast Combo", 12.0, 15);
            productRepository.save(breakfastCombo);
            Product theWorks = new Product("The Works", 15.0, 15);
            productRepository.save(theWorks);

            System.out.println("Started in Bootstrap");
            System.out.println("Number of Products" + productRepository.count());
            System.out.println(productRepository.findAll());
            System.out.println("Number of Parts" + partRepository.count());
            System.out.println(partRepository.findAll());
        }
    }


}
/*
 * OutsourcedPart o= new OutsourcedPart();
 * o.setCompanyName("Western Governors University");
 * o.setName("out test");
 * o.setInv(5);
 * o.setPrice(20.0);
 * o.setId(100L);
 * outsourcedPartRepository.save(o);
 * OutsourcedPart thePart=null;
 * List<OutsourcedPart> outsourcedParts=(List<OutsourcedPart>)
 * outsourcedPartRepository.findAll();
 * for(OutsourcedPart part:outsourcedParts){
 * if(part.getName().equals("out test"))thePart=part;
 * System.out.println(thePart.getCompanyName());
 * List<OutsourcedPart> outsourcedParts=(List<OutsourcedPart>)
 * outsourcedPartRepository.findAll();
 * for(OutsourcedPart part:outsourcedParts){
 * System.out.println(part.getName()+" "+part.getCompanyName());
 */