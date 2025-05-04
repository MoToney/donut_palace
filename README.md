# CHANGES
 
### C.  Customize the HTML user interface for your customer’s application. The user interface should include the shop name, the product names, and the names of the parts.

**File name: demo.css**
*Line number: 1-16*
*Change: placed CSS styling for UI  in demo.css*
``` css 
html {

    height: 100%;

    border: 10px solid #4d0b06;

	}

  

body {

    justify-content: center;

    color: #DA9929;

    border: 1px solid white;

}

  

.navbar-brand {

    font: bold 2em 'Lobster', sans-serif;

    color: black;}
```

**File name: logo.jpg added to src/main/resources/static/images**

**File name: mainscreen.html**

*Line number: 15* | *Change: added link to demo.css*
	`<link rel="stylesheet" th:href="@{/css/demo.css}" />`

*Line number: 17 | Change: changed title to "Donut Palace"*
	*`<title>Donut Palace</title>`*

*Line number: 21-44 | Change: added navbar using bootstrap, navbar contains the name of the company, logo, and links to home and about.html which will be added in Part D*
```
    <header>

        <nav class="navbar navbar-expand-lg navbar-light bg-light">

            <div class="container-fluid">

                <a class="navbar-brand" href="/mainscreen">

                    <img th:src="@{/images/logo.jpg}" alt="Logo" width="55" height="55"

                        class="d-inline-block align-text-middle">

                    Donut Palace</a>

                <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarNav"

                    aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">

                    <span class="navbar-toggler-icon"></span>

                </button>

                <div class="collapse navbar-collapse" id="navbarNav">

                    <ul class="navbar-nav">

                        <li class="nav-item">

                            <a class="nav-link active" aria-current="page" href="/mainscreen">Home</a>

                        </li>

                        <li class="nav-item">

                            <a class="nav-link" href="/about">About</a>

                        </li>

                    </ul>

                </div>

            </div>

        </nav>

    </header>
```

*Line number: 49, 88 | Changes: changed the "parts" header for the table to "items" and changed the "products" header for the table to "meals"*
```
<h2>Items</h2>
```

```
<h2>Meals</h2>
```


---
### D.  Add an “About” page to the application to describe your chosen customer’s company to web viewers and include navigation to and from the “About” page and the main screen.

**File name: about.html created in src/main/resources/templates**
*Line number: 1 - 36 | Changes: added similar heading and navbar as mainscreen.html*
```
<!DOCTYPE html>

<html lang="en">

  

<head>

    <meta charset="UTF-8">

    <meta name="viewport" content="width=device-width, initial-scale=1">

    <title>About Us</title>

  

    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet"

        integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">

  

    <link rel="stylesheet" th:href="@{/css/demo.css}" />

</head>

  

<body>

    <header>

        <nav class="navbar navbar-expand-lg navbar-light bg-light">

            <div class="container-fluid">

                <a class="navbar-brand" href="/mainscreen">

                    <img th:src="@{/images/logo.jpg}" alt="Logo" width="55" height="55"

                        class="d-inline-block align-text-middle">

                    Donut Palace</a>

                <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarNav"

                    aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">

                    <span class="navbar-toggler-icon"></span>

                </button>

                <div class="collapse navbar-collapse" id="navbarNav">

                    <ul class="navbar-nav">

                        <li class="nav-item">

                            <a class="nav-link" href="/mainscreen">Home</a>

                        </li>

                        <li class="nav-item">

                            <a class="nav-link active" aria-current="page" href="/about">About</a>

                        </li>

                    </ul>

                </div>

            </div>

        </nav>

    </header>
```

*Line number: 41 - 43 | Changes: added information about the company "Donut Palace"*
```
<h1>About Donut Palace</h1>

    <p>Welcome to Donut Palace, where we serve the best donuts in town!</p>

    <p>Our mission is to provide delicious treats and a delightful experience for all our customers.</p>
```

*Line number: 44 | Changes: added another link to mainscreen.html*
`<a href="/mainscreen" class="btn btn-primary">Back to Home</a>`

**File name: AboutController.java created in src/main/java/com/example/demo/controllers**

*Line number: 1-9 | Changes: Set up the AboutController class and ensures that requests to /about map to the method specified

Line number: 11-15 | Changes: Defines a method that returns about.html*

```
package com.example.demo.controllers;

  

import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.GetMapping;

  

@RequestMapping("/about")

@Controller

public class AboutController {

  

    @GetMapping

    public String about() {

        return "about";

    }

}
```

---
### E.  Add a sample inventory appropriate for your chosen store to the application. You should have five parts and five products in your sample inventory and should not overwrite existing data in the database.

**File name: BootStrapData.java**
*Line number: 6, 43-79 | Changes: Created sample data for the Part database with if statement that guarantees the sample data is added only when the database is empty*

```
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
```

*Line number: 81-92 | Changes: Created sample data for the Product database with if statement that guarantees the sample data is added only when the database is empty*
```
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
```

**File name: application.properties**
*Line number: 6 | Changes: created a new database by changing the name*
```
spring.datasource.url=jdbc:h2:file:~/spring-boot-h2-db222
```

---
### F.  Add a “Buy Now” button to your product list. Your “Buy Now” button must meet each of the following parameters:
#### • The “Buy Now” button must be next to the buttons that update and delete products.
#### • The button should decrement the inventory of that product by one. It should not affect the inventory of any of the associated parts.
#### •  Display a message that indicates the success or failure of a purchase.

**File name: AddPartController.java**
*Line number: 67-83 | added method for the buying the part and directing the user to a fail or success page depending on if the inventory is available*
```
    @GetMapping("/buyPart")

    public String buyPart(@RequestParam("partID") int theId, Model theModel) {

  

        PartService repo = context.getBean(PartServiceImpl.class);

        OutsourcedPartService outsourcedrepo = context.getBean(OutsourcedPartServiceImpl.class);

        InhousePartService inhouserepo = context.getBean(InhousePartServiceImpl.class);

  

        Part part = repo.findById(theId);

        int inv = part.getInv(); // Corrected to use part.getInv() instead of repo.getInv()

        if (inv == 0) {

            return "failurepart";

        } else {

            part.setInv(inv - 1);

            repo.save(part);

            return "successpart";

        }

    }
```

**File name:  AddProductController.java**
*Line number: 183-205 | Changes: added method for the buying the product and directing the user to a fail or success page depending on if the inventory is available*
```
@GetMapping("/buyProduct")

    public String buyProduct(@RequestParam("productID") int theId, Model theModel) {

        // intialize productService bean through spring context

        ProductService productService = context.getBean(ProductServiceImpl.class);

        // create a product object called product2

        Product product2 = productService.findById(theId);

        // creating a variable to store the value of the product

        int inv = product2.getInv();

        // checking to see if inv is 0

        if (inv == 0) {

            // returning failure.html page

            return "failureproduct";

        } else {

            // decrementing the value of inv by 1

            product2.setInv(inv - 1);

            // set new value of inv to product2

  

            // save product2 with the new value of inv

            productService.save(product2);

            // returning success.html page

            return "successproduct";

        }

    }
```

**File name: mainscreen.html**
*Line number: 79 | Changes: added a "Buy Now" button to the Part table which uses the buyPart method* 
```
<a th:href="@{/buyPart(partID=${tempPart.id})}" class="btn btn-primary btn-sm mb-3">Buy Now</a>
```

*Line number: 118-119 | Changes: added a "Buy Now" button to the Product table which uses the buyProduct method* 
```
<a th:href="@{/buyProduct(productID=${tempProduct.id})}" class="btn btn-primary btn-sm mb-3">Buy Now</a>
```

**Created file name: failurepart.html**
*Purpose: display a page that reflects that purchasing the part failed* 
```
<!DOCTYPE html>

<html lang="en">

<html xmlns:th="https://www.thymeleaf.org">

<head>

    <meta charset="UTF-8">

    <meta name="viewport" content="width=device-width, initial-scale=1">

    <title>Failure Form</title>

  

    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />

</head>

<body>

<h1>You did not buy the part.</h1>

  

    <a href="http://localhost:8080/">Back to Main Screen</a>

<!--<footer><a href="http://localhost:8080/">Link-->

<!--    to Main Screen</a></footer>-->

</body>

</html>
```

**Created file name: failureproduct.html**
*Purpose: display a page that reflects that purchasing the product failed* 
```
<!DOCTYPE html>

<html lang="en">

<html xmlns:th="https://www.thymeleaf.org">

<head>

    <meta charset="UTF-8">

    <meta name="viewport" content="width=device-width, initial-scale=1">

    <title>Failure Form</title>

  

    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />

</head>

<body>

<h1>You did not buy the product.</h1>

  

    <a href="http://localhost:8080/">Back to Main Screen</a>

<!--<footer><a href="http://localhost:8080/">Link-->

<!--    to Main Screen</a></footer>-->

</body>

</html>
```

**Created file name: successpart.html**
*Purpose: display a page that reflects that purchasing the part succeeded* 
```
<!DOCTYPE html>

<html lang="en">

<html xmlns:th="https://www.thymeleaf.org">

<head>

    <meta charset="UTF-8">

    <meta name="viewport" content="width=device-width, initial-scale=1">

    <title>Success Form</title>

  

    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />

</head>

<body>

<h1>You bought the part.</h1>

  

    <a href="http://localhost:8080/">Back to Main Screen</a>

<!--<footer><a href="http://localhost:8080/">Link-->

<!--    to Main Screen</a></footer>-->

</body>

</html>
```
**Created file name: successproduct.html**
*Purpose: display a page that reflects that purchasing the product succeeded*
```
<!DOCTYPE html>

<html lang="en">

<html xmlns:th="https://www.thymeleaf.org">

<head>

    <meta charset="UTF-8">

    <meta name="viewport" content="width=device-width, initial-scale=1">

    <title>Success Form</title>

  

    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />

</head>

<body>

<h1>You bought the product.</h1>

  

    <a href="http://localhost:8080/">Back to Main Screen</a>

<!--<footer><a href="http://localhost:8080/">Link-->

<!--    to Main Screen</a></footer>-->

</body>

</html>
```
---
### G.  Modify the parts to track maximum and minimum inventory by doing the following:
#### •  Add additional fields to the part entity for maximum and minimum inventory.
#### •  Modify the sample inventory to include the maximum and minimum fields.
#### •  Add to the InhousePartForm and OutsourcedPartForm forms additional text inputs for the inventory so the user can set the maximum and minimum values.
#### •  Rename the file the persistent storage is saved to.
#### •  Modify the code to enforce that the inventory is between or at the minimum and maximum value.

**File name: Part.java**
*Line number: 33-36 | Changes: added minInv and maxInv variables to the Part class*
```
    @Min(value = 0, message = "Min Inventory value must be positive")

    int minInv;

    @Min(value = 0, message = "Max Inventory value must be positive")

    int maxInv;
```

*Line number: 91-105 | Changes: added getter and setter methods for minInv and maxInv variables*
```
    public int getMinInv() {

        return minInv;

    }

    public void setMinInv(int minInv) {

        this.minInv = minInv;

    }

    public int getMaxInv() {

        return maxInv;

    }

  

    public void setMaxInv(int maxInv) {

        this.maxInv = maxInv;

    }
```

*Line number: 20 | Changes: added annotation for the ValidInventory validator, which is detailed below*
```
@ValidInventory
```

**Created file name: InventoryValidator.java**
*Purpose: this class validates that the inventory is not greater than the maximum inventory allowed or less than the minimum inventory allowed for that specific Part, and uses a custom Constraint to display an error message if needed*
```
package com.example.demo.validators;

  

import com.example.demo.domain.Part;

import com.example.demo.domain.Product;

import com.example.demo.service.ProductService;

import com.example.demo.service.ProductServiceImpl;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.context.ApplicationContext;

  

import javax.validation.ConstraintValidator;

import javax.validation.ConstraintValidatorContext;

  

/**

 *

 *

 *

 *

 */

public class InventoryValidator implements ConstraintValidator<ValidInventory, Part> {

    @Autowired

    private ApplicationContext context;

    public static ApplicationContext myContext;

  

    @Override

    public void initialize(ValidInventory constraintAnnotation) {

        // ConstraintValidator.super.initialize(constraintAnnotation);

    }

  

    @Override

    public boolean isValid(Part part, ConstraintValidatorContext constraintValidatorContext) {

        // create code to make sure that inventory is between min and max value

        if (part.getInv() > part.getMaxInv()) {

            return false;

        }

        if (part.getInv() < part.getMinInv()) {

            return false;

        }

        return true;

    }

}
```

**Created file name: ValidInventory.java**
*Purpose: this interface validates the data by using InventoryValidator.java*
```
package com.example.demo.validators;

  

import javax.validation.Constraint;

import javax.validation.Payload;

import java.lang.annotation.ElementType;

import java.lang.annotation.Retention;

import java.lang.annotation.RetentionPolicy;

import java.lang.annotation.Target;

  

/**

 *

 *

 *

 *

 */

@Constraint(validatedBy = {InventoryValidator.class})

@Target({ElementType.TYPE})

@Retention(RetentionPolicy.RUNTIME)

public @interface ValidInventory {

    String message() default "Inventory error";

    Class<?> [] groups() default {};

    Class<? extends Payload> [] payload() default {};

  

}
```

**File name: BootStrapData.java**
*Line number 49-50, 57-58, 66-67, 75-76, 85-86 | Changes: adjusted the sample data to include sample data for the MinInv and MaxInv variables*
```
            glazedDonut.setMaxInv(10);

            glazedDonut.setMinInv(1);
```

```
            chocolateDonut.setMaxInv(20);

            chocolateDonut.setMinInv(2);
```

```
            becCroissant.setMaxInv(15);

            becCroissant.setMinInv(1);
```

```
            donutHoles.setMaxInv(20);

            donutHoles.setMinInv(5);
```

```
            cFrappe.setMaxInv(10);

            cFrappe.setMinInv(1);
```

**File name: mainscreen.html**
*Line number: 67-68 | Changes: Added minimum inventory and maximum inventory columns into the Part table*
```
                    <th>Minimum Inventory</th>

                    <th>Maximum Inventory</th>
```

*Line number: 77-78 | Changes: Added table cells that reflect the values of the  maximum inventory and minimum inventory variables*
```
                    <td th:text="${tempPart.minInv}">1</td>

                    <td th:text="${tempPart.maxInv}">1</td>
```

**File name: InhousePartForm.html**
*Line numbers 37-49 | Changes: Added input fields w/ labels for the minInv and maxInv variables*
```
        <p>

            <label th:for="*{minInv}">Minimum Inventory:</label>

            <input type="text" path="minInv" th:field="*{minInv}" placeholder="Minimum Inventory"

                class="form-control mb-4 col-4" />

        </p>

        <p th:if="${#fields.hasErrors('minInv')}" th:errors="*{minInv}">Minimum Inventory Error</p>

  

        <p>

            <label th:for="*{maxInv}">Maximum Inventory:</label>

            <input type="text" path="maxInv" th:field="*{maxInv}" placeholder="Max Inventory"

                class="form-control mb-4 col-4" />

        </p>

        <p th:if="${#fields.hasErrors('maxInv')}" th:errors="*{maxInv}">Maximum Inventory Error</p>
```

*Line numbers: 19-22, 24-27, 30,34, 51-54 | Changes: added labels for the fields in the form*
```
        <p>

            <label th:for="*{name}">Name:</label>

            <input type="text" id="name" th:field="*{name}" placeholder="Name" class="form-control mb-4 col-4" />

        </p>
```

```
        <p>

            <label th:for="*{price}">Price:</label>

            <input type="text" path="price" th:field="*{price}" placeholder="Price" class="form-control mb-4 col-4" />

        </p>
```

```
        <p>

  

            <label th:for="*{inv}">Inventory:</label>

            <input type="text" path="inv" th:field="*{inv}" placeholder="Inventory" class="form-control mb-4 col-4" />

        </p>
```

```
        <p>

            <label th:for="*{partId}">Part ID:</label>

            <input type="text" th:field="*{partId}" placeholder="Part ID" class="form-control mb-4 col-4" />

        </p>
```

**File name: File name: OutsourcedPartForm.html**
*Line numbers 37-47 | Changes: Added input fields w/ labels for the minInv and maxInv variables*
```
        <p>

            <label th:for="*{minInv}">Minimum Inventory:</label>

            <input type="text" path="minInv" th:field="*{minInv}" placeholder="Minimum Inventory" class="form-control mb-4 col-4" />

        </p>

        <p th:if="${#fields.hasErrors('minInv')}" th:errors="*{minInv}">Minimum Inventory Error</p>

  

        <p>

            <label th:for="*{maxInv}">Maximum Inventory:</label>

            <input type="text" path="maxInv" th:field="*{maxInv}" placeholder="Max Inventory" class="form-control mb-4 col-4" />

        </p>

        <p th:if="${#fields.hasErrors('maxInv')}" th:errors="*{maxInv}">Maximum Inventory Error</p>
```

Line numbers: 19-22, 24-27, 30,34, 50-53 | Changes: added labels for the fields in the form
```
        <p>

            <label th:for="*{name}">Name:</label>

            <input type="text" id="name" th:field="*{name}" placeholder="Name" class="form-control mb-4 col-4" />

        </p>
```

```
        <p>

            <label th:for="*{price}">Price:</label>

            <input type="text" path="price" th:field="*{price}" placeholder="Price" class="form-control mb-4 col-4" />

        </p>
```

```
        <p>

  

            <label th:for="*{inv}">Inventory:</label>

            <input type="text" path="inv" th:field="*{inv}" placeholder="Inventory" class="form-control mb-4 col-4" />

        </p>
```

```
        <p>

            <label th:for="*{companyName}">Company Name:</label>

            <input type="text" th:field="*{companyName}" placeholder="Company Name" class="form-control mb-4 col-4" />

        </p>
```

---
### H.  Add validation for between or at the maximum and minimum fields. The validation must include the following:
#### •  Display error messages for low inventory when adding and updating parts if the inventory is less than the minimum number of parts.
#### •  Display error messages for low inventory when adding and updating products lowers the part inventory below the minimum.
#### •  Display error messages when adding and updating parts if the inventory is greater than the maximum.

**File name: InventoryValidator.java** 
*Line number: 34-35, 40-41 | Changes: added custom constraint violation that displays a message to the user when the max inventory or min inventory conflicts with the inventory set*

```
// display error message

            constraintValidatorContext

                    .buildConstraintViolationWithTemplate( "Solution: Fix your Inventory, it is greater than the max inventory").addConstraintViolation();
```

```
            // display error message

            constraintValidatorContext.buildConstraintViolationWithTemplate(

                    "Solution: Fix your Inventory, it is less than the min inventory").addConstraintViolation();
```

**File name: InhousePartForm.html**
*Line numbers: 56-60 | Changes: added \<div> that will catch errors and print them to the user*
```
        <div th:if="${#fields.hasAnyErrors()}">

            <ul>

                <li th:each="err : ${#fields.allErrors()}" th:text="${err}"></li>

            </ul>

        </div>
```

**File name: File name: OutsourcedPartForm.html**
*Line numbers: 55-59 | Changes: added \<div> that will catch errors and print them to the user*
```
        <div th:if="${#fields.hasAnyErrors()}">

            <ul>

                <li th:each="err : ${#fields.allErrors()}" th:text="${err}"></li>

            </ul>

        </div>
```

**File name: EnufPartsValidator.java**
*Line numbers: 36-42, 46 | Changes: adds code to the isValid() method to check if the inventory was increased in an amount more than the Part inventory can support, and displays a custom error message*
```
if (p.getInv()<(product.getInv()-myProduct.getInv())) {

                    // display error message

                    constraintValidatorContext.disableDefaultConstraintViolation();

                    constraintValidatorContext.buildConstraintViolationWithTemplate(

                            "Solution: Fix your Inventory, it is less than the min inventory").addConstraintViolation();

                    return false;

                }
```

**File name: productForm.html**
*Line numbers: 17-19, 21-25, 27-30 | Changes: added labels to the fields in the product form*
```
<p>

        <label th:for="*{name}">Name:</label>

        <input type="text" th:field="*{name}" placeholder="Name" class="form-control mb-4 col-4"/></p>
```

```
<p>

        <label th:for="*{price}">Price:</label>

        <input type="text" th:field="*{price}" placeholder= "Price" class="form-control mb-4 col-4"/>

    </p>
```

```
    <p>

        <label th:for="*{inv}">Inventory:</label>

        <input type="text" th:field="*{inv}" placeholder="Inventory" class="form-control mb-4 col-4"/>

    </p>
```
---
### I.  Add at least two unit tests for the maximum and minimum fields to the PartTest class in the test package.

**File Name: PartTest.java**
*Line numbers: 162-196 | Changes: added tests for the getter and setter methods for MaxInv and MinInv*
```
@Test

    void setMinInv() {

        int minInv=1;

        partIn.setMinInv(minInv);

        assertEquals(minInv, partIn.getMinInv());

        partOut.setMinInv(minInv);

        assertEquals(minInv, partOut.getMinInv());

    }

    @Test

    void getMinInv() {

        int minInv=1;

        partIn.setMinInv(minInv);

        assertEquals(minInv, partIn.getMinInv());

        partOut.setMinInv(minInv);

        assertEquals(minInv, partOut.getMinInv());

    }

    @Test

    void setMaxInv() {

        int maxInv=10;

        partIn.setMaxInv(maxInv);

        assertEquals(maxInv, partIn.getMaxInv());

        partOut.setMaxInv(maxInv);

        assertEquals(maxInv, partOut.getMaxInv());

    }

    @Test

    void getMaxInv() {

        int maxInv=10;

        partIn.setMaxInv(maxInv);

        assertEquals(maxInv, partIn.getMaxInv());

        partOut.setMaxInv(maxInv);

        assertEquals(maxInv, partOut.getMaxInv());

    }
```
---
### J.  Remove the class files for any unused validators in order to clean your code.

**DELETED: DeletePartValidator.java and ValidDeletePart.java** 
*Purpose: removed these two files because they were not actively being used within the project*

**File name: Part.java**
*Line number: 19(removed) | Changes: deleted the line that contained an annotation to `@ValidDeletePart` because the file ValidDeletePart.java was deleted*

---
### Errors Corrected

**DELETED: negativeerror.html, confirmationdeletepart, confirmationdeleteproduct**

*Purpose: these files reference the delete function that was previously deleted with DeletePartValidator.java and ValidDeletePart.java* 

**File name: confirmationaddpart.html**
*Line number: 10 | Changes: changed the reference to "part" to reference "item"*
```
<h1>Your item has been added or updated</h1>
```

**File name: confirmationaddproduct.html**
*Line number: 10 | Changes: changed the reference to "product" to reference "meal"*
```
<h1>Your meal has been added or updated</h1>
```

**File name: confirmationassocpart.html**
*Line number: 10 | Changes: changed the reference to "part" to reference "item"*
```
<h1>Your item has been successfully added or removed</h1>
```

**File name: failurepart.html**
*Line number: 12 | Changes: changed the reference to "part" to reference "item"*
```
<h1>You did not buy the item.</h1>
```

**File name: failureproduct.html**
*Line number: 12 | Changes: changed the reference to "product" to reference "meal"*
```
<h1>You did not buy the meal.</h1>
```

**File name: InHousePartForm.html**
*Line number: 8, 13, 52 | Changes: changed the reference to "part" to reference "item"*
```
<title>Item Form</title>
```

```
<h1>Inhouse Item Detail</h1>
```

```
<label th:for="*{partId}">Item ID:</label>
```

**File name: OutsourcedPartForm.html**
*Line number: 7, 12 | Changes: changed the reference to "product" to reference "meal"*
```
<title>Item Form</title>
```

```
<h1>Outsourced Item Detail</h1>
```

**File name: productForm.html**
*Line number: 7, 12 | Changes: changed the reference to "product" to reference "meal"*
```
<title>Meal Form</title>
```

```
<title>Meal Detail</title>
```

*Line number: 43, 62 | Changes: changed the reference to "part" to reference "item"*
```
<h2>Available Items</h2>
```

```
<h2>Associated Items</h2>
```

**File name: saveproductscreen.html**
*Line number: 5,8  | Changes: changed the reference to "product" to reference "meal"*
```
<title>Save Meal Screen</title>
```

```
<p>Please save the meal before adding parts!</p>
```

**File name: successpart.html**
*Line number: 12 | Changes: changed the reference to "part" to reference "item"*
```
<h1>You bought the item.</h1>
```

**File name: successproduct.html**
*Line number: 12 | Changes: changed the reference to "product" to reference "meal"*
```
<h1>You bought the meal.</h1>
```

### Correcting the interface because it does not have a shop name or part names displayed. 
**File name: mainscreen.html**
*Line number: 26 | Changes: removed the reference to "Donut Palace" in the navbar
```
<a class="navbar-brand" href="/mainscreen">
	<img th:src="@{/images/logo.jpg}" alt="Logo" width="55" height="55">
    </a>
```
*Line number: 47 and 49 | Changes: changed the reference to "Shop" to "The Donut Palace" and changed the reference to "Items" to "A La Carte Items"*
```
<h1>The Donut Palace</h1>
```

```
<h2>A La Carte Items</h2>
```

**File name: about.html**
*Line number: 21 | Changes: removed the reference to "Donut Palace" in the navbar and changed the href to "/about"*
```
<a class="navbar-brand" href="/about">
	<img th:src="@{/images/logo.jpg}" alt="Logo" width="55" height="55">
    </a>
```

*Line number: 40 and 41 | Changes: references to "Donut Palace" changed to "The Donut Palace"*
```
<h1>About The Donut Palace</h1>
<p>Welcome to The Donut Palace, where we serve the best donuts in town!</p>
```
