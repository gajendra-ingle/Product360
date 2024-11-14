
# Product360

## Introduction

Product360 is a project created for learning and understanding Hibernate ORM functionalities. This hands-on practice is aimed at gaining proficiency in implementing Hibernate for various operations like CRUD, sorting, filtering, and data retrieval. It is not intended as a production-ready system but as a personal learning endeavor.

### What I Learned in Hibernate 🎯
- **Object Relational Mapping (ORM):** Understanding the mapping between Java objects and database tables.
- **Configuration and Setup:** Setting up Hibernate configuration files and mapping files.
- **Session Management:** Using Hibernate `SessionFactory` to manage database sessions.
- **CRUD Operations:** Creating, reading, updating, and deleting data with Hibernate.
- **Query Language:** Writing HQL (Hibernate Query Language) for complex data queries.
- **Transaction Management:** Ensuring consistency and atomicity during database operations.
- **Annotations and XML Mapping:** Using annotations for entity configuration and alternative XML mappings.
- **Lazy and Eager Fetching:** Managing data fetching strategies to optimize performance.

---

## Project Description💡

This project includes the following tasks and features to understand Hibernate better:

1. **Add Product to Database**
   - Add new products with details like ID, name, quantity, price, manufacturing date, and expiry date.
   - **Acceptance Criteria:**
     - **Success:** Added Successfully
     - **Already Exists:** Product already exists
     - **Error:** Something went wrong

2. **Delete Product from Database**
   - Delete a product by its unique Product ID.
   - **Acceptance Criteria:**
     - **Success:** Deleted Successfully
     - **Not Exists:** Product Not exists for delete
     - **Error:** Something went wrong

3. **Get Particular Product Data**
   - Fetch details of a specific product based on its Product ID.
   - **Acceptance Criteria:**
     - **Success:** Return Product
     - **Not Found:** Resource not exist
     - **Error:** Something went wrong

4. **Update Particular Product**
   - Update product details for a specific product.
   - **Acceptance Criteria:**
     - **Success:** Updated Successfully
     - **Not Exists:** Product Not exists to update
     - **Error:** Something went wrong

5. **Retrieve All Products**
   - Fetch a list of all products stored in the database.
   - **Acceptance Criteria:**
     - **Success:** Return all products
     - **Not Exists:** Return proper message
     - **Error:** Return proper message

6. **Retrieve All Products in Ascending Order by Given Parameter**
   - Retrieve all products sorted in ascending order based on a specified parameter.
   - **Acceptance Criteria:**
     - **Success:** Return sorted list of products
     - **Error:** Return proper message

7. **Retrieve Product by Product Name**
   - Find and retrieve product details using the product name.
   - **Acceptance Criteria:**
     - **Found:** Return product information
     - **Not Found:** Product not found

8. **Retrieve Products with Price Greater Than Specified Price**
   - Retrieve products priced above a given amount.
   - **Acceptance Criteria:**
     - **Found:** Return list of products
     - **Not Found:** Return proper message

9. **Retrieve Products by Name Pattern**
   - Retrieve products whose names match a specified pattern.
   - **Acceptance Criteria:**
     - **Found:** Return list of matching products
     - **Not Found:** Return proper message

10. **Retrieve Products Within Price Range**
    - Retrieve products falling within a specified price range.
    - **Acceptance Criteria:**
      - **Found:** Return list of products
      - **Not Found:** Return proper message

11. **Retrieve Maximum Product Price**
    - Retrieve the maximum price of a product in the database.
    - **Acceptance Criteria:**
      - **Success:** Return maximum price
      - **Error:** Return proper message

---

## Technologies Used 🛠️

- **Programming Language:** Java
- **ORM Framework:** Hibernate
- **Database:** MySQL
- **Development Tools:** Eclipse, IntelliJ IDEA, or VS Code
- **Build Tool:** Maven
- **Version Control:** Git/GitHub

---

Feel free to use this project for your learning journey.
