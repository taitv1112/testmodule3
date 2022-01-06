package controller;

import model.Category;
import model.Product;
import service.CategoryService;
import service.ProductService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet(urlPatterns = "/product")
public class ProductServlet extends HttpServlet {
    ProductService productService = new ProductService();
    CategoryService categoryService = new CategoryService();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");

        if (action == null) {
            action = "";
        }
        RequestDispatcher requestDispatcher;
        switch (action) {
            case "create":
                try {
                    req.setAttribute("categories", categoryService.getList());
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                requestDispatcher = req.getRequestDispatcher("/views/createProduct.jsp");
                requestDispatcher.forward(req, resp);
                break;
            case "delete":
                int id = Integer.parseInt(req.getParameter("id"));
                try {
                    productService.delete(id);
                    resp.sendRedirect("/product");
                } catch (SQLException e) {
                    e.printStackTrace();
                }

                break;
            case "edit":
                int id1 = Integer.parseInt(req.getParameter("id"));
                try {
                    req.setAttribute("product", productService.getProductById(id1));
                    req.setAttribute("categories", categoryService.getList());
                    requestDispatcher = req.getRequestDispatcher("views/editProduct.jsp");
                    requestDispatcher.forward(req, resp);
                } catch (SQLException e) {
                    e.printStackTrace();
                }

                break;
            default:
                try {
                    req.setAttribute("products", productService.getList());
                    requestDispatcher = req.getRequestDispatcher("/views/showProduct.jsp");
                    requestDispatcher.forward(req, resp);
                } catch (SQLException e) {
                    e.printStackTrace();
                }
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "create":
                String name = request.getParameter("name");
                Double price = Double.parseDouble(request.getParameter("price"));
                int quantity = Integer.parseInt( request.getParameter("quantity"));
                String description = request.getParameter("description");
                String color = request.getParameter("color");
                int id_category = Integer.parseInt( request.getParameter("id_category"));
                Product product = new Product(name, price, quantity,description,color,id_category);
                try {
                    productService.save(product);
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                response.sendRedirect("/product");
                break;
            case "edit":
                int idE = Integer.parseInt(request.getParameter("id"));
                String nameE = request.getParameter("name");
                Double priceE = Double.parseDouble(request.getParameter("price"));
                int quantityE = Integer.parseInt( request.getParameter("quantity"));
                String descriptionE = request.getParameter("description");
                String colorE = request.getParameter("color");
                int id_categoryE = Integer.parseInt( request.getParameter("id_category"));
                Product productE = new Product(nameE, priceE, quantityE,descriptionE,colorE,id_categoryE);

                try {
                    productService.edit(idE, productE);
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                response.sendRedirect("/product");
                break;
            case "search":
                String nameSearch = request.getParameter("search");
                try {
                    request.setAttribute("products", productService.findProductByName(nameSearch));
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                RequestDispatcher requestDispatcher = request.getRequestDispatcher("/views/showProduct.jsp");
                requestDispatcher.forward(request, response);
                break;
        }
    }
}
