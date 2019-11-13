package servlets;

import models.Lot;
import models.Product;
import models.User;
import services.LotService;
import services.ProductService;
import services.UserService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.File;
import java.io.IOException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@WebServlet("/add-new-lot")
@MultipartConfig(fileSizeThreshold = 6291456, // 6 MB
        maxFileSize = 10485760L, // 10 MB
        maxRequestSize = 20971520L // 20 MB
)
public class AddLotServlet extends HttpServlet {

    private static final String UPLOAD_DIR = "uploads";
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {


        if (req.getSession().getAttribute("isSignIn") == null) {
            resp.sendRedirect(req.getContextPath() + "/login");
        } else {

            RequestDispatcher requestDispatcher = req.getRequestDispatcher("/jsp/addLot.jsp");
            requestDispatcher.forward(req, resp);
        }

//        System.out.println(new Timestamp(new Date(startDate).getTime()));
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        resp.setCharacterEncoding("UTF-8");

        req.setCharacterEncoding("UTF-8");
        UserService userService = new UserService();
        LotService lotService = new LotService();
        ProductService productService = new ProductService();

        HttpSession session = req.getSession();
        User user = userService.findUserByLogin(session.getAttribute("login").toString());

        String appPath = req.getServletContext().getRealPath("");
        String uploadFilePath = appPath + File.separator + UPLOAD_DIR;
//        System.out.println(appPath);
//        System.out.println(uploadFilePath);

        File uploadFolder = new File(uploadFilePath);
        if (!uploadFolder.exists()) {
            uploadFolder.mkdirs();
        }

//        System.out.println(req.getPart("filename").getSubmittedFileName());
        ArrayList<String> fileNames = new ArrayList<>();
        List<Part> fileParts = req.getParts().stream().filter(part -> "file".equals(part.getName())).collect(Collectors.toList());
        for (Part part : fileParts) {
            if (part != null && part.getSize() > 0) {
                String fileName = part.getSubmittedFileName();
                String contentType = part.getContentType();

                fileNames.add(fileName);

//                System.out.println(fileName);

                if (!(contentType.equalsIgnoreCase("image/jpeg")||contentType.equalsIgnoreCase("image/png"))) {
                    continue;
                }

                part.write(uploadFilePath + File.separator + fileName);

            }
        }
        String startDate = req.getParameter("sdate") + " " + req.getParameter("stime") + ":00";
//        System.out.println(Timestamp.valueOf(startDate));
        String finishDate = req.getParameter("fdate") + " " + req.getParameter("ftime") + ":00";
        String description = req.getParameter("description");
        String name = req.getParameter("name");
        Long startPrice = Long.parseLong(req.getParameter("startPrice"));

        Product product = new Product(startPrice, fileNames, name, description);
        productService.save(product);

        Lot lot = new Lot(user.getId(), false, null, Timestamp.valueOf(startDate), Timestamp.valueOf(finishDate), false, product.getId());
        lotService.save(lot);

//        RequestDispatcher requestDispatcher = req.getRequestDispatcher("");
//        requestDispatcher.forward(req, resp);

    }
}
